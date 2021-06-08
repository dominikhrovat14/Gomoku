package test;

import logika.Igra;
import splosno.Koordinati;

public class TestDiagonale {
	
	public static final  char PRAZNO = '.';

	public static void main(String[] args) {

		Igra igra = new Igra();
		igra.zacni();

		System.out.println(igra);
		
		
		System.out.println(igra.ZmagaStolpec());
		
		int dim = 15;
		
		int ZMAGA_ST = 5;
		
		int[][] numbers = new int[dim][dim];
		
		int counter = 0;
		
		for(int i = 0; i < dim; i++) {
			
			for(int j = 0; j < dim; j++) {
				
				
				numbers[i][j] = (i+j)%10;
			}
		}
		
		System.out.println(output(numbers, dim));

		int limit = dim - ZMAGA_ST + 1;
		int start = ZMAGA_ST - 1;
		
		for(int i = 0; i < limit; i++) {
			
			for(int j = 0; j < dim; j++) {
				
					if(j  >= start ) {
				
						String a = "";
						for(int k = 0; k < ZMAGA_ST; k++) {
							
							a = a+""+numbers[i+k][j-k];
						}
						
						System.out.println("a  "+a);
					}
					
										
					if(j  < limit ) {
 
						String b = "";
						for(int k = 0; k < ZMAGA_ST; k++) {
							
							b = b+""+numbers[i+k][j+k];
						}
						System.out.println("b  "+b);
					}
					


				
				//if((j+ ZMAGA_ST) <= )
				
			}
		}
		
		//System.out.println(limit);
		
	}
	
	
	
	public static String output(int[][] numbers, int dim) {
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				
				sb.append(numbers[i][j]);
			}
			sb.append("\n");
		}
		
		return sb.toString();

	}

}
