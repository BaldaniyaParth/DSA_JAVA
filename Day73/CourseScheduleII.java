package Day73;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

    public static void main(String[] args) {
        int numCourses = 2;
        int [][] prerequisites = {{1,0}};
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0; i<prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int ans = 0, res[]=new int[numCourses];
        while(!q.isEmpty()){
            int V = q.poll();
            res[ans]=V;
            ans++;
            for(Integer n : adj.get(V)){
                indegree[n]--;
                if(indegree[n]==0){
                    q.offer(n);
                }
            }
        }
        if(ans==numCourses) return res;
        return new int[]{};
    }
}
