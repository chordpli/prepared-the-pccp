package binarysearch.p12982;

import java.util.Arrays;

public class Solution2 {
    /**
     * @param d      부서별 금액이 들어있는 배열
     * @param budget 예산을 나타냅니다
     */
    public int solution(int[] d, int budget) {
        // d를 정렬합니다.
        Arrays.sort(d);

        // 몇 부서에 나눠 줬는지 체크합니다.
        int count = 0;

        for (int i = 0; i < d.length; i++) {
            budget -= d[i];
            if (budget >= 0) count++;
            if (budget <= 0) break;
        }

        return count;
    }
}
