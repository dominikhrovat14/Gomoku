package test;

import java.util.Set;

import logika.Igra;
import splosno.Koordinati;

public class TestIgra {

	public static void main(String[] args) {

		
		Igra igra = new Igra();
		igra.zacni();
		
		Igra kopijaIgre = new Igra(igra);


		
		
		odigraj(kopijaIgre);	
		odigraj(kopijaIgre);	
		odigraj(kopijaIgre);	

		odigraj(igra);	

	}
	public static void odigraj(Igra kopijaIgre) {
		
		Set<Koordinati> moznePoteze = kopijaIgre.moznePoteze;
		Koordinati p = moznePoteze.iterator().next();
		
		System.out.println(kopijaIgre.odigrajPotezo (p));
		System.out.println(kopijaIgre);

	}

}
