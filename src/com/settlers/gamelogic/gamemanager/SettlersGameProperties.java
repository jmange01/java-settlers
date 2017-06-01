package com.settlers.gamelogic.gamemanager;

/**
 * Encapsulates the relevant static game properties, such as the cost of
 * game pieces.
 * 
 * @author jmang
 *
 */
public class SettlersGameProperties {
	public enum GamePiece {
		SETTLEMENT(1,1,1,1,0),
		ROAD(1,0,0,1,0),
		CITY(0,2,0,0,3),
		DEV_CARD(0,1,1,0,1);
		
		private int brick;
		private int wheat;
		private int sheep;
		private int lumber;
		private int ore;
		
		GamePiece(int brick, int wheat, int sheep, int lumber, int ore) {
			this.brick = brick;
			this.wheat = wheat;
			this.sheep = sheep;
			this.lumber = lumber;
			this.ore = ore;
		}
		
		public boolean isPlayable(int brick, int wheat, int sheep, int lumber, int ore) {
			return brick >= this.brick 
					&& wheat >= this.wheat 
					&& sheep >= this.sheep 
					&& lumber >= this.lumber
					&& ore >= this.ore;
		}
		
		public int[] getCost() {
			int[] vals = {brick, wheat, sheep, lumber, ore};
			return vals;
		}
	}
}
