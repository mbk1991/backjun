import java.util.*;

/*1.현재 위치에서 이동할 수 있는 곳에 goal이 있는지 확인한다.
 *2. 있으면 step 수를 반환하고 종료한다.
 *3. 없으면 한 칸 이동한 후 반복한다.
 * */


public class B2178{
    private static int[][] maze;
    private static boolean[][] isVisit;

    // up, down, left, right
    static int[] x = {0, 0, -1, 1};
    static int[] y = {1, -1, 0, 0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        maze = new int[N][M];
        isVisit = new boolean[N][M];
        sc.nextLine();

        //set maze
        for(int i=0; i<N; i++){
           String[] currRow =  sc.nextLine().split("");
           for(int j=0; j<M; j++){
               if(currRow[j] != ""){
               maze[i][j] = Integer.parseInt(currRow[j]);
               }
           }
        }

        //solve maze
        Position goal = new Position(N-1, M-1);
        solveMaze(goal);

    }

    private static void solveMaze(Position goal){
    Queue<Position> queue = new LinkedList<>();
    Position start = new Position(0,0);
    start.step = 1;
    queue.offer(start);
    isVisit[0][0] = true;

    while(queue.size() >  0){
        Position currPosition = queue.poll();
        if(currPosition.isArrive(goal)){
            System.out.println(currPosition.step);
            break;

        }

        for(int i=0; i<4; i++){
            int nextY = currPosition.y + y[i];
            int nextX = currPosition.x + x[i];

            if( nextY >= 0 && nextY < maze.length && nextX >= 0 && nextX < maze[0].length
                    && !isVisit[nextY][nextX]
                    && maze[nextY][nextX] == 1){

                Position nextPosition = new Position(nextY, nextX);
                nextPosition.step = currPosition.step + 1;
                queue.offer(nextPosition);
                isVisit[nextY][nextX] = true;

         }
        }
      }
    }

    private static void printMaze(){
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Position{
    public int x, y, step;
    public Position(int y, int x){
        this.x = x;
        this.y = y;
    }
    public boolean isArrive(Position goal){
        if(this.x == goal.x && this.y == goal.y){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        return String.format("x = %s, y = %s, step = %s \n", this.x, this.y, this.step);
    }

}
