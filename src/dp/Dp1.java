package dp;

import java.util.Scanner;
/*
https://acmicpc.net/problem/14501
 */
public class Dp1 {
    static final int MAX = 15;
    static int dp[] = new int[MAX];
    static int N;
    static int T[];
    static int P[];
    static int solve(int i) {
        if (i > N ) return -999999999;
        if (i == N ) return 0;

        int answer = dp[i];

        if(answer != -1) return answer;

        return Math.max(solve(i + 1), solve(i + T[i]) + P[i]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        T = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
            dp[i] = -1;
        }

        System.out.println(solve(0));

    }
}
