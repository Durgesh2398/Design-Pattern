package Creational;
import java.util.*;
import java.io.*;

interface Bank{
	String getBankName();
}

class HDFC implements Bank{
	private final String BNAME;
	public HDFC() {
		BNAME="HDFC BANK";
	}
	@Override
	public String getBankName() {
		// TODO Auto-generated method stub
		return BNAME;
	}
}

class ICICI implements Bank{
	private final String BNAME;
	public ICICI() {
		BNAME="ICICI BANK";
	}@Override
	public String getBankName() {
		// TODO Auto-generated method stub
		return BNAME;
	}
}

class SBI implements Bank{
	private final String BNAME;
	public SBI() {
		BNAME="SBI BANK";
	}
	@Override
	public String getBankName() {
		// TODO Auto-generated method stub
		return BNAME;
	}
}

abstract class Loan{
	protected double rate;
	abstract void getIntersetRate(double rate);
	public void calculateLoanPayement(double loanamount,int years) {
		double EMI;
		int n;
		n=years*12;
		rate=rate/1200;
		EMI=((rate*Math.pow((1+rate), n))/((Math.pow((1+rate), n))-1))*loanamount;
		System.out.println("yours monthly EMI is " + EMI+" for the amount "+loanamount+" you have borrowed");
	}
}

class HomeLoan extends Loan{
	@Override
	void getIntersetRate(double r) {
		// TODO Auto-generated method stub
		rate=r;
	}
}

class BussinessLoan extends Loan{
	@Override
	void getIntersetRate(double r) {
		// TODO Auto-generated method stub
		rate =r;
	}
}

class EducationLoan extends Loan{
	@Override
	void getIntersetRate(double r) {
		// TODO Auto-generated method stub
		rate =r;
	}
}

abstract class AbstractFactory{
	public abstract Bank getBank(String bank);
	public abstract Loan getLoan(String loan);
}

class BankFactory extends AbstractFactory{
	@Override
	public Bank getBank(String bank) {
		// TODO Auto-generated method stub
		if(bank==null) {
			return null;
		}
		if(bank.equalsIgnoreCase("HDFC")) {
			return new HDFC();
		}
		else if(bank.equalsIgnoreCase("ICICI")) {
			return new ICICI();
		}
		else if(bank.equalsIgnoreCase("SBI")) {
			return new SBI();
		}
		return null;
	}
	@Override
	public Loan getLoan(String loan) {
		// TODO Auto-generated method stub
		return null;
	}
}

class LoanFactory extends AbstractFactory{
	@Override
	public Bank getBank(String bank) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Loan getLoan(String loan) {
		// TODO Auto-generated method stub
		if(loan == null){  
	         return null;  
	    }  
	    if(loan.equalsIgnoreCase("Home")){  
	         return new HomeLoan();  
	    } 
	    else if(loan.equalsIgnoreCase("Business")){  
	         return new BussinessLoan();  
	    }
	    else if(loan.equalsIgnoreCase("Education")){  
	         return new EducationLoan();  
	    }
		return null;
	}	
}

class FactoryCreator{
	public static AbstractFactory getFactory(String choice) {
		if(choice.equalsIgnoreCase("Bank")){  
	         return new BankFactory();  
	    } 
		else if(choice.equalsIgnoreCase("Loan")){  
	         return new LoanFactory();  
	    }  
	    return null;
	}
}

public class AbstractFactoryBank {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the bsnk name from where you want to take loan amount");
		String bankName=sc.next();
		System.out.println("Enter the type of loan eg home loan or business loan or education loan");
		String loanName=sc.next();
		AbstractFactory bankFactory=FactoryCreator.getFactory("Bank");
		Bank b= bankFactory.getBank(bankName);
		System.out.println("enter teh interest rate for"+b.getBankName()+" :");
		double rate=Double.parseDouble(sc.next());
		System.out.println("Enter the loan amount you want to take");
		double loanAmount=Double.parseDouble(sc.next());
		System.out.println("Enter the number of years to pay your entier loan amount");
		int years=Integer.parseInt(sc.next());
		System.out.println("You are taking the loan "+b.getBankName());
		AbstractFactory loanFactory = FactoryCreator.getFactory("Loan");  
        Loan l=loanFactory.getLoan(loanName);  
        l.getIntersetRate(rate);  
        l.calculateLoanPayement(loanAmount,years);
	}
}
