package oving;

import java.util.Arrays;

public class CardDeck extends CardHand {
	public Card[] cards;
	public int n,antK;
	public CardHand cardhand;
	
	
	public CardDeck(int n){
		antK=n*4;
		this.cards = new Card[n*4];

		for (int s=0;s<n;s++){
				cards[s] = new Card('S',s+1);
				cards[s+n]= new Card('H',s+1);
				cards[s+2*n] = new Card('D',s+1);
				cards[s+3*n]= new Card('C',s+1);
		}
		
	}
	
	
	public int getCardCount(){
		return antK;
	}
	
	public Card getCard(int m){
		if (m>getCardCount()||m<0){
			throw new IllegalArgumentException("Invalid input");
		}
		else{
			return cards[m];
		}
	}
	
	public void shufflePerfectly(){

		int i;
		Card[] temp3;
		temp3= Arrays.copyOf(cards, cards.length);


		int t1=0,t2=4;
		for (i=0;i<cards.length;i++){
			if(i%2==0){

				cards[i]=temp3[t1];
				t1=t1+1;
				
			}
			else{

				cards[i]=temp3[t2];
				t2=t2+1;		
			}

		}

	}
	
	public void deal(CardHand cardhand, int n){
		
		for (int i=n-1;i>=0;i--){
			cardhand.addCard(cards[antK-1]);
			antK--;
		}
	}
		
	
	public String toString(){
		
		return ("Antall kort er: " + getCardCount()
				+ ", kortene er som følge: "+ Arrays.toString(cards) +"\n");
	}
	
	public static void main(String[] args){
		CardDeck ny = new CardDeck(10);
		
		System.out.print(ny);
		
		CardHand hand = new CardHand();
		ny.deal(hand, 8);
		System.out.print(hand.getCardCount());
		System.out.print(hand.cardsOnH+"\n");
		hand.play(1);
		System.out.print(hand.cardsOnH);
		
	}
}

