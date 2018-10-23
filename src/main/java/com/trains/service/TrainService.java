package com.trains.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.trains.models.Edge;
import com.trains.models.Node;



public class TrainService {
	public HashMap<Node,Edge> routeTable;
	public HashMap<String,Node> nodes;
	
	public TrainService()
	{
		this.routeTable = new HashMap<>();
		this.nodes = new HashMap<String, Node>();
	}
	
	public void addNode(Node node,Edge edge) {
		 routeTable.put(node,edge);
	        if (!nodes.containsKey(node.getName())) {
	        	nodes.put(node.getName(), node);
	        }
	    }

	/*
	 * Calculates the distance between specified path 
	 */
	public int findDistanceBetween(ArrayList<String> nodeNames) throws Exception {
		
		if(nodeNames.size() < 2)
			return 0;
		ArrayList<Node> cities = new ArrayList<>();
		for (String cn:nodeNames) {
			cities.add(nodes.get(cn));
		}
		int distance, depth, i;
		distance = depth = i = 0;
 
		while(i < cities.size() - 1) {
			if(this.routeTable.containsKey(cities.get(i))) {
				Edge route = this.routeTable.get(cities.get(i));
				while(route != null) {
					if(route.destination.equals(cities.get(i + 1))) {
						distance += route.weight;
						depth++;
						break;
					}
					route = route.next;
				}
			}
			else
				throw new Exception("NO SUCH ROUTE");
			i++;
		}
		if(depth != cities.size() - 1)
			throw new Exception("NO SUCH ROUTE");
 
		return distance;
	}
	
	/*
	 * To find the number of trips with exact hops given.
	 * 
	 */
	public int findTripsWithExactHops(String start, String end, int maxStops) throws Exception{
		
		return findExactlyHopRoutes(nodes.get(start), nodes.get(end), 0, maxStops);
	}
	/*
	 * Finds number of stops from start to end,
	 * with a exact number of Stops given
	 */
	private int findExactlyHopRoutes(Node start, Node end, int depth, int maxStops) throws Exception{
		int routes = 0;
		
		if(this.routeTable.containsKey(start) && this.routeTable.containsKey(end)) {
			depth++;
			if(depth > maxStops)		
				return 0;
					
			Edge edge = this.routeTable.get(start);
			while(edge != null) {
				
				if(edge.destination.equals(end)) {
					if(depth == maxStops) {
						routes++;
					}
					edge = edge.next;
					continue;
				}
				
				else if(!edge.destination.visited) {
					routes += findExactlyHopRoutes(edge.destination, end, depth, maxStops);	
				}
				edge = edge.next;
			}
		}
		else
			throw new Exception("NO SUCH ROUTE");
 
		
		return routes;
	}
 
	/*
	 * To find the number of trips with less than or equal to the  hops given.
	 * 
	 */
	public int findTripsWithMaxHops(String start, String end, int maxStops) throws Exception{
		return findMaxHopRoutes(nodes.get(start), nodes.get(end), 0, maxStops);
	}
	
	
	/*
	 * Finds number of stops from start to end,
	 * with a maximum of maxStops 
	 */
	private int findMaxHopRoutes(Node start, Node end, int depth, int maxStops) throws Exception{
		int routes = 0;
		
		if(this.routeTable.containsKey(start) && this.routeTable.containsKey(end)) {
			depth++;
			if(depth > maxStops)		
				return 0;
			start.visited = true;		
			Edge edge = this.routeTable.get(start);
			while(edge != null) {
				
				if(edge.destination.equals(end)) {
						routes++;
					edge = edge.next;
					continue;
				}
				
				else if(!edge.destination.visited) {
					routes += findMaxHopRoutes(edge.destination, end, depth, maxStops);
				}
				edge = edge.next;
			}
		}
		else
			throw new Exception("NO SUCH ROUTE");
 
		
		start.visited = false;
		return routes;
	}
	/*
	 * Find the shortest route between two cities;
	 * 
	 */
	public int findShortestRoute(String start, String end) throws Exception {
		
		return findShortestRoute(nodes.get(start), nodes.get(end), 0, 0);
 
	}
 
	/*
	 * Finds the shortest route between two nodes
	 */
	private int findShortestRoute(Node start, Node end, int weight, int shortestRoute) throws Exception{
		
		if(this.routeTable.containsKey(start) && this.routeTable.containsKey(end)) {
			
			start.visited = true;		
			Edge edge = this.routeTable.get(start);
			while(edge != null) {
				
				if(edge.destination == end || !edge.destination.visited)
					weight += edge.weight;
 

				if(edge.destination.equals(end)) {
					if(shortestRoute == 0 || weight < shortestRoute)
						shortestRoute = weight;
					start.visited = false;
					return shortestRoute; 			
				}
				
				else if(!edge.destination.visited) {
					shortestRoute = findShortestRoute(edge.destination, end, weight, shortestRoute);
				
					weight -= edge.weight;
				}
				edge = edge.next;
			}
		}
		else
			throw new Exception("NO SUCH ROUTE");
		start.visited = false;
		return shortestRoute;
 
	}
 
	/*
	 * Find number of possible routes with less than given distance
	 */
	public int findDifferentRoutesWithinDistance(String start, String end, int maxDistance) throws Exception {
		//Wrapper to maintain weight
		return findnumRoutesWithin(nodes.get(start), nodes.get(end), 0, maxDistance);
	}
 
	/*
	 * Find number of possible routes with less than given distance
	 */
	private int findnumRoutesWithin(Node start, Node end, int weight, int maxDistance) throws Exception{
		int routes = 0;
		
		if(this.routeTable.containsKey(start) && this.routeTable.containsKey(end)) {
		
			Edge edge = this.routeTable.get(start); 
			while(edge != null) {
				weight += edge.weight;
				if(weight <= maxDistance) {
					if(edge.destination.equals(end)) {
						routes++;
						weight -= edge.weight; 
						edge = edge.next;
						continue;
					}
					else {
						routes += findnumRoutesWithin(edge.destination, end, weight, maxDistance);
						weight -= edge.weight;	
					}
				}
				else 
					weight -= edge.weight;
 
				edge = edge.next;
			}
		}
		else
			throw new Exception("NO SUCH ROUTE");
 
		return routes;
 
	}	

}
