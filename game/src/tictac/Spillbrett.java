package tictac;

import java.util.Arrays;

public class Spillbrett {

	// vis spillbrett
	public char [][] brett;
	
	public Spillbrett(){
		
		brett = new char [3][3];
		
		for (int i = 0; i< brett.length;i++){
			Arrays.fill(brett[i], ' ');
		}
	}
	
	public void visbrett(){
		for (int i = 0; i< brett.length;i++){
			for (int j = 0; j< brett[0].length;j++){
				System.out.print("   "+brett[i][j]);
				if(j==0||j==1){
					System.out.print('|');
				}
			}
			if (i ==0||i==1){
			System.out.print("\n---------------\n");
			}
		}
		System.out.println();
	}
	
	//setter inn x eller o i brett
	
	public boolean setCell(char c, int x, int y){
		
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
	
	
}
