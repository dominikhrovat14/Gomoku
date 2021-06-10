package inteligenca;

import logika.Igra;

public class OceniPozicijo {

	// char[][] board = Igra.board;
	// static int dim = Igra.dim;
	// static int w = Igra.ZMAGA_ST;
	static int dim = 15;
	static int w = 5;
	static char jaz = 'X';
	char nasprotnik = 'O';

	public static int oceniPozicijo(Igra igra, char naPotezi) {


		return Ocenaa(igra, naPotezi);
	}

	static int Ocenaa(Igra igra, char igralec) {
		char[][] polje = igra.board;
		return Ocena(polje, igralec) - Ocena(polje, nasprotnik(igralec));
	}

	public static int Ocena(char[][] polje, char igralec) {
		return oceniDiagonalno(polje, igralec) + oceniVodoravno(polje, igralec) + oceniNavpicno(polje, igralec);
	}

	private static int oceniDiagonalno(char[][] board, char igralec) {
		return ocena1(board, igralec) + ocena2(board, igralec) + ocena3(board, igralec) /*+ ocena4(board, igralec)*/;
	}

	static int ocena1(char[][] board, char igralec) {
		int ocena = 0;
		// prvo pogledamo vse diagonale, zaènemo pri diagonalah, ki se zaènejp na levi
		// strani in gredo do zgornje stranice.
		// gremo èez vse vrstice od w-te vrstice naprej.
		// zadnje vrstice ne pogleda, ker jo bo naslednja
		for (int i = w - 1; i < dim - 1; i++) {
			// pri vsaki diagonali se zacnemo premikati gor desno
			for (int j = 0; j <= i - w + 1; j++) {
				int tocke = 0;
				// gledamo vsa zaporedja dolžine w
				for (int k = j; k < j + w; k++) {
					// ce je moj znak v board, se vrednost poveca za 1
					int x = i - k;
					int y = k;
					if (board[x][y] == igralec)
						tocke++;

					else if (board[x][y] == nasprotnik(igralec)) {
						// ce se pojavi char od nasprotnika, ima podseznam vrednost 0
						tocke = 0;
						break;
					}
				}
				ocena += tocke*tocke;
			}
		}
		return ocena;
	}
	

	static int ocena2(char[][] board, char igralec) {
		int ocena = 0;
		// pogledamo še diagonale, ki se zaènejo spodaj in konèajo na desnem robu.
		for (int i = 0; i <= dim - w; i++) {
			// pri vsaki diagonali se zacnemo premikati gor desno
			// zaènemo po vseh j, pri katerih ne pridemo èez meje polja
			for (int j = 0; j <= dim - w - i; j++) {
				int tocke = 0;
				// gledamo vsa zaporedja dolžine w
				for (int k = j; k < j + w; k++) {
					// ce je moj znak v board, se vrednost poveca za 1
					int x = dim - k - 1;
					int y = i + k;
					if (board[x][y] == igralec)
						tocke++;

					else if (board[x][y] == nasprotnik(igralec)) {
						// ce se pojavi char od nasprotnika, ima podseznam vrednost 0
						tocke = 0;
						break;
					}
				}
				ocena += tocke*tocke;
			}
		}
		return ocena;
	}

	static int ocena3(char[][] board, char igralec) {
		int ocena = 0;
		// pogledamo še diagonale, ki se zaènejo spodaj in konèajo na levem robu.
		for (int i = w - 1; i < dim; i++) {
			// pri vsaki diagonali se zacnemo premikati gor desno
			// zaènemo po vseh j, pri katerih ne pridemo èez meje polja
			for (int j = 0; j <= i - w + 1; j++) {
				int tocke = 0;
				// gledamo vsa podzaporedja dolžine w
				for (int k = j; k < j + w; k++) {
					// ce je moj znak v board, se vrednost poveca za 1
					int x = dim - k - 1;
					int y = i - k;
					if (board[x][y] == igralec) {
						tocke++;
						}
					else if (board[x][y] == nasprotnik(igralec)) {
						// ce se pojavi char od nasprotnika, ima podseznam vrednost 0
						tocke = 0;
						break;
					}
				}
				ocena += tocke*tocke;
			}
		}
		return ocena;
	}

	static int ocena4(char[][] board, char igralec) {
		int ocena = 0;
		// pogledamo še diagonale, ki se zaènejo zgoraj in konèajo na desnem robu.
		// prve vrstice ne preveri, ker jo bo preverila prejsnja
		for (int i = 1; i <= dim - w; i++) {
			// pri vsaki diagonali se zacnemo premikati gor desno
			// zaènemo po vseh j, pri katerih ne pridemo èez meje polja
			for (int j = 0; j <= dim - w - i; j++) {
				int tocke = 0;
				// gledamo vsa zaporedja dolžine w
				for (int k = j; k < j + w; k++) {
					int x = k;
					int y = i + k;
					// ce je moj znak v board, se vrednost poveca za 1
					if (board[x][y] == igralec)
						tocke++;

					else if (board[x][y] == nasprotnik(igralec)) {
						// ce se pojavi char od nasprotnika, ima podseznam vrednost 0
						tocke = 0;
						break;
					}

				}
				ocena += tocke*tocke;
			}
		}
		return ocena;
	}

	static int oceniVodoravno(char[][] board, char igralec) {
		int ocena = 0;
		for (int i = 0; i < dim; i++) {
			// po vseh vrsticah
			for (int j = 0; j <= dim - w; j++) {
				// gledamo vse podsezname dolžine zmaga_st. In racunamo
				// vrednost vsakega.
				int tocke = 0;
				for (int k = j; k < j + w; k++) {
					// ce je moj znak v board, se vrednost poveca za 1
					if (board[i][k] == igralec)
						tocke++;

					else if (board[i][k] == nasprotnik(igralec)) {
						// ce se pojavi char od nasprotnika, ima podseznam vrednost 0
						tocke = 0;
						break;
					}
				}
				ocena += tocke*tocke;
			}
		}
		return ocena;
	}

	public static void s(String a) {
		System.out.print(a);
	}

	public static void sln(String a) {
		System.out.println(a);
	}

	public static void i(int a) {
		System.out.print(a);
	}

	public static void iln(int a) {
		System.out.println(a);
	}

	private static int oceniNavpicno(char[][] board, char igralec) {
		// enako kot vodoravno, le da menjamo indekse
		int ocena = 0;
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j <= dim - w; j++) {
				int tocke = 0;
				for (int k = j; k < j + w; k++) {
					if (board[k][i] == igralec)
						tocke++;
					else if (board[k][i] == nasprotnik(igralec)) {
						tocke = 0;
						break;
					}
				}
				ocena += tocke*tocke;
			}
		}
		return ocena;
	}

	public static char nasprotnik(char igralec) {
		if (igralec == 'X')
			return 'O';
		else
			return 'X';
	}
}

/*s("board "); 
i(x);
s(" , ");
i(y);
s(" tocke: ");
iln(tocke);*/
