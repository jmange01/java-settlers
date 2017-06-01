package com.settlers.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.settlers.gui.listener.GameAction;
import com.settlers.gui.listener.GameAction.ActionType;

public class EndTurnPanel extends GamePanel {
	private static final long serialVersionUID = 5248497304313488454L;
	
	private GameAction action;
	
	public EndTurnPanel() {
		this.setPreferredSize(new Dimension(150,40));
		this.setVisible(true);
		JButton turnEndButton = new JButton("END TURN");
		
		turnEndButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				action = new GameAction(ActionType.END_TURN,null);
			}
		});
		
		turnEndButton.setSize(150,25);
		this.add(turnEndButton);
	}

	@Override
	public void notifyGameAction(GameAction action) {
		// TODO Auto-generated method stub

	}

	@Override
	public GameAction getAction() {
		GameAction gameAction = action;
		this.action = null;
		return gameAction;
	}

}
