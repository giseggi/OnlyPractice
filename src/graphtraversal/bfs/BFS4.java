package graphtraversal.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1697
public class BFS4 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static int level;

    static int[] visited;

    static int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        Arrays.fill(visited, -1);

        graph.add(new ArrayList<>());
        graph.get(0).add(1);
        for (int i = 1; i < 100000; i++) {
            graph.add(new ArrayList<>());
            graph.get(i).add(i - 1);
            graph.get(i).add(i + 1);
        }
        graph.add(new ArrayList<>());
        graph.get(MAX).add(MAX - 1);

        for (int i = 1; i <= 50000; i++) {
            graph.get(i).add(i * 2);
        }
        level = 1;
        BFS(N);
        System.out.println(visited[K]);

    }

    static void BFS(int N) {
        int nextLevelCount = 1;
        int temp = 0;
        visited[N] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i : graph.get(n)) {
                if (visited[i] == -1) {
                    visited[i] = level;
                    queue.offer(i);
                    temp++;
                }
            }
            nextLevelCount--;
            if (nextLevelCount == 0) {
                level++;
                nextLevelCount = temp;
                temp = 0;
            }
        }
    }
}
