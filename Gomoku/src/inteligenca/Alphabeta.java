package inteligenca;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import logika.Igra;

import splosno.Koordinati;

import inteligenca.OceniPozicijo;

public class Alphabeta extends Inteligenca {
	
	private static final int ZMAGA = Integer.MAX_VALUE; // vrednost zmage
	private static final int PORAZ = -ZMAGA;  // vrednost izgube
	private static final int REMI = 0;  // vrednost neodločene igre	
	
	private int globina;
	
	public Alphabeta (int globina) {
		super("alphabeta globina " + globina);
		this.globina = globina;
	}
	
	@Override
	public Koordinati izberiPotezo (Igra igra) {
		// Na zaÄ�etku alpha = PORAZ in beta = ZMAGA
		
		return alphabetaPoteze(igra, this.globina, PORAZ, ZMAGA, igra.naPotezi()).poteza;
	}
	
	public static OcenjenaPoteza alphabetaPoteze(Igra igra, int globina, int alpha, int beta, char jaz) {
		int ocena;
		if (igra.naPotezi() == jaz) {ocena = PORAZ;} else {ocena = ZMAGA;}
		List<Koordinati> poteze = igra.moznePoteze;
		Koordinati kandidat = poteze.get(0);
		for (Koordinati p: poteze) {
			Igra kopijaIgre = new Igra(igra);
			kopijaIgre.odigrajPotezo(p);
			int ocenap;
			if (kopijaIgre.preveriZmago() == jaz) {
				ocenap = ZMAGA;
				break;}
			else if (kopijaIgre.preveriZmago() == OceniPozicijo.nasprotnik(jaz)) {
				ocenap = PORAZ;
				break;}
			else if (poteze.size() == 0) {
				ocenap = REMI;
				break;}
				// nekdo je na potezi
				if (globina == 1) { ocenap = OceniPozicijo.oceniPozicijo(kopijaIgre, jaz);
				}
				else {
					ocenap = alphabetaPoteze (kopijaIgre, globina-1, alpha, beta, jaz).ocena;
				System.out.println(ocenap + " "+ ocena);
				
				
				}
			if (igra.naPotezi() == jaz) { // Maksimiramo oceno
				if (ocenap > ocena) { // mora biti > namesto >=
					ocena = ocenap;
					kandidat = p;
					alpha = Math.max(alpha,ocena);
				}
			} else { // igra.naPotezi() != jaz, torej minimiziramo oceno
				if (ocenap < ocena) { // mora biti < namesto <=
					ocena = ocenap;
					kandidat = p;
					beta = Math.min(beta, ocena);					
				}	
			}
			if (alpha >= beta) // Izstopimo iz "for loop", saj ostale poteze ne pomagajo
				return new OcenjenaPoteza (kandidat, ocena);
		}
		return new OcenjenaPoteza (kandidat, ocena);
	}

	public static Koordinati prvi(Set<Koordinati> mn) {
		Koordinati j = new Koordinati(0,0);
		for (Koordinati k : mn) {
			j=k;
			break;
		}
		return j;
		
	}
	
}