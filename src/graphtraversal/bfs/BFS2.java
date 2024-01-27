package graphtraversal.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1260
public class BFS2 {

    static int graph[][];
    static boolean isVisited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        DFS(V);
        Arrays.fill(isVisited, false);
        System.out.println();
        BFS(V);
    }

    static void DFS(int V) {
        isVisited[V] = true;
        System.out.print(V);
        for (int i = 1; i < graph[V].length; i++) {
            if (graph[V][i] == 1 && !isVisited[i]) {
                System.out.print(" ");
                DFS(i);
            }
        }
    }

    static void BFS(int start) {
        isVisited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for(int i = 1; i < graph[v].length; i++) {
                if(graph[v][i] == 1 && !isVisited[i]) {
                    isVisited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
