package com.settlers.gui.renderer.drawer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.settlers.gamelogic.gamestate.board.SettlersBoard;
import com.settlers.gamelogic.gamestate.board.Settlement;

public class SettlementDrawer implements Drawer<SettlersBoard> {
	
	List<Settlement> settlements = new ArrayList<Settlement>();

	@Override
	public void draw(Graphics g) {
		for(Settlement s:settlements) {
			BufferedImage i = (BufferedImage)s.getTexture();
			g.drawImage(i, s.getLocation().x - (i.getWidth()/2), s.getLocation().y - (i.getHeight()/2), null);
//			g.drawImage(s.getTexture(), 400, 400, null);
		}

	}

	@Override
	public void update(SettlersBoard board) {
		this.settlements = board.getSettlements();
		
	}

}
