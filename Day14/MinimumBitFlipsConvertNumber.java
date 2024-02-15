package Day14;

public class MinimumBitFlipsConvertNumber {

    public static void main(String[] args) {
        int start = 10;
        int goal = 7;
        System.out.println(minBitFlips(start,goal));
    }

    public static int minBitFlips(int start, int goal) {
        int steps=0;

        while(start>0 || goal>0){
            if((start&(1))!=(goal&(1))){
                steps++;
            }
            start=start>>1;
            goal=goal>>1;
        }
        return steps;
    }
}
