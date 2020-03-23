package Dyanamic;

public class catalan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(catalan_number(3));
	}
	public static int catalan_number(int n) {
		int[] arr=new int[n+1];
		arr[0]=1;
		for(int i=1;i<n+1;i++) {
			for(int j=0;j<i;j++) {
				arr[i]+=arr[j]*arr[i-1-j];
			}
		}
		return arr[n];
	}
}
