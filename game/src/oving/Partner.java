package oving;

public class Partner {

	public String navn;
	public Partner partner; 
	
	public Partner(String navn){
		this.navn = navn;
	}
	
	public String getName(){
		return navn;
	}
	
	public Partner getPartner(){
		return partner;
	}
	
	public void setPartner(Partner partner){
		
		if(partner==null){ 							//sjekk om partner skal slettes
			if(this.getPartner()!=null){			//sjekk om vedkommende har partner
				Partner oldP = this.partner;
				this.partner = null;				
				oldP.setPartner(null);
			}
			else{
				this.partner = null;
			}
		}
		else{
			if(this.partner != null){
				if(this==this.partner.getPartner() && (this.getPartner() != partner)){
					Partner noP = this.partner;
					this.partner=null;
					noP.setPartner(null);
					
					Partner newP = partner;
					partner.setPartner(this);
					this.setPartner(newP);
				}

			}
			else{
				this.partner = partner;
				partner.setPartner(this);
			}
		}
		

		
	}
	public String toString(){
		return navn;
	}
	
	public static void main(String[] args){
		Partner Lars = new Partner("Lars");
		Partner Kari = new Partner("Kari");
		Partner Petter = new Partner("Petter");
		Partner Mari = new Partner("Mari");
		
		System.out.println("Start");
		System.out.println("Lars sin partner er " + Lars.getPartner());
		System.out.println("Kari sin partner er " + Kari.getPartner());
		System.out.println("Kari blir sammen med lars");
		Lars.setPartner(Kari);
		System.out.println("Lars sin partner er " + Lars.getPartner());
		System.out.println("Kari sin partner er " + Kari.getPartner());
		System.out.println("Kari dumper lars");
		Kari.setPartner(null);
		System.out.println("Lars sin partner er " + Lars.getPartner());
		System.out.println("Kari sin partner er " + Kari.getPartner());
		System.out.println("Kari blir sammen med lars");
		Kari.setPartner(Lars);
		System.out.println("Lars sin partner er " + Lars.getPartner());
		System.out.println("Kari sin partner er " + Kari.getPartner());
		System.out.println("Kari blir sammen med Petter og dumper Lars");
		Petter.setPartner(Mari);
		Kari.setPartner(Petter);
		System.out.println("Lars sin partner er " + Lars.getPartner());
		System.out.println("Kari sin partner er " + Kari.getPartner());
		System.out.println("Petter sin partner er " + Petter.getPartner());
		
	}
	
}
