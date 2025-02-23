import java.util.*;

public class B2903{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int numberOfPoints = (int) Math.pow((Math.pow(2,N) + 1),2);
        System.out.println(numberOfPoints);
    }
}
