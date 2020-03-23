package Tree;

import java.util.ArrayList;

public class bst_to_balanced_bst {
	static class node{
		int data;
		node left;
		node right;
		public node(int data) {
			this.data=data;
			left=right=null;
		}
		public node() {
			left=right=null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(4);
		root.left=new node(3);
		root.left.left=new node(2);
		root.left.left.left=new node(1);
		root.right=new node(5);
		root.right.right=new node(6);
		root.right.right.right=new node(7);
		ArrayList<Integer> list=new ArrayList<Integer>();
		inorder(root,list);
		int l=list.size();
		int[] arr=new int[l];
		for(int i=0;i<l;i++) {
			arr[i]=list.get(i);
		}
		node root1=func(0,arr.length-1,arr);
		preorder(root1);
	}
	public static void preorder(node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
		
	}
	public static void inorder(node root,ArrayList<Integer> list) {
		if(root==null) {
			return;
		}
		
		inorder(root.left,list);
		list.add(root.data);
		inorder(root.right,list);
		
	}
	public static node func(int low,int high,int[] arr) {
		if(high-low==1) {
			node root=new node(arr[high]);
			root.left=new node(arr[low]);
			return root;
		}
		else if(high-low==2) {
			node root=new node(arr[low+1]);
			root.left=new node(arr[low]);
			root.right=new node(arr[high]);
			return root;
		}
		node root=new node(arr[(high-low)/2]);
		root.left=func(low,(high-low)/2-1,arr);
		root.right=func((high-low)/2+1,high,arr);
		return root;
	}
}
