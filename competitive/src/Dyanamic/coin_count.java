package Dyanamic;

public class coin_count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3};
		int result=coinchange1(arr,arr.length,10);
		System.out.println(result);
	}
	public static int coinchange(int[] arr,int m,int n) {
		
		if(n==0) {
			return 1;
		}
		if(n<0) {
			return 0;
		}  
		
		if(m<=0 && n>0) {
			return 0;
		}
		return coinchange(arr,m-1,n)+coinchange(arr,m,n-arr[m-1]);
	}
	public static int coinchange1(int[] arr,int m,int n) {
		int[] arr1=new int[n+1];
		arr1[0]=1;
		for(int i=0;i<m;i++) {
			for(int j=arr[i];j<=n;j++) {
				arr1[j]+=arr1[j-arr[i]];
			}
		}
		return arr1[n];
	}
}
