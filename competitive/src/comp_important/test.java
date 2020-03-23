package comp_important;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class test {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[] arr;
		String str;
		int n;
		while((str=br.readLine())!=null) {
			n = Integer.parseInt(str);
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr=new int[n];
			for(int j=0;j<n;j++) {
				arr[j]=Integer.parseInt(st.nextToken());
			}
			System.out.println(func(arr,arr.length,0));
		}
	}
	public static int func(int[] arr,int l,int smoke) {
		if(l==0 || l==1) {
			return smoke;
		}
		int[] arr1=new int[l-1];
		int min=Integer.MAX_VALUE;
		int pos=-1,product=Integer.MAX_VALUE;
		int i,j=0;
		for(i=0;i<l-1;i++) {
			if(min>((arr[i]+arr[i+1])%100)){
				pos=i;
				min=(arr[i]+arr[i+1])%100;
			}
			else if(min==(arr[i]+arr[i+1])%100 && product>arr[i]*arr[i+1]) {
				product=arr[i]*arr[i+1];
				pos=i;
			}
		}
		smoke+=arr[pos]*arr[pos+1];
		for(i=0;i<l;i++) {
			if(i==pos) {
				arr1[j]=(arr[i]+arr[i+1])%100;
				i++;
			}else {
				arr1[j]=arr[i];
			}
			j++;
		}
		if(arr1[pos]==0) {
			return smoke;
		}
		return func(arr1,l-1,smoke);
	}
	
}
