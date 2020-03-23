package Dyanamic;

import java.util.Scanner;

public class cutting_rod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price= {1,5,8,9,10,17,17,20};
		int result=func(price,8);
		System.out.println(result);

	}
	public static int func(int[] price,int length) {
		int[] max_profit=new int[length+1];
		for(int i=1;i<=length;i++) {
			int max=0;
			for(int j=0;j<i;j++) {
				max=Math.max(max, max_profit[i-j-1]+price[j]);
			}
			System.out.println(max);
			max_profit[i]=max;
		}
		return max_profit[length];
	}

}
