/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eniso.projecth;

import java.util.List;

/**
 *
 * @author Wael
 */
public interface GraphAdapter {
    int[][] fromAdjacencyList(List<List<Integer>> adjacencyList);
    List<List<Integer>> toAdjacencyList(int[][] adjacencyMatrix);
}

