/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eniso.projecth;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wael
 */
public class GraphAdapterImpl implements GraphAdapter {

    @Override
    public int[][] fromAdjacencyList(List<List<Integer>> adjacencyList) {
        int numVertices = adjacencyList.size();
        int[][] adjacencyMatrix = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            List<Integer> neighbors = adjacencyList.get(i);
            for (int neighbor : neighbors) {
                adjacencyMatrix[i][neighbor] = 1;
            }
        }

        return adjacencyMatrix;
    }

    @Override
    public List<List<Integer>> toAdjacencyList(int[][] adjacencyMatrix) {
        int numVertices = adjacencyMatrix.length;
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            List<Integer> neighbors = new ArrayList<>();
            for (int j = 0; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    neighbors.add(j);
                }
            }
            adjacencyList.add(neighbors);
        }

        return adjacencyList;
    }
    
}
