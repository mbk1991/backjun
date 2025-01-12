import java.util.*;


/*백준 1260번 문제: DFS와 BFS
 *입력을 그래프로 저장하고DFS로 탐색한 결과, BFS로 탐색한 결과를 출력하는 문제.
 *그래프로 저장하는 3가지 방법별로 DFS, BFS탐색의 구현을 각각 연습할 수 있다.
 * */

public class B1260{

    private static boolean[] isVisit;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc. nextLine());
        int numberOfNodes = Integer.parseInt(st.nextToken());
        int numberOfLinks = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());
        isVisit = new boolean[numberOfNodes+1];

        //read input and make graph.
        //그래프의 표현 방법(가중치가 없는 무방향그래프)
        //1) 엣지리스트(edge list) -> 2차원 배열 
        //2) 인접행렬 (adjacency matrix) -> 2차원 배열
        //3) 인접리스트 (adjacency list) -> 리스트 배열
     
        //1) edge list
        //edge list는 엣지 기준이라 탐색하기 불편하다.
        /*
        int[][] edgeList = new int[2][numberOfLinks];
        for(int i=0; i<numberOfLinks; i++){
            edgeList[0][i] = sc.nextInt();
            edgeList[1][i] = sc.nextInt();
        }  
        printArray(edgeList);

        */

        /*
        //2) adjacency matrix
        int[][] adjacencyMatrix = new int[numberOfNodes+1][numberOfNodes+1];
        for(int i=0; i<numberOfLinks; i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            adjacencyMatrix[node1][node2] = 1;
            adjacencyMatrix[node2][node1] = 1;
        }


        dfs(adjacencyMatrix, startNode);
        System.out.println();
        clearVisit();
        bfs(adjacencyMatrix,startNode);
        */

        //3) adjacency list
        List<Integer>[] adjacencyList = new List[numberOfNodes + 1];
        //adjacency list init
        for(int i=0; i<adjacencyList.length; i++){
            adjacencyList[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<numberOfLinks; i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            adjacencyList[node1].add(node2);
            adjacencyList[node2].add(node1);
        }

        for(int i=1; i<adjacencyList.length; i++){
            System.out.println(adjacencyList[i].toString());
        }

        dfs(adjacencyList, startNode);
    }

    private static void dfs(int[][] graph, int startNode){
       // dfsRcsv(graph, startNode);
       dfsStack(graph, startNode);
    }

    private static void dfs(List[] graph, int startNode){
        dfsRcsv(graph, startNode);
        clearVisit();
        dfsStack(graph, startNode);
    }

    private static void bfs(int[][] graph, int startNode){
        bfsQueue(graph, startNode);
    }

    private static void bfs(List[] graph, int startNode){

    }

    private static void dfsRcsv(int[][] graph, int node){
        //1. 처리
        System.out.print(node + " ");
        isVisit[node] = true;
        //2. 연결된 노드 이동
        for(int i=1; i<graph.length; i++){
            if(graph[node][i] == 1 && !isVisit[i] ){
                dfsRcsv(graph, i);
            }
        }
    }

    private static void dfsRcsv(List[] graph, int node){
        //1. 처리
        System.out.println(node + " ");
        System.out.println("node : " + node);
        isVisit[node] = true;
        //2. 그래프 이동 처리
        for(int i=0; i<graph[node].size(); i++){
            int linkNode =(int)graph[node].get(i);
            if(!isVisit[linkNode]){
                dfsRcsv(graph, linkNode);
            }
        }
    }

    private static void dfsStack(int[][] graph, int startNode){
        Stack<Integer> st = new Stack<>();
        st.push(startNode);

        while(!st.isEmpty()){
            int currNode = st.pop();
            //1. 처리
            if(!isVisit[currNode]){
                System.out.print(currNode + " ");
                isVisit[currNode] = true;
            }

            //2. 연결된 노드 이동
            for(int i=graph.length-1; i>0; i--){
                if(graph[currNode][i] == 1 && !isVisit[i] ){
                    st.push(i);
                }
            }
        }
    }
    
    private static void dfsStack(List[] graph, int startNode){

    }

    private static void bfsQueue(int[][] graph, int startNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        //1. 처리
        while(queue.size() > 0 ){
            int currNode = queue.poll();
            if(!isVisit[currNode]){
                System.out.print(currNode + " ");
                isVisit[currNode] = true;
            }

        //2. 연결된 노드 이동 
            for(int i=0; i<graph.length; i++){
                if(graph[currNode][i] == 1 && !isVisit[i] ){
                    queue.offer(i);
                }
            }
        }
    }

    private static void clearVisit(){
        Arrays.fill(isVisit,false);
    }

    private static void printArray(int[][] array){
        for(int i=0; i<array[0].length; i++){
            for(int j=0; j<array.length; j++){
                System.out.print( array[j][i] + " " );
        }
            System.out.println();
        }
    }

/*
그래프를 객체지향적으로 설계한다면?
    abstract class Graph<T> {
        Scanner scanner;
        boolean[] isVisit;
        int nodes;
        int links;

        abstract void setGraph();
        abstract void dfs(T startNode);
        abstract void bfs(T startNode);

        void isVisitInit(){
            isVisit = new boolean[getGraphSize() + 1];
        }
        abstract int getGraphSize();
    }

    class EdgeList<T> extends Graph<T>{
        T[][] edgeList;

        public EdgeList(Scanner sc, int nodes, int links){
            super.scanner = sc;
            super.nodes = nodes;
            super.links = links;
            edgeList = new T[2][links + 1];
        }

        @Override
        void setGraph(){

        }

        
        @Override
        void dfs(T startNode){

        }

        @Override
        void bfs(T startNode){

        }

        @Override
        int getGraphSize(){
            return 0;
        }

    }

    class AdjacencyMatrix<T> extends Graph<T>{
        T graph;
        
        @Override
        void dfs(T startNode){

        }

        @Override
        void bfs(T startNode){

        }

        @Override
        int getGraphSize(){
            return 0;
        }
    }

    class AdjacencyList<T> extends Graph<T>{
        T graph;

        @Override
        void dfs(T startNode){

        }

        @Override
        void bfs(T startNode){

        }

        @Override
        int getGraphSize(){
            return 0;
        }
    }
    */


}
