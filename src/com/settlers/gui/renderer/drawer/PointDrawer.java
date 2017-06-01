package com.settlers.gui.renderer.drawer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

import com.settlers.gamelogic.gamestate.board.SettlersBoard;

public class PointDrawer implements Drawer<SettlersBoard> {

	private List<Point> pts;
	
	public PointDrawer(List<Point> pts) {
		this.pts = pts;
	}
	@Override
	public void draw(Graphics g) {
		for(Point pt:pts) {
			g.setColor(Color.GREEN);
			g.drawOval((int)pt.getX(), (int)pt.getY(), 10, 10);
		}	
	}
	@Override
	public void update(SettlersBoard board) {
		// TODO Auto-generated method stub
		
	}
}
