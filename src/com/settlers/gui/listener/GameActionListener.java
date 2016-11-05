package com.settlers.gui.listener;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import com.settlers.gui.GameActionPanel;

public class GameActionListener implements MouseInputListener {
	GameAction action;
	GameActionPanel parent;
	public GameActionListener(GameAction action, GameActionPanel parent) {
		this.parent = parent;
		this.action = action;
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		parent.notifyGameAction(this.action);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
