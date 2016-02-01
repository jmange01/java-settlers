package test;

import org.junit.Test;

import com.settlers.gamelogic.gamestate.board.BoardBuilder;
import com.settlers.gamelogic.gamestate.board.Hexagon;
import com.settlers.gamelogic.gamestate.board.SettlersBoard;
import com.settlers.gamelogic.gamestate.board.StandardBoardBuilder;

public class BoardBuilderTest {
	@Test
	public void buildBoardTest() {
		BoardBuilder bb = new StandardBoardBuilder();
		SettlersBoard sb = bb.buildBoard();
		
		int index = 1;
		for(Hexagon h:sb.getTiles()) {
			System.out.println("\nTile " + index++ + ": \n\tType: " 
			+ h.getTileType().toString() + "\n\tRoll Value: " + h.getRollVal());
		}
	}
}
