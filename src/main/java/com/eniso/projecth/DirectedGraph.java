/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eniso.projecth;

import java.util.*;

/**
 *
 * @author Wael
 */
   public  class DirectedGraph extends Graph {
    protected List<int[]> directedEdges;

    public DirectedGraph(List<Integer> vertices, List<int[]> directedEdges) {
        super(vertices, new ArrayList<>()); 
        this.directedEdges = directedEdges;
    }
    
    @Override
public List<Integer> bfs(int start) {
    List<Integer> visited = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);

    while (!queue.isEmpty()) {
        int current = queue.poll();
        visited.add(current);

        for (int[] directedEdge : directedEdges) {
            if (directedEdge[0] == current && !visited.contains(directedEdge[1])) {
                queue.offer(directedEdge[1]);
            }
        }
    }

    return visited;
 }
//Recursive + no stack + backtracking is implict
   
    @Override
    public List<Integer> dfs(int start) {
        List<Integer> visited = new ArrayList<>();
        dfsRecursive(start, visited);
        return visited;
    }
    
    private void dfsRecursive(int current, List<Integer> visited) {
        visited.add(current);
        
        for (int[] directedEdge : directedEdges) {
            if (directedEdge[0] == current && !visited.contains(directedEdge[1])) {
                dfsRecursive(directedEdge[1], visited);
            }
        }
    }
    
   public Map<Integer, Integer> dijkstra(int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Node> visited = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        
        for (int vertex : vertices) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        
        distances.put(start, 0);
        visited.offer(new Node(start, 0));

        while (!visited.isEmpty()) {
            Node current = visited.poll();
            int currentNode = current.vertex;
            int currentDistance = current.distance;

            if (currentDistance > distances.get(currentNode)) {
                continue; 
            }

            for (int[] edge : edges) {
                if (edge[0] == currentNode) {
                    int neighbor = edge[1];
                    int weight = 1; // Assume 1 for all edges
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


    private static class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }


       }
 }
