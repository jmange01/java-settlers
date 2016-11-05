package com.settlers.gamelogic.gamestate.board;

import java.awt.Image;
import java.awt.Point;

public class Settlement {
	Point location;
	Image texture;
	
	public Settlement(int x, int y, Image texture) {
		this.location = new Point(x,y);
		this.texture = texture;
	}
	
	public Image getTexture() {
		return this.texture;
	}
	
	public Point getLocation() {
		return location;
	}
}
