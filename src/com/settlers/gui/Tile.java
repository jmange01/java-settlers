package com.settlers.gui;

import java.awt.Polygon;

import com.settlers.gamelogic.gamestate.board.Hexagon;
import com.settlers.gamelogic.gamestate.board.Node;

public class Tile extends Polygon {
	private Hexagon hexagon;

	public Tile(Hexagon hexagon) {
		this.hexagon = hexagon;
		this.setPoints();
	}
	
	public Hexagon getHexagon() {
		return this.hexagon;
	}
	
	public void setPoints() {
		for(Node node:this.hexagon.getNodes()){
			int xPos = 0;
			int yPos = 0;
			if(node.getLocation().y%2 == 0) {
				xPos = this.hexagon.getTileWidth()/4;
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
		}
	}
}
