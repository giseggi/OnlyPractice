package graphtraversal.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.acmicpc.net/problem/2667
public class DFS3 {

    static int[][] graph;

    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new int[N + 10][N + 10];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for(int j = 1; j <= N; j++) graph[i][j] = s.charAt(j - 1) - '0';
        }

        List<Integer> countList = new ArrayList<>();
        for(int i = 1; i <= N; i ++) {
            for(int j = 1; j <= N; j++) {
                if(graph[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    DFS(i, j);
                    countList.add(count);
                }
            }
        }
        System.out.println(countList.size());
        countList.stream().sorted().forEach(System.out::println);
    }

    static void DFS(int y, int x) {
        visited[y][x] = true;
        count++;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(graph[ny][nx] == 1 && !visited[ny][nx] && checkBoundary(nx, ny, graph.length)) {
                DFS(ny, nx);
            }
        }
    }

    static boolean checkBoundary(int x, int y, int N) {
        return x < N && y < N;
    }
}
