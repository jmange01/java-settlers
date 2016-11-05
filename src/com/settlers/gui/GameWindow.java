package com.settlers.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.settlers.gamelogic.gamemanager.GameManager;
import com.settlers.gui.listener.GameAction;
import com.settlers.gui.renderer.BoardRenderer;

public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	List<GameContainer> panes = new ArrayList<GameContainer>();
	private GameManager manager;

	public GameWindow(GameManager manager){
		this.manager = manager;
		this.setSize(new Dimension(800,600));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.init();
		this.repaint();
	}
	
	public void init(){
//		this.add(new BoardPanel(new BoardRenderer(manager.getGameBoard()),this.manager));
//		this.add(new ScorePanel(this.manager));

		
		panes.add(new ScorePanel(this.manager));
		panes.add(new BoardPanel(new BoardRenderer(manager.getGameBoard()),this.manager));
		
//TODO: this is a basic renderer to show a summary of the game state. remove the line below this one later
//		panes.add(new BoardPanel(new SimpleRenderer<Object>(manager.getGameBoard()),this.manager));

		for(GameContainer c : panes) {
			this.add(c);
		}
	}
	
	public GameAction getAction() {
		for(GameContainer c : panes) {
			GameAction action = c.getAction();
			if(action != null) {
				return action;
			}
		}
		return null;
	}
	
	public void update() {
		for(GameContainer c : panes) {
			c.repaint();
		}
	}
}
