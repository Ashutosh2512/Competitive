package comp_important;

import java.util.ArrayList;
import java.util.Iterator;

public class all_subsequence {
	static ArrayList<String> list=new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3};
		func("abc","",0);
		Iterator i=list.iterator();
		while(i.hasNext()) {
			System.out.println(i.next().toString());
		}
		
	}
	public static void powerset(int[] arr) {
		int size=arr.length;
		int pow_size=(int)Math.pow(2, size);
		for(int counter=0;counter<pow_size;counter++) {
			for(int j=0;j<size;j++) {
				if((counter & (1 << j))>0) {
					System.out.print(arr[j]+" ");
				}
			}
			System.out.println();
		}
		
	}
	//subsequences of a particular length k
	public static void func(String given,String str,int position) {
		if(position==given.length() || str.length()==2) {
			if(str.length()==2) {
				list.add(str);
			}
			return;
		}
		func(given,str+given.charAt(position),position+1);
		func(given,str,position+1);
	}
	
}
