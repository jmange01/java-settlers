package com.settlers.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gui.GameContainerFactory.Stage;
import com.settlers.gui.listener.GameAction;
import com.settlers.gui.listener.GameAction.ActionType;

public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	GameContainer container;
	private SettlersGameState state;

	public GameWindow(SettlersGameState state){
		this.setSize(new Dimension(800,600));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.init(state);
		this.state = state;
		this.repaint();
	}
	
	public void init(SettlersGameState state){		
		this.container = GameContainerFactory.getContainerInstance(Stage.SETUP, state, this);
		this.add(container.getPanel());
	}
	
	public GameAction getAction() {
		GameAction action = this.container.getAction();
		if(action != null) {
			if(ActionType.END_STAGE.equals(action.getType())) {
				state.finalizeInitialState();
				this.notifyPhaseChange();
			} else {
				return action;
			}
		}
		return null;
	}
	
	public void update() {
		this.container.update();
	}
	
	public void notifyPhaseChange() {
		this.container.getPanel().setVisible(false);
		this.remove(container.getPanel());
		this.invalidate();
		this.validate();
		this.container = GameContainerFactory.getContainerInstance(Stage.PLAY, state, this);
		this.add(container.getPanel());
	}
}
