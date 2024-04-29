/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eniso.projecth;

/**
 *
 * @author Wael
 */
public interface IGraphManaging {
    void createGraph(Graph graph);
    void updateGraph(Graph graph);
    void deleteGraph(int graphId);
    
    void addVertex(Vertex vertex);
    void updateVertex(Vertex vertex);
    void deleteVertex(int vertexId);
    
    void addEdge(Edge edge);
    void updateEdge(Edge edge);
    void deleteEdge(int edgeId);
}
