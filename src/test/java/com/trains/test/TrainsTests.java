package com.trains.test;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.trains.service.TrainService;
import com.trains.main.Start;

/**
 * Tests for {@code LLRailRoadService}.
 */
public class TrainsTests {

    @Test
    public   void testdistanceBetweenWithValidValues() {
    	TrainService graph = new TrainService(); 
    	Start.init(graph);
    	ArrayList<String> testNodeNames = new ArrayList<>();
    	testNodeNames.add("A");
    	testNodeNames.add("B");
    	testNodeNames.add("C");
        int ans=0;
		try {
			ans = graph.findDistanceBetween(testNodeNames);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        assertEquals(9, ans);
    }
    

    @Test
    public   void testdistanceBetweenWithIncorrectRoute() {
    	TrainService graph = new TrainService(); 
    	Start.init(graph);
    	ArrayList<String> testNodeNames = new ArrayList<>();
    	testNodeNames.add("A");
    	testNodeNames.add("E");
    	testNodeNames.add("D");
        int ans=0;
		try {
			ans = graph.findDistanceBetween(testNodeNames);
		} catch (Exception e) {
			
			
		}
        assertEquals(0, ans);
    }
    
    @Test
    public   void testdistanceBetweenWithNullValue() {
    	TrainService graph = new TrainService(); 
    	Start.init(graph);
    	ArrayList<String> testNodeNames = new ArrayList<>();
    	testNodeNames.add("A");
    	testNodeNames.add(null);
        int ans=0;
		try {
			ans = graph.findDistanceBetween(testNodeNames);
		} catch (Exception e) {
			
			
		}
        assertEquals(0, ans);
    }
    @Test
    public   void testnumMaxStops() {
    	TrainService graph = new TrainService(); 
    	Start.init(graph);
        int ans=0;
		try {
			ans = graph.findTripsWithMaxHops("C", "C", 3);
		} catch (Exception e) {
			
			
		}
        assertEquals(2, ans);
    }
    @Test
    public   void testnumStops() {
    	TrainService graph = new TrainService(); 
    	Start.init(graph);
        int ans=0;
		try {
			ans = graph.findTripsWithExactHops("A", "C", 4);
		} catch (Exception e) {
			
			
		}
        assertEquals(1, ans);
    }

	@Test
	public   void testshortestRoute() {
	TrainService graph = new TrainService(); 
	Start.init(graph);
    int ans=0;
	try {
		ans = graph.findShortestRoute("A", "C");
	} catch (Exception e) {
		
		
	}
    assertEquals(9, ans);
}
	
	@Test
	public   void numRoutesWithin() {
	TrainService graph = new TrainService(); 
	Start.init(graph);
    int ans=0;
	try {
		ans = graph.findDifferentRoutesWithinDistance("C", "C",30);
	} catch (Exception e) {
	
		
	}
    assertEquals(3, ans);
}
		
}

