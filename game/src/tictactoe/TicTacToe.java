package tictactoe;

import java.util.Arrays;

public class TicTacToe {
	public int count;
	public char [][] brett;
	
	public TicTacToe(){
		brett = new char [3][3];
		
		for (int i = 0; i< brett.length;i++){
			Arrays.fill(brett[i], ' ');
		
		}	
		
	}
	
	//sjekker om innput er lovlig
	public boolean setCell(char c, int x, int y){
		if (c!='O' && c!='X'){
			System.out.print("må være stor X eller O, ikke " + Character.toString(c));
			return false;
		}
		if (x>=0 && x<=2 && y<=2 && y>=0){
			if (isOccupied(x,y)){
				return false;
			}
			else{
				brett[x][y]= c;
				return true;
			}
		}
		else {
			return false;
		}
		
	}
	
	// sjekker om rute er ledig
		public boolean isOccupied(int x, int y){
			if (brett[x][y]!= ' '){
				return true;
			}
			else{
				return false;
			}
		}
		
		// returnerer bokstav i rute xy
		public char getCell(int x, int y){
			return brett[x][y];
		}

		//sjekker hvem sin tur det er
		public char getCurrentPlayer(){
			int countx=0,counto=0;
			
			for (int i=0; i<brett.length;i++){
				for (int j=0;j<brett[1].length;j++){
					if(getCell(i,j)=='O'){
						counto++;
					}
					else if(getCell(i,j)=='X'){
						countx++;
					}
				}
			}
			
			if (counto<countx){
				return 'O';
			}
			else{
				return 'X';
			}
		}
		
		//tar inn input og gjør trekket
		public void play(int x, int y){
			
			if (setCell(getCurrentPlayer(),x,y)){
				char spiller = getCurrentPlayer();
				System.out.print("\n Gyldig trekk, neste spiller er " + Character.toString(spiller) +" \n");
			}
			else{
				System.out.print("\n Ugyldig input \n");
			}
		}
		
		//sjekker vinne betingelser
		public boolean hasWinner(){
			 if( brett[0][0]==brett[1][0] && brett[1][0] == brett[2][0] && (brett [0][0]=='X' || brett [0][0]=='O'))
	                return true;
	    else if( brett [0][1]==brett[1][1] && brett[1][1] == brett[2][1] && (brett [0][1]=='X' || brett [0][1]=='O'))
	                return true;
	    else if( brett [0][2]==brett[1][2] && brett[1][2] == brett[2][2] && (brett [0][2]=='X' || brett [0][2]=='O'))
	                return true;
	    else if( brett [0][0]==brett[0][1] && brett[0][1] == brett[0][2] && (brett [0][0]=='X' || brett [0][0]=='O'))
	                return true;
	    else if( brett [1][0]==brett[1][1] && brett[1][1] == brett[1][2] && (brett [1][0]=='X' || brett [1][0]=='O'))
	                return true;
	    else if( brett [2][0]==brett[2][1] && brett[2][1] == brett[2][2] && (brett [2][0]=='X' || brett [2][0]=='O'))
	                return true;
	    else if( brett [0][0]==brett[1][1] && brett[1][1] == brett[2][2] && (brett [0][0]=='X' || brett [0][0]=='O'))
	                return true;
	    else if( brett [2][0]==brett[1][1] && brett[1][1] == brett[0][2] && (brett [2][0]=='X' || brett [2][0]=='O'))
	                return true;
	    else
	                return false;
		}
		
		//sjekker hvem som har vunnet
		public boolean isWInner(char c){
			if (getCurrentPlayer() != c && hasWinner()){
				return true;
			}
			else{
				
				return false;
			}		
		}
	
		//sjekker om spillet er ferdig
		public boolean isFInished(){
			if(hasWinner()||Nospace()){
				return true;
			}
			else{
				return false;
			}
		}
		
		//sjekker om brettet er full
	private boolean Nospace() {
		int count=0;
		
		for (int i=0; i<brett.length;i++){
			for (int j=0;j<brett[1].length;j++){
				if(getCell(i,j)!=' '){
					count++;
				}
			}
		}
		
		if (count>=9){
			return true;
		}
		
		else{
			return false;
		}
			
	}
	
	//skriver ut brettet
	public String toString(){
		
		return (  "\n "+Character.toString(getCell(0,0)) + " | " 
				+ Character.toString(getCell(0,1)) + " | " 
				+ Character.toString(getCell(0,2)) + "  \n" 
				+ "-----------\n" 
				+ " "+Character.toString(getCell(1,0)) + " | " 
				+ Character.toString(getCell(1,1)) + " | " 
				+ Character.toString(getCell(1,2)) + "  \n" 
				+ "-----------\n" 
				+ " "+Character.toString(getCell(2,0)) + " | " 
				+ Character.toString(getCell(2,1)) + " | " 
				+ Character.toString(getCell(2,2)) + " \n");
		
	}
	
	//sjekker om string er et heltall
	public boolean isInteger(String in){
		try{
			Integer.parseInt(in);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
	
	//tar inn string input
	public void getInput(String in){
		
		if(isInteger(in) && in.length()==2){
			if(isFInished()==false){
			int x = Character.getNumericValue(in.charAt(0));
			int y = Character.getNumericValue(in.charAt(1));
			
			play(x,y);
			}
		}
		else{
			System.out.print("Invalid input, skal være i formen: 00 \n");
		}
		
		if(hasWinner()){
			if(isWInner('X')){
				System.out.print("Spiller X har vunnet!. Spillet er over\n");
			}
			else{
				System.out.print("Spiller O har vunnet!. Spillet er over\n");
			}
		}
		
		if(Nospace()){System.out.print("Tom for plass, spillet endte i uavgjort!\n");}
	
	}
	
	//tester
	public static void main(String args[]){
		TicTacToe nyspill = new TicTacToe();
		
		
//		System.out.print(nyspill);
//		
//		System.out.print("Det er spiller " + Character.toString(nyspill.getCurrentPlayer()) + " sin tur\n");
//		nyspill.play(2, 0);
//		System.out.print(nyspill);
//		System.out.print("Det er spiller " + Character.toString(nyspill.getCurrentPlayer()) + " sin tur\n");
//		nyspill.play(1, 0);
//		nyspill.play(2, 1);
//		nyspill.play(1, 2);
//		nyspill.play(0, 2);
//		nyspill.play(2, 2);
//		nyspill.play(1, 1);
//		nyspill.play(0, 1);
//		nyspill.play(0, 0);
//		System.out.print(nyspill.isWInner('X'));
//		System.out.print(nyspill);
//		System.out.print("spillet er ferdig? " +nyspill.isFInished());
		System.out.print(nyspill);
		nyspill.getInput("12");
		System.out.print(nyspill);
		System.out.print("spillet er ferdig? " +nyspill.isFInished());
	}	

}
