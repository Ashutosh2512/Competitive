import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub\
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		ArrayList<Integer> enter=new ArrayList<Integer>();
		ArrayList<Integer> out=new ArrayList<Integer>();
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringTokenizer st1=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			enter.add(Integer.parseInt(st.nextToken()));
			out.add(Integer.parseInt(st1.nextToken()));
		}
		
		int j=0,count=0,i=j;
		while(i<n) {
			i=j;
			while(j<n && out.get(j)!=enter.get(i)) {
				j++;
				count++;
			}
			j++;
			i=j;
		}
		System.out.println(count);
	}
}
