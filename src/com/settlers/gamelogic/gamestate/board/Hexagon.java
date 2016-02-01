package com.settlers.gamelogic.gamestate.board;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public class Hexagon extends Polygon{

	private static final long serialVersionUID = 1L;
	
	private List<Node> nodes;
	private int rollVal;
	Color color;
	TileType type;
	int tileWidth;
	int tileHeight;
	
	public enum TileType{
		OCEAN,
		DESERT,
		BRICK,
		WHEAT,
		SHEEP,
		LUMBER,
		ORE;
	}	
	
	public Hexagon() {
		nodes = new ArrayList<Node>();
		this.type = TileType.OCEAN;
	}
	
	public void setCharacteristics(int rollVal,TileType type) {
		this.setRollVal(rollVal);
		this.type = type;
	}
	
	/**
	 * returns itself to allow chaining.
	 * @param p
	 * @return
	 */
	public Hexagon addPoint(Point p) {
		super.addPoint((int)p.getX(), (int)p.getY());
		return this;
	}
	
	public void addNode(Node n) {
		n.addTile(this.rollVal, this.type);
		nodes.add(n);
	}
	
	public Color getColor() {
		return color;
	}
	
	private void setRollVal(int val) {
		if(val>0 && val<13) {
			this.rollVal = val;
		} else {
			this.rollVal = 12;
		}
	}
	
	public int getRollVal() {
		return this.rollVal;
	}
	
	public TileType getTileType() {
		return this.type;
	}
	//TODO: may want to remove this after separating the GUI implementation from the ghame logic implementation.
	public void setColor(Color color) {
		this.color = color;
	}
	public int getTileWidth() {
		return tileWidth;
	}
	
	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}
	
	public int getTileHeight() {
		return tileHeight;
	}
	
	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}
	
	public List<Node> getNodes() {
		return this.nodes;
	}
}
