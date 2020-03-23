package divide_and_conquer;

public class max_subArray_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,5,9,7};
		System.out.print(maxSum(arr,0,arr.length-1));

	}
	public static int maxSum(int[] arr,int l,int h) {
		if(l==h) {
			return arr[h];
		}
		int m=(l+h)/2;
		return Math.max(Math.max(maxSum(arr,l,m),maxSum(arr,m+1,h)),maxMidSum(arr,l,h,m));
	}
	public static int maxMidSum(int[] arr,int l,int h,int m) {
		int left_sum=Integer.MIN_VALUE;
		int i,sum=0;
		for(i=m;i>=l;i--) {
			sum=sum+arr[i];
			if(sum>left_sum) {
				left_sum=sum;
			}
		}
		int right_sum=Integer.MIN_VALUE;
		sum=0;
		for(i=m+1;i<=h;i++) {
			sum+=arr[i];
			if(sum>right_sum) {
				right_sum=sum;
			}
		}
		return left_sum+right_sum;
	}
}
