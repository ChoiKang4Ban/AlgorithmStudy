import java.io.*;
import java.util.*;

public class Main_15787 {

    static int n,m;
    static int trains[];

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        Set<Integer> trainset = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trains = new int[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int trainIdx = Integer.parseInt(st.nextToken());
            int seat;

            // 명령어 따른 구분
            switch (order){

                case 1:{
                    seat = Integer.parseInt(st.nextToken());
                    trains[trainIdx] |=(1<<seat);
                    break;
                }
                case 2:{
                    seat = Integer.parseInt(st.nextToken());
                    trains[trainIdx] &=~(1<<seat);
                    break;
                }
                case 3:{
                    trains[trainIdx]<<=1;
                    trains[trainIdx] &= ((1 << 21) - 1);
                    break;
                }
                case 4:{
                    trains[trainIdx] >>= 1;
                    trains[trainIdx] &= ~1;
                    break;
                }
            }

        }

        //Set을 활용하여 중복이 되어있는 기차를 제거함.
        for (int i = 1; i <= n; i++) {
            trainset.add(trains[i]);
        }
        System.out.println(trainset.size());

    }
}
