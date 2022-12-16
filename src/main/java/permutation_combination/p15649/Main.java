package permutation_combination.p15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    /* 자연수 N과 M이 주어졌을 떄, 조건을 만족하는 수열을 구하라

     */

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    /**
     * N = 숫자 몇까지 출력할지
     * M = 숫자를 몇 개 출력할지 .
     */
    static int N, M;
    static ArrayList<String> answer = new ArrayList<>();
    static boolean visit[];

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
    }

    static void dfs(int depth, String str) {
        if (depth == M) {
            answer.add(str.trim());
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, str + i + " ");
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dfs(0, "");
        for (String s :answer) {
            System.out.println(s);
        }
    }
}
