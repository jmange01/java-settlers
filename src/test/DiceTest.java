package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.settlers.util.Dice;

public class DiceTest {


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Dice d = new Dice(2,6);
		try {

			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			String s = bufferRead.readLine();
			while(s!="stop"){
				System.out.println(d.roll());
				s = bufferRead.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d.roll();
	}

}
