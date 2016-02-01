package com.settlers.gamelogic.gamestate.deck;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Deck {
	private List<Card> cards;
	private Random rand = new Random();
	
	public Deck(File source){
		loadCards(source);
	}
	
	private void loadCards(File input){
		
	}
	
	public void shuffle(){
		List<Card> temp = new ArrayList<Card>();
		for(int i = 0; i<cards.size();i++){
			temp.add(cards.get((int)rand.nextDouble()*52));
		}
	}
	
	public Card draw(){
		if(cards!=null){
			Card card = cards.get(0);
			cards.remove(cards.get(0));
			return card;
		} else{
			return null;
		}
		
	}
}
