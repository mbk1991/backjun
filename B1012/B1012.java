import java.util.*;

public class B1012{

    //up,down,left,right
    static int[] x = {0,0,-1,1};
    static int[] y = {-1,1,0,0};
    static int[][] map;
    static boolean[][] isChecked;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i=0; i<tc; i++){
            int M = sc.nextInt(); // 가로
            int N = sc.nextInt(); //세로 
            int K = sc.nextInt(); //배추의 개수
            
            map = new int[N][M];
            isChecked = new boolean[N][M];

            for(int j=0; j<K; j++){
                int X = sc.nextInt();
                int Y = sc.nextInt();
                map[Y][X] = 1;
            }

 //           printMap();
            test();
        }
    }

    public static void test(){
        int cnt = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j] == 1 && !isChecked[i][j]){
                    check(i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void check(int row, int col){
       isChecked[row][col] = true;
    
       for(int i=0; i<4; i++){
           int nextY = row + y[i];
           int nextX = col + x[i];
            
           if(0 <= nextY && nextY < map.length && 0 <= nextX && nextX < map[0].length 
                   && map[nextY][nextX] == 1 && !isChecked[nextY][nextX]){
                        check(nextY, nextX);
                   }

       }
    }


    private static void printMap(){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }


}
