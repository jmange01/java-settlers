package com.settlers.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gui.listener.GameAction;
import com.settlers.gui.listener.GameAction.ActionType;

public class DiceRollPanel extends GamePanel {
	private static final long serialVersionUID = 845167590457917406L;
	
	private SettlersGameState state;
	private JButton rollButton;
	private JLabel result;
	private GameAction action;
	
	public DiceRollPanel(SettlersGameState state) {
		this.state = state;
		this.setPreferredSize(new Dimension(200,200));
		this.setVisible(true);
		rollButton = new JButton("ROLL");
		rollButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				action = new GameAction(ActionType.ROLL_DICE,state.getActivePlayer());
			}
		});
		result = new JLabel("");
		this.add(rollButton);
		this.add(result);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		if(TurnStep.ROLL.equals(state.getCurrentTurnStep())) {
			//this.result.setVisible(false);
			//this.result.invalidate();
			this.result.setText(this.state.getLastRoll() != 0 ? String.valueOf(this.state.getLastRoll()) : "");
			this.rollButton.validate();
			this.rollButton.setVisible(true);
//		}
	}
	
	@Override
	public void notifyGameAction(GameAction action) {

	}

	@Override
	public GameAction getAction() {
		GameAction action = this.action;
		this.action = null;
		return action;
	}

}
