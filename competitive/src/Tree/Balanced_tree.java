package Tree;

public class Balanced_tree {
	
	static class node{
		int data;
		node left;
		node right;
		public node(int data) {
			this.data=data;
		}
	}
	node root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Balanced_tree b=new Balanced_tree();
        b.root=new node(1);
        b.root.left=new node(2);
        b.root.right=new node(3);
        b.root.left.left=new node(4);
        b.root.left.right=new node(5);
        int left=ifbalanced(b.root.left);
        int right=ifbalanced(b.root.right);
        int k=left-right;
        if(k==1 || k==0 || k==-1) {
        	System.out.println("balanced");
        }else {
        	System.out.println("not balanced");
        }
	}
	public static int ifbalanced(node root) {
		if(root==null) {
			return 0;
		}
		int left=1+ifbalanced(root.left);
		int right=1+ifbalanced(root.right);
		if(left-right>1 || left-right<-1) {
			System.out.println("not a balanced tree");
			System.exit(right-left);
		}
		return Math.max(left, right);
	}
}
