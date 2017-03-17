package com.settlers.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gamelogic.gamestate.board.Node;
import com.settlers.gamelogic.gamestate.board.SettlersBoard;
import com.settlers.gui.listener.BoardPanelMouseListener;
import com.settlers.gui.listener.GameAction;
import com.settlers.gui.renderer.AbstractRenderer;
import com.settlers.util.Calculator2d;

public class BoardPanel extends GamePanel {	
	private static final long serialVersionUID = 4568611896607665446L;
	private AbstractRenderer<? extends Object> renderer;
	private SettlersGameState state;
	private GameAction gameAction = null;
	private Node activeNode = null;
	
	private Component lightBox = null;

	public BoardPanel(AbstractRenderer<? extends Object> r, SettlersGameState state){
		this.setPreferredSize(new Dimension(450,450));
		this.setLocation(new Point(100,0));
		this.setVisible(true);
		this.setBackground(Color.CYAN);
		this.setLayout(null);
		this.state = state;
		this.renderer = r;
		this.renderer.setOrigin(this.getLocation());
		this.addListeners();
		
	}
	
	public void notifyPanelAction(MouseEvent e) {
		if(MouseEvent.MOUSE_CLICKED == e.getID()) {
			Node n = getNearestNode(e.getPoint());
			//TODO: replace hard-coded value with property
			if(Calculator2d.getDistance(e.getPoint(), n.getLocation()) < 10.0) {
				this.addLightBox(n);				
			} else {
				this.removeLightBox();
			}
		}
	}
	@Override
	public void notifyGameAction(GameAction g) {
		this.gameAction = g;
		g.setLocation(activeNode);
		this.removeLightBox();
	}
	
	private void addListeners() {
		this.addMouseListener(new BoardPanelMouseListener(this));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBoard(g);
	}
	
	private void drawBoard(Graphics g){
		this.setBackground(Color.CYAN);
		renderer.render(g);
	}
	
	private Node getNearestNode(Point p) {
		double bestDist = Double.MAX_VALUE;
		Node nearest = null;
		SettlersBoard board = this.state.getBoard();
		for(Tile t:board.getTiles()) {
			for(Node n:t.getNodes()) {
				double dist = Calculator2d.getDistance(n.getLocation(), p);
				if(dist < bestDist) {
					bestDist = dist;
					nearest = n;
				}
			}
		}
		return nearest;
	}
	
	protected void addLightBox(Node n) {
		if(this.lightBox != null) {
			this.remove(this.lightBox);
		}
		JPanel lightBox = new BoardActionDialogBox(n, state.getActivePlayer(), this);
		this.add(lightBox);
		this.lightBox = lightBox;
		this.activeNode = n;
	}
	
	protected void removeLightBox() {
		if(this.lightBox != null) {
			this.remove(this.lightBox);
			this.activeNode = null;
		}
	}

	@Override
	public GameAction getAction() {
		GameAction action = this.gameAction;
		this.gameAction = null;
		return action;
	}
}
