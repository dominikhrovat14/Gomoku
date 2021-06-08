package logika;

import splosno.Koordinati;

public class OcenjenaPoteza {
	
	public Koordinati p;
	public int ocena;

	public OcenjenaPoteza(Koordinati p, int ocena) {
		
		this.p = p;
		this.ocena = ocena;
	}

	public int compareTo(OcenjenaPoteza op) {
		
		return Integer.valueOf(this.ocena).compareTo(
				Integer.valueOf(op.ocena));
	}
	public String toString() {
		
		return "x: "+p.getX()+" y: "+p.getY()+" "+ocena;
	}

}
