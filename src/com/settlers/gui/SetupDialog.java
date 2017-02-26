package com.settlers.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gamelogic.vo.Player;
import com.settlers.gui.listener.GameAction;
import com.settlers.gui.listener.GameAction.ActionType;

public class SetupDialog extends GamePanel {
	private static final long serialVersionUID = 1540038987593201469L;
	private GameAction action = null;
	private SettlersGameState state;
	private List<JPanel> playerSetupFields = new ArrayList<JPanel>();

	public SetupDialog(SettlersGameState state) {
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setBackground(Color.GRAY);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(new FlowLayout());
		
		this.state = state;
		this.addPlayerSetupField();
		
		JButton button = new JButton("Start");
		button.setSize(150,25);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadGameSettings();
				action = new GameAction(ActionType.END_STAGE,null);
			}
		});
		this.add(button);
		button.setVisible(true);
	}
	
	private void addPlayerSetupField() {
		JPanel playerSetupPanel = new JPanel();
		playerSetupPanel.setSize(400,500);
		playerSetupPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		playerSetupPanel.setBackground(Color.WHITE);
		playerSetupPanel.setLayout(new FlowLayout());
		
		for(int i = 0; i < 4; i++) {
			JPanel playerField = this.createPlayerSetupField();
			this.playerSetupFields.add(playerField);
			playerSetupPanel.add(playerField);
		}
		
		this.add(playerSetupPanel);		
	}
	
	private JPanel createPlayerSetupField() {
		JComboBox<String> dropDown = new JComboBox<String>();
		dropDown.addItem("Human");
		dropDown.addItem("None");
		
		dropDown.setVisible(true);
		
		JTextField nameField = new JTextField("");
		nameField.setPreferredSize(new Dimension(100,25));
		nameField.setVisible(true);
		
		//TODO: Add color selection for players
		
		JPanel player = new JPanel();
		player.setVisible(true);
		player.setLayout(new FlowLayout());
		player.add(dropDown);
		player.add(nameField);
		
		return player;
	}
	
	protected void loadGameSettings() {
		for(JPanel panel : playerSetupFields) {
			for(Component c : panel.getComponents()) {
				if(c instanceof JTextField) {
					JTextField field = (JTextField)c;
					if(!field.getText().isEmpty()) {
						state.addPlayer(new Player(field.getText()));
					}
				}
			}
		}
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
