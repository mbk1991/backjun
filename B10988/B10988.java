import java.util.*;

public class B10988{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        System.out.println(isPalindrome(input)? 1 : 0);
    }

    private static boolean isPalindrome(String input){
        char[] charArr = input.toCharArray();

        for(int i=0; i< charArr.length / 2; i++){
            if( charArr[i] != charArr[charArr.length-1 - i] ){
                return false;
            }
        }
        return true;
    }
}
