package com.settlers.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.settlers.gamelogic.gamemanager.GameManager;
import com.settlers.gui.renderer.BoardRenderer;

public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private GameManager manager;	

	public GameWindow(GameManager manager){
		this.manager = manager;
		this.setSize(new Dimension(800,600));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.init();
		this.repaint();
	}
	
	public void init(){
		this.add(new BoardPanel(new BoardRenderer(manager.getGameBoardTiles())));
	}
}
