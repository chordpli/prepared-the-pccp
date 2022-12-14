package bruteforce.p42839;

import java.util.HashSet;
import java.util.Set;

// 소수 찾기
public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        String numbers = "01521";
        System.out.println(s.solution(numbers));

    }
    /*
    1. 글자별로 숫자 저장.
    2. set에 저장.
    3. 해당 숫자가 소수인지 확인하고 리턴
     */

    static String[] numbersArr;
    static boolean[] check;
    static Set<Integer> savedNums = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        // 1. 문자열을 숫자로 변환하여 하나씩 저장
        numbersArr = numbers.split("");
        check = new boolean[numbersArr.length];
        dfs(0, "");

        // 4. 해당 숫자가 소수인지 확인한다.
        return (int) savedNums.stream().filter(Solution::prime).count();

    }

    static void dfs(int depth, String current) {
        if (depth > numbersArr.length) return;

        for (int i = 0; i < numbersArr.length; i++) {
            if (!check[i]) {
                check[i] = true;
                // 2. set에 저장한다.
                savedNums.add(Integer.valueOf(current + numbersArr[i]));
                dfs(depth + 1, current + numbersArr[i]);
                check[i] = false;
            }

        }
    }

    static boolean prime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
