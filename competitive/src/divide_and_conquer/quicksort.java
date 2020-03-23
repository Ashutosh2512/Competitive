package divide_and_conquer;

public class quicksort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,5,12,7,9};
		func(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void func(int[] arr,int low,int high) {
		if(low<high) {
			int pi=partition(arr,low,high);
			func(arr,low,pi-1);
			func(arr,pi+1,high);
		}
	}
	public static int partition(int[] arr,int low,int high) {
		int pivot=arr[high];
		int i=low-1;
		for(int j=low;j<high;j++) {
			if(arr[j]<=pivot) {
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr,i+1,high);
		return(i+1);
	}
	public static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
