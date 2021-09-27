package assignment_8;

public class carmain {
	public static void main (String []args) {
		car oldJunker = new car("Ford", "Pinto", 1972, 17.5, 12,8);
		oldJunker.drive(5);
		oldJunker.fillTank(1);
		System.out.println(oldJunker.toString());
	}
}
