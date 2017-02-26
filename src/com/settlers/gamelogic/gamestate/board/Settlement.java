package com.settlers.gamelogic.gamestate.board;

import java.awt.Image;
import java.awt.Point;

import com.settlers.gamelogic.vo.Player;

public class Settlement {
	private Point location;
	private Image texture;
	private Node n;
	private Player owner;
	
	public Settlement(Node n, Player owner) {
		this.location = new Point((int)n.getLocation().getX(),(int)n.getLocation().getY());
		this.texture = owner.getSettlementImage();
		this.n = n;
		this.owner = owner;
	}
	
	public Image getTexture() {
		return this.texture;
	}
	
	public Point getLocation() {
		return this.location;
	}
	
	public Node getNode() {
		return this.n;
	}
	
	public Player getOwner() {
		return this.owner;
	}
}
