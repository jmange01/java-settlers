package com.settlers.gamelogic.gamestate.board;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.settlers.gui.Tile;

public class Node {
	private Point indexedLocation;
	private Point location;
	private Settlement settlement = null;
	private Set<Node> adjacent = new HashSet<Node>();
	private Map<Integer,List<Tile>> resources;
	
	public Node(int y, int x) {
		setIndexedLocation(new Point(x,y));
		resources = new HashMap<Integer,List<Tile>>();
	}
	
	public void addTile(Tile t) {
		int rollVal = t.getRollVal();
		if(resources.containsKey(rollVal)) {
			resources.get(rollVal).add(t);
		}
		else {
			List<Tile> tiles = new ArrayList<Tile>();
			tiles.add(t);
			resources.put(rollVal,tiles);
		}
	}
	
//	public void addRoad
	
	public boolean hasSettlement() {
		return this.settlement != null;
	}
	
	public void setSettlement(Settlement settlement) {
		this.settlement = settlement;
	}
	
	public void setIndexedLocation(Point location) {
		this.indexedLocation = location;
	}
	
	public Point getIndexedLocation() {
		return this.indexedLocation;
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}
	
	public Point getLocation() {
		return this.location;
	}
	
	public Set<Node> getAdjacent() {
		 return this.adjacent;
	}
	
	public void addAdjacent(Node n) {
		this.adjacent.add(n);
	}
	
	public Map<Integer, List<Tile>> getResourceMap() {
		return this.resources;
	}
}
