package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	int n;
	LinkedList<Integer> adjList[];
	
	public Graph(int n) {
		this.n=n;
		adjList=new LinkedList[n];
		for(int i=0;i<n;i++) {
			adjList[i]=new LinkedList<Integer>();
		}
	}
	void addEdge(int s,int d) {
		adjList[s].add(d);
	}
	void bfs(int start) {
		boolean[] b=new boolean[n];
		b[start]=true;
		LinkedList<Integer> queue=new LinkedList<Integer>();
		queue.add(start);
		while(!queue.isEmpty()) {
			int p=queue.poll();
			System.out.println(p);
			Iterator it=adjList[p].iterator();
			while(it.hasNext()) {
				int k=(int)it.next();
				if(b[k]!=true) {
					b[k]=true;
					queue.add(k);
				}
			}
		}
	}
	void DFS(int s,boolean[] visited) {
		visited[s]=true;
		System.out.println(s);
		Iterator it=adjList[s].iterator();
		while(it.hasNext()) {
			int k=(int) it.next();
			if(visited[k]!=true) {
				DFS(k,visited);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g=new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		boolean[] b=new boolean[4];
		b[2]=true;
		g.DFS(2,b);
	}

}
