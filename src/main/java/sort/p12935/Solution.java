package sort.p12935;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] arr) {
        // 최소값 찾기
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        // arr의 length가 1일 때, 최소값을 반환하면 빈 배열이 되므로 -1을 리턴
        if (arr.length == 1) return new int[]{-1};

        // 최소값을 제거하고 배열을 리턴하므로 입력된 배열의 길이 -1을 한다.
        int[] answer = new int[arr.length - 1];

        // answer의 index를 체크해줄 int i 선언
        int i = 0;

        // 배열에서 꺼낸 값이 min이면 Pass, 아니면 answer 배열에 넣는다.
        for (int num : arr) {
            if(num == min) continue;
            answer[i] = num;
            i++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {3, 2, 1, 4, 5};

        System.out.println(Arrays.toString(s.solution(arr)));
    }
}
