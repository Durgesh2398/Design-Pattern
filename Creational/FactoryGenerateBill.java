package Creational;
import java.util.*;
import java.io.*;

abstract class Plan{
	protected double rate;
	abstract void getRate();
	public void calculateBill(int units){
		System.out.println(units*rate);
	}
}

class DomesticPlan extends Plan{
	@Override
	void getRate() {
		// TODO Auto-generated method stub
		rate=3.50;
	}
}
class CommrcialPlan extends Plan{
	@Override
	void getRate() {
		// TODO Auto-generated method stub
		rate=7.50;
	}
}
class InstitutionalPlan extends Plan{
	@Override
	void getRate() {
		// TODO Auto-generated method stub
		rate=5.50;
	}
}

class GetPlanFactory{
	public Plan getPlan(String planType) {
		if(planType==null) {
			return null;
		}
		if(planType.equalsIgnoreCase("DOMESTICPLAN")) {
			return new DomesticPlan();
		}
		else if(planType.equalsIgnoreCase("COMMERCIALPLAN")) {
			return new CommrcialPlan();
		}
		else if(planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
			return new InstitutionalPlan();
		}
		return null;
	}
}
public class FactoryGenerateBill {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		GetPlanFactory planFactory = new GetPlanFactory();
		System.out.println("enter the name of plan for which the bill will be generated");
	      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		Scanner sc=new Scanner(System.in);
		String planName=br.readLine();
		System.out.print("enter the number of units");
		int units=Integer.parseInt(br.readLine());  
		Plan p=planFactory.getPlan(planName);
		System.out.println("bill amount "+planName+" of "+units+"  units is" );
		p.getRate();
		p.calculateBill(units);

	}

}
