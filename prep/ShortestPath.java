package prep;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPath
{
	private static int INF = Integer.MAX_VALUE;

	public static void main(String[] args)
	{
		int[][] graph = {
			{0, 4, 0, 0, 0, 0, 0, 8, 0},
			{4, 0, 8, 0, 0, 0, 0, 11, 0},
			{0, 8, 0, 7, 0, 4, 0, 0, 2},
			{0, 0, 7, 0, 9, 14, 0, 0, 0},
			{0, 0, 0, 9, 0, 10, 0, 0, 0},
			{0, 0, 4, 14, 10, 0, 2, 0, 0},
			{0, 0, 0, 0, 0, 2, 0, 1, 6},
			{8, 11, 0, 0, 0, 0, 1, 0, 7},
			{0, 0, 2, 0, 0, 0, 6, 7, 0}
		};

		dijkstra(graph, 0); // Start from node 0

	}

	private static class Node implements Comparable<Node>
	{
		int vertex;
		int distance;

		Node(int vertex, int distance)
		{
			this.vertex = vertex;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node other)
		{
			return Integer.compare(this.distance, other.distance);
		}
	}

	public static int[] dijkstra(int[][] graph, int startNode)
	{
		int n = graph.length;
		int[] dist = new int[n];
		boolean[] visited = new boolean[n];
		Arrays.fill(dist, INF);
		dist[startNode] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(startNode, 0));

		while (!pq.isEmpty())
		{
			Node currentNode = pq.poll();
			int u = currentNode.vertex;

			if (visited[u])
			{
				continue; // Skip if already visited
			}
			visited[u] = true;

			for (int v = 0; v < n; v++)
			{
				if (graph[u][v] != 0 && !visited[v])
				{
					int newDist = dist[u] + graph[u][v];
					if (newDist < dist[v])
					{
						dist[v] = newDist;
						pq.add(new Node(v, dist[v]));
					}
				}
			}
		}
		System.out.println("Vertex\tDistance from Source " + startNode);
		for (int i = 0; i < n; i++)
			System.out.println(i + "\t" + (dist[i] == INF ? "INF" : dist[i]));
		return dist;
	}
}
