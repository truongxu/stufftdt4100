package slagkip;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;



public class Slagskip {
	public char [][] brett1;
	public char [][] brett2;
	public char [][] ship1;
	public char [][] ship2;
	public int [] count;
	public int turn = 0;
	
	public Slagskip(){
		count = new int[2];
		brett1 = new char [10][10];
		brett2 = new char [10][10];
		count = new int[2];
		count[0]=0;
		count[1]=0;
		for (int i=0;i<brett1.length;i++){
			Arrays.fill(brett1[i], '~');
			Arrays.fill(brett2[i], '~');
		}
		
		convert();
	}
	
	public void convert(){
		String k = "...XX........XX..XXX...XX..........................X.........X...XXX...X.........X..XX..............";
		String g = ".XXX.......XXX....X.........X.........X....XX...X.............X..XXX....X.........X.................";
		int x=0;
		int y=0;
		ship1 = new char [10][10];
		ship2 = new char [10][10];
		for (int i=0;i<k.length();i++){
			ship1[x][y] = k.charAt(i);
			ship2[x][y] = g.charAt(i);
			y=y+1;
			if(y==10){
				y=0;
				x=x+1;
			}
		}
//		System.out.print(brett3 +"\n");		
//		System.out.print(brett3[1][9]+"\n");
//		System.out.println(Arrays.toString(brett3[9]));
//		
//		System.out.print("ship for spiller 1\n");
//		
//		printBrett(ship1);
//		System.out.print("\n ship for spiller 2\n");
//		printBrett(ship2);
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
		
		public boolean isFinished(int [] count){
			if (count[0]==18||count[1]==18){
				return true;
			}
			else{
				return false;
			}
		}
	
	//tar inn string input
		public void getInput(String in){
			
			if(isFinished(count)==false){
				if(isInteger(in) && in.length()==2){
					int x = Character.getNumericValue(in.charAt(0));
					int y = Character.getNumericValue(in.charAt(1));
					
					System.out.print("// Spiller " +currentPlayer(turn) +"'s sin tur \n" );
					if (currentPlayer(turn)==1){
						printBrett(brett1);
					}
					else {
						printBrett(brett2);
					}
					play(x,y);
				}
				else{
				System.out.print("Invalid input, skal være i formen: 00 \n");
			}
			}
			
			else{
					if(count[0]==18){
						System.out.print("Spiller 1 har vunnet!. Spillet er over\n");
						printBrett(brett1);
					}
					else{
						System.out.print("Spiller 2 har vunnet!. Spillet er over\n");
						printBrett(brett2);
					}
			}
				
		}
		
		public void play(int x, int y){
			//spiller en sin tur
			if(currentPlayer(turn)==1){
				if(checkgyldig(brett1,x,y)){
					spiller1(x,y);
					turn++;
				}
				else {
					System.out.print("Ugyldig trekk, prøv igjen\n");
				}
			}
			else{
				if(checkgyldig(brett2,x,y)){
					spiller2(x,y);
					turn++;
				}
				else {
					System.out.print("Ugyldig trekk, prøv igjen\n");
				}
			}
		}
		
		public int currentPlayer(int turn){
			if(turn%2==0){
				return 1;
			}
			else return 2;
		}
		
		//sjekker hva ruten inneholder, false på alt annet enn ~
		public boolean checkgyldig(char[][] brett, int x, int y){
			if (brett[x][y]!='~'){
				return false;
			}
			else return true;
		}
		//spiller en prøver seg
		public void spiller1(int x, int y){
			System.out.print(x+ " " +y+"\n");
			if (ship1[x][y]=='X'){
				brett1[x][y]='X';
				count[0]++;
				System.out.print("BOOM! Du traff noe \n");
			}
			else{
				brett1[x][y]='.';
				System.out.print("Bare vann \n");
			}
		}
		//spiller to prøver seg
		public void spiller2(int x, int y){
			System.out.print(x+ " " +y +"\n");
			if (ship2[x][y]=='X'){
				brett2[x][y]='X';
				count[1]++;
				System.out.print("BOOM! Du traff noe \n");
			}
			else{
				brett2[x][y]='.';
				System.out.print("Bare vann \n");
			}
		}
		
	public void printBrett(char[][] b){
		
		for (int i=0; i<b[1].length;i++){
			System.out.print('|');
			System.out.print(b[i]);
			System.out.print('|');
			System.out.print("\n");
		}
	}
	
	
	
	
	public static void main(String[] args){
	
	Slagskip ny = new Slagskip();
	
	
	while (!ny.isFinished(ny.count)){
//		Scanner scan = new Scanner(System.in);
//		String in = scan.next();
//		ny.getInput(in);
//		int i=scan.nextInt();
		

	}
	
//	ny.getInput("03");
//	ny.getInput("12");	
//	ny.getInput("04");
//	ny.getInput("00");
//	ny.getInput("13");	
//	ny.getInput("01");
//	ny.getInput("14");
//	ny.getInput("14");	
//	ny.getInput("17");
//	ny.getInput("08");
//	ny.getInput("18");	
//	ny.getInput("20");
//	ny.getInput("19");
//	ny.getInput("33");	
//	ny.getInput("23");
//	ny.getInput("54");
//	ny.getInput("24");
//	ny.getInput("66");	
//	ny.getInput("51");
//	ny.getInput("99");
//	ny.getInput("61");	
//	ny.getInput("46");
//	ny.getInput("65");
//	ny.getInput("75");
//	ny.getInput("66");	
//	ny.getInput("76");
//	ny.getInput("67");
//	ny.getInput("59");	
//	ny.getInput("71");
//	ny.getInput("80");
//	ny.getInput("81");	
//	ny.getInput("33");
//	ny.getInput("84");
//	ny.getInput("84");
//	ny.getInput("85");	
//	ny.getInput("85");
	
	}
	
	
	
	
}
