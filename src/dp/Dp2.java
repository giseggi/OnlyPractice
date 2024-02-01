package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1005
public class Dp2 {

    static int[][] graph;

    static int[] dp;

    static int[] D;

    static int[] indegree;

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int l = 0; l < T; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            D = new int[N + 1];
            dp = new int[N + 1];
            graph = new int[N + 1][N + 1];
            indegree = new int[N + 1];
            st = new StringTokenizer(br.readLine());

            int index = 1;
            while (st.hasMoreTokens()) {
                D[index] = Integer.parseInt(st.nextToken());
                index++;
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = 1;
            }
            int W = Integer.parseInt(br.readLine());

            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    if (graph[j][i] == 1) indegree[i]++;

            topologicalSort();
            System.out.println(dp[W]);
        }
    }

    static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();
            dp[num] += D[num];
            for (int i = 1; i <= N; i++) {
                if (graph[num][i] == 1) {
                    if (--indegree[i] == 0) queue.offer(i);
                    if (dp[i] < dp[num]) dp[i] = dp[num];
                }
            }
        }
    }
}
