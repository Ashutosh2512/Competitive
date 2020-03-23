package Dyanamic;

public class Ugly_numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ugly(11));
	}
	public static int ugly(int n) {
		int[] arr=new int[n];
		
		int i2=0;
		int i3=0;
		int i5=0;
		
		arr[0]=1;
		
		int multiple_of_2=arr[i2]*2;
		int multiple_of_3=arr[i3]*3;
		int multiple_of_5=arr[i5]*5;
		
		
		
		int next_ugly=1;
		
		for(int i=1;i<n;i++) {
			next_ugly=min(multiple_of_2,multiple_of_3,multiple_of_5);
			
			arr[i]=next_ugly;
			
			if(next_ugly==multiple_of_2) {
				i2++;
				multiple_of_2=arr[i2]*2;
			}
			if(next_ugly==multiple_of_3) {
				i3++;
				multiple_of_3=arr[i3]*3;
			}
			if(next_ugly==multiple_of_5) {
				i5++;
				multiple_of_5=arr[i5]*5;
			}
		}
		return next_ugly;
	}
	public static int min(int a,int b,int c) {
		int min=(a<b)?a:b;
		min=(min<c)?min:c;
		return min;
	}
}
