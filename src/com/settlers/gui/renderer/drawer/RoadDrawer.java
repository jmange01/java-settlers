package com.settlers.gui.renderer.drawer;

import java.awt.Graphics;
import java.awt.Point;

import com.settlers.gamelogic.gamestate.board.Road;
import com.settlers.gamelogic.gamestate.board.SettlersBoard;

public class RoadDrawer implements Drawer<SettlersBoard> {
	SettlersBoard board;
	
	@Override
	public void draw(Graphics g) {
		for(Road road : board.getRoads()) {
			Point start = road.getStart().getLocation();
			Point end = road.getEnd().getLocation();
			//TODO: This will be removed in favor of road icon. Just doing colored lines for now.
			g.setColor(road.getOwner().playerColor);
			g.drawLine(start.x, start.y, end.x, end.y);
		}
	}
	
	@Override
	public void update(SettlersBoard board) {
		this.board =  board;
	}
}
