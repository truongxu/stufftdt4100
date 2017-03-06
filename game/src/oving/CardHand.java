package oving;

import java.util.ArrayList;

public class CardHand {
	ArrayList<Card> cardsOnH;
	
	public CardHand(){
		 cardsOnH = new ArrayList<Card>();
	};
	
	
	public int getCardCount(){
		return cardsOnH.size();
		
	}
	
	public Card getCard(int n){
		return cardsOnH.get(n);
	}
	
	public void addCard(Card card){
		cardsOnH.add(card);
	}
	
	public Card play(int n){
		Card r = this.getCard(n);
		this.cardsOnH.remove(n);
		return r;
	}
}
