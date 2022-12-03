package binarysearch.p17681;

public class Solution {
    /**
     *
     * @param n
     * 지도 한 변의 길이, 각 칸은 공백(" ") 또는 벽("#)으로 이루어짐
     * @param arr1
     * 지도 1, 정수 배열
     * @param arr2
     * 지도 2, 정수 배열
     * @return
     */
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        // arr1, arr2를 2진수로 변환
        String[] arrToBinary = new String[n];
        for (int i = 0; i < n; i++) {
            // arr1[i] 와 arr2[i]를 OR 계산하여 arrToBinary배열에 집어넣는다.
            arrToBinary[i] = Integer.toBinaryString(arr1[i] | arr2[i]);

            // 2진법으로 계산한 결과의 길이가 n보다 작다면 앞에 부족한 길이만큼 0을 더해준다.
            for (int j = arrToBinary[i].length(); j < n ; j++) {
                arrToBinary[i] = "0" + arrToBinary[i];
            }
        }

        // 1인 경우에는 #, 0인 경우에는 " "을 출력한다.
        for (int i = 0; i < n; i++) {
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (arrToBinary[i].charAt(j) == '1') {
                    result.append("#");
                } else {
                    result.append(" ");
                }
            }
            answer[i] = String.valueOf(result);
        }
        return answer;
    }
}