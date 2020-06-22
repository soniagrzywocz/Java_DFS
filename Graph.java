package lab12;

import java.util.*;

public class Graph {

    private int V; // number of vertices
    private LinkedList<Integer> adj[];


    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void edge_addition(int source, int destination) {
        adj[source].add(destination);
    }


    public boolean DFS(int v) {

        System.out.println("Starting the depth-first search");
        boolean[] black = new boolean[V]; // for the nodes that we visited
        Stack<Integer> stack = new Stack<>();
        long topTime = System.nanoTime();
        for (int start = 0; start < V; start++) {
            long iniTime = System.nanoTime();
            if (black[start] == false) {
                stack.push(start);
                black[start] = true;
                while (stack.isEmpty() == false) {
                    int indexN = stack.pop();
                    System.out.print(indexN + " ");
                    LinkedList<Integer> nodeList = adj[indexN];

                    for (int i = 0; i < nodeList.size(); i++) {
                        int counter = 0;
                        int dest = nodeList.get(i);
                        if (black[dest] == false) {
                            stack.push(dest);
                            black[dest] = true;
                        }
                    }
                    long finalT = System.nanoTime();
                    long execT = (finalT - iniTime);
                    System.out.println("Total time taken to find the node:  " + execT);

                }

            }
        }
        long topEndTime = System.nanoTime();
        long finT = (topEndTime - topTime);
        System.out.println("Total time of the depth-first search: " + finT);

        System.out.println();
        return false;
    }
    public void topSortHelper(int v, boolean black[], Stack stack) {
        black[v] = true;
        Iterator<Integer> iterator = adj[v].iterator();
        while(iterator.hasNext()) {
            int i = iterator.next();
            if (!black[i]) {
                topSortHelper(i, black, stack);
            }
        }
        stack.push(v);
    }
    public void topologicalSort() {
        Stack stack = new Stack();

        boolean black[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            black[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (!black[i]) {
                topSortHelper(i, black, stack);
            }
        }
        while (!stack.empty()) {
            System.out.println("Topological sort: " + stack.pop() + " ");
        }
    }

    public void printGraph() {
        System.out.println("NODE RELATIONSHIPS");
        System.out.println();
        for (int i = 0; i < V; i++) {
            LinkedList<Integer> list = adj[i];
            if (list.isEmpty() == false) {
                System.out.println("Node" + " " + i + " " +  "is connected to:" );
                //System.out.println(i + ":");
                for (int j = 0; j < list.size(); j++) {
                    System.out.print(list.get(j) + ",");
                }
            }

           System.out.println();
        }
    }
}







