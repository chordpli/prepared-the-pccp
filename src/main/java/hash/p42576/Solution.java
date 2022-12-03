package hash.p42576;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> check = new HashMap<>();
        for (String s : participant) {
            check.put(s, check.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            check.put(s, check.get(s) - 1);
        }

        Set<String> keySet = check.keySet();
        String answer = null;
        for (String s : keySet) {
            if (check.get(s) == 1) {
                answer = s;
            }

        }
        return answer;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        String[] participant = {"lep", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(s.solution(participant, completion));
    }
}
