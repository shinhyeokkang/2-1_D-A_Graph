public class GraphTest {
	public static void main(String[] args) {
		Graph g = new IncMatrix(7,11);
		g.addEdge(0, 1, 3);
		g.addEdge(0, 2, 17);
		g.addEdge(0, 3, 6);
		g.addEdge(1, 3, 5);
		g.addEdge(1, 6, 12);
		g.addEdge(2, 4, 10);
		g.addEdge(2, 5, 8);
		g.addEdge(3, 4, 9);
		g.addEdge(4, 5, 4);
		g.addEdge(4, 6, 2);
		g.addEdge(5, 6, 14);
		
		System.out.println(g);
		
		System.out.println("BFS: " + g.bfs(0));
		//System.out.println("kruskal algorithm: " + g.kruskal());
		/*System.out.println("prim's algorithm: " + g.prim(0).bfs(0));*/
	}
}
