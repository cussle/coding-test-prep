import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int[] fishes;
    static int cy = -1, cx = -1, size = 2, needed = 2, time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        fishes = new int[7];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int cur = Integer.parseInt(st.nextToken());
                board[i][j] = cur;

                // fish count
                if (cur > 0 && cur < 7) {
                    fishes[cur]++;
                }

                // starting point
                if (cur == 9) {
                    cy = i;
                    cx = j;
                    board[i][j] = 0;
                }
            }
        }

        // int debug = 0;
        Queue<int[]> queue;
        int[][] dist;
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        while (existEdibleFish()) {
            // debug++;

            queue = new ArrayDeque<>();
            queue.offer(new int[]{cy, cx});
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = -1;
                }
            }
            dist[cy][cx] = 0;

            int best = Integer.MAX_VALUE;
            int by = Integer.MAX_VALUE, bx = Integer.MAX_VALUE;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if (best != Integer.MAX_VALUE && dist[cur[0]][cur[1]] >= best) {
                    break;
                }
                
                for (int d = 0; d < 4; d++) {
                    int ny = cur[0] + dy[d];
                    int nx = cur[1] + dx[d];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= n || dist[ny][nx] != -1) {
                        continue;
                    }

                    if (board[ny][nx] > size) {
                        continue;
                    }

                    dist[ny][nx] = dist[cur[0]][cur[1]] + 1;

                    if (board[ny][nx] != 0 && board[ny][nx] < size && fishes[board[ny][nx]] > 0) {
                        if (best > dist[ny][nx]) {
                            by = ny;
                            bx = nx;
                            best = dist[ny][nx];
                        } else if (best == dist[ny][nx]) {
                            if (ny < by) {
                                by = ny;
                                bx = nx;
                            } else if (ny == by && nx < bx) {
                                by = ny;
                                bx = nx;
                            }
                        }
                    }

                    queue.offer(new int[]{ny, nx});
                }
            }

            if (best != Integer.MAX_VALUE) {
                cy = by;
                cx = bx;

                fishes[board[cy][cx]]--;
                needed--;
                board[cy][cx] = 0;

                time += best;

                if (needed < 1) {
                    size++;
                    needed = size;
                }
            } else {
                break;
            }

            // if (debug > 1000) {
            //     System.out.println("\n\n break due to debug status");
            //     break;
            // }
        }

        System.out.println(time);


        // System.out.println("\n\n\n = = = = = DEBUG = = = = =");
        // System.out.println("final size: " + size + " (need " + needed + " to size up)");
        // System.out.println("start from (y, x) = (" + cy + ", " + cx + ")");
        // System.out.println("fish count");
        // for (int i = 1; i < 7; i++) {
        //     System.out.println("size " + i + ": " + fishes[i]);
        // }
        // System.out.println("\n");
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }

    private static boolean existEdibleFish() {
        boolean status = false;
        int range = Math.min(7, size);
        for (int i = 1; i < range; i++) {
            if (fishes[i] > 0) {
                status = true;
            }
        }
        return status;
    }
}
