package com.settlers.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.settlers.gamelogic.gamestate.board.Hexagon;
import com.settlers.gamelogic.gamestate.board.SettlersBoard;
import com.settlers.gui.renderer.AbstractRenderer;
import com.settlers.gui.renderer.drawer.Drawer;
import com.settlers.gui.renderer.drawer.HexagonTileDrawer;
import com.settlers.gui.renderer.drawer.PointDrawer;

public class BoardPanel extends JPanel {

	private static final int TILE_VIEW_WIDTH = 6;
	private static final int TILE_VIEW_HEIGHT = 8;
	
	private static final long serialVersionUID = 4568611896607665446L;
	private AbstractRenderer<? extends Polygon> renderer;
	private SettlersBoard board;

	public BoardPanel(AbstractRenderer<? extends Polygon> r){
		this.setSize(800,800);
		this.setVisible(true);
		this.setBackground(Color.CYAN);
		this.renderer = r;
//		board.setTiles(generateBaseTiles());
		this.addListeners();
		
	}
	
	private void addListeners() {
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int x = arg0.getX();
				int y = arg0.getY();
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		
		super.paintComponent(g);
		drawBoard(g, board);
		try {
			BufferedImage bi = ImageIO.read(new File("resources/settlement.png"));
			g.drawImage(bi, 100, 100, null);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void drawBoard(Graphics g, SettlersBoard board){
		this.setBackground(Color.CYAN);
		renderer.render(g);
	}
	
	private List<Hexagon> generateBaseTiles() {
		List<Hexagon> tiles = new ArrayList<Hexagon>();
		Point[][] points = new Point[(TILE_VIEW_HEIGHT*2)+1][TILE_VIEW_WIDTH*2];
		
		int tileWidth = this.getWidth()/TILE_VIEW_WIDTH;
		int tileHeight = this.getHeight()/TILE_VIEW_HEIGHT+1;
		
		int offset_x = tileWidth/2;
		int offset_y = tileHeight/2;
		
		int x = offset_x/2;
		int y = 0;
		
		for(int i=0;i<(TILE_VIEW_HEIGHT*2)+1;i++) {
			if(i%2==0) {
				x = offset_x/2;
				for(int j=0;j<TILE_VIEW_WIDTH*2;j++) {
					points[i][j] = new Point(x,y);
					if(j%2 == 0) {
						x += offset_x;
					} else {
						x += tileWidth;
					}
				}
			} else {
				x = 0;
				for(int j=0;j<TILE_VIEW_WIDTH*2;j++) {
					points[i][j] = new Point(x,y);
					if(j%2 == 0) {
						x += tileWidth;
					} else {
						x += offset_x;
					}
				}
			}
			y += offset_y;
		}
		
		int r = 100;
		int g = 100;
		int b = 100;
		for(int i=0; i<((TILE_VIEW_HEIGHT*2)+1)-2;i++) {
			for(int j=(i%2==0?0:1);j<(TILE_VIEW_WIDTH*2)-1;j+=2) {
				Hexagon h = new Hexagon();
				h.addPoint(points[i][j]).addPoint(points[i][j + 1])
						.addPoint(points[i + 1][j + 1])
						.addPoint(points[i + 2][j + 1])
						.addPoint(points[i + 2][j]).addPoint(points[i + 1][j]);
				if(h != null) {		
					h.setColor(new Color(r, g, b));
					tiles.add(h);
				}
				b += 10;
			}
			b = 100;
			g+=10;
		}
		return tiles;
	}
}
