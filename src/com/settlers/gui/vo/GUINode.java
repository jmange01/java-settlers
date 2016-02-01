package com.settlers.gui.vo;

import java.awt.Point;

import com.settlers.gamelogic.gamestate.board.Node;

public class GUINode {
	private Point point;
	private Node node;
	
	public GUINode(Node node, Point point) {
		this.setPoint(point);
		this.setNode(node);
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
}
