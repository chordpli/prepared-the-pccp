package bfs_dfs.p43164;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    // 방문한 곳 처리
    static boolean visited[];
    // 간 루트들을 저장합니다.
    static ArrayList<String> savedRoute;


    // ticket[0] -> ticket[1]로 가는 항권권.
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        // 방문한 곳 초기화
        visited = new boolean[tickets.length];
        // 모두 방문하였음을 체크해야한다.
        int count = 0;
        // 간 루트들 초기화
        savedRoute = new ArrayList<>();

        // 출발점
        String start = "ICN";
        // 루트 저장(ICN부터 출발하므로 ICN을 입력)
        String route = "ICN";
        dfs(start, route, tickets, count);

        Collections.sort(savedRoute);
        answer = savedRoute.get(0).split(" ");
        return answer;
    }

    void dfs(String start, String route, String[][] tickets, int count) {
        // 모든 공항을 다 돌아다녔다면, 저장된 문자열을 어레이리스트에 저장한다.
        if (count == tickets.length) {
            savedRoute.add(route);
        }

        // 모든 공항을 다 돌아다녀야 하므로 티켓만큼 이동.
        for (int i = 0; i < tickets.length; i++) {
            // 시작점과 티켓의 출발점이 같고, 방문하지 않았을 경우
            // 이전 도착점인 [i-1][1]과 [i][0]이 동일해야한다.(그래야 잘 도착한 것)
            if (start.equals(tickets[i][0]) && !visited[i]) {
                // 방문처리
                visited[i] = true;
                // A->B로 갔으므로 B공항에서 ->C로 가야한다.
                // 그러므로 시작점이 B공항이 되어야하므로 ticket[i][1]이 된다.
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] tickets = {
                /*y=0*/ /*y=1*/
                /*x=0*/{"ICN", "SFO"},
                /*x=1*/{"ICN", "ATL"},
                /*x=2*/{"SFO", "ATL"},
                /*x=3*/{"ATL", "ICN"},
                /*x=4*/{"ATL", "SFO"}
        };
        System.out.println(Arrays.toString(s.solution(tickets)));
    }
}