package Dyanamic;

public class temple_offering {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height= {1,4,3,6,2,1};
		int[] arr=func(height);
		for(int c:arr) {
			System.out.print(c+" ");
		}
	}
	//naive approach
	public static int[] func(int[] height) {
		int l=height.length;
		int[] offering=new int[l];
		for(int i=0;i<l;i++) {
			if(i==0) {
				offering[i]=1;
			}
			else if(height[i]>height[i-1]) {
				offering[i]=offering[i-1]+1;
			}else if(height[i]<height[i-1]){
				offering[i]=offering[i-1]-1;
			}else {
				offering[i]=offering[i-1];
			}
			if(offering[i]==0) {
				int k=i;
				while(k>=0 && height[k]<height[k-1]) {
					offering[k]+=1;
					k--;
				}
			}
		}
		return offering;
	}
}
