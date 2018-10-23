package com.trains.models;

public class Node {

	private String name;
	public boolean visited;
	
	public Node(String name) {
		this.name= name;
		this.visited =false;
	}

@Override
public boolean equals(Object obj) {
	if(obj==null || obj.getClass()!=getClass()) {
		return false;
	}
	
	if(obj== this) {
		return true;
	}
	Node node=(Node) obj;
	return this.name == node.name;
}
public int hashCode() {
	if(this.name ==null) {
		return 0;
	}
	return this.name.hashCode();
}
@Override
public String toString()
{
	
	return this.name;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}