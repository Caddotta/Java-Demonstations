 package assignment_8;

public class fractions {

	private int numerator;
	private int denominator;
	
	public fractions (int n, int d) {
		if (d == 0) {
			throw new ArithmeticException();
		} else {
		this.numerator = n;
		this.denominator = d;
		}
	}	
	public int getNum() {
		return numerator;
	}
	public int getDenom() {
		return denominator;
	}
	public void setNum(int n) {
		this.numerator = n;
	}
	public void setDenom(int d) {
		if (d == 0) {
			throw new ArithmeticException();
		} else {
		this.denominator = d;
		}
	}
	public boolean equals (fractions a) {
		return (this.numerator * a.getDenom() == this.denominator * a.getNum());
	}
	public String toString() {
		return numerator +"/"+ denominator;
	}
	public fractions add(fractions a) {
		int numerator = (this.numerator * a.getDenom() + denominator * a.getNum());
		int denominator = (this.denominator * a.getDenom());
		int gcd = findgcd(numerator, denominator);
		int n = numerator / gcd;
		int d = denominator / gcd;
		fractions converted = new fractions(n, d);
		return converted;
	}
	public static int findgcd(int a, int b) {
		if (a == 0) {
			return b;
		}
			return findgcd(b % a, a);
		}
}
