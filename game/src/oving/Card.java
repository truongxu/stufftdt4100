package oving;

public class Card {
	Card(){};
	char K;
	int tall;
	
	public Card(char K,int tall){
		if(ugyldigB(K)||ugyldigT(tall)){
			throw new IllegalArgumentException("Invalid input");
		}
		this.K = K;
		this.tall=tall;
	}

	public char getSuit(){
		return K;
	}
	
	public int getFace(){
		return this.tall;
	}
	
	public String toString(){
		return "" + this.K+this.tall;
	}
	public boolean ugyldigB(char K){
		if(K=='S'||K=='H'||K=='D'||K=='C'){
			return false;
		}

		else{
			return true;
		}
	}
	public boolean ugyldigT(int tall){
		if (tall<1||tall>13){
			return true;
		}
		else{
			return false;
		}
	}
}
