package com.settlers.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
	private List<JTextField> playerNames = new ArrayList<JTextField>();
	private List<JComboBox<String>> playerColors = new ArrayList<JComboBox<String>>();

	public SetupDialog(SettlersGameState state) {
		this.setPreferredSize(new Dimension(800,300));
		this.setVisible(true);
		this.setBackground(Color.GRAY);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
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
		playerSetupPanel.setSize(400,200);
		playerSetupPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		playerSetupPanel.setBackground(Color.WHITE);
		playerSetupPanel.setLayout(new BoxLayout(playerSetupPanel, BoxLayout.PAGE_AXIS));
		
		for(int i = 0; i < 4; i++) {
			JPanel playerField = this.createPlayerSetupField(i);
			this.playerSetupFields.add(playerField);
			playerSetupPanel.add(playerField);
		}
		this.add(playerSetupPanel);		
	}
	
	private JPanel createPlayerSetupField(int num) {
		JComboBox<String> dropDown = new JComboBox<String>();
		dropDown.addItem("Human");
		dropDown.addItem("None");
		dropDown.setVisible(true);
		
		JTextField nameField = new JTextField("Player " + num);
		nameField.setPreferredSize(new Dimension(100,25));
		nameField.setVisible(true);
		
		//TODO: Replace this with a legitimate color selector
		JLabel color = new JLabel("Color:");
		JComboBox<String> colorSelector = new JComboBox<String>();
		colorSelector.addItem("Red");
		colorSelector.addItem("Blue");
		colorSelector.addItem("Orange");
		colorSelector.addItem("Green");
		
		JPanel player = new JPanel();
		player.setVisible(true);
		player.setLayout(new FlowLayout());
		player.add(dropDown);
		player.add(nameField);
		player.add(color);
		player.add(colorSelector);
		
		this.playerNames.add(nameField);
		this.playerColors.add(colorSelector);
		
		return player;
	}
	
	protected void loadGameSettings() {
		for(int i = 0; i < this.playerSetupFields.size(); i++) {
			JTextField field = this.playerNames.get(i);
			JComboBox<String> box = this.playerColors.get(i);
			if(!field.getText().isEmpty()) {
				state.addPlayer(new Player(field.getText(), box.getSelectedItem().toString()));
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
