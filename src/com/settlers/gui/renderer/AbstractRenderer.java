package com.settlers.gui.renderer;

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import com.settlers.gui.renderer.drawer.Drawer;

public abstract class AbstractRenderer<T> {
	private List<Drawer> drawers = new ArrayList<Drawer>();
	
	public void render(Graphics g) {
		for(Drawer d:drawers) {
			d.draw(g);
		}
	}
	
	public int addDrawer(Drawer d) {
		this.drawers.add(d);
		return drawers.size();
	}
}
