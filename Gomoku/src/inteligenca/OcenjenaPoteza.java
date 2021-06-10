package inteligenca;

import splosno.Koordinati;

public class OcenjenaPoteza {
	
	public Koordinati poteza;
	public int ocena;

	public OcenjenaPoteza(Koordinati poteza, int ocena) {
		
		this.poteza = poteza;
		this.ocena = ocena;
	}

	public int compareTo(OcenjenaPoteza op) {
		
		return Integer.valueOf(this.ocena).compareTo(
				Integer.valueOf(op.ocena));
	}
	public String toString() {
		
		return "x: "+poteza.getX()+" y: "+poteza.getY()+" "+ocena;
	}

}
