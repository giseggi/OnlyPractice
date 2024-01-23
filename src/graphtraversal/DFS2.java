package graphtraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2606
public class DFS2 {
    static int answer = 0;
    static int graph[][];
    static boolean isVisited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        graph = new int[V + 1][V + 1];
        isVisited = new boolean[V + 1];

        for(int i = 0; i < E; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        DFS(1);
        System.out.println(answer);
    }

    static void DFS(int v) {
        isVisited[v] = true;
        for(int i = 1; i < graph[v].length; i++) {
            if(graph[v][i] == 1 && !isVisited[i]) {
                answer++;
                DFS(i);
            }
        }
    }
}
