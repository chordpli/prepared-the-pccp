package greedy.p42862;

public class Fail {

    public static int[] check = new int[31];

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int count = reserve.length;

        for (int i = 0; i < lost.length; i++) {
            check[lost[i]] = check[lost[i]] + 1;
        }

        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] - 1 == lost[j] && check[reserve[i] - 1] > 0 && count > 0) {
                    check[reserve[i] - 1] = check[reserve[i] - 1] - 1;
                    count--;
                    break;
                }

                if (reserve[i] + 1 == lost[j] && check[reserve[i] + 1] > 0 && count > 0) {
                    check[reserve[i] + 1] = check[reserve[i] + 1] - 1;
                    count--;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (check[i] == 1) {
                answer++;
            }
        }
        return n - answer;
    }

    public static void main(String[] args) {
        Fail s = new Fail();
        int n = 3;
        int[] lost = {1, 2};
        int[] reserve = {2, 3};

        System.out.println(s.solution(n, lost, reserve));
    }
}
