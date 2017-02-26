package com.settlers.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gamelogic.vo.Player;
import com.settlers.gui.listener.GameAction;

public class ScorePanel extends GamePanel {
	private static final long serialVersionUID = 9078119655383269863L;
	
	private SettlersGameState state;

	public ScorePanel(SettlersGameState state) {
		this.setPreferredSize(new Dimension(100,200));
		this.setVisible(true);
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		this.state = state;
		for(Player p : this.state.getPlayers()) {
			JLabel playerName = new JLabel(p.getPlayerName());
			playerName.setVisible(true);
			this.add(playerName);
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Component c : this.getComponents()) {
			if(c instanceof JLabel) {
				JLabel label = (JLabel)c;
				Player active = state.getActivePlayer();
				if(label.getText().equals(active.getPlayerName())) {
					label.setForeground(Color.red);
				} else {
					label.setForeground(Color.black);
				}
			}
		}
	}

	@Override
	public void notifyGameAction(GameAction action) {
		
	}

	@Override
	public GameAction getAction() {
		return null;
	}
}