package Day43;

import java.util.PriorityQueue;

public class HandStraights {

    public static void main(String[] args) {
        int [] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand,groupSize));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int elem: hand) minHeap.add(elem);

        while(!minHeap.isEmpty()){
            int head = minHeap.poll();
            for(int i=1; i<groupSize; i++)
                if(!minHeap.remove(head+i)) return false;
        }
        return true;
    }
}
