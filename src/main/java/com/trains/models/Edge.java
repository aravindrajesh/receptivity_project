package com.trains.models;

public class Edge {
	
	public Node origin;
	public Node destination;
	public int weight;
	
	public Edge next;
	
	public Edge(Node origin,Node destination, int weight)
	{
		this.origin =origin;
		this.destination =destination;
		this.weight= weight;
		this.next =null;
	}
	
	public Edge next(Edge edge)
	{
		this.next=edge;
		return this;
	}

	public String toString() {
		return this.origin.getName()+"->"+ this.destination.getName()+"->"+this.weight;
	}
}
