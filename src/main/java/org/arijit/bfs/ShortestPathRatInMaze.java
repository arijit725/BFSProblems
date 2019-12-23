package org.arijit.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Given a MxN matrix where each element can either be 0 or 1. We need to find
 * the shortest path between a given source cell to a destination cell. The path
 * can only be created out of a cell if its value is 1.
 * 
 * Time Complexity: O(n)
 * 
 * @author arijit
 *
 */
public class ShortestPathRatInMaze {

	public static void main(String args[]) {
		int mat[][] = { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
				{ 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } };

		findShortestPath(mat, 0, 0, 3, 4);
	}

	/* Rat can move to near cell in four direction */
	private static int xAxix[] = { 0, 1, 0, -1 };
	private static int yAxis[] = { 1, 0, -1, 0 };

	public static void findShortestPath(int mat[][], int sourceX, int sourceY, int destX, int destY) {
		boolean visited[][] = new boolean[mat.length][mat[0].length];
		Coordinate source = new Coordinate(sourceX, sourceY, 0);
		Queue<Coordinate> q = new LinkedList<Coordinate>();
		q.add(source);
		while (!q.isEmpty()) {
			Coordinate cord = q.poll();

			if (cord.getX() == destX && cord.getY() == destY) {
				System.out.println("Found destination: " + cord.getDist());
				return;
			}
			// iterating all neighbour points
			for (int i = 0; i < xAxix.length; i++) {
				int newX = cord.getX() + xAxix[i];
				int newY = cord.getY() + yAxis[i];
				if (newX < 0 || newY < 0 || newX > mat.length || newY > mat.length)
					// out of range
					continue;
				if (mat[newX][newY] == 0)
					// cell is not accessible as value is 0.
					continue;
				if (visited[newX][newY])
					// cell is already visited from another source
					continue;
				Coordinate newCord = new Coordinate(newX, newY, cord.getDist() + 1);
				q.add(newCord);
			}
		}

	}

	private static class Coordinate {
		private int x;
		private int y;
		private int dist;

		public Coordinate(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		public int getDist() {
			return dist;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}
}
