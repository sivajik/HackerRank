package com.hr.problemsolving.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConnectedGraphsDJ {

	public static void main(String[] args) {
		//int[][] gb = new int[][] { { 1, 6 }, { 2, 7 }, { 3, 8 }, { 4, 9 }, { 2, 6 } };
		 int[][] gb = new int[][] { { 1, 17 }, { 5, 13 }, { 7, 12 }, { 5, 17 }, { 5,
		 12 }, { 2, 17 }, { 1, 18 },
		 { 8, 13 }, { 2, 15 }, { 5, 20 } };
		System.out.println(Arrays.toString(componentsInGraph(gb)));
	}

	static int[] componentsInGraph(int[][] gb) {
		DisjointSet dSet = new DisjointSet();
		dSet.makeSet(gb);

		for (int i = 0; i < gb.length; i++) {
			dSet.union(gb[i][0], gb[i][1]);
		}

		Map<Integer, Integer> repCount = new HashMap<Integer, Integer>();

		Set<Integer> set = dSet.map.keySet();
		Iterator<Integer> itr = set.iterator();
		while (itr.hasNext()) {
			Node node = dSet.map.get(itr.next());
			//System.out.println("Travering: " + node.data);
			int representative = dSet.representative(node);
			if (!repCount.containsKey(representative)) {
				repCount.put(representative, 1);
			} else {
				repCount.put(representative, repCount.get(representative) + 1);
			}
		}

		List<Integer> r2 = new ArrayList(repCount.values());
		Collections.sort(r2);
		if (r2.size() > 1) {
			return new int[] { r2.get(0), r2.get(r2.size() - 1) };
		} else if (r2.size() == 1) {
			return new int[] { r2.get(0), r2.get(0) };
		}
		return null;
	}
}

class Node {
	int data;
	Node parent;
	int rank;
	int setSize;

	public String toString() {
		if (parent == this) {
			return "root: " + this.data + " ";
		} else {
			return data + " -> " + parent.toString();
		}
	}
}

class DisjointSet {
	Map<Integer, Node> map = new HashMap<Integer, Node>();

	public void makeSet(int[][] dataArray) {
		for (int i = 0; i < dataArray.length; i++) {
			if (!map.containsKey(dataArray[i][0])) {
				Node node = new Node();
				node.data = dataArray[i][0];
				node.parent = node;
				node.rank = 0;
				node.setSize = 0;
				map.put(dataArray[i][0], node);
			}

			if (!map.containsKey(dataArray[i][1])) {
				Node node = new Node();
				node.data = dataArray[i][1];
				node.parent = node;
				node.rank = 0;
				node.setSize = 0;
				map.put(dataArray[i][1], node);
			}
		}
	}

	public Node findSet(Node node) {
		Node parent = node.parent;
		if (node == parent) {
			return node;
		} else {
			return findSet(node.parent);
		}
	}

	ArrayList<Integer> results = new ArrayList<Integer>();

	public void union(int data1, int data2) {
		Node n1 = map.get(data1);
		Node n2 = map.get(data2);

		Node node1 = findSet(n1);
		Node node2 = findSet(n2);

		if (node1.data == node2.data) {
			return;
		}

		if (node1.rank >= node2.rank) {
			node1.rank = (node1.rank == node2.rank) ? node1.rank + 1 : node1.rank;
			node2.parent = node1;
		} else {
			node1.parent = node2;
		}

		// map.put(data1, node1);
		// map.put(data2, node2);
	}

	public int representative(Node node) {
		if (node == node.parent) {
			return node.data;
		} else {
			return representative(node.parent);
		}
	}
}