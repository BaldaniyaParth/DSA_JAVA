package Day43;

import java.util.Arrays;

public class TaskScheduler {

    public static void main(String[] args) {
        char [] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval(tasks,n));
    }

    public static int leastInterval(char[] tasks, int n) {

        if(tasks==null || tasks.length==0) return 0;

        int[] frequency=new int[26];

        for(char task:tasks)
        {
            frequency[task-'A']++;
        }

        Arrays.sort(frequency);

        int maxfrequency=frequency[25]-1;
        int idleslots=maxfrequency*n;

        for(int i=24;i>=0 && frequency[i]>0;i--)
        {
            idleslots-=Math.min(maxfrequency,frequency[i]);

        }

        return idleslots>0 ? idleslots+tasks.length : tasks.length;
    }
}
