package Dyanamic;

public class getTotalNumberofSequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(func1(5,2));
	}
	//recursive solution
	public static int func(int m,int n) {
		if(m<n) {
			return 0;
		}
		if(n==0) {
			return 1;
		}
		return func(m-1,n)+func(m/2,n-1);
	}
	//DP solution
	public static int func1(int m,int n) {
		int[][] T=new int[m+1][n+1];
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==0) {
					T[i][j]=0;
				}else if(j==0) {
					T[i][j]=1;
				}
				else if(i<j) {
					T[i][j]=0;
				}else if(j==1) {
					T[i][j]=i;
				}else {
					T[i][j]=T[i-1][j]+T[i/2][j-1];
				}
			}
		}
		return T[m][n];
	}
}
