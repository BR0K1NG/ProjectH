/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eniso.projecth;

/**
 *
 * @author Wael
 */
import java.util.*;

public class WeightedGraph extends Graph {
    protected Map<int[], Integer> weights;

    public WeightedGraph(List<Integer> vertices, List<int[]> edges, Map<int[], Integer> weights) {
        super(vertices, edges);
        this.weights = weights;
    }
    
     @Override
   public List<Integer> bfs(int start) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited.add(current); 

            for (int[] edge : edges) {
                if (edge[0] == current && !visited.contains(edge[1])) {
                    queue.offer(edge[1]);
                } else if (edge[1] == current && !visited.contains(edge[0])) {
                    queue.offer(edge[0]);
                }
            }
        }

        return visited;
    }
    // DFS Iterative + stack
    @Override
   public List<Integer> dfs(int start) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);

                List<Integer> neighbors = getNeighbors(current);
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        return visited;
    }

    private List<Integer> getNeighbors(int node) {
        List<Integer> neighbors = new ArrayList<>();
        for (int[] edge : edges) {
            if (edge[0] == node) {
                neighbors.add(edge[1]);
            } else if (edge[1] == node) {
                neighbors.add(edge[0]);
            }
        }
        return neighbors;
    }
    public Map<Integer, Integer> dijkstra(int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Node> visited = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        
        // Initialize distances with infinity for all vertices
        for (int vertex : vertices) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        
        // Set distance of start node to 0
        distances.put(start, 0);
        visited.offer(new Node(start, 0));

        while (!visited.isEmpty()) {
            Node current = visited.poll();
            int currentNode = current.vertex;
            int currentDistance = current.distance;

            if (currentDistance > distances.get(currentNode)) {
                continue; // Skip if this node has already been relaxed
            }

            
            for (int[] edge : edges) {
                if (edge[0] == currentNode || edge[1] == currentNode) {
                    int neighbor = (edge[0] == currentNode) ? edge[1] : edge[0];
                   List<Integer> key = Arrays.asList(currentNode, neighbor);
                    int weight = weights.getOrDefault(key, Integer.MAX_VALUE); 

                    int newDistance = currentDistance + weight;
                    if (newDistance < distances.get(neighbor)) {
                        distances.put(neighbor, newDistance);
                        visited.offer(new Node(neighbor, newDistance));
                    }
                }
            }
        }

        return distances;
    }
    
}
    
    
    
    
    
    
    