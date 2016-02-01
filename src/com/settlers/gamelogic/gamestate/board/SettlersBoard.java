package com.settlers.gamelogic.gamestate.board;

import java.awt.Point;
import java.util.List;

import com.settlers.gui.Tile;

public class SettlersBoard {
	
	private List<Hexagon> tiles;
	private Node[][] nodes;
	private Point[][] points;
	
	public SettlersBoard(){
		super();
	}
	
	public void setNodes(Node[][] nodes) {
		this.nodes = nodes;
	}
	
	public Node[][] getNodes() {
		return nodes;
	}

	public List<Hexagon> getTiles() {
		return tiles;
	}

	public void setTiles(List<Hexagon> tiles) {
		this.tiles = tiles;
	}

	public Point[][] getPoints() {
		return points;
	}

	public void setPoints(Point[][] points) {
		this.points = points;
	}
}
