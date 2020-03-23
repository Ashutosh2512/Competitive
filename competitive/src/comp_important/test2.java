package comp_important;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
//this program is used to calculate the maximum value of & between a selected pair of 
//elements from an array.Eg: {4,8,10,2} will have a max & value for 8 and 10.

public class test2 {
	static int[] flag;
	public static void main(String args[]) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int i;
		int[] arr=new int[n];
		flag=new int[32];
		Arrays.fill(flag,0);
		for(i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		int max=func(arr,4);
		
		System.out.println(max);
	
		
	}
	public static int func(int[] arr,int level) {
		if(level==-1) {
			return 0;
		}
		int i,l=arr.length,count=0,ans=0;;
		for(i=0;i<l;i++) {
			if(flag[i]==0) {
				if((arr[i] & (1 << (level-1)))!=0) {
					count++;
				}
			}
		}
		if(count>=2) {
			ans+=(1<<level-1);
			for(i=0;i<l;i++) {
				if((arr[i] & (1<<level-1))==0) {
					flag[i]=1;
				}
			}
		}
		return ans+func(arr,level-1);
	}
}
