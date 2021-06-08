package graficni;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;

import javax.swing.JPanel;

import logika.Igra;
import splosno.Koordinati;



public class Panel extends JPanel implements MouseListener {
	
	
	
	  static int width;

	  static int height;

	  int rows;

	  int cols;
	  
	  public int x, y;
	  public static Koordinati clovekPoteza;
//	  public static int poteza;
	  public  Igra igra;
	  public static  int velikost = 500;
	  public  Set<Koordinati> moznePoteze;
	  
	public Panel(int sirina, int visina, int rows, int cols, Igra igra) {
		super(); 
		
		this.igra = igra;
		this.moznePoteze = igra.moznePoteze;
		
		setPreferredSize(new Dimension(sirina, visina));
		GridsCanvas(sirina, visina, rows, cols);
		
		addMouseListener(this);
		
	}

		
		
		public void GridsCanvas(int w, int h, int r, int c) {
			System.out.println("NOTRI");
		    setSize(width = w, height = h);
		    rows = r;
		    cols = c;
		    
		  }
		
		public static void dimenzije() {
			velikost = Frame.velikost;
		}

	
	  public void paint(Graphics g) {
		    int i;
		    // narisi vrtice

		    int rowHt = velikost / (rows);
		    System.out.println(velikost / (rows));
		    for (i = 0; i < rows; i++)
		      g.drawLine(0, i * rowHt, velikost, i * rowHt);

		    // narisi stolpce
		    int rowWid = velikost / (cols);
		    for (i = 0; i < cols; i++) {
		      g.drawLine(i * rowWid, 0, i * rowWid, velikost);
		    }
		    
		    if (igra.poteza % 2 == 0) {
			    if (igra.moznePoteze.contains(clovekPoteza)) {
			    	igra.preveriZmago(clovekPoteza);
			    	if (igra.zmagovalec == Igra.PRAZNO) {
			    		igra.odigrajPotezo(clovekPoteza);
					    g.setColor(Frame.barva);
					    g.fillOval(CentralizirajX(x, 15, 500), CentralizirajY(y, 15, 500), 15, 15);
			    	}
			    }
		    }
		    if (igra.poteza % 2 != 0) {
		    	Koordinati k = igra.racunalnikPoteza();
		    	igra.preveriZmago(k);
		    	if (igra.zmagovalec == Igra.PRAZNO) {
			    	g.setColor(Color.blue);
				    g.fillOval(CentralizirajX(pretvoriRacunalnik(k.getX(), 15, 500),15,500), CentralizirajY(pretvoriRacunalnik(k.getY(), 15, 500),15,500), 15, 15);
				    igra.odigrajPotezo(k);
		    	}
		    }
		    
		    

		  }
	
	  //postavi zeton na sredino kvadratka
	public int CentralizirajX(int x, int rows, int h) {
		for (int i = 0; i < h; i = i + (h / rows)){
			if (x < i) {
				x = (int)Math.round((i + (i - (h / rows) )) / 2); //x premaknemo v sredino

				return x-7;
		}
			
	}
		return 0;
		}
	
	public int CentralizirajY(int y, int cols, int w) {
		for (int i = 0; i < w; i = i + (int)Math.round(w / cols)){
			if (y < i) {
				y = (int)Math.round((i + (i - (w / cols) )) / 2); //x premaknemo v sredino
				return y-7;

		}
	}
		return 0;
		}
	
	//pretvori koordinate v koordinate od 0 do dim
	
	public int pretvoriKoordinatoX(int x, int rows, int h) {
		int j = -2;
		for (int i = 0; i < h; i = i + (h / rows)){
			j = j + 1;
			if (x < i) {
				return j;
				
		}
		
	}
		return 0;
		
}
	
	
	public int pretvoriKoordinatoY(int y, int cols, int w) {
		int j = -2;
		for (int i = 0; i < w; i = i + (w / cols)){
			j = j + 1;
			if (y < i) {
				return j;
				
		}
		
	}
		return 0;
		
}
	
	public int pretvoriRacunalnik(int x, int cols, int w) {
		for (int i = 0; i < cols; i++) {
			if (x < i) {
				x = ((2*i - 1) * (w / cols)) / 2;
				return x;
			}
		}
		return 0;
	}
	

	

	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		clovekPoteza = (new Koordinati((pretvoriKoordinatoX(x, rows, width)), pretvoriKoordinatoY(y, cols, height)));
		repaint();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
