package com.settlers.gui.renderer;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import com.settlers.gamelogic.gamestate.board.Hexagon;
import com.settlers.gamelogic.gamestate.board.SettlersBoard;
import com.settlers.gui.Tile;
import com.settlers.gui.renderer.drawer.HexagonTileDrawer;
import com.settlers.gui.renderer.drawer.SettlementDrawer;

public class BoardRenderer extends AbstractRenderer<Polygon> {

	private List<Tile> boardTiles;
	private List<Point> nodes;
	
	public BoardRenderer(SettlersBoard board) {
		this.board = board;
		this.boardTiles = board.getTiles();
		this.init();
	}
	
	private void init() {
//		generateNodePoints();
		super.addDrawer(new HexagonTileDrawer(this.boardTiles, this.origin));
		super.addDrawer(new SettlementDrawer());
	}
	
	private void generateNodePoints() {
		nodes = new ArrayList<Point>();
/*		for(Hexagon hex:boardTiles) {
			tile.setTileHeight(tileHeight);
			tile.setTileWidth(tileWidth);*/
			
/*			Tile guiTile = new Tile(tile);
			this.guiTiles.add(guiTile);
*/			
			
//		}
	}
}
