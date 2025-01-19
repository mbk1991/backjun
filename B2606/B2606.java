import java.util.*;

/*
 *1번 노드와 연결된 노드의 개수를 세는 문제 (1번 노트는 제외인 것으로 보임)
 *bfs로 돌면서 세면 될 거 같음
 */
public class B2606{

    static boolean[] isVisit;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numberOfComputers = sc.nextInt();
        int numberOfLinks = sc.nextInt();
        isVisit = new boolean[numberOfComputers + 1];

        //adjacency list
        List<Integer>[] graph = new List[numberOfComputers + 1];
        for(int i=1; i<graph.length; i++){
            graph[i] = new ArrayList<Integer>();
        }

        //make graph
        for(int i=0; i<numberOfLinks; i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        int result = cntNode(graph);
        System.out.println(result - 1); // exclude  start node 

    }

    private static int cntNode(List<Integer>[] graph){
        Queue<Integer> queue = new LinkedList<>();        
        queue.offer(1); // start node
        isVisit[1] = true;

        int nodeCnt = 0;
        while(queue.size() > 0){
            int currNode = queue.poll();
            nodeCnt++;
            //linked node offer
            for(int i=0; i<graph[currNode].size(); i++){
                int nextNode = graph[currNode].get(i);

                if(!isVisit[nextNode]){
                    queue.offer(nextNode);
                    isVisit[nextNode] = true;

                }
            }
        }
        return nodeCnt;
    }
    
    private static void printGraph(List<Integer>[] graph){
        for(int i=1; i<graph.length; i++){
            System.out.println(graph[i].toString());
        }
    }
}

