package graph;

import java.util.Arrays;

public class spanning_tree {

	public static void main(String[] args) {
		edge[] e1=new edge[7];
		e1[0]=new edge(0,1,1);
		e1[1]=new edge(3,4,2);
		e1[2]=new edge(1,4,3);
		e1[3]=new edge(1,3,4);
		e1[4]=new edge(1,2,5);
		e1[5]=new edge(2,4,6);
		e1[6]=new edge(0,2,7);
		kruskal(e1,5);
	}
	
	public static void kruskal(edge[] edges,int n){
		int[] parents=new int[n];
		Arrays.fill(parents, -1);
		Arrays.sort(edges);
		int length=edges.length;
		int cycles=0;
		int sum=0;
		for(int i=0;i<length;i++) {
			System.out.println(i);
			int one=edges[i].first;
			int two=edges[i].second;
			int x=find(parents,one);
			int y=find(parents,two);
			if(x==y && x!=-1) {
				cycles++;
			}
			union(parents,x,y);
		}
		System.out.println("min weight "+sum);
		System.out.println("number of cycles "+cycles);
		for(int i:parents) {
			System.out.print(i+" ");
		}
	}
	public static int find(int[] parent,int x) {
		if(parent[x]==-1) {
			return x;
		}
		return find(parent,parent[x]);
	}
	public static void union(int[] parent,int x,int y) {
		int xset=find(parent,x);
		int yset=find(parent,y);
	    if(xset!=x && yset==y) {
			parent[yset]=xset;
		}
	    else {
	    	parent[xset]=yset;
	    }
	}

}

class edge implements Comparable<edge>{
	int first;
	int second;
	int weight;
	
	public edge(int first,int second,int weight) {
		this.first=first;
		this.second=second;
		this.weight=weight;
	}
	
	@Override
	public int compareTo(edge e) {
		if(this.weight>e.weight) {
			return 1;
		}else if(this.weight==e.weight) {
			return 0;
		}
		return -1;
	}
}