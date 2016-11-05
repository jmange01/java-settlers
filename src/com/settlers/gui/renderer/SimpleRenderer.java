package com.settlers.gui.renderer;

import com.settlers.gamelogic.gamestate.board.SettlersBoard;
import com.settlers.gui.renderer.drawer.SimpleGamestateDrawer;

public class SimpleRenderer<T> extends AbstractRenderer<T> {

	public SimpleRenderer(SettlersBoard board) {
		this.board = board;
		super.addDrawer(new SimpleGamestateDrawer());
		
	}
}
