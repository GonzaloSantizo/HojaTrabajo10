
// Java program to find the shortest
// path between any two nodes using
// Floyd Warshall Algorithm.
import java.util.*;
import java.util.Scanner;

class Main {

    static final int MAXN = 100;

    // Infinite value for array
    static int INF = (int) 1e7;

    static int[][] dis = new int[MAXN][MAXN];
    static int[][] Next = new int[MAXN][MAXN];

    // Initializing the distance and
    // Next array
    static void initialise(int V,
            int[][] graph) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dis[i][j] = graph[i][j];

                // No edge between node
                // i and j
                if (graph[i][j] == INF)
                    Next[i][j] = -1;
                else
                    Next[i][j] = j;
            }
        }
    }

    // Function construct the shortest
    // path between u and v
    static Vector<Integer> constructPath(int u,
            int v) {

        // If there's no path between
        // node u and v, simply return
        // an empty array
        if (Next[u][v] == -1)
            return null;

        // Storing the path in a vector
        Vector<Integer> path = new Vector<Integer>();
        path.add(u);

        while (u != v) {
            u = Next[u][v];
            path.add(u);
        }
        return path;
    }

    // Standard Floyd Warshall Algorithm
    // with little modification Now if we find
    // that dis[i][j] > dis[i][k] + dis[k][j]
    // then we modify next[i][j] = next[i][k]
    static void floydWarshall(int V) {
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {

                    // We cannot travel through
                    // edge that doesn't exist
                    if (dis[i][k] == INF ||
                            dis[k][j] == INF)
                        continue;

                    if (dis[i][j] > dis[i][k] +
                            dis[k][j]) {
                        dis[i][j] = dis[i][k] +
                                dis[k][j];
                        Next[i][j] = Next[i][k];
                    }
                }
            }
        }
    }

    // Print the shortest path
    static void printPath(Vector<Integer> path) {
        int n = path.size();
        for (int i = 0; i < n - 1; i++)
            System.out.print(path.get(i) + " -> ");
        System.out.print(path.get(n - 1) + "\n");
    }

    // Driver code
    public static void main(String[] args) {
        int V = 5;
        int[][] graph = { { 0, 30, INF, INF, 15 },
                { 30, 0, 25, INF, 40 },
                { INF, 25, 0, 15, 70 },
                { INF, INF, 15, 0, 90 },
                { 15, 40, 70, 90, 0 } };

        // Function to initialise the
        // distance and Next array
        initialise(V, graph);

        // Calling Floyd Warshall Algorithm,
        // this will update the shortest
        // distance as well as Next array
        floydWarshall(V);
        Vector<Integer> path;

        Scanner scan = new Scanner(System.in);

        int opcion = 0;
        View Vista = new View();

        while (opcion != 4) {

            System.out.println("\n\nWelcome where do you want to go?");
            System.out.println("1. Go to a new city (Enter origen and destination)");
            System.out.println("2. Show center of graph");
            System.out.println("3. Modify map (graph)");
            System.out.println("4. Exit\n\n");

            opcion = scan.nextInt();

            if (opcion == 1) {
                // Ask for origen and destination
                // Path from node 1 to 3
                int Origen;
                int Destination;

                System.out.println("\nEnter origen City (just the number):");
                Vista.PrintCities();

                Origen = scan.nextInt();

                System.out.println("\nEnter destination City (just the number):");
                Vista.PrintCities();

                Destination = scan.nextInt();

                System.out.print("Shortest path from Origen to Destination: ");
                path = constructPath(Origen, Destination);
                printPath(path);

            } else if (opcion == 2) {
                // Show center of graph
            } else if (opcion == 3) {
                // Modify current graph

                scan = new Scanner(System.in);

                Int ChangeGraph;

                Vista.PrintCities();
                ChangeGraph = scan.nextInt();

            } else if (opcion == 4) {
                // Exit
            }
        }
    }
}
