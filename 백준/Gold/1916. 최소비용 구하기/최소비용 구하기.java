import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* 다익스트라 알고리즘 연습 */
public class Main {

    private static class City implements Comparable<City> {

        int id;
        int cost;

        public City(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(City city) {  // cost를 기준으로 정렬
            return this.cost - city.cost;
        }
    }

    private static int dijkstra(int N, List<City>[] graph, int start, int end) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<City> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new City(start, 0));

        while (!priorityQueue.isEmpty()) {
            City currentCity = priorityQueue.poll();

            if (currentCity.id == end) {
                return currentCity.cost;
            }

            if (currentCity.cost > distance[currentCity.id]) {
                continue;
            }

            for (City neighbor : graph[currentCity.id]) {
                int newCost = currentCity.cost + neighbor.cost;

                if (newCost < distance[neighbor.id]) {
                    distance[neighbor.id] = newCost;
                    priorityQueue.offer(new City(neighbor.id, newCost));
                }
            }
        }

        return distance[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());  // 도시 개수
        int M = Integer.parseInt(br.readLine());  // 버스 개수

        List<City>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());  // 출발
            int v = Integer.parseInt(st.nextToken());  // 도착
            int w = Integer.parseInt(st.nextToken());  // 비용 (가중치)
            graph[u].add(new City(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(N, graph, start, end));
    }
}
