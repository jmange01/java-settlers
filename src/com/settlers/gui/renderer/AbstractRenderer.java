package com.settlers.gui.renderer;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.settlers.gamelogic.gamestate.board.SettlersBoard;
import com.settlers.gui.renderer.drawer.Drawer;

public abstract class AbstractRenderer<T> {
	private List<Drawer> drawers = new ArrayList<Drawer>();
	protected SettlersBoard board;
	protected Point origin = new Point(0,0);
	
	public void render(Graphics g) {
		for(Drawer d:drawers) {
			d.update(board);
			d.draw(g);
		}
	}
	
	public int addDrawer(Drawer d) {
		this.drawers.add(d);
		return drawers.size();
	}
	
	public void setOrigin(Point origin) {
		this.origin = origin;
	}
}
