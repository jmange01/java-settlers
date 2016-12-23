package com.settlers.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.settlers.gamelogic.gamestate.board.Node;
import com.settlers.gamelogic.vo.Player;
import com.settlers.gui.listener.GameAction;
import com.settlers.gui.listener.GameAction.ActionType;
import com.settlers.gui.listener.GameActionListener;

public class BoardActionDialogBox extends GameActionPanel {
	private static final long serialVersionUID = -7343538705381591898L;
	protected BoardPanel parentPanel;
	private Player actor;
	public BoardActionDialogBox(Node n, Player actor, BoardPanel parent) {
		this.parentPanel = parent;
		this.actor = actor;
		this.setLocation(n.getLocation());
		this.setSize(new Dimension(100,100));
		this.setBackground(new Color(1f,1f,1f,0.9f));
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		this.setVisible(true);
		this.addOptions(n);
	}
	
	@Override
	public void notifyGameAction(GameAction action) {
		this.parentPanel.notifyGameAction(action);
	}
	
	private void addOptions(Node n) {
		if(!n.hasSettlement()) {
			JButton button = new JButton("BUILD SETTLEMENT");
			button.setSize(100, 20);
			button.setFont(button.getFont().deriveFont(7.0f));
			button.setMargin(new Insets(0,0,0,0));
			this.add(button);
			button.addMouseListener(new GameActionListener(new GameAction(ActionType.BUILD_SETTLEMENT, this.actor),this));
		}
	}
}
