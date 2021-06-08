package test;

import logika.Igra;
import splosno.Koordinati;

public class TestCounting {
	
	public static final  char PRAZNO = '.';

	public static void main(String[] args) {

		Igra igra = new Igra();
		igra.zacni();
		
/*
		igra.board[0][0] = 'X';
		igra.board[1][1] = 'X';
		igra.board[2][2] = 'X';
		igra.board[3][3] = 'X';
		igra.board[4][4] = 'X';


		
		igra.board[igra.dim-1][igra.dim-1] = 'X';
		igra.board[igra.dim-2][igra.dim-2] = 'X';
		igra.board[igra.dim-3][igra.dim-3] = 'X';
		igra.board[igra.dim-4][igra.dim-4] = 'X';
		igra.board[igra.dim-5][igra.dim-5] = 'X';

		
		
		igra.board[0][4] = 'X';
		igra.board[1][3] = 'X';
		igra.board[2][2] = 'X';
		igra.board[3][1] = 'X';
		igra.board[4][0] = 'X';

		*/		

		
		igra.board[igra.dim-1][igra.dim-5] = 'O';
		igra.board[igra.dim-2][igra.dim-4] = 'O';
		igra.board[igra.dim-3][igra.dim-3] = 'O';
		igra.board[igra.dim-4][igra.dim-2] = 'O';
		igra.board[igra.dim-5][igra.dim-1] = 'O';

		
		System.out.println(igra);
				
		System.out.println(igra.ZmagaDiagonala());
		
		System.out.println(igra.preveriZmago(null));

		

	}
}
