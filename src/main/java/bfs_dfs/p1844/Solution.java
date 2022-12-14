package bfs_dfs.p1844;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 상, 하, 좌, 우 이동
    static int[] x = {0, 0, 1, -1};
    static int[] y = {-1, 1, 0, 0};
    // 재방문 방지
    boolean[][] visited;

    public int solution(int[][] maps) {
        // 재방문 방지 초기화
        visited = new boolean[maps.length][maps[0].length];
        return bfs(maps);
    }

    private int bfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        // 큐에 시작점을 넣는다.
        queue.add(new int[]{0, 0});
        // 시작점 방문 완료
        visited[0][0] = true;


        // 큐가 비워질때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 값을 빼서 임시 폴더에 넣는다.
            int[] temp = queue.poll();

            // 4번, 4방향 반복
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + x[i];
                int ny = temp[1] + y[i];

                // 지도의 범위를 벗어났을 때 생략
                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) {
                    continue;
                }

                // 방문하지 않았으면서, 해당 지도의 숫자가 1인 경우 방문해야 하므로 true
                if (!visited[nx][ny] && maps[nx][ny] == 1) {
                    // 방문 하는 순간 true
                    visited[nx][ny] = true;
                    // 방문하였으므로 해당 좌표를 큐에 넣는다.
                    queue.add(new int[]{nx, ny});
                    // 기준 자리의 값 + 1 (거리가 증가)
                    maps[nx][ny] = maps[temp[0]][temp[1]] + 1;
                }
            }
        }
        // 지도의 끝에 도착하였으면, 도착점의 값을 반환한다.
        if (visited[maps.length - 1][maps[0].length - 1]) {
            return maps[maps.length - 1][maps[0].length - 1];
        } else {
            // 지도의 끝에 도달하지 못했으면 -1 반환
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        Solution s = new Solution();
        System.out.println(s.solution(maps));
    }
}