package divide_and_conquer;

public class kth_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1= {2,3,6,7,9};
		int[] arr2= {1,4,8,10,55};
		System.out.println(func(arr1,arr2,arr1.length-1,arr2.length-1,10));

	}
	public static int func(int[] arr1,int[] arr2,int end1,int end2,int k) {
		if(k==1) {
			return arr1[0]<arr2[0]?arr1[0]:arr2[0];
		}
		if(end1+end2+2==k) {
			return arr1[end1]>arr2[end2]?arr1[end1]:arr2[end2];
		}
		int mid1=end1/2;
		int mid2=end2/2;
		if(end1+end2+2>k) {
			if(arr1[end1]<arr2[end2]) {
				return func(arr1,arr2,end1,mid2,k);
			}
			return func(arr1,arr2,mid1,end2,k);
		}
		if(arr1[end1]<arr2[end2]) {
			return func(arr1,arr2,end1+mid1+1,end2,k);
		}
		return func(arr1,arr2,end1,end2+mid2+1,k);
	}
}
