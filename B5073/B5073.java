import java.util.*;

public class B5073{
    public static void main(String[] args){
        boolean isEnd = false;
        Scanner sc = new Scanner(System.in);
        while(!isEnd){
            int[] sides = new int[3];
            sides[0] = sc.nextInt();
            sides[1] = sc.nextInt();
            sides[2] = sc.nextInt();
            if(sides[0] == 0){
                isEnd = true;
                break;
            }
            sideCheck(sides);
        }
     }

     private static void sideCheck(int ... sides){
        Arrays.sort(sides);
        if(sides[2] >= (sides[0]+sides[1])){
            System.out.println("Invalid");
        }
        else if(sides[0] == sides[1] && sides[1] == sides[2]){
            System.out.println("Equilateral");
        }
        else  if(sides[0] == sides[1] || sides[1] == sides[2]){
            System.out.println("Isosceles");
        }else{
            System.out.println("Scalene");
        }
    }  
}
