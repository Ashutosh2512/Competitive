package Tree;

public class bst_sorted_array {
	static class node{
		int data;
		node left;
		node right;
		
		public node(int data) {
			this.data=data;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5,6,7};
		node root=func(arr,0,arr.length-1);
		inorder(root);
		
	}
	public static node func(int[] arr,int low,int high) {
		if(high==low) {
			return new node(arr[high]);
		}
		else if(high==low+1) {
			node a=new node(arr[high]);
			a.left=new node(arr[low]);
			return a;
		}
		node a=new node(arr[(low+high+1)/2]);
		a.left=func(arr,low,(low+high+1)/2-1);
		a.right=func(arr,(low+high+1)/2+1,high);
		return a;
	}
	public static void inorder(node root) {
		if(root==null) {
			return;
		}
		System.out.println(root.data);
		inorder(root.left);
		inorder(root.right);
		
	}
}
