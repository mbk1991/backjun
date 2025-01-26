/**
 *맵을 저장하면서 1의 좌표를 저장해둔다.
 *스타트는 1,
 2일차는 2부터 시작
 3일차는 3부터 시작
 각 일차 별로 주변을 업데이트할 때 0이 아닌 경우 더 작은 값으로 업데이트한다.
 맵은 일수로 채워지게 된다.
 모두 익어있으면 0
 1일이 소요되면 1을 리턴
 -1인 겨우는 빈 공간으로 토마토 익기 전파가 되지 않는다.
 *
 * */

import java.util.*;

public class B7576{
    static List<Position> onePositionList = new ArrayList<>();
    static int[] dx = {0,0,-1,1}; // up, down, left, right
    static int[] dy = {-1,1,0,0,};
    static int[][] map;
    static boolean[][] isVisit;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        map = new int[y][x];
        isVisit = new boolean[y][x];

        int total = x*y;
        int cntMinusOne = 0;
        int cntOne = 0;

        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1){
                    onePositionList.add(new Position(i,j));
                    cntOne ++;
                }else if(map[i][j] == -1){
                    cntMinusOne ++;
                }
            }
        }

        if(total == cntMinusOne){
            //텅 빈 경우
            System.out.println(-1);
            return;
        }

        if(total == cntOne + cntMinusOne){
            //모든 사과가 익어있는 경우
            System.out.println(0);
            return;
        }

        if(cntOne == 0){
            //익은 사과가 없는 경우
            System.out.println(-1);
            return;
        }

        process();
        printAns();
    }

    private static void printAns(){
        int max = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                if(map[i][j] > max){
                    max = map[i][j];
                }
            }
        }
        System.out.println(max - 1);
    }

    private static void process(){
        for(int i=0; i<onePositionList.size(); i++){
            bfs(onePositionList.get(i));
        }
    }

    private static void bfs(Position p){
        Queue<Position> queue = new LinkedList<>();
        queue.offer(p);
        //init start point map
        map[p.y][p.x] = 1;

        while(queue.size()>0){
          Position curr = queue.poll();
          int nextY, nextX;
          int currVal = map[curr.y][curr.x];
          int nextVal = currVal + 1;

           for(int i=0; i<4; i++){
              nextY = curr.y + dy[i];
              nextX = curr.x + dx[i];

              if(!(0 <= nextY && nextY < map.length)) continue;
              if(!(0 <= nextX && nextX < map[i].length)) continue;
              if(map[nextY][nextX] == -1) continue;
              if(isVisit[nextY][nextX]){
                  if(nextVal >= map[nextY][nextX]) continue;
              }

              map[nextY][nextX] = nextVal;
              isVisit[nextY][nextX] = true;
              queue.offer(new Position(nextY, nextX));
           }

       }
    }

    private static void printMap(){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

class Position{
       public int x,y;
       public Position(int y, int x){
         this.y = y;
         this.x = x;
    }
}
