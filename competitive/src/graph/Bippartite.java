package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;



public class Bippartite {
	static int size=4;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] g=new int[6][6];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			g[u][v]=1;
			g[v][u]=1;
		}
		boolean b=isBipartite(g,0);
		if(b) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
	public static boolean isBipartite(int[][] g,int source) {
		//create a color array for each vertex
		//-1->initial(white) 1->red 0->green
		int[] arr=new int[size];
		Arrays.fill(arr, -1);
		arr[0]=1;
		LinkedList<Integer> q=new LinkedList<Integer>();
		q.add(0);
		while(!q.isEmpty()) {
			int pos=q.pop();
			if(g[pos][pos]==1) {
				return false;
			}
			for(int i=0;i<size;i++) {
				if(g[pos][i]==1 && arr[i]==-1) {
					arr[i]=1-arr[pos];
					q.add(i);
				}else if(g[pos][i]==1 && arr[i]==arr[pos]){
					return false;
				}
				
			}
		}
		return true;
	}
}
