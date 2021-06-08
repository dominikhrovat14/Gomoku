package logika;

import java.util.List;
import java.util.Set;


import splosno.Koordinati;

public class Minimax {
	
	private static final int ZMAGA = Integer.MAX_VALUE;
	private static final int NEODLOC = 0;
	
	public static  List<OcenjenaPoteza>  minimax(Igra igra, int globina) {
		
		NajboljseOcenjenePoteze najboljsePoteze = new NajboljseOcenjenePoteze();
		Koordinati najboljsaPoteza = null;
		Set<Koordinati> moznePoteze = igra.moznePoteze;
		for (Koordinati p : moznePoteze) {
			
			Igra kopijaIgre = new Igra(igra);
			kopijaIgre.odigrajPotezo (p);
			
			int ocena = 0;
			if (kopijaIgre.preveriZmago(p) == 'O' || kopijaIgre.preveriZmago(p) == 'X') {
				
				ocena = ZMAGA; 
			}
			else if(kopijaIgre.preveriZmago(p) == 'N' ) { // TODO neodloceno
				
				ocena = NEODLOC; 
			}
			else {
				
				if (globina==1) {
					
					
					ocena = OceniPozicijo.oceniPozicijo(kopijaIgre, igra.naPotezi());
					
					//ocena z vidike igralca, ki je igral p
				}
				else {
					
					ocena = -minimax(kopijaIgre, globina-1).get(0).ocena;
					//negacija ocene z vidike drugega igralca
				}
			}
			
			
			najboljsePoteze.addIfBest(new OcenjenaPoteza(p, ocena));
			
			/*
			if (kopijaIgre.preveriZmago(p) == Igra.PRAZNO) continue;
			if (kopijaIgre.preveriZmago(p) == 'X') ocena += 1;
			if (kopijaIgre.preveriZmago(p) == 'O') ocena -= 1;
			
			*/
			
		}
		return najboljsePoteze.list();
		
	}

}
