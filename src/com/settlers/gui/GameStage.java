package com.settlers.gui;

import com.settlers.gui.listener.GameAction;

public interface GameStage {
	public void init();
	
	public GameAction getAction();
	
	public void update();
}
