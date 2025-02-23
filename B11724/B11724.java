import java.util.*;

public class B11724{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numberOfNodes = sc.nextInt();
        int numberOfLinks = sc.nextInt();
        boolean[] isVisit = new boolean[numberOfNodes + 1];

        List<Integer>[] graph = new List[numberOfNodes + 1];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<numberOfLinks; i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        int result = 0;
        for(int i=1; i<graph.length; i++){
            if(isVisit[i]) continue;

            //bfs
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.offer(i);
            isVisit[i] = true;

            while(queue.size() > 0){
                int currNode = queue.poll();
                for(int nextNode : graph[currNode]){
                    if(!isVisit[nextNode]){
                        queue.offer(nextNode);
                        isVisit[nextNode] = true;
                    }
                }
            }

            result ++;
        }
        System.out.println(result);
    }





}
