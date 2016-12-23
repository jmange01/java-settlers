package com.settlers.gamelogic.gamestate.board;

import java.awt.Point;
import java.awt.Polygon;

import com.settlers.gui.Tile;
import com.settlers.gui.Tile.TileType;

public class Hexagon extends Polygon{
	private static final long serialVersionUID = 1L;
	
	private Tile tile;
	int tileWidth;
	int tileHeight;
	
	public Hexagon(Tile t, int width, int height, Point origin) {
		this.tile = t;
		this.tileWidth = width;
		this.tileHeight = height;
		
		for(Node n:t.getNodes()) {
			this.setNodeCoordinates(n, origin);
		}
	}
	
	public void setNodeCoordinates(Node node, Point origin) {
		int xPos = (int)origin.getX();
		int yPos = (int)origin.getY();
		if(node.getIndexedLocation().y%2 == 0) {
			xPos = this.getTileWidth()/4;
			for(int i=0;i<node.getIndexedLocation().x;i++) {
				if(i%2 == 0) {
					xPos += this.getTileWidth()/2;
				} else {
					xPos += this.getTileWidth();
				}
			}
		} else {
			for(int i=0;i<node.getIndexedLocation().x;i++) {
				if(i%2 == 0) {
					xPos += this.getTileWidth();
				} else {
					xPos += this.getTileWidth()/2;
				}
			}
		}
		
		yPos = (this.getTileHeight()/2)*node.getIndexedLocation().y;

		this.addPoint(xPos - 100, yPos - 100);
		node.setLocation(new Point(xPos-100, yPos-100));
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
	
	public TileType getTileType() {
		return this.tile.getTileType();
	}
	
	public int getTileRollVal() {
		return this.tile.getRollVal();
	}
}
