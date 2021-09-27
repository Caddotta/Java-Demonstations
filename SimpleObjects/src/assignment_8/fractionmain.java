package assignment_8;

public class fractionmain {

public static void main(String []args) {
	
	fractions f1 = new fractions(1,2);
	fractions f2 = new fractions(1,4);
	fractions f3 = new fractions(2,4);
	
	System.out.println("toString Function: "+f1.toString());
	
	System.out.println("add function: "+f1.toString()+" + "+f2.toString()+" = "+f1.add(f2));
	
	System.out.println("equals function: "+f1.toString()+" = "+f3.toString()+" is: "+f1.equals(f3));
	System.out.println("equals function: "+f1.toString()+" = "+f2.toString()+" is: "+f1.equals(f2));
}
}
