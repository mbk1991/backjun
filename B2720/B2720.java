import java.util.*;

public class B2720{
    
    private static final int QUARTER = 25;
    private static final int DIME = 10;
    private static final int NICKEL = 5;
    private static final int PENNY = 1;

    public static void  main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            int C = sc.nextInt();

            System.out.print(C / QUARTER + " ");
            C = C % QUARTER;

            System.out.print(C / DIME + " ");
            C = C % DIME;

            System.out.print(C / NICKEL + " ");
            C = C % NICKEL;

            System.out.println(C / PENNY);
        }
    }
}
