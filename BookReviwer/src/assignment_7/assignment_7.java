package assignment_7;
import java.util.*;
import java.io.*;

/*
 * Collin Addotta
 * Assignment 7
 */

public class assignment_7 
{
	public static void main (String []args) 												throws FileNotFoundException {
		
		
		final int NUM_RECCOMMENDATIONS = 3; // Extra Credit Quantifier
		
		
		final String []bookNames = new String[20];
		final double [][]reviewScores = new double [30][20];
		final double []inputScores = new double [20];
		final double []similarityScore = new double[30];
		final double []weightedAverage = new double[20];
		double [] Numerator = new double[20];
		
		double[][]Product = new double [30][20];
		 
		double Denominator = 0;
		
		Get_BookNames(bookNames);
		Get_ReviewScores(reviewScores);	
		Get_InputScores(bookNames, inputScores);
		Find_SimilarityScore(reviewScores, inputScores, similarityScore);

		Find_Product(similarityScore, reviewScores, Product);
		
		WeightedAverageDenominator(similarityScore, Denominator);
		Denominator = WeightedAverageDenominator(similarityScore, Denominator);
		
		
		WeightedAverageNumerator(Product, Numerator);
		
		Find_WeightedAverage(Numerator, Denominator, weightedAverage);
		//System.out.print(Arrays.toString(weightedAverage));
		
		Reccommendation(weightedAverage, bookNames, NUM_RECCOMMENDATIONS, inputScores);
		
	}
	//Scans the text file of book names provided in the assignment and appends each line to an index in bookNames.
	public static String [] Get_BookNames(String[] bookNames) throws FileNotFoundException { 
		
		Scanner bn = new Scanner(new File("book_names.txt"));
		//String [] bookNames = new String[20];
		int i =0;
		while (bn.hasNextLine()&& i < bookNames.length) {
			bookNames [i] = bn.nextLine();
			i++;
		}
		
		return bookNames;
	}
	//Scans the text file of the review scores provided in the assignment and appends each row by each column to an index in reviewScores.
	public static double [][] Get_ReviewScores(double[][] reviewScores) 					    throws FileNotFoundException {
		Scanner rs = new Scanner(new File("ratings.txt"));
		for (int i = 0; i < 30; i++) // && rs.hasNextLine()
		{
			for (int j = 0; j < 20; j++) { // && rs.hasNextLine()
				reviewScores[i][j]=rs.nextInt();
			}
		}
		return reviewScores;
	}
	//Receives a user input after displaying the current index of the bookNames array, and appends that input to an index in inputScores.
	//Verifies that the input is valid.
	public static double[] Get_InputScores(String[] bookNames, double[] inputScores) {
		Scanner r = new Scanner(System.in);
		System.out.println("Rate the following book titles from 1-5. If you have not read a book, enter -1.");
		for (int i = 0; i < bookNames.length; i++) {
			System.out.println(bookNames[i]);
			double rate = r.nextDouble();
			if (rate > 5 || rate < -1 || rate == 0) {
				System.out.println("You entered an incorrect value. Please Retry. ");
				i--;
			}
			inputScores[i] = rate;
		}
		return inputScores;
	}
	//Uses the Cosine Similarity described during lecture. First validates both users read the book and then proceeds to perform the algorithm.
	//Returns array similarityScore
	public static double[] Find_SimilarityScore(double[][] reviewScores, double[] inputScores, double []similarityScore) 	throws FileNotFoundException {
		
		for (int i =0; i<30; i++) 
		{
			double valueUser = 0, valueInput = 0;
			double newvUser = 0, newvInput = 0;
			double p1 = 0, p2 = 0, both = 0;
			for (int j = 0; j<20; j++) {
				valueUser = reviewScores[i][j];
				valueInput= inputScores[j];
				if (valueUser != -1 && valueInput != -1) {
					both += valueUser * valueInput;
				}
				if (valueUser != -1) {
					newvUser += Math.pow(valueUser, 2);
				}
				if (valueInput != -1) {
					newvInput += Math.pow(valueInput, 2);
				}
			}
			p1 = Math.sqrt(newvUser);
			p2 = Math.sqrt(newvInput);
			similarityScore[i] = (both / (p1*p2));
		}
		return similarityScore;
	}
	
	//This function multiplies the value within array similarityScore to the rating of that particular user.
	public static double[][] Find_Product(double[]similarityScore, double[][] reviewsScores, double[][]Product){
		
		for (int i=0; i<reviewsScores.length; i++) {
			for (int j=0; j<reviewsScores[i].length; j++)
			{
				if (reviewsScores[i][j] != -1) {
					Product[i][j]+=reviewsScores[i][j]*similarityScore[i];
				}
			}
		}
		return Product;
	}
	//This function determines the denominator for the weighted average formula by adding all values of the similarityScore array.
	
	public static double WeightedAverageDenominator(double[]similarityScore, double Denominator) {
		for (int i=0; i<30; i++) {
			Denominator+=similarityScore[i];
		}
		return Denominator;
}
	//This function determines the numerator for the weighted average formula by performing a for loop for each column and assessing it to an
	//array Numerator. This provides a list of the sum for each value of Weight * Rating.

	public static double[] WeightedAverageNumerator(double[][] Product, double[]Numerator) {
		
		double x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][0];
			}
		Numerator[0]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][1];
			}
		Numerator[1]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][2];
			}
		Numerator[2]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][3];
			}
		Numerator[3]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][4];
			}
		Numerator[4]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][5];
			}
		
		Numerator[5]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][6];
			}
		
		Numerator[6]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][7];
			}
		Numerator[7]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][8];
			}
		Numerator[8]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][9];
			}
		Numerator[9]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][10];
			}
		Numerator[10]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][11];
			}
		Numerator[11]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][12];
			}
		Numerator[12]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][13];
			}
		Numerator[13]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][14];
			}
		Numerator[14]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][15];
			}
		Numerator[15]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][16];
			}
		Numerator[16]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][17];
			}
		Numerator[17]=x;
		x = 0;
		for (int i=0; i<30; i++) {		
			x += Product[i][18];
			}
		Numerator[18]=x;
		x = 0;
		for (int i=0; i<30; i++) {
			x += Product[i][19];
			}
		Numerator[19]=x;
		x = 0;
		
		return Numerator;
	}
	//This compiles the returned Numerator and returned Denominator to assess the weighted average of each book.

	public static double[] Find_WeightedAverage(double[] Numerator, double Denominator, double []weightedAverage) {
		for (int i = 0; i<20; i++) {
			weightedAverage[i] = (Numerator[i]/Denominator);
		}
		return weightedAverage;
	}
	//This creates a copy for the weighted average index, a copy for the input scores index, and a copy of the book names.
	//CopyWeightedAverage is sorted in descending order, and the indices of Book Names and Input scores are assigned the same
	//index value as the sorted CopyWeightedAverage.
	//A final index, st, stores the necessary data of every book, and then through an if statement, it is assessed if the user
	//has not read the current book in the st array. If user has not read a book, the value of array st for that iterance is printed,
	//and a counter is deduced with respect to NUM_RECCOMMENDATIONS. If the quanity of books needed has been found, the loop breaks.
	public static void Reccommendation(double[] weightedAverage, String[] bookNames, int NUM_RECCOMMENDATIONS, double[] inputScores)
	{
		double []CopyWeightedAverage = new double[weightedAverage.length];
		double []CopyInputScores = new double[inputScores.length];
		String []CopyBookNames = new String[bookNames.length];
		
		for (int i=0; i<weightedAverage.length; i++) {
			CopyWeightedAverage[i]=weightedAverage[i];
			CopyInputScores[i]=inputScores[i];
			CopyBookNames[i]=bookNames[i];
		}
		
		double temp = 0;
		String temp2 = "";
		double temp3 = 0;
		
		for (int i=0; i<CopyWeightedAverage.length; i++) {
			for (int j= i+1; j<CopyWeightedAverage.length; j++) {
				if(CopyWeightedAverage[i] < CopyWeightedAverage[j]) {
					temp = CopyWeightedAverage[i];
					temp2 = CopyBookNames[i];
					temp3= CopyInputScores[i];
					
					CopyWeightedAverage[i] = CopyWeightedAverage[j];
					CopyBookNames[i] = CopyBookNames[j];
					CopyInputScores[i] = CopyInputScores[j];
					
					CopyWeightedAverage[j] = temp;
					CopyBookNames[j] = temp2;
					CopyInputScores[j] = temp3;
				}
			}
		}
		String [] st = new String [CopyWeightedAverage.length];
		System.out.println("\n\nThe top "+NUM_RECCOMMENDATIONS+" new books for you are: \n");
		for (int i=0; i<CopyWeightedAverage.length; i++) {
			st[i] = (CopyBookNames[i]+". A reccommended score of "+CopyWeightedAverage[i]+"\n");
		}
		int COUNT = NUM_RECCOMMENDATIONS;
		for (int i=0; i<st.length; i++) {
			if (CopyInputScores[i]==-1) {
				System.out.println(st[i]);
				COUNT--;
				if (COUNT == 0){
					break;
				}
			}
		}
	return;
	}
			
}
