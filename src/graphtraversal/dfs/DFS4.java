package graphtraversal.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1012
public class DFS4 {
    static int[][] graph;

    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int l = 0; l < T; l ++ ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            count = 0;
            graph = new int[M + 2][N + 2];
            visited = new boolean[M + 1][N + 1];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[y + 1][x + 1] = 1;
            }

            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        DFS(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    static void DFS(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (graph[ny][nx] == 1 && !visited[ny][nx]) {
                DFS(ny, nx);
            }
        }
    }
}
