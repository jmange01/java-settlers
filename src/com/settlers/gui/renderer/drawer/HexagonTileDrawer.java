package com.settlers.gui.renderer.drawer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.settlers.gamelogic.gamestate.board.Hexagon;
import com.settlers.gamelogic.gamestate.board.Node;
import com.settlers.gamelogic.gamestate.board.SettlersBoard;
import com.settlers.gui.Tile;

public class HexagonTileDrawer implements Drawer {
	
	private int tileHeight = 80;
	private int tileWidth = 80;
	
	private Point origin;
	
	public enum ResourceColors {
		OCEAN(Color.BLUE),
		DESERT(Color.GRAY),
		BRICK(Color.RED),
		WHEAT(Color.YELLOW),
		SHEEP(Color.GREEN),
		LUMBER(Color.ORANGE),
		ORE(Color.BLACK);
		
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
//		try(PrintWriter pw = new PrintWriter(new File("tiles.csv"));) {
			for(Hexagon h:tiles) {
//				logtiles(pw, h);
				g.setColor(ResourceColors.valueOf(h.getTileType().toString()).c);
				g.fillPolygon(h);
				g.setColor(Color.BLACK);
				g.drawPolygon(h);
			}
/*		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
