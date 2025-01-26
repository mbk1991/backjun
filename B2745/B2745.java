import java.util.*;

public class B2745{

    public static Map<Character, Integer> baseMap = new HashMap<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int B = sc.nextInt();

        setBaseMap();

        convertDecimal(N,B);


    }

    private static void convertDecimal(String N, int base){

        int result = 0;
        char[] numCharArr = N.toCharArray();
        int carry = 1;
        for(int i = numCharArr.length-1; i >= 0; i--){
            result += (baseMap.get( numCharArr[i] ) * carry);
            carry *= base;
        }
        System.out.println(result);
    }


    private static void setBaseMap(){
        for(int i=0; i<36; i++){
            if(i < 10){
                baseMap.put((char)('0' + i), i);
            }else{
                baseMap.put((char)('A' + i - 10), i);
                baseMap.put((char)('a' + i - 10), i);
            }
        }
    }
}
