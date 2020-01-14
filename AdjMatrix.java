import java.util.*;

public class AdjMatrix implements Graph {
	private double m[][];
	public class Edge implements Comparable<Edge>{
		private int u, v;
		private double weight;
		public Edge(int x, int y, double w) {
			u=x;v=y;weight =w;
		}
		public int compareTo(Edge e) {
			if(weight < e.weight) 	return -1;
			else if(weight > e.weight) return 1;
			else return 0;
		}
		public String toString() {
			return "("+u+","+v+"):"+weight;
		}
	}
	
	public AdjMatrix(int n){
		m = new double[n][n];
		for(int i = 0; i < n ; i++)
			for(int j = 0 ; j < n ; j++) 
				m[i][j] = 0;
	}
	public void addEdge(int u, int v, double w) {
		if( w <= 0 ) return;
		if(u<m.length && v < m.length) {
			m[u][v] = w;
			m[v][u] = w;
		}
	}
	public String toString() {
		String s = "";
		for(int i = 0; i < m.length ; i++){
			for(int j = 0 ; j < m.length ; j++)
				s += m[i][j] + " ";
			s+="\n";
		}
		return s;
	}
	public String bfs(int n) {
		String s = "";
		boolean[] visit = new boolean[m.length];
		for(int i = 0; i< m.length ; i++)
			visit[i] = false;
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(n);
		visit[n] = true;
		Integer temp;
		while(q.size()>0){
			temp = q.remove();
			s+= temp + " ";
			for(int i = 0 ; i < m.length ; i++) {
				if(m[temp][i]>0)
					if(visit[i]==false) {
						q.add(i);
						visit[i] = true;
					}
			}
		}
		return s;
	}
	public String kruskal() {
		String s = "";
		Set<Integer> set = new Set(m.length);
		ArrayList<Edge> e = new ArrayList<Edge>();
		double totalWeight = 0;
		for(int i = 0; i < m.length ; i++)
			for(int j =i ; j < m.length ; j++) {
				if(m[i][j]!= 0) e.add(new Edge(i,j,m[i][j]));
			}
		//Sort edges (u, v)ordered by weight(u, v), increasing
		e.sort(new Comparator<Edge>(){
			public int compare(Edge o1, Edge o2) {		return o1.compareTo(o2);		}
			});
		for(int i = 0, numOfEdges = 0 ; i < e.size() ; i++) {
			int u = e.get(i).u,v = e.get(i).v;  
			if(!set.isSameSet(u,v)) {
				numOfEdges ++;
				set.union(u, v);
				totalWeight += e.get(i).weight;
				if(numOfEdges < m.length-1)	s += e.get(i).toString() +", ";
				else {
					s += e.get(i).toString() +": "+ totalWeight+ "\n";
					break;
				}
			}
		}
		return s;
	}
 /*	public Graph prim(int v) {
		Graph result = new AdjMatrix(m.length);
		Set set = new Set(m.length);
		int temp = v;
		int numOfEdge = 0;
		double totalWeight = 0.0;
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		while(numOfEdge < m.length-1) {
			for(int i = 0 ; i < m.length ; i++) {
				if(m[temp][i]>0 && !set.isSameSet(temp, i)) 
					q.add(new Edge(temp, i, m[temp][i]));
			}
			Edge e = null;
			do {
				e = q.remove();
			}	while(set.isSameSet(temp,e.v));
			if(e!= null) {
				result.addEdge(e.u, e.v, e.weight);
				set.union(e.u, e.v);
				temp = e.v;
				numOfEdge++;
			} else numOfEdge = m.length +1;
		}
		
		return result;
		
	
	}*/ 
}
