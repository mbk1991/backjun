import java.util.*;

/*그래프에서 연결된 노드의 개수를 노름차순으로 출력하는 문제
 *맵에서 상/하/좌/우인 
 * */

public class B2667{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];
        boolean[][] isChecked = new boolean[N][N];

        //make map
        for(int i = 0; i<N; i++){
            String line = sc.next();
            char[] columns = line.toCharArray();
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(columns[j]+"");
            }
        }

        Finder finder = new Finder(map);
        finder.find();
        finder.printAns();
    }
}

//find : 건물을 찾는 기능 - 단지 설정이 되지 않은 건물을 찾음
//check : 같은 단지인지 확인하는 기능 - 건물을 단지로 묶는 역할


    class Finder{
        int[][] map;
        boolean[][] isChecked;
        public Map<Integer,Integer> groupMap = new HashMap<>(); // 단지번호, 단지 내 건물 개수
        int groupIdx = 1;
        //up,down,left,right
        int[] rowDir = {-1,1,0,0};
        int[] colDir = {0,0,-1,1};

        public Finder(int[][] map){
            this.map = map;
            isChecked = new boolean[map.length][map.length];

        }

        public void find(){
            for(int i=0; i<map.length; i++){
                for(int j=0; j<map[0].length; j++){
                    if(map[i][j] != 0 && !isChecked[i][j]){
                        check(i,j,groupIdx);
                        groupIdx++;
                    }
                }
            }
        }

        private void check(int row, int col, int groupIdx){
            //process: isChecked true 및 카운팅
            isChecked[row][col] = true;
            int cnt = groupMap.getOrDefault(groupIdx, 0);
            groupMap.put(groupIdx, cnt + 1);

            //주변 확인
            for(int i=0; i<4; i++){
                int r = row + rowDir[i];
                int c = col + colDir[i];

                if(0 <= r && r < map.length && 0 <= c && c < map[0].length
                        && map[r][c] == 1 && !isChecked[r][c]){
                                check(r, c, groupIdx);
                        }
            }
        }

        public void printAns(){
            System.out.println(groupMap.size());

            groupMap.values().stream().sorted().forEach(v->{
                System.out.println(v);
            });


        }


    }





