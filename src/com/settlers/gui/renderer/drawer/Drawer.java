package com.settlers.gui.renderer.drawer;

import java.awt.Graphics;

public interface Drawer<T> {
	/**
	 * Handles the drawing logic for rendering various aspects of the GUI to the window.
	 * @param g a standard Java Graphics class
	 */
	public void draw(Graphics g);
	
	/**
	 * Updates the drawer with the current state of the board.
	 * @param board the current game board.
	 */
	void update(T t);
}
