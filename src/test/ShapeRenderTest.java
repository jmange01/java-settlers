package test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gamelogic.gamestate.board.Hexagon;
import com.settlers.gui.GameWindow;

public class ShapeRenderTest {
	
	private SettlersGameState gameState = new SettlersGameState();
	Properties props;
	
//	@Test
/*	public void testRenderHexagon(){
		List<Hexagon> tiles = new ArrayList<Hexagon>();
		tiles.add(new Hexagon().addPoint(new Point(100,100)).addPoint(new Point(200,100)).addPoint(new Point(250,170)));
		tiles.add(new Hexagon().addPoint(new Point(100,150)).addPoint(new Point(200,100)));
		gameState.getBoard().setTiles(tiles);
		JFrame frame = new GameWindow(gameState);
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
	}*/
}
