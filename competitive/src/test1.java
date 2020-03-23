import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class test1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<t;i++) {
			int n=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			String s=br.readLine();
			boolean[] solved=new boolean[n];
			char[] arr=new char[n];
			int count=0;
			for(int j=0;j<n;j++) {
				char c1=s.charAt(j);
				if(c1=='R') {
					if(b>0) {
						solved[j]=true;
						arr[j]='P';
						b--;
						count++;
					}else {
						solved[j]=false;
					}
				}
				else if(c1=='P') {
					if(c>0) {
						solved[j]=true;
						arr[j]='S';
						c--;
						count++;
					}else {
						solved[j]=false;
					}
				}
				else {
					if(a>0) {
						solved[j]=true;
						arr[j]='R';
						a--;
						count++;
					}
					else {
						solved[j]=false;
					}
				}
			}
			int temp;
			if(n%2==0) {
				temp=n/2;
			}else {
				temp=n/2+1;
			}
			if(count>=temp) {
				System.out.println("YES");
				for(int j=0;j<n;j++) {
					if(!solved[j]) {
						if(a>0) {
							arr[j]='R';
						}
						else if(b>0) {
							arr[j]='P';
						}else {
							arr[j]='S';
						}
					}
					System.out.print(arr[j]);
				}
			}
			else {
				System.out.println("NO");
			}
			System.out.println();
		}
	}
}
