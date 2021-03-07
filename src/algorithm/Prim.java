package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prim {
    static int N;
    static int E;
    static ArrayList<Edge>[] graph;
    static boolean visit[];
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 정점 수
            E = Integer.parseInt(st.nextToken()); // 간선 갯수

            visit = new boolean[N+1];
            graph = new ArrayList[N+1]; // 1번부터 각 정점에 연결된 간선 정보 저장 리스트 여러개
            for(int i=1; i<=N; i++)
                graph[i] = new ArrayList<>();

            for(int e=0; e<E; e++){ // 인접행렬과 같은 역할의 그래프 만들기
                st = new StringTokenizer(br.readLine());

                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                graph[v1].add(new Edge(v2,value));
                graph[v2].add(new Edge(v1,value));
            }

            ans = 0;
            makeMST();
            System.out.println("#"+tc+" "+ans);
        }


    }

    static void makeMST(){
        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator()); // 후보 간선들 중 미니멈 밸류 정렬해주는 queue
        int now=1, cnt=1; // 1번 정점에서 출발하고 연결 완료된 정점의 갯수 1
        visit[1] = true; // 1번 정점 방문처리 해놓기

        while(cnt<N){ // 방문할 정점이 남아있으면
            List<Edge> nowEdges = graph[now]; // 현재 정점에 연결된 간선들의 정보

            for(int i=0; i<nowEdges.size(); i++){
                Edge edge = nowEdges.get(i);
                if(!visit[edge.num]){ // 간선 도착 노드가 방문하지 않은 노드라면
                    pq.add(edge); // 후보 간선으로 추가시켜놓자.
                }
            }

            while(!pq.isEmpty()){ // 짧은 거부터 빼겠지만 혹시 이미 방문한 정점으로 가는 간선이면 안써야 해서 반복문.
                Edge edge = pq.poll(); // 우선순위 큐라서 가장 짧은 간선이 나옴.
                if(!visit[edge.num]){ // 이 간선 끝이 방문한적 없는 노드이면 다음 방문 정점으로 만들자.
                    visit[edge.num] = true; // 방문처리
                    ans += edge.value; // 현재 선택하는 간선의 가중치 더해놓자.
                    now = edge.num; // 이제 다음 정점에 서있는 상태임.
                    cnt++;
                    break; // 유효 간선 중 최소 value를 찾아 선택했으므로 반복은 종료해도 됨.
                }
            }
        }
    }

    static class Edge{
        int num, value; // 간선 끝에 매달려 있는 정점 번호와 해당 간선의 가중치

        Edge(int num, int value){
            this.num = num;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node [e=" + num + ", v=" + value + "]";
        }
    }

    static class EdgeComparator implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.value > o2.value ? 1 : -1;
        }
    }

}

/*
7
11
1 2 2
2 3 5
1 3 20
1 4 10
4 5 1
5 6 23
3 6 3
3 5 6
7 6 9
7 3 2
2 7 7

 */