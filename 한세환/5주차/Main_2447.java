import java.io.*;

public class Main_2447 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                star(i,j,n);
            }
            System.out.println();
        }

    }

    public static void star(int r,int c, int num){

        if((r/num)%3==1 && (c/num)%3==1)
            System.out.print(" ");
        else{
            if(num/3==0)
                System.out.print("*");
            else
                star(r,c,num/3);
        }



    }

}
