package Tree;

import java.util.ArrayList;

public class reverse_path {
	static class node{
		int data;
		node left;
		node right;
		public node(int data) {
			this.data=data;
			left=right=null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root=new node(7);
		root.left=new node(6);
		root.right=new node(5);
		root.left.left=new node(4);
		root.left.right=new node(3);
		root.right.left=new node(2);
		root.right.right=new node(1);
		func(root,4);
		inorder(root);
	}
	public static void func(node root,int key){
		ArrayList<node> list=new ArrayList<node>();
		search(root,key,list);
		int l=list.size();
		for(int i=0;i<l/2;i++) {
			int temp=list.get(i).data;
			list.get(i).data=list.get(l-i-1).data;
			list.get(l-i-1).data=temp;
		}
	}
	public static boolean search(node root,int key,ArrayList<node> list) {
		if(root==null) {
			return false;
		}
		else if(root.data==key) {
			list.add(root);
			return true;
		}
		boolean left=search(root.left,key,list);
		boolean right=search(root.right,key,list);
		if(left) {
			list.add(root);
		}
		else if(right) {
			list.add(root);
		}
		return left||right ;
	}
	public static void inorder(node root) {
		if(root==null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
}
