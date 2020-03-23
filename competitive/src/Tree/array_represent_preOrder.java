package Tree;

import java.util.List;
import java.util.Stack;

public class array_represent_preOrder {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,4,1};
		System.out.println(func(arr));
		
	}
	
	public static boolean func(int[] pre) {
		Stack<Integer> s = new Stack<Integer>(); 
		  int n=pre.length;
        // Initialize current root as minimum possible 
        // value 
        int root = Integer.MIN_VALUE; 
  
        // Traverse given array 
        for (int i = 0; i < n; i++) { 
        	
            // If we find a node who is on right side 
            // and smaller than root, return false 
            if (pre[i] < root) { 
            	
                return false; 
            } 
  
            // If pre[i] is in right subtree of stack top, 
            // Keep removing items smaller than pre[i] 
            // and make the last removed item as new 
            // root. 
            while (!s.empty() && s.peek() < pre[i]) { 
                root = s.peek(); 
                s.pop(); 
            } 
  
            // At this point either stack is empty or 
            // pre[i] is smaller than root, push pre[i] 
            s.push(pre[i]); 
        } 
        return true; 
	}
}
