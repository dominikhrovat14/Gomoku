package inteligenca;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import logika.Igra;

import splosno.Koordinati;

import inteligenca.OceniPozicijo;

public class Minimax extends Inteligenca{
	
	private static final int ZMAGA = Integer.MAX_VALUE; // vrednost zmage
	private static final int PORAZ = -ZMAGA;  // vrednost izgube
	private static final int REMI = 0;  // vrednost neodloÄ�ene igre	
	
	private int globina;
	
	public Minimax (int globina) {
		super("minimax globina " + globina);
		this.globina = globina;
	}

	public Koordinati izberiPotezo (Igra igra) {
		OcenjenaPoteza najboljsaPoteza = minimax(igra, this.globina, igra.naPotezi());
		return najboljsaPoteza.poteza;	
	}
	
	// vrne najboljso ocenjeno potezo z vidike igralca jaz
	public OcenjenaPoteza minimax(Igra igra, int globina, char jaz) {
		OcenjenaPoteza najboljsaPoteza = null;
		List<Koordinati> moznePoteze = igra.moznePoteze;
		for (Koordinati p: moznePoteze) {
			Igra kopijaIgre = new Igra(igra);
			kopijaIgre.odigrajPotezo(p);
			int ocena;
			if (kopijaIgre.preveriZmago() == jaz) {
				ocena = ZMAGA;
				break;}
			else if (kopijaIgre.preveriZmago() == OceniPozicijo.nasprotnik(jaz)) {
				ocena = PORAZ;
				break;}
			else if (moznePoteze.size() == 0) {
				ocena = REMI;
				break;}
				// nekdo je na potezi
				if (globina == 1) ocena = OceniPozicijo.oceniPozicijo(kopijaIgre, jaz);
				// globina > 1
				else ocena = minimax(kopijaIgre, globina-1, jaz).ocena;	
			if (najboljsaPoteza == null 
					// max, èe je p moja poteza
					|| jaz == igra.naPotezi() && ocena > najboljsaPoteza.ocena
					// sicer min 
					|| jaz != igra.naPotezi() && ocena < najboljsaPoteza.ocena)
				najboljsaPoteza = new OcenjenaPoteza(p, ocena);		
		}
		return najboljsaPoteza;
	}
}
