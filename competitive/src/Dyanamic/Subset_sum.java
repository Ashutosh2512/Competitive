package Dyanamic;

public class Subset_sum {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3};
		boolean[] b=new boolean[4];
		boolean bool=func1(arr,4);
		System.out.println(bool);
	}
	
	public static boolean func(int[] arr,int m,int sum){
		
		if(sum==0) {
			
			
			return true;
		}
		if(m==0 && sum>0) {
			return false;
		}
		if(arr[m]>sum) {
			return func(arr,m-1,sum);
		}
		return func(arr,m-1,sum-arr[m])||func(arr,m-1,sum);
		
		
	}
	public static boolean func1(int[] arr,int sum) {
		int n=arr.length;
		boolean[][] subset=new boolean[sum+1][n+1];
		for(int i=0;i<=n;i++) {
			subset[0][i]=true;
		}
		for(int j=1;j<=sum;j++) {
			subset[j][0]=false;
		}
		for(int i=1;i<=sum;i++) {
			for(int j=1;j<=n;j++) {
				subset[i][j]=subset[i][j-1];
				if(i>=arr[j-1]) {
					subset[i][j]=subset[i][j]||subset[i-arr[j-1]][j-1];
				}
			}
		}
		return subset[sum][n];
	}
	
}
