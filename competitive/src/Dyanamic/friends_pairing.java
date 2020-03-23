package Dyanamic;

public class friends_pairing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result=count(3);
		System.out.println(result);
	}
	public static int count(int n) {
		if(n==0 || n==1) {
			return 1;
		}
		return count(n-1)+count(n-2)*(n-1);
	}
	
	public static int count1(int n) {
		int[] arr=new int[n+1];
		arr[0]=1;
		arr[1]=1;
		for(int i=2;i<n+1;i++) {
			arr[i]=arr[i-1]+(i-1)*arr[i-2];
		}
		return arr[n];
	}
}
