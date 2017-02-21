package stateandbehavior;

public class Account {
	
	private double balance;
	
	//Set balance to 0.00
	public Account() {
		balance = 0.0;
	}
	
	public double interestRate = 0.07;
	
	//Deposit
	public void deposit(double amount) {
		if(amount>=0){
			balance = balance + amount;
			
		}
		else {
			System.err.println("Deposit amount can not be negative");
		}
	}
	
	//Add interest
	public void addInterest() {
		balance= balance * (1+interestRate);
	}
	
	//Get balance
	public double getBalance(){
		return balance;
	}
	
	//Get interestRate
	public double getInterestRate() {
		return interestRate;
	}
	
	//set new interestRate
	public void setInterestRate(double rate){
		interestRate = rate;
	}
	public String toString(){
		return "Balance= " + getBalance() + " , interest= "+getInterestRate();
	}
	public static void main(String[] args){
		Account jonas = new Account();
		jonas.deposit(100);
		System.out.println(jonas);
		jonas.addInterest();
		System.out.println(jonas);
		jonas.setInterestRate(0.09);
		System.out.println(jonas);
	}
	
}
