package com.trains.main;

import com.trains.models.Edge;
import com.trains.models.Node;
import com.trains.process.InputProcessor;
import com.trains.service.TrainService;

public class Start {

	public static void init(TrainService graph){
		Node a,b,c,d,e;
		a = new Node("A");
		b = new Node("B");
		c = new Node("C");
		d = new Node("D");
		e = new Node("E");
		graph.addNode(a, new Edge(a, b, 5).next(new Edge(a, d, 5).next(new Edge(a, e, 7))));
		graph.addNode(b, new Edge(b, c, 4));
		graph.addNode(c, new Edge(c, d, 8).next(new Edge(c, e, 2)));
		graph.addNode(d, new Edge(d, c, 8).next(new Edge(d, e, 6)));
		graph.addNode(e, new Edge(e, b, 3));
		
	}

	public static void main(String[] args) throws Exception{
		TrainService graph = new TrainService();
		init(graph);
		
		InputProcessor cp = new InputProcessor(graph);
				cp.inputFileProcessor("C:\\Users\\AR\\workspace\\Receptivity_TrainsProblems\\src\\main\\java\\com\\trains\\main\\commands.txt");
				
	}
		
		
		

}

