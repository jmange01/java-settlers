package com.settlers.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gamelogic.vo.Player;
import com.settlers.gui.listener.GameAction;

/**
 * Display component that shows the resource stockpile for all players.
 * This should be either removed or modified to show only the totals 
 * for the active player. For local games it may be a good idea to provide
 * a "view stockpile" button so that the active player's stockpile remains 
 * hidden from others.
 * @author Jeff
 *
 */
public class ResourcePanel extends GamePanel {
	private static final long serialVersionUID = -8907772917200501827L;
	private SettlersGameState state;
	private List<PlayerPanel> playerPanels = new ArrayList<PlayerPanel>();
	
	private class PlayerPanel extends JPanel{
		private static final long serialVersionUID = 1913064197596455675L;
		JLabel name = new JLabel();
		JTextArea resources = new JTextArea();
		PlayerPanel(Player player) {
			this.setMinimumSize(new Dimension(100,200));
			this.setVisible(true);
			this.setBackground(Color.WHITE);
			
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			name.setText(player.getPlayerName());
			resources.setText(player.reportResources());
			
			this.name.setVisible(true);
			this.resources.setVisible(true);
			this.add(name);
			this.add(resources);
		}
		
		protected void update(Player player) {
			name.setText(player.getPlayerName());
			resources.setText(player.reportResources());
			
		}
	}
	
	public ResourcePanel(SettlersGameState state) {
		this.setPreferredSize(new Dimension(state.getPlayers().size() * 100,200));
		this.setVisible(true);
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		this.state = state;
		for(Player p : this.state.getPlayers()) {
			PlayerPanel panel = new PlayerPanel(p);
			this.playerPanels.add(panel);
			this.add(panel);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < playerPanels.size(); i++) {
			Player p = this.state.getPlayers().get(i);
			this.playerPanels.get(i).update(p);
		}
	}
	
	@Override
	public void notifyGameAction(GameAction action) {
		// TODO Auto-generated method stub

	}

	@Override
	public GameAction getAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
