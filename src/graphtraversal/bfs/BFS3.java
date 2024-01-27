package graphtraversal.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2178
public class BFS3 {

    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int N;

    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 2][M + 2];
        visited = new boolean[N + 2][M + 2];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                graph[i][j] = s.charAt(j - 1) - '0';
            }
        }
        BFS();
        System.out.println(graph[N][M]);
    }

    static void BFS() {
        visited[1][1] = true;
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();
        xQueue.offer(1);
        yQueue.offer(1);
        while (!xQueue.isEmpty() && !yQueue.isEmpty()) {
            int x = xQueue.poll();
            int y = yQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (graph[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    xQueue.offer(nx);
                    yQueue.offer(ny);
                    graph[ny][nx] = graph[y][x] + 1;
                }
            }
        }
    }
}
