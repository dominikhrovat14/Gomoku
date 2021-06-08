package logika;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import graficni.Frame;
import graficni.Panel;
import splosno.Koordinati;

public class Igra {
	
	/*
	public static char[][] board;
	public static int dim;
	public static Set<Koordinati> moznePoteze;
	public final static char PRAZNO = '.';
	public static Igra igra;
	public static char zmagovalec;
	*/
	
	public  char[][] board;
	public  int dim;
	public Set<Koordinati> moznePoteze;
	public static final  char PRAZNO = '.';
	public  Igra igra;
	public char zmagovalec;
	public int poteza ;

	char[] igralci = {'X', '0'};
	
	public static final int ZMAGA_ST = 5;
	
	public Igra(int dim) {
		
		this.poteza = 0;
		this.dim = dim;
		zmagovalec = PRAZNO;
		board = new char[dim][dim];
		moznePoteze = new HashSet<Koordinati>();
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				board[i][j] = PRAZNO;
				Koordinati k = new Koordinati(i,j);
				moznePoteze.add(k);
			}
		}
	}
	
	public Igra(Igra igra) {
		
		this.poteza = igra.poteza;
		this.dim = igra.dim;
		this.zmagovalec = PRAZNO;
		this.board = new char[dim][dim];
		
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				
				this.board[i][j] = igra.board[i][j] ;
			}
		}

		this.moznePoteze = new HashSet<Koordinati>();
		this.moznePoteze.addAll(igra.moznePoteze);

	}

	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				
				sb.append(this.board[i][j]);
			}
			sb.append("\n");
		}
		
		return sb.toString();

	}
	
	public void nastaviIgralce(char[] igralci) {
		
		this.igralci = igralci;
	}
	
	public Igra() {
		this(15);
		
	}
	
	public char naPotezi() {
		
		return igralci[this.poteza%2];
	}
	
	
	public  void zacni () {
		igra = new Igra ();
	}
	
	public  boolean odigrajPotezo(Koordinati k) {
		if ( this.moznePoteze.contains(k)) {
			
			this.moznePoteze.remove(k);
			 
			this.board[k.getX()][k.getY()] = naPotezi() ;

			/*
			if (this.poteza % 2 == 0) {
				 this.board[k.getX()][k.getY()] = 'X' ;
			}
			else { 
				this.board[k.getX()][k.getY()] = 'O';
			}
			*/
			
			
			this.poteza++;
			
			return true;
		}
		return false;
	}
	
	public  char preveriZmago(Koordinati k) {
		
		// 		java.util.List<Character> polja = Arrays.asList(ZmagaVrstica(k), ZmagaStolpec(k), ZmagaDiagonala(k)); 
		java.util.List<Character> polja = Arrays.asList(ZmagaVrstica(), ZmagaStolpec(), ZmagaDiagonala()); 
		for (Character i : polja) {
			if (!i.equals( this.PRAZNO)) {
				igra.zmagovalec = i;
				System.out.println(igra.zmagovalec);
				return igra.zmagovalec;
			}
		}
		
		
		if(moznePoteze.size() == 0) {
			
			return  'N';
		}
		else {

			return  this.PRAZNO;			
		}
		
	}
	
	public  Koordinati racunalnikPoteza() {
		Set<Koordinati> moznePoteze = igra.moznePoteze;
		int size = moznePoteze.size();
		int j = new Random().nextInt(size);
		int i = 0;
		Koordinati poteza = null; //na nekaj nastavimo
		for(Koordinati k : moznePoteze)
		{
			if (i == j) {
				poteza = k;
				return poteza;

				
			}
				
			i++;
		}
		igra.odigrajPotezo(poteza);
		return poteza;

	}
	// to je zmaga stolpec?
	
	public char ZmagaVrstica() {
	
		char zmagovalec = this.PRAZNO;
		
		
		for (int i = 0; i < dim; i++) {
		
			int zaporednih = 0;
			char trenutni = this.PRAZNO;
			
			for (int j = 0; j < dim; j++) {
				
				if(this.board[i][j] == this.PRAZNO) {
		
					zaporednih = 0;
					trenutni = this.PRAZNO;
				}
				else if(this.board[i][j] == trenutni) {
					
					zaporednih++;
				}
				else {
					
					trenutni = this.board[i][j];
					zaporednih = 1;
				}
				
				
				if(zaporednih == ZMAGA_ST) {
					
					zmagovalec = trenutni;
					return zmagovalec;
				}
			}
		}		
		return  zmagovalec;
	}
	public char ZmagaStolpec() {
	
		
		char zmagovalec = this.PRAZNO;
		
		for (int j = 0; j < dim; j++) {

		
			int zaporednih = 0;
			char trenutni = this.PRAZNO;
			for (int i = 0; i < dim; i++) {

				
				if(this.board[i][j] == this.PRAZNO) {
		
					zaporednih = 0;
					trenutni = this.PRAZNO;
				}
				else if(this.board[i][j] == trenutni) {
					
					zaporednih++;
				}
				else {
					
					trenutni = this.board[i][j];
					zaporednih = 1;
				}
				
				
				if(zaporednih == ZMAGA_ST) {
					
					zmagovalec = trenutni;
					return zmagovalec;
				}
			}
		}		
		return  zmagovalec;
	}
	public char ZmagaDiagonala() {
		
		char zmagovalec = this.PRAZNO;

		int limit = dim - ZMAGA_ST + 1;
		int start = ZMAGA_ST - 1;
		
		for(int i = 0; i < limit; i++) {
			
			for(int j = 0; j < dim; j++) {
				
			
				if(this.board[i][j] != this.PRAZNO) {

					if(j >= start ) {
						
						char trenutni = this.board[i][j];
						boolean ujemanje = true;
						
						for(int k = 1; k < ZMAGA_ST; k++) {
							
							if(this.board[i+k][j-k] != trenutni) {
								
								ujemanje = false;
							}
						}
						
						if(ujemanje) {
							
							zmagovalec = trenutni;
							return zmagovalec;
						}
						
					}
					if(j  < limit ) {
						
						char trenutni = this.board[i][j];
						boolean ujemanje = true;

						for(int k = 1; k < ZMAGA_ST; k++) {
							
							if(this.board[i+k][j+k] != trenutni) {
								
								ujemanje = false;
							}
						}
						
						if(ujemanje) {
							
							zmagovalec = trenutni;
							return zmagovalec;
						}
					}
					
				}
			}
		}

		return  zmagovalec;
	}

	
	public char ZmagaVrstica(Koordinati k) {
		int i = 0;
		for (char c :  this.board[k.getX()]) {
			if (c == 'X') {
				i++;
				if (i >= 5) {
					return 'X';
				}
			}
			else {
				i = 0;
			}
		}
		return  this.PRAZNO;
	}
	
	public char ZmagaStolpec(Koordinati k) {
		int j = 0;
		for (int i = 0; i<  this.dim; i++) {
			if ( this.board[i][k.getY()] == 'X') {
				j++;
				if (j >= 5) {
					return 'X';
				}
			}
			else {
				j = 0;
			}
		}
		return  this.PRAZNO;
	}
	public char ZmagaDiagonala(Koordinati k) {
		return this.PRAZNO;
		/*int j = 0;
		int zacetek = Math.min(k.getX(),k.getY());
		int konec = dim - Math.max(k.getX(),k.getY()) + 1;
		for (int i = zacetek; i< konec; i++) {
			if (board[k.getX() - i][k.getY() - i] == 'X') {
				j++;
				if (j >= 4) {
					return 'X';
				}
			}
			else {
				j = 0;
			}
		}
		return PRAZNO;   */
	}
	
	
	

}
