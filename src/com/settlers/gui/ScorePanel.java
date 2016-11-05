package com.settlers.gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.settlers.gamelogic.gamemanager.GameManager;
import com.settlers.gui.listener.GameAction;

public class ScorePanel extends GameContainer {
	private static final long serialVersionUID = 9078119655383269863L;

	public ScorePanel(GameManager manager) {
		this.setSize(100,200);
		this.setVisible(true);
		this.setBackground(Color.GRAY);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	@Override
	public void notifyGameAction(GameAction action) {
		
	}

	@Override
	public GameAction getAction() {
		return null;
	}
}
