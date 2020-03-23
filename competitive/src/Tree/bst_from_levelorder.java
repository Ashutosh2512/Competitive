package Tree;

public class bst_from_levelorder {
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

	}
	public static node constructBST(int[] arr) {
		if(arr==null) {
			return null;
		}
		node root=null;
		int l=arr.length;
		for(int i=0;i<l;i++) {
			root=level(root,arr[i]);
		}
		return root;
	}
	public static node level(node root,int n) {
		if(root==null) {
			return new node(n);
		}
		if(n<root.data) {
			root.left=level(root.left,n);
		}else {
			root.right=level(root.right,n);
		}
		return root;
	}
}
