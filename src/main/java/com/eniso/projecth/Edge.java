/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eniso.projecth;

/**
 *
 * @author Wael
 */
public class Edge {
    private int id;
    private int sourceVertexId;
    private int destinationVertexId;
    private double weight; // Optional: If you want to include weight for weighted graphs
    
    public Edge(int id, int sourceVertexId, int destinationVertexId, double weight) {
        this.id = id;
        this.sourceVertexId = sourceVertexId;
        this.destinationVertexId = destinationVertexId;
        this.weight = weight;
    }
    
    // Getters and setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getSourceVertexId() {
        return sourceVertexId;
    }
    
    public void setSourceVertexId(int sourceVertexId) {
        this.sourceVertexId = sourceVertexId;
    }
    
    public int getDestinationVertexId() {
        return destinationVertexId;
    }
    
    public void setDestinationVertexId(int destinationVertexId) {
        this.destinationVertexId = destinationVertexId;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
