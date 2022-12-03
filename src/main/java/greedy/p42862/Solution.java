package greedy.p42862;

import java.util.Arrays;

public class Solution {

    /**
     * @param n       전체 학생의 수
     * @param lost    체육복을 도난당한 학생들의 번호가 담긴 배열
     * @param reserve 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열
     * @return
     */

    // 전체 학생 수는 2명 이상 30명 이하
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌 체육복을 가져온 학생이 체육복을 도난 당했을 때
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = 0;
                    reserve[j] = 0;
                    break;
                }
            }
        }

        // 체육복을 빌려줘보자
        for (int i = 0; i < lost.length; i++) {
            // 도난 당했는데 여벌 가져온 사람은 빌려줄 수 없음.
            // 빌렸으면 패스
            if (lost[i] == 0) continue;
            for (int j = 0; j < reserve.length; j++) {
                // 도난 당했는데 여벌 가져온 사람은 빌려줄 수 없음.
                // 이미 빌려줬으므로 패스
                if (reserve[j] == 0) continue;
                if (reserve[j] - 1 == lost[i] || reserve[j] + 1 == lost[i]) {
                    // 빌려줬으므로 패스
                    reserve[j] = 0;
                    // 빌렸으므로 패스
                    lost[i] = 0;
                    break;
                }
            }
        }

        // 도난 당했는데 빌리지 못한 사람 체크
        int count = 0;
        for (int j : lost) {
            // j가 0 이상이면 아직도 못빌린사람.
            if (j > 0) {
                count++;
            }
        }

        // 전체 인원에서 못빌린 사람을 뺌.
        return n - count;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5;
        int[] lost = {4, 2};
        int[] reserve = {3, 5};

        System.out.println(s.solution(n, lost, reserve));
    }
}
