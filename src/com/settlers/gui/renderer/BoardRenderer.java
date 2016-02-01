package com.settlers.gui.renderer;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import com.settlers.gamelogic.gamestate.board.Hexagon;
import com.settlers.gui.Tile;
import com.settlers.gui.renderer.drawer.HexagonTileDrawer;

public class BoardRenderer extends AbstractRenderer<Polygon> {
	
	private int tileHeight = 120;
	private int tileWidth = 120;
	private List<Hexagon> boardTiles;
	private List<Tile> guiTiles;
	private List<Point> nodes;
	
	public BoardRenderer(List<Hexagon> boardTiles) {
		this.boardTiles = boardTiles;
		this.guiTiles = new ArrayList<Tile>();
		this.init();
	}
	
	private void init() {
		generateNodePoints();
		super.addDrawer(new HexagonTileDrawer(this.guiTiles));
	}
	
	private void generateNodePoints() {
		nodes = new ArrayList<Point>();
		for(Hexagon tile:boardTiles) {
			tile.setTileHeight(tileHeight);
			tile.setTileWidth(tileWidth);
			
			Tile guiTile = new Tile(tile);
			this.guiTiles.add(guiTile);
			
			
		}
	}
}
