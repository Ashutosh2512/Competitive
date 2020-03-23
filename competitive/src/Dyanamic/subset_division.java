package Dyanamic;

public class subset_division {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,8,3};
		boolean b=func1(arr,7);
		System.out.println(b);
	}
	//naive
	public static boolean func(int[] arr,int n,int m,int sum) {
		if(m==0) {
			return false;
		}
		if(m==1) {
			return true;
		}
		
		if(sum%m==0 && sum!=0) {
			return true;
		}
		if(n<0) {
			return false;
		}
		
		return func(arr,n-1,m,sum+arr[n])||func(arr,n-1,m,sum);
	}
	
	public static boolean func1(int[] arr,int m) {
		int n=arr.length;
		if(n>m) {
			return true;
		}
		boolean[][] arr1=new boolean[m+1][n+1];
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==0) {
					arr1[i][j]=true;
				}else if(j==0 && i!=0) {
					arr1[i][j]=false;
				}else if(i<arr[j-1]) {
					arr1[i][j]=arr1[i][j-1];
				}else {
					arr1[i][j]=arr1[i][j-1] || arr1[i-arr[j-1]][j-1];
				}
			}
		}
		return arr1[m][n];
	}
}
