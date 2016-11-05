package com.settlers.gui;

import javax.swing.JPanel;

import com.settlers.gui.listener.GameAction;

public abstract class GameActionPanel extends JPanel {
	private static final long serialVersionUID = -2383770275299700136L;
	
	public abstract void notifyGameAction(GameAction action);
}
