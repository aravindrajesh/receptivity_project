package com.trains.process;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.trains.service.TrainService;


public class InputProcessor {
	private TrainService graph;
	public InputProcessor (TrainService graph) {
		this.graph = graph;
	}
	
	  public void inputFileProcessor(String path) throws Exception {

	        Scanner in = new Scanner(new FileInputStream(path));

	        while (in.hasNext()) {
	        	String input= in.nextLine().toString();
	        	try {
	        	String[] parts = (input.split(";"));
	        	if (parts.length <= 1) {
	        		throw new IllegalArgumentException("Illegal Arguments. Number of parameters are less than are equal to 1");
	        	} else {
	        		String name = parts[0];
	        		switch (name) {
	                	case "shortestRoute":
	                		findShortestPath(input);
	                		break;
	                case "distance":
	                    findDistance(input);
	                    break;
	                case "numMaxStops":
	                	findNumMaxStops(input);
	                    break;
	                case "numExactStops":
	                     findExactNumStops(input);
	                break;
                    
	                case "numRoutesWithin":
	                	findnumRoutesWithinDistance(input);
	                    break;
	                	default:
	                		throw new IllegalArgumentException("unknown command: Pick any one option from list 1.shortestRoute ,2.distance, 3.numMaxStops, 4.numStops, 5.numRoutesWithin  ");
	        		}
	        	}
	        	} catch (Exception e) {
	        		System.out.println(e.getMessage());
	        		}
	    }
	  }
	  
	  private void findShortestPath(String input) throws Exception {
	        String[] parts = input.split(";");

	        if (parts.length != 3) {
	            throw new IllegalArgumentException("Illegal Arguments. Number of parameters are less than are equal to 3");
	        } else {
	        	System.out.println(graph.findShortestRoute(parts[1],parts[2]));
	        }
	    }
	  
	  private void findDistance(String input) throws Exception {
	        String[] parts = input.split(";");

	        if (parts.length < 2) {
	            throw new IllegalArgumentException("Illegal Arguments. Number of parameters are less than are equal to 2");
	        } else {
	        	ArrayList<String> nodeNames = new ArrayList<>(); 
	        	for (int i=1;i<parts.length;i++) {
	        		nodeNames.add(parts[i]);
	        	}
	        	System.out.println(graph.findDistanceBetween(nodeNames));
	        }
	    }
	  
	  private void findNumMaxStops(String input) throws Exception {
		  
		  String[] parts = input.split(";");
		  int maxstops=0;

	        if (parts.length != 4) {
	            throw new IllegalArgumentException("Illegal Arguments. Number of parameters are less than are equal to 4");
	        } else {
	        	 try {
		                 maxstops =(Integer.parseInt(parts[3]));
		            } catch (NumberFormatException e) {
		                throw new IllegalArgumentException("Provided input is not a valid: must contain an integer");
		            }

	        	 System.out.println(graph.findTripsWithMaxHops(parts[1], parts[2], maxstops));
	           

	          
	        }
		  
	        
	    }
	  
 private void findExactNumStops(String input) throws Exception {
		  
		  String[] parts = input.split(";");
		  int maxstops=0;

	        if (parts.length != 4) {
	            throw new IllegalArgumentException("Illegal Arguments. Number of parameters are less than are equal to 4 ");
	        } else {
	        	 try {
		                 maxstops =(Integer.parseInt(parts[3]));
		            } catch (NumberFormatException e) {
		                throw new IllegalArgumentException("Provided input is not a valid: must contain an integer");
		            }

	        	 System.out.println(graph.findTripsWithExactHops(parts[1], parts[2], maxstops));
	           

	          
	        }
		  
	        
	    }
	  
	  
private void findnumRoutesWithinDistance(String input) throws Exception {
		  
		  String[] parts = input.split(";");
		  int maxstops=0;

	        if (parts.length!= 4) {
	            throw new IllegalArgumentException("Illegal Arguments. Number of parameters are less than are equal to 4");
	        } else {
	        	 try {
		                 maxstops =(Integer.parseInt(parts[3]));
		            } catch (NumberFormatException e) {
		                throw new IllegalArgumentException("Provided input is not a valid: must contain an integer");
		            }

	        	 System.out.println(graph.findDifferentRoutesWithinDistance(parts[1], parts[2], maxstops));
	           

	          
	        }
		  
	        
	    }


}
