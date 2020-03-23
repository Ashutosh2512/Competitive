package Dyanamic;

public class is_subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1= {19,5,3};
		int[] arr2= {10, 5, 2, 23, 19};
		boolean b=func(arr1,arr2);
		System.out.println(b);
	}
	//this dp function can be used to check if one array is subset of another iff the arrays don't contain
	//same element more than once
	public static boolean func(int[] arr1,int[] arr2) {
		int l1=arr1.length;
		int l2=arr2.length;
		int count=0;
		int[][] arr=new int[l1+1][l2+1];
		for(int i=0;i<l1+1;i++) {
			for(int j=0;j<l2+1;j++) {
				if(i==0||j==0) {
					arr[i][j]=0;
				}else {
					if(arr1[i-1]==arr2[j-1]) {
						count=1;
					}
					arr[i][j]=arr[i-1][j]+count;
				}
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
			count=0;
		}
		if(arr1.length==arr[l1][l2]){
			return true;
		}
		return false;	
	}
}
