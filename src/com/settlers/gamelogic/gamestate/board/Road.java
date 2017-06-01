package com.settlers.gamelogic.gamestate.board;

import com.settlers.gamelogic.vo.Player;

public class Road {
	private Node start;
	private Node end;
	private Player owner;
	
	public Road(Node start, Node end, Player owner) {
		this.start = start;
		this.end = end;
		this.owner = owner;
	}
	
	public Node getStart() {
		return this.start;
	}
	
	public Node getEnd() {
		return this.end;
	}
	
	public Player getOwner() {
		return this.owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Road other = (Road) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}
}
