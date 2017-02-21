package tictactoe;


import java.util.Arrays;

public class test {
	
	public static void main(String[] args){
	
		char brett[][];
		brett = new char [3][3];

		for (int i = 0; i< brett.length;i++){
			Arrays.fill(brett[i], ' ');
		
		}	
		
		brett[1][1]= 'k';
		
		System.out.print(Character.toString(brett[1][1]) +"|"
						+Character.toString(brett[1][2])+"\n"	);
		
		brett[1][2]= 'm';
		System.out.print(Character.toString(brett[1][1]) +"|"
				+Character.toString(brett[1][2])	);
	
	}


	
		
}
	
	
	
		
	