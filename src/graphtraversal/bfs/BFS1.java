package graphtraversal.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/24444
public class BFS1 {
    static int count;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        for (int i = 1; i <= N; i++) Collections.sort(graph.get(i));
        count = 1;
        BFS(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void BFS(int R) {
        visited[R] = count;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(R);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for(int i : graph.get(v)) {
                if (visited[i] == 0) {
                    count++;
                    visited[i] = count;
                    queue.offer(i);
                }
            }
        }
    }
}
