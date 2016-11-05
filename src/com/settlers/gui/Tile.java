package com.settlers.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.settlers.gamelogic.gamestate.board.Hexagon;
import com.settlers.gamelogic.gamestate.board.Node;

public class Tile {
	
	private List<Node> nodes = new ArrayList<Node>();
	private int rollVal;
	Color color;
	TileType type = TileType.OCEAN;
	
	public enum TileType{
		OCEAN,
		DESERT,
		BRICK,
		WHEAT,
		SHEEP,
		LUMBER,
		ORE;
	}	
	
	public void setCharacteristics(int rollVal,TileType type) {
		this.setRollVal(rollVal);
		this.type = type;
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
	
	public void addNode(Node n) {
		n.addTile(this);
		this.nodes.add(n);
	}
	
	public List<Node> getNodes() {
		 return this.nodes;
	}
	
	public void setPoints(Hexagon h) {
		/*for(Node node:h.getNodes()){
			int xPos = 0;
			int yPos = 0;
			if(node.getLocation().y%2 == 0) {
				xPos = h.getTileWidth()/4;
				for(int i=0;i<node.getLocation().x;i++) {
					if(i%2 == 0) {
						xPos += hexagon.getTileWidth()/2;
					} else {
						xPos += hexagon.getTileWidth();
					}
				}
			} else {
				for(int i=0;i<node.getLocation().x;i++) {
					if(i%2 == 0) {
						xPos += hexagon.getTileWidth();
					} else {
						xPos += hexagon.getTileWidth()/2;
					}
				}
			}
			
			yPos = (hexagon.getTileHeight()/2)*node.getLocation().y;

			this.addPoint(xPos-100, yPos-100);
		}*/
	}
}
