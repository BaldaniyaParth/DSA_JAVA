package Week1;

public class PartitioningDeciBinaryNumbers {

    public static void main(String[] args) {
        String n = "32";
        System.out.println(minPartitions(n));
    }
    public static int minPartitions(String n) {
        for(int i=9;i>=0;i--){
            if(n.contains(n.valueOf(i))) return i;
        }
        return 0;
    }
}
