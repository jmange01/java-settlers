package com.settlers.gamelogic.gamestate.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.settlers.gamelogic.gamestate.templates.StandardBoardTemplate;
import com.settlers.gui.Tile;
import com.settlers.gui.Tile.TileType;

public class StandardBoardBuilder implements BoardBuilder{
	private static final int BOARD_WIDTH = 6;
	private static final int BOARD_HEIGHT = 8;
	StandardBoardTemplate template = new StandardBoardTemplate();

	@Override
	public SettlersBoard buildBoard() {
		SettlersBoard sb = new SettlersBoard();
		sb.setNodes(initNodes());
		sb.setTiles(createTiles(sb.getNodes()));
		
		return sb;
	}
	
	private Node[][] initNodes() {
		Node[][] nodes = new Node[(BOARD_HEIGHT*2)+1][BOARD_WIDTH*2];
		for(int i=0;i<(BOARD_HEIGHT*2)+1;i++) {
			for(int j=0;j<(BOARD_WIDTH*2);j++) {
				nodes[i][j] = new Node(i,j);
			}
		}
		return nodes;
	}
	
	private List<Tile> createTiles(Node[][] nodes) {
		List<Tile> tiles = new ArrayList<Tile>();
		for(int i=1;i<nodes.length-1;i++) {
			for(int j=i%2==1?1:2;j<nodes[i].length;j+=2) {
				int value = template.nextTile();
				Tile t  = new Tile();
				t.addNode(nodes[i][j-1]);
				t.addNode(nodes[i-1][j-1]);
				t.addNode(nodes[i-1][j]);
				t.addNode(nodes[i][j]);
				t.addNode(nodes[i+1][j]);
				t.addNode(nodes[i+1][j-1]);
				
				nodes[i][j-1].addAdjacent(nodes[i+1][j-1]);
				nodes[i][j-1].addAdjacent(nodes[i-1][j-1]);
				nodes[i-1][j-1].addAdjacent(nodes[i][j-1]);
				nodes[i-1][j-1].addAdjacent(nodes[i-1][j]);
				nodes[i-1][j].addAdjacent(nodes[i-1][j-1]);
				nodes[i-1][j].addAdjacent(nodes[i][j]);
				nodes[i][j].addAdjacent(nodes[i-1][j]);
				nodes[i][j].addAdjacent(nodes[i+1][j]);
				nodes[i+1][j].addAdjacent(nodes[i][j]);
				nodes[i+1][j].addAdjacent(nodes[i+1][j-1]);
				nodes[i+1][j-1].addAdjacent(nodes[i+1][j]);
				nodes[i+1][j-1].addAdjacent(nodes[i][j-1]);

				if(value == 1) {
					addCharacteristics(t);	
				}
				tiles.add(t);
			}
		}
		return tiles;
	}
	
	private void addCharacteristics(Tile t) {
		Random r = new Random();
		//TODO: There's a bug in the random tile selection here. Going to fix it later
		t.setCharacteristics((int)(r.nextDouble() * 12) + 1, TileType.values()[(int)(r.nextDouble() * 6) + 1]);
	}
}
