package com.settlers.gui.renderer.drawer;

import java.awt.Color;
import java.awt.Graphics;

import com.settlers.gamelogic.gamestate.board.SettlersBoard;

public class SimpleGamestateDrawer implements Drawer {
	private SettlersBoard board;
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("This is a String", 100, 100);
	}

	@Override
	public void update(SettlersBoard board) {
		this.board = board;
	}

}
