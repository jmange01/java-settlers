package com.settlers.gui.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.settlers.gui.BoardPanel;

public class BoardPanelMouseListener implements MouseListener {
	private BoardPanel panel;
	
	public BoardPanelMouseListener(BoardPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		panel.notifyPanelAction(event);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
