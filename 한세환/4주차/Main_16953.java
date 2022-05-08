import java.io.*;
import java.util.*;

class Search{
    long num;

    int cnt;

    Search(long num , int cnt){
        this.num = num;
        this.cnt = cnt;
    }
}

public class Main_16953 {

    static long startN, target;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        startN = Long.parseLong(st.nextToken());
        target = Long.parseLong(st.nextToken());

        bfs();

    }

    public static void bfs(){

        Queue<Search> queue = new LinkedList<>();
        queue.offer(new Search(startN,1));

        while (!queue.isEmpty()){
            Search now = queue.poll();

            if(now.num == target){
                System.out.println(now.cnt);
                return;
            }

            if(now.num*2<=target){
                queue.offer(new Search(now.num*2, now.cnt+1));
            }
            if(now.num*10+1<=target){
                queue.offer(new Search(now.num*10+1, now.cnt+1));
            }
        }
        System.out.println(-1);

    }

}