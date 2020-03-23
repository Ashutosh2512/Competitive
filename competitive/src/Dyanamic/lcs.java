package Dyanamic;
//LCS can be used to solve the longest repeating subproblems
public class lcs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(func("abcd","acde",3,3,0));
	}
	//recursive
	public static int func(String s1,String s2,int m,int n,int count) {
		if(m<0 || n<0) {
			return count;
		}
		if(s1.charAt(m)==s2.charAt(n)) {
			return func(s1,s2,m-1,n-1,count+1);
		}
		return Math.max(func(s1,s2,m-1,n,count), func(s1,s2,m,n-1,count));
	}
	//DP solution
	public static int func1(String s1,String s2) {
		int m=s1.length();
		int n=s2.length();
		int[][] arr=new int[m+1][n+1];
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==0||j==0) {
					arr[i][j]=0;
				}else if(s1.charAt(i-1)==s2.charAt(j-1)) {
					arr[i][j]=arr[i-1][j-1]+1;
				}else {
					arr[i][j]=Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		return arr[m][n];
	}
}
