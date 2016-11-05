package com.settlers.main;

import javax.swing.JFrame;

import com.settlers.gamelogic.gamemanager.GameManager;
import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gui.GameWindow;
import com.settlers.gui.listener.GameAction;

public class SOJGame implements Runnable{
	
	GameWindow gui;
	GameManager manager;
	public SOJGame(){
		SettlersGameState gameState = new SettlersGameState();
		manager = new GameManager(gameState);
		gui = new GameWindow(manager);
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			GameAction action = gui.getAction();
			if(action != null) {
				manager.update(action);
				gui.update();
			}
		}
		
	}
}
