package com.settlers.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.settlers.gui.listener.GameAction;

/**
 * Container class for all GUI contents. This allows different GUI's to be loaded in for each 
 * phase of the game (e.g. setup, play, postgame stats, etc).
 * 
 * @author Jeff
 *
 */
public class GameContainer {
	private JPanel panel;
	private List<GamePanel> gamePanels = new ArrayList<GamePanel>();
	private GameWindow parent;
	
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	public void setParent(GameWindow window) {
		this.parent = window;
	}
	
	public GameAction getAction() {
		for(GamePanel panel : this.gamePanels) {
			GameAction action = panel.getAction();
			if(action != null) {
				return action;
			}
		}
		return null;
	}
	
	public void addGamePanel(GamePanel gamePanel) {
		if(this.panel != null) {
			panel.add(gamePanel);
		}
		this.gamePanels.add(gamePanel);
	}
	
	public JPanel getPanel() {
		return this.panel;
	}
	
	public void update() {
		for(GamePanel gp : gamePanels) {
			gp.repaint();
		}
	}
	
	public void notifyPhaseChange() {
		parent.notifyPhaseChange();
	}
}
