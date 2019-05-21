package com.hr.problemsolving.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ConnectedCellsInGrid1 {

	public static void main(String[] args) {
		// 5
		 //int[][] a = new int[][] { { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, {1, 0, 0, 0 } };
// 3
		//int[][] a = new int[][] { { 1, 1, 0 }, { 1, 0, 0 }, { 0, 0, 1 } };
// 8
		//int[][] a = new int[][] { { 0, 0, 1, 1 }, { 0, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };

/*		int[][] a = new int[][] {
			{0, 1, 1, 1, 1},
			{1, 0, 0, 0, 1},
			{1, 1, 0, 1, 0},
			{0, 1, 0, 1, 1},
			{0, 1, 1, 1, 0}
		};
		*/
		int[][] a = new int[][] {
		{0, 1, 0, 0, 0, 0, 1, 1, 0},
		{1, 1, 0, 0, 1, 0, 0, 0, 1},
		{0, 0, 0, 0, 1, 0, 1, 0, 0},
		{0, 1, 1, 1, 0, 1, 0, 1, 1},
		{0, 1, 1, 1, 0, 0, 1, 1, 0},
		{0, 1, 0, 1, 1, 0, 1, 1, 0},
		{0, 1, 0, 0, 1, 1, 0, 1, 1},
		{1, 0, 1, 1, 1, 1, 0, 0, 0}
		};
		System.out.println(connectedCell(a));
	}

	// Complete the connectedCell function below.
	static int connectedCell(int[][] matrix) {
		DFSGraph g = new DFSGraph(matrix);
		g.print();
		System.out.println("==========");
		g.DFS();
		return g.maxPath + 1;
	}

	static class Pair {
		int row, col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}

		// Depends only on account number
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (row + col);
			return result;
		}

		// Compare only account numbers
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (this.row == other.row && this.col == other.col) {
				return true;
			}
			return false;
		}

	}

	static class DFSGraph {
		int v;
		LinkedList<Vertex> adj[] = null;
		HashMap<Integer, Vertex> map = null;

		private static int counter = 0;

		DFSGraph(int[][] adjMartix) {
			this.v = 0;
			for (int i = 0; i < adjMartix.length; i++) {
				this.v += adjMartix[i].length;
			}

			map = new HashMap<Integer, Vertex>();
			adj = new LinkedList[v + 1];
			for (int i = 0; i < this.v; i++) {
				adj[i] = new LinkedList<Vertex>();
				map.put(i, new Vertex(i));
			}

			int nodeId = 0;
			Map<Pair, Integer> nodes = new HashMap<Pair, Integer>();

			for (int i = 0; i < adjMartix.length; i++) {
				for (int j = 0; j < adjMartix[i].length; j++) {
					nodes.put(new Pair(i, j), nodeId++);
					if (adjMartix[i][j] == 1) {
						addEdge(nodes.get(new Pair(i, j)), nodes.get(new Pair(i, j)));
					}
				}
			}
			
			for (int i = 0; i < adjMartix.length; i++) {
				for (int j = 0; j < adjMartix[i].length; j++) {
					if (adjMartix[i][j] == 1) {
						if (i-1 > 0 && j-1 > 0 && adjMartix[i-1][j-1] ==1) {
							addEdge(nodes.get(new Pair(i, j)), nodes.get(new Pair(i-1, j-1)));
						}
						
						if (i-1 > 0 && adjMartix[i-1][j] ==1) {
							addEdge(nodes.get(new Pair(i, j)), nodes.get(new Pair(i-1, j)));
						}
						
						if (i-1 > 0 && j+1 < adjMartix[i].length && adjMartix[i-1][j+1] ==1) {
							addEdge(nodes.get(new Pair(i, j)), nodes.get(new Pair(i-1, j+1)));
						}
						
						if (j-1 > 0 && adjMartix[i][j-1] ==1) {
							addEdge(nodes.get(new Pair(i, j)), nodes.get(new Pair(i, j-1)));
						}
						
						if (j+1 < adjMartix[i].length && adjMartix[i][j+1] ==1) {
							addEdge(nodes.get(new Pair(i, j)), nodes.get(new Pair(i, j+1)));
						}
						
						if (i+1 < adjMartix.length && j-1 > 0 && adjMartix[i+1][j-1] ==1) {
							addEdge(nodes.get(new Pair(i, j)), nodes.get(new Pair(i+1, j-1)));
						}
						
						if (i+1 < adjMartix.length && adjMartix[i+1][j] ==1) {
							addEdge(nodes.get(new Pair(i, j)), nodes.get(new Pair(i+1, j)));
						}
						
						if (i+1 < adjMartix.length && j+1 < adjMartix[i].length && adjMartix[i+1][j+1] ==1) {
							addEdge(nodes.get(new Pair(i, j)), nodes.get(new Pair(i+1, j+1)));
						}
					}
				}
			}
		}

		public void addEdge(int u, int v) {
			if (map.get(v) != null && !adj[u].contains(map.get(v))) {
				adj[u].add(map.get(v));
			}

			if (map.get(u) != null && !adj[v].contains(map.get(u))) {
				adj[v].add(map.get(u));
			}
		}

		public void print() {
			System.out.println("Printing Graph");
			for (int i = 0; i < v; i++) {
				System.out.println("Vertex : " + (i) + " : adhList = " + this.adj[i]);
			}
		}

		public static int maxPath = Integer.MIN_VALUE;

		public void DFS() {
			for (int i = 0; i < v; i++) {
				if (map.get(i).color == VertexColor.WHITE) {
					System.out.println("\n\nDisjoint Tree Started starting at vertex: " + i);
					DFSVisit(i);
					System.out.println("Traversal Path: " + counter);
					maxPath = Math.max(counter, maxPath);
					resetColors();
					counter = 0;
				}
			}
		}

		public void resetColors() {
			for (int i = 0; i < v; i++) {
				map.get(i).color = VertexColor.WHITE;
			}
		}

		public void DFSVisit(int u1) {
			Vertex u = map.get(u1);
			u.color = VertexColor.GRAY;
			System.out.println(u);
			for (Vertex v : adj[u1]) {
				if (v.color == VertexColor.WHITE) {
					v.predecessor = u;
					counter++;
					DFSVisit(v.vertex);
				}
			}
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
			return " " + vertex ;
		}
	}

	static enum VertexColor {
		WHITE, GRAY, BLACK;
	}

}