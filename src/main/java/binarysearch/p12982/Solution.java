package binarysearch.p12982;

import java.util.Arrays;

public class Solution {
    /**
     *
     * @param d
     * 부서별 금액이 들어있는 배열
     * @param budget
     * 예산을 나타냅니다
     */
    public int solution(int[] d, int budget) {
        int answer = 0;

        // d를 정렬합니다.
        Arrays.sort(d);

        // 몇 부서에 나눠 줬는지 체크합니다.
        int count = 0;
        // 최대로 나눠준 부서의 값을 저장합니다.
        int max = 0;


        for (int i = 0; i < d.length; i++) {
            // 사용중인 금액을 저장합니다.
            int used = d[i];
            if(used <= budget)count ++;
            for (int j = i+1; j <d.length ; j++) {
                if (used + d[j] > budget) {
                    if (used - d[j - 1] + d[j] <= budget) {
                        count--;
                        used -= d[j-1];
                    }else{
                        break;
                    }
                }
                used += d[j];
                count++;
            }

            if (count > max) {
                max = count;
            }
            count = 0;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] d = {4};
        System.out.println(s.solution(d, 3));
    }
}
