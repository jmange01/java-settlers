package com.settlers.gamelogic.gamestate.board;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.settlers.gamelogic.gamestate.board.Hexagon.TileType;

public class Node {
	Point location;
	HashMap<Integer,List<TileType>> resources;
	
	public Node(int y, int x) {
		setLocation(new Point(x,y));
		resources = new HashMap<Integer,List<TileType>>();
	}
	
	public void addTile(int rollVal,TileType type) {
		if(resources.containsKey(rollVal)) {
			resources.get(rollVal).add(type);
		}
		else {
			List<TileType> t = new ArrayList<TileType>();
			t.add(type);
			resources.put(rollVal,t);
		}
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}
	
	public Point getLocation() {
		return this.location;
	}
}
