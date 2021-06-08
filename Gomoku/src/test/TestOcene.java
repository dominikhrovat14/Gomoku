package test;

import logika.NajboljseOcenjenePoteze;
import logika.OcenjenaPoteza;
import splosno.Koordinati;

public class TestOcene {

	public static void main(String[] args) {


		Koordinati p1 = new Koordinati(0, 0);
		
		Koordinati p2 = new Koordinati(10, 10);

		
		OcenjenaPoteza a = new OcenjenaPoteza(p1, 10);
		
		OcenjenaPoteza b = new OcenjenaPoteza(p2, 100);

		
		NajboljseOcenjenePoteze status = new NajboljseOcenjenePoteze();
		
		
		status.addIfBest(a);
		
		System.out.println(status);
		
		status.addIfBest(b);
		
		System.out.println(status);


		
	}

}
