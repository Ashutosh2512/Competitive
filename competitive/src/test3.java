import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test3 {
	public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br =  
              new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());
       System.out.println(n*(n+1)*(n-1)/3-2);
    }
}
