
import java.util.*;

public class IncMatrix implements Graph {
private double m[][];
private int cur = 0;
public IncMatrix(int v, int e){
m = new double[v][e];
for(int i = 0 ; i < v ;i++)
for(int j = 0 ; j < e ; j++)
m[i][j]=0;
}
public void addEdge(int u, int v, double w) {
if(w<=0) return;
if(u<m.length&&v<m.length&&cur<m[0].length) {
m[u][cur] = w;
m[v][cur] = w;
cur++;
}
}
public String toString() {
String s = "";
for(int i = 0; i < m.length ; i++){
for(int j = 0 ; j < m[i].length ; j++)
s += m[i][j] + " ";
s+="\n";
}
return s;
}
public String bfs(int t) {
	String a = "";
	boolean[] visit = new boolean[m.length];
	for(int i = 0; i< m.length ; i++)
		visit[i] = false;
	Queue<Integer> q = new ArrayDeque<Integer>();
	q.add(t);
	visit[t] = true;
	Integer temp;
	while(q.size()>0){
		temp = q.remove();
		a+= temp + " ";
		if(temp==6) continue;
		for(int j = temp ; j < m[0].length ; j++) {
			int k = temp+1;
			if(m[temp][j]!=0) {
				while(m[temp][j]!= m[k][j]) {
					k++;
					if(k==m.length) break;
				}
			}
				if(k!=7&&!q.contains(k)) {
				if(visit[k]==false) {
					q.add(k);
					visit[k] = true;
				}
			}
			}
		}
	
	return a;

}
@Override
public String kruskal() {
	
	
	return null;
	// TODO Auto-generated method stub

}

}