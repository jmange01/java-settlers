package com.settlers.gui;

import com.settlers.gui.listener.GameAction;

public abstract class GamePanel extends GameActionPanel {
	private static final long serialVersionUID = -4707257568677579944L;
	public abstract void notifyGameAction(GameAction action);
	public abstract GameAction getAction();
}
