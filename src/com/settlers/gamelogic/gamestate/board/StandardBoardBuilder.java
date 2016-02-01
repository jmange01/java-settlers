package com.settlers.gamelogic.gamestate.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.settlers.gamelogic.gamestate.board.Hexagon.TileType;
import com.settlers.gamelogic.gamestate.templates.StandardBoardTemplate;

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
	
	private List<Hexagon> createTiles(Node[][] nodes) {
		List<Hexagon> hexes = new ArrayList<Hexagon>();
		for(int i=1;i<nodes.length-1;i++) {
			for(int j=i%2==1?1:2;j<nodes[i].length;j+=2) {
				int value = template.nextTile();
				Hexagon h = new Hexagon();
				h.addNode(nodes[i][j-1]);
				h.addNode(nodes[i-1][j-1]);
				h.addNode(nodes[i-1][j]);
				h.addNode(nodes[i][j]);
				h.addNode(nodes[i+1][j]);
				h.addNode(nodes[i+1][j-1]);
				
				if(value == 1) {
					addCharacteristics(h);	
				}
				hexes.add(h);
			}
		}
		return hexes;
	}
	
	private void addCharacteristics(Hexagon h) {
		Random r = new Random();
		h.setCharacteristics((int)(r.nextDouble()*12)+1, TileType.values()[(int)(r.nextDouble()*6)+1]);
	}
}
