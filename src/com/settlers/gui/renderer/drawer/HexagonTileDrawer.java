package com.settlers.gui.renderer.drawer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.settlers.gamelogic.gamestate.board.Hexagon;
import com.settlers.gamelogic.gamestate.board.SettlersBoard;
import com.settlers.gui.Tile;
import com.settlers.gui.Tile.TileType;

public class HexagonTileDrawer implements Drawer<SettlersBoard> {
	
	private int tileHeight = 80;
	private int tileWidth = 80;
	
	private Point origin;
	
	private static final Color DESERT_COLOR = new Color(0.9f, 0.8f, 0.7f);
	private static final Color BRICK_COLOR = new Color(0.9f, 0.5f, 0.5f);
	
	public enum ResourceColors {
		OCEAN(Color.BLUE),
		DESERT(DESERT_COLOR),
		BRICK(BRICK_COLOR),
		WHEAT(Color.YELLOW),
		SHEEP(Color.GREEN),
		LUMBER(Color.ORANGE),
		ORE(Color.GRAY);
		
		private final Color c;
		
		ResourceColors(Color c) {
			this.c = c;
		}
	}
	
	private List<Hexagon> tiles;
	
	public HexagonTileDrawer(List<Tile> tiles, Point origin) {
		this.origin = origin;
		this.tiles = new ArrayList<Hexagon>();
		for(Tile t:tiles) {
			this.tiles.add(new Hexagon(t, this.tileWidth, this.tileHeight, this.origin));
		}
	}

	@Override
	public void draw(Graphics g) {
		for(Hexagon h:tiles) {
			g.setColor(ResourceColors.valueOf(h.getTileType().toString()).c);
			g.fillPolygon(h);
			g.setColor(Color.BLACK);
			g.drawPolygon(h);
			if(!h.getTileType().equals(TileType.OCEAN) && !h.getTileType().equals(TileType.DESERT)) {
				g.drawString(String.valueOf(h.getTileRollVal()), (int)h.getBounds().getCenterX(), (int)h.getBounds().getCenterY());				
			}
		}
	}
	
	public void logtiles(PrintWriter pw, Hexagon h) {

		int[] xpts = h.xpoints;
		int[] ypts = h.ypoints;
		pw.append(h.toString() + ",");
		for(int i=0;i<h.npoints;i++) {
			pw.append(xpts[i] + ":" + ypts[i] + ",");
		}
		pw.append("\n");
	}

	@Override
	public void update(SettlersBoard board) {
		// TODO Auto-generated method stub
		
	}
}
