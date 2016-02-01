package com.settlers.gui.renderer.drawer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import com.settlers.gamelogic.gamestate.board.Hexagon;
import com.settlers.gamelogic.gamestate.board.SettlersBoard;
import com.settlers.gui.Tile;

public class HexagonTileDrawer implements Drawer {
	
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
	
	private List<Tile> tiles;
	
	public HexagonTileDrawer(List<Tile> tiles) {
		this.tiles = tiles;
	}

	@Override
	public void draw(Graphics g) {
		try(PrintWriter pw = new PrintWriter(new File("tiles.csv"));) {
			for(Tile t:tiles) {
				logtiles(pw, t);
				g.setColor(ResourceColors.valueOf(t.getHexagon().getTileType().toString()).c);
				g.fillPolygon(t);
				g.setColor(Color.BLACK);
				g.drawPolygon(t);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//g.drawPolygon(board.getTiles().get(3));
	}
	
	public void logtiles(PrintWriter pw, Tile t) {

		int[] xpts = t.xpoints;
		int[] ypts = t.ypoints;
		pw.append(t.getHexagon().toString() + ",");
		for(int i=0;i<t.npoints;i++) {
			pw.append(xpts[i] + ":" + ypts[i] + ",");
		}
		pw.append("\n");
	}
}
