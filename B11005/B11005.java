import java.util.*;

public class B11005{

    public static Map<Integer, Character> baseMap = new HashMap<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Integer N = sc.nextInt();
        Integer base = sc.nextInt();

        setBaseMap();

        StringBuilder  sb = new StringBuilder();

        int num = N;
        int carry = 1;
        int r = 0;

        while(num > 0){
            r = num % base;
            num = num / base;
            sb.insert(0, baseMap.get(r) );
        }

        System.out.println(sb.toString());
    }

    private static void setBaseMap(){
        for(int i=0; i<36; i++){
            if(i < 10){
                baseMap.put(i, (char)('0'+i));
            }else{
                baseMap.put(i, (char)('a'+i-10));
                baseMap.put(i, (char)('A'+i-10));
            }
        }
    }
}
