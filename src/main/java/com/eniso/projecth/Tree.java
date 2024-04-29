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

public class Tree extends Graph {
    protected int root;
    protected Map<Integer, List<Integer>> parent; 
    protected Map<Integer, List<Integer>> children;
    protected Map<Integer, Integer> depth;

    public Tree(List<Integer> vertices, int root, Map<Integer, List<Integer>> parent, Map<Integer, List<Integer>> children, Map<Integer, Integer> depth) {
        super(vertices, new ArrayList<>()); 
        this.root = root;
        this.parent = parent;
        this.children = children;
        this.depth = depth;
    }
    
    
    @Override
public List<Integer> bfs(int start) {
    return bfsFromNode(root);
}

private List<Integer> bfsFromNode(int start) {
    List<Integer> visited = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    
    queue.offer(start);
    visited.add(start);

    while (!queue.isEmpty()) {
        int current = queue.poll();
        List<Integer> currentChildren = children.getOrDefault(current, new ArrayList<>());
        for (int child : currentChildren) {
            if (!visited.contains(child)) {
                queue.offer(child);
                visited.add(child);
            }
        }
    }

    return visited;
}

    @Override
    public List<Integer> dfs(int start) {
        return dfsFromNode(root);
    }

    private List<Integer> dfsFromNode(int node) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                
                List<Integer> currentChildren = children.getOrDefault(current, new ArrayList<>());
                for (int child : currentChildren) {
                    stack.push(child);
                }
            }
        }

        return visited;
    }

}


