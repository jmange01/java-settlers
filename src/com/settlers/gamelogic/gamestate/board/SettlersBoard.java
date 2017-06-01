package com.settlers.gamelogic.gamestate.board;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.settlers.gui.Tile;

public class SettlersBoard {
	
	private List<Tile> tiles;
	private Node[][] nodes;
	private Point[][] points;
	private List<Settlement> settlements;
	private List<Road> roads;
	
	public SettlersBoard(){
		super();
		settlements = new ArrayList<Settlement>();
		roads = new ArrayList<Road>();
	}
	
	public void setNodes(Node[][] nodes) {
		this.nodes = nodes;
	}
	
	public Node[][] getNodes() {
		return nodes;
	}

	public List<Tile> getTiles() {
		return tiles;
	}

	public void setTiles(List<Tile> tiles) {
		this.tiles = tiles;
	}

	public Point[][] getPoints() {
		return points;
	}

	public void setPoints(Point[][] points) {
		this.points = points;
	}

	public void addSettlement(Settlement s) {
		this.settlements.add(s);
	}
	
	public List<Settlement> getSettlements() {
		return this.settlements;
	}
	
	public List<Road> getRoads() {
		return this.roads;
	}
	
	public void addRoad(Road r) {
		this.roads.add(r);
	}
}
