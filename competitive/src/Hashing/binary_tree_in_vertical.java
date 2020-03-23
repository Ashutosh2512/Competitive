package Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class binary_tree_in_vertical {
	static class node{
		int order;
		int data;
		node left;
		node right;
		public node(int data) {
			this.data=data;
			left=right=null;
		}
	}
	static class hashNode{
		int data;
		hashNode next;
		public hashNode(int data) {
			this.data=data;
		}
	}
	static ArrayList<node> list=new ArrayList<node>();
	static int min=0,max=0;
	
	public static void main(String[] args) {
		node root=new node(1);
		root.left=new node(2);
		root.right=new node(3);
		root.left.left=new node(4);
		root.left.right=new node(5);
		root.right.left=new node(6);
		root.right.right=new node(7);
		root.right.right.right=new node(8);
		preorder(root,0);	
		hashNode[] arr=new hashNode[max-min+1];
		int l=list.size();
		node ref=null;
		for(int i=0;i<l;i++) {
			ref=list.get(i);
			int position=ref.order+Math.abs(min);
			if(arr[position]==null) {
				arr[position]=new hashNode(ref.data);
			}else {
				hashNode h=arr[position];
				while(h.next!=null) {
					h=h.next;
				}
				h.next=new hashNode(ref.data);
			}
		}
		System.out.println(arr[2].next.next.data);
	}
	public static void preorder(node root,int i) {
		if(root==null) {
			return;
		}
		if(min>i) {
			min=i;
		}if(max<i) {
			max=i;
		}
		root.order=i;
		list.add(root);
		preorder(root.left,i-1);
		preorder(root.right,i+1);
	}
}
