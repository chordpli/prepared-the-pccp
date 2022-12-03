package sort.p12935;

import java.util.Arrays;

public class Fail {
    // arr에서 가장 작은 수를 제거한 배열을 리턴하는 함수
    // 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴
    public int[] solution(int[] arr) {
        int[] answer;

        // 리턴하려는 배열이 빈 배열인 경우 -1 리턴
        if (arr.length == 1) {
            return new int[]{-1};
        }

        answer = new int[arr.length - 1];

        // 최소 값이 있는 idx 저장
        int idx = 0;
        // 최소 값 기준 지정
        int min = arr[0];

        // 최소값 찾기
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i] < min) {
                min = arr[i];
                idx = i;
            }
        }

        // 최소값 마지막으로 빼버리기
        int temp = arr[idx];
        arr[idx] = arr[arr.length - 1];
        arr[arr.length-1] = temp;

        // 최솟값 빼고 넣기
        for (int i = 0; i <answer.length ; i++) {
            answer[i] = arr[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Fail s = new Fail();
        System.out.println(Arrays.toString(s.solution(new int[]{1,2,3,4,5})));
    }
}
