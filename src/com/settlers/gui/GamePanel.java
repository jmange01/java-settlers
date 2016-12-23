package com.settlers.gui;

import javax.swing.JPanel;

import com.settlers.gui.listener.GameAction;

public abstract class GamePanel extends GameActionPanel {
	public abstract void notifyGameAction(GameAction action);
	public abstract GameAction getAction();
}
