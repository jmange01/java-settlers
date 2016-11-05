package com.settlers.gui.renderer.drawer;

import java.awt.Graphics;

import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gamelogic.gamestate.board.SettlersBoard;

public interface Drawer {
	public void draw(Graphics g);
	
	void update(SettlersBoard board);
}
