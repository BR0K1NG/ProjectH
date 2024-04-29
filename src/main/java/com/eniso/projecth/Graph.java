
package com.eniso.projecth;
/**
 *
 * @author Wael
 */

import java.util.List;

abstract class Graph {
    protected List<Integer> vertices;
    protected List<int[]> edges;

    public Graph(List<Integer> vertices, List<int[]> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }
    
    public abstract List<Integer> bfs(int start);
    public abstract List<Integer> dfs(int start);


}


    
