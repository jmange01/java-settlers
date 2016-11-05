package com.settlers.gamelogic.gamestate.board;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.settlers.gui.Tile;

public class SettlersBoard {
	
	private List<Tile> tiles;
	private Node[][] nodes;
	private Point[][] points;
	private List<Settlement> settlements;
	
	public SettlersBoard(){
		super();
		settlements = new ArrayList<Settlement>();
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
}
