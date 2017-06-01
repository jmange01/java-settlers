package com.settlers.gamelogic.gamestate.board;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.settlers.gamelogic.vo.Player;
import com.settlers.gui.Tile;

public class Node {
	private Point indexedLocation;
	private Point location;
	private Settlement settlement = null;
	private Set<Node> adjacent = new HashSet<Node>();
	private Map<Integer,List<Tile>> resources;
	private List<Road> roads = new ArrayList<Road>();
	
	public Node(int y, int x) {
		this.setIndexedLocation(new Point(x,y));
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
	
	public void addRoad(Road r) {
		this.roads.add(r);
	}
	
	public int roadCount() {
		return this.roads.size();
	}
	
	public boolean hasRoadTo(Node n) {
		for(Road r : this.roads) {
			if(r.getEnd().equals(n) || r.getStart().equals(n)) return true;
		}
		return false;
	}
	
	public boolean hasSettlement() {
		return this.settlement != null;
	}
	
	public boolean isOccupiedBy(Player p) {
		if(this.settlement.getOwner().equals(p)) {
			return true;
		}
		return false;
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
	
	@Override
	public int hashCode() {
		return this.indexedLocation.x * 10000 + this.indexedLocation.y;
	}
}
