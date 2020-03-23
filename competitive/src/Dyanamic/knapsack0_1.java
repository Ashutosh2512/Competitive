package Dyanamic;

public class knapsack0_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weight= {5,10,15};
		int[] value= {10,30,20};
		System.out.println(func1(weight,value,100));
	}
	public static int func(int[] weight,int[] value,int w) {
		int n=weight.length;
		int[][] max=new int[w+1][n+1];
		for(int i=0;i<w+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==0 || j==0) {
					max[i][j]=0;
				}else if(i>=weight[j-1]) {
					max[i][j]=Math.max(max[i][j-1],max[i-weight[j-1]][j-1] +value[j-1]);
				}else {
					max[i][j]=max[i][j-1];
				}
			}
		}
		return max[w][n];
	}
	public static int func1(int[] weight,int[] value,int w) {
		int n=weight.length;
		int[][] max=new int[w+1][n+1];
		for(int i=0;i<w+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==0 || j==0) {
					max[i][j]=0;
				}else if(i>=weight[j-1]) {
					max[i][j]=Math.max(max[i][j-1],max[i-weight[j-1]][j] +value[j-1]);
				}else {
					max[i][j]=max[i][j-1];
				}
			}
		}
		return max[w][n];
	}
}
