package Dyanamic;

public class tiling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result=number_of_tiles(4);
		System.out.println(result);
	}
	public static int number_of_tiles(int n) {
		int[] count=new int[n+1];
		count[0]=1;
		count[1]=1;
		for(int i=2;i<n+1;i++) {
			count[i]=count[i-1]+count[i-2];
		}
		return count[n];
	}
}
