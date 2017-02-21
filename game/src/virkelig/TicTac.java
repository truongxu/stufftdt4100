package virkelig;

import java.util.Arrays;

public class TicTac {
	
	public char [][] brett;
	
	public TicTac(){
		System.out.print("hei2");
		brett = new char [3][3];
		
		for (int i = 0; i< brett.length;i++){
			Arrays.fill(brett[i], ' ');
		
		}	
		brett[1][1]='C';
	}
	
	public boolean setCell(char c, int x, int y){
		System.out.print("hei");
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

		
	
	public String toString(){
		
		return (  Character.toString(getCell(0,0)) + "|" 
				+ Character.toString(getCell(0,1)) + "|" 
				+ Character.toString(getCell(0,2)) + "|\n" 
				+ "--------------\n" 
				+ Character.toString(getCell(1,0)) + "|" 
				+ Character.toString(getCell(1,1)) + "|" 
				+ Character.toString(getCell(1,2)) + "|\n" 
				+ "--------------\n" 
				+ Character.toString(getCell(2,0)) + "|" 
				+ Character.toString(getCell(2,1)) + "|" 
				+ Character.toString(getCell(2,2)) + "|\n");
		
	}
	
	public static void man(String args[]){
		TicTac nyspill = new TicTac();
		char h ='g';
		System.out.print(nyspill);
		System.out.print(Character.toString(h));
	}

}
