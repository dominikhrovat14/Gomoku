package graficni;

import logika.Igra;

public class Glavna {

	public static void main(String[] args) {
		Igra igra = new Igra();
		igra.zacni();
		Frame frame = new Frame(igra);
		
		frame.setVisible(true);
		


	}

}
