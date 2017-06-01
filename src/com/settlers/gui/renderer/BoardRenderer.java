package com.settlers.gui.renderer;

import java.util.List;

import com.settlers.gamelogic.gamestate.board.SettlersBoard;
import com.settlers.gui.Tile;
import com.settlers.gui.renderer.drawer.HexagonTileDrawer;
import com.settlers.gui.renderer.drawer.RoadDrawer;
import com.settlers.gui.renderer.drawer.SettlementDrawer;

public class BoardRenderer extends AbstractRenderer<SettlersBoard> {

	private List<Tile> boardTiles;
	
	public BoardRenderer(SettlersBoard board) {
		this.board = board;
		this.boardTiles = board.getTiles();
		this.init();
	}
	
	private void init() {
		super.addDrawer(new HexagonTileDrawer(this.boardTiles, this.origin));
		super.addDrawer(new SettlementDrawer());
		super.addDrawer(new RoadDrawer());
	}
}
