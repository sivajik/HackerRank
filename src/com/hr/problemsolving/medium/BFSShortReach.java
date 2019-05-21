package com.hr.problemsolving.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSShortReach {
	static class Node {
		int data;
		Node predecessor;
		int distance;
		Color color;

		Node(int data) {
			this.data = data;
			this.predecessor = null;
			this.distance = 0;
			this.color = Color.WHITE;
		}

		public String toString() {
			return "Node:: " + this.data + " Dist: " + this.distance + " ["
					+ (this.predecessor != null ? "" + this.predecessor.data : "*") + "]";
		}
	}

	static enum Color {
		GRAY, WHITE, BLACK
	}

	static class Graph {
		int n;
		int[][] adj = null;

		Map<Integer, Node> map = new HashMap<Integer, Node>();

		Graph(int n) {
			this.n = n;
			this.adj = new int[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				adj[i] = new int[n + 1];
				map.put(i, new Node(i));
			}
		}

		public void addEdge(int u, int v) {
			adj[u][v] = 1;
			adj[v][u] = 1;
		}

		public List<Node> getAdjNodes(Node node) {
			int[] adjRows = adj[node.data];
			List<Node> adjEdges = new ArrayList<Node>();
			for (int i = 1; i <= this.n; i++) {
				if (adj[node.data][i] == 1) {
					adjEdges.add(map.get(i));
				}
			}
			return adjEdges;
		}

		public void BFS(int s) {
			Node node = map.get(s);
			Queue<Node> q = new LinkedList<Node>();
			q.add(node);

			while (!q.isEmpty()) {
				Node visitedNode = q.remove();
				System.out.println(visitedNode);
				node.color = Color.GRAY;

				for (Node eachNode : getAdjNodes(visitedNode)) {
					if (eachNode.color == Color.WHITE) {
						eachNode.color = Color.GRAY;
						eachNode.predecessor = visitedNode;
						eachNode.distance = visitedNode.distance + 1;
						q.add(eachNode);
					}
				}
				node.color = Color.BLACK;
			}

		}

		public int[] getResults(int startingNodeIndex) {
			int[] distances = new int[this.n - 1];
			int counter = 0;

			for (int i = 1; i <= this.n; i++) {
				if (i != startingNodeIndex) {
					distances[counter++] = map.get(i).distance == 0 ? -1 : 6 * map.get(i).distance;
				}
			}
			return distances;
		}
	}

	static int[] bfs(int n, int m, int[][] edges, int s) {
		Graph g = new Graph(n);

		for (int i = 0; i < m; i++) {
			g.addEdge(edges[i][0], edges[i][1]);
		}

		g.BFS(s);
		return g.getResults(s);
	}

	public static void main(String[] args) {
		/*
		 * Graph g = new Graph(5); g.addEdge(1, 2); g.addEdge(1, 3); g.addEdge(3, 4);
		 */

		/*
		 * Graph g = new Graph(4); g.addEdge(1, 2); g.addEdge(1, 3);
		 */

		/*Graph g = new Graph(3);
		g.addEdge(2, 3);

		g.BFS(2);
		System.out.println(Arrays.toString(g.getResults(2)));*/
		
		int[][] edges = new int[][] {
			// {1, 2},
			// {1, 3},
			//{3, 4},
			
			{2, 3}
		};
		//int[] results = bfs(4, 2, edges, 1);
		int[] results = bfs(3, 1, edges, 2);
		System.out.println(Arrays.toString(results));
	}

}
