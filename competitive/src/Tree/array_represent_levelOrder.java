package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class array_represent_levelOrder {
	static class node{
		int data;
		int min;
		int max;
		public node(int min,int data,int max) {
			this.min=min;
			this.data=data;
			this.max=max;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {11, 6, 13, 5, 12, 10};
		boolean bool=func(arr);
		System.out.println(bool);
	}
	public static boolean func(int[] arr) {
		Queue<node> q=new LinkedList<node>();
		node r=new node(Integer.MIN_VALUE,arr[0],Integer.MAX_VALUE);
		q.add(r);
		int i=1;
		int l=arr.length;
		while(q.size()!=0 && i!=l) {
			node a=q.peek();
			q.remove();
			if(arr[i]>a.min && arr[i]< a.data) {
				q.add(new node(a.min,arr[i],a.data));
				i++;
			}
			if(arr[i]<a.max && arr[i]>a.data) {
				q.add(new node(a.data,arr[i],a.max));
				i++;
			}
		}
		if(i==l) {
			return true;
		}
		return false;
	}
}
