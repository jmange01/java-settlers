package test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.settlers.util.Dice;

public class DiceTest {
	@Test
	public void testSingle() {
		simulateRolls(1,4,100);
	}
	
	@Test
	public void testTwoStandard() {
		simulateRolls(2,6,1000);
	}
	
	@Test
	public void testManySmall() {
		simulateRolls(8,3,1000);
	}
	
	@Test
	public void testManyLarge() {
		simulateRolls(12,12,100000);
	}
	
	private void simulateRolls(int diceCount, int sides, int reps) {
		Dice d = new Dice(diceCount,sides);
		Set<Integer> results = new HashSet<Integer>();
		for(int i = 0; i < reps; i++) {
			results.add(d.roll());			
		}
		assert(results.size() == diceCount * sides);
	}

}
