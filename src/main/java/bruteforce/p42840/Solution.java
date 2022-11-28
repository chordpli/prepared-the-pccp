package bruteforce.p42840;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == arr[0][i % arr[0].length]) score[0]++;
            if (answers[i] == arr[1][i % arr[1].length]) score[1]++;
            if (answers[i] == arr[2][i % arr[2].length]) score[2]++;
        }
        int max = Arrays.stream(score).max().getAsInt();
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) count++;
        }

        int[] answer = new int[count];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) {
                answer[idx] = i + 1;
                idx++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = {3, 3, 1, 1, 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(s.solution(answer)));
    }

}
