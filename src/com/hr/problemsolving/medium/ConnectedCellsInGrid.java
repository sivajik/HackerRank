package com.hr.problemsolving.medium;

import java.util.HashMap;
import java.util.LinkedList;

public class ConnectedCellsInGrid {

	public static void main(String[] args) {
		 int[][] a = new int[][] { { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, {
		 1, 0, 0, 0 } };
		
		//int[][] a = new int[][] { { 1, 1, 0 }, { 1, 0, 0 }, { 0, 0, 1 } };
		
		/*int[][] a = new int[][] {
			{0,0,1,1},
			{0,0,1,0},
			{0,1,1,0},
			{0,1,0,0},
			{1,1,0,0}
		};*/
		System.out.println(connectedCell(a));
	}

	// Complete the connectedCell function below.
	static int connectedCell(int[][] matrix) {
		DFSGraph g = new DFSGraph(matrix);
		g.print();
		System.out.println("==========");
		g.DFS();
		return g.maxPath;
	}

	static class DFSGraph {
		int v;
		LinkedList<Vertex> adj[] = null;
		HashMap<Integer, Vertex> map = null;

		private static int counter = 0;

		DFSGraph(int[][] adjMartix) {
			this.v = adjMartix.length;
			map = new HashMap<Integer, Vertex>();
			adj = new LinkedList[v + 1];
			for (int i = 1; i <= this.v; i++) {
				adj[i] = new LinkedList<Vertex>();
				map.put(i, new Vertex(i));
			}

			for (int i = 0; i < adjMartix.length; i++) {
				for (int j = 0; j < adjMartix[i].length; j++) {
					if (adjMartix[i][j] == 1) {
						addEdge(i + 1, j + 1);
					}
				}
			}
		}

		public void addEdge(int u, int v) {
			//if (Math.abs(u - v) <= 1) {
				adj[u].add(map.get(v));
			//}
		}

		public void print() {
			System.out.println("Printing Graph");
			for (int i = 1; i <= v; i++) {
				System.out.println("Vertex : " + (i) + " : adhList = " + this.adj[i]);
			}
		}

		public static int maxPath = Integer.MIN_VALUE;

		public void DFS() {
			for (int i = 1; i <= v; i++) {
				if (map.get(i).color == VertexColor.WHITE) {
					System.out.println("\n\nDisjoint Tree Started starting at vertex: " + i);
					DFSVisit(i);
					System.out.println("Traversal Path: " + counter);
					if (counter > maxPath) {
						maxPath = counter;
					}
					resetColors();
					counter = 0;
				}
			}
		}

		public void resetColors() {
			for (int i = 1; i <= v; i++) {
				map.get(i).color = VertexColor.WHITE;
			}
		}

		public void DFSVisit(int u1) {
			Vertex u = map.get(u1);
			u.color = VertexColor.GRAY;
			// u.startTime = counter++;
			System.out.println(u);
			for (Vertex v : adj[u1]) {
				if (v == u) {
					counter++;
					continue;
				}
				if (v.color == VertexColor.WHITE) {
					v.predecessor = u;
					counter++;
					DFSVisit(v.vertex);
				} else if (v.color == VertexColor.GRAY) {
					counter++;
				}
			}
			// u.endTime = counter++;
			u.color = VertexColor.GRAY;
		}
	}

	static class Vertex {
		int startTime;
		int endTime;
		Vertex predecessor;
		int vertex;
		VertexColor color;

		Vertex(int vertex) {
			this.vertex = vertex;
			this.color = VertexColor.WHITE;
			this.predecessor = null;
		}

		public String toString() {
			return " " + vertex + "[" + startTime + "/" + endTime + "]";
		}
	}

	static enum VertexColor {
		WHITE, GRAY, BLACK;
	}

}