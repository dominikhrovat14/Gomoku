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
	
	
	
	  int width;

	  int height;

	  int rows;

	  int cols;
	  
	  public int x, y;
	  public static Koordinati clovekPoteza;
	  public Igra igra;
	  public  int velikost = 500;
	  public  Set<Koordinati> moznePoteze;
	  
	  public boolean clovekClovek = false;
	  public boolean racunalnikRacunalnik = false;
	  
	  
	  public static Koordinati zacetek;
	  public static Koordinati zacetek_stolpec,zacetek_diagonala;
	  public static Koordinati konec;
	  public static Koordinati konec_stolpec, konec_diagonala;
	  
	  
	  
	  
	public Panel(int sirina, int visina, int rows, int cols, Igra igra) {
		super(); 
		
		this.igra = igra;
		this.moznePoteze = igra.moznePoteze;
		
		setPreferredSize(new Dimension(sirina, visina));
		GridsCanvas(sirina, visina, rows, cols);
		
		addMouseListener(this);
		
	}

		
		
		public void GridsCanvas(int w, int h, int r, int c) {
		    setSize(width = w, height = h);
		    rows = r;
		    cols = c;
		    
		  }
		
		public void dimenzije() {
			velikost = Frame.velikost;
		}
		
		public void dimenzije(int velikost) {
			this.velikost = velikost;
			this.width 	  = velikost;
			this.height   = velikost;
		}

	
	//  public void paint(Graphics g) {
		
		public void paintComponent (Graphics g) {
			
		    super.paintComponent(g);       

		    // narisi vrtice
		    int rowHt = velikost / (rows);
		    
		    
		    for (int i = 0; i < rows; i++)
		      g.drawLine(0, i * rowHt, velikost, i * rowHt);
		    
		    // narisi stolpce
		    int rowWid = velikost / (cols);
		    
		    rowWid = (int)Math. round((velikost / (double)(cols)));

		    
		    for (int i = 0; i < cols; i++) {
		      g.drawLine(i * rowWid, 0, i * rowWid, velikost);
		    }
		    
		    if (Frame.racunalnikRacunalnik == true) {
				igra.racunalnikIgra(igra, Frame.panel);
					for (int i = 0; i < igra.dim; i++) {
						for (int j = 0; j < igra.dim; j++) {
							
							if(igra.board[i][j] != igra.PRAZNO) {
								
								Koordinati k = new Koordinati(i, j);
								
								if(igra.board[i][j] == igra.igralci[0]) { // clovek
									g.setColor(Frame.barva);
								}
								else {
									//racunalnik
								    g.setColor(Color.blue);
								}
								
							    g.fillOval(CentralizirajX(pretvoriRacunalnik(k.getX(), 15, velikost),15,velikost), CentralizirajY(pretvoriRacunalnik(k.getY(), 15, velikost),15,velikost), velikost / (3*cols), velikost / (3*cols));
							 
							}
						}
					}
				
				
				
		    }
		    
		    
			for (int i = 0; i < igra.dim; i++) {
				for (int j = 0; j < igra.dim; j++) {
					
					if(igra.board[i][j] != igra.PRAZNO) {
						
						Koordinati k = new Koordinati(i, j);
						
						if(igra.board[i][j] == igra.igralci[0]) { // clovek

							g.setColor(Frame.barva);
						}
						else {
							//racunalnik
						    g.setColor(Color.blue);
						}
					    g.fillOval(CentralizirajX(pretvoriRacunalnik(k.getX(), 15, velikost),15,velikost), CentralizirajY(pretvoriRacunalnik(k.getY(), 15, velikost),15,velikost), velikost / (3*cols), velikost / (3*cols));

					}
				}
			}
			
			
			if (igra.ZmagaVrstica() != Igra.PRAZNO) {
				System.out.println(Igra.zacetek.getX());
				g.setColor(Color.GREEN);
		    	g.drawLine(pretvoriRacunalnik(Igra.zacetek.getX(),  15, velikost), pretvoriRacunalnik(Igra.zacetek.getY(), 15, velikost), pretvoriRacunalnik(Igra.konec.getX(), 15, velikost), pretvoriRacunalnik(Igra.konec.getY(), 15, velikost));
		    	
		    }
			
			if (igra.ZmagaStolpec() != Igra.PRAZNO) {
				g.setColor(Color.GREEN);
		    	g.drawLine(pretvoriRacunalnik(Igra.zacetek_stolpec.getX(),  15, velikost), pretvoriRacunalnik(Igra.zacetek_stolpec.getY(), 15, velikost), pretvoriRacunalnik(Igra.konec_stolpec.getX(), 15, velikost), pretvoriRacunalnik(Igra.konec_stolpec.getY(), 15, velikost));
		    	
		    }
			
			if (igra.ZmagaDiagonala() != Igra.PRAZNO) {
				System.out.println(Igra.zacetek_diagonala.getX() + " " + Igra.konec_diagonala.getX());
				g.setColor(Color.GREEN);
		    	g.drawLine(pretvoriRacunalnik(Igra.zacetek_diagonala.getX(),  15, velikost), pretvoriRacunalnik(Igra.zacetek_diagonala.getY(), 15, velikost), pretvoriRacunalnik(Igra.konec_diagonala.getX(), 15, velikost), pretvoriRacunalnik(Igra.konec_diagonala.getY(), 15, velikost));
			}
			
			
			
			
			
		    // clovek

		    // racunalnik
	  //  	g.setColor(Color.blue);
	//	    g.fillOval(CentralizirajX(pretvoriRacunalnik(k.getX(), 15, velikost),15,velikost), CentralizirajY(pretvoriRacunalnik(k.getY(), 15, velikost),15,velikost), 15, 15);

		    
		    /*
		    if (igra.poteza % 2 == 0) {
			    if (igra.moznePoteze.contains(clovekPoteza)) {
			    	if (igra.preveriZmago() == Igra.PRAZNO) {
			    		igra.odigrajPotezo(clovekPoteza);
					    g.setColor(Frame.barva);
					    g.fillOval(CentralizirajX(x, 15, velikost), CentralizirajY(y, 15, velikost), 15, 15);
			    	}
			    }
		    }
		    if (igra.poteza % 2 != 0) {
		    	Koordinati k = igra.racunalnikPoteza();
		    	if (igra.preveriZmago() == Igra.PRAZNO) {
			    	g.setColor(Color.blue);
				    g.fillOval(CentralizirajX(pretvoriRacunalnik(k.getX(), 15, velikost),15,velikost), CentralizirajY(pretvoriRacunalnik(k.getY(), 15, velikost),15,velikost), 15, 15);
				    igra.odigrajPotezo(k);
		    	}
		    }
		    */
		    

		  }
	
	  //postavi zeton na sredino kvadratka
	public int CentralizirajX(int x, int rows, int h) {
		
		for (int i = 0; i < h; i = i + (h / rows)){
			if (x < i) {
				y = (int)Math.round((i + (i - (h / rows) )) / 2); //x premaknemo v sredino

				return y-7;
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
	
	//pretvori koordinate od 0 do velikost v koordinate od 0 do dim
	
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
		for (int i = 0; i < cols + 1; i++) {
			if (x < i) {
				y = ((2*i - 1) * (w / cols)) / 2;
				return y;
			}
		}
		return 0;
	}
	

	

	@Override
	public void mouseClicked(MouseEvent e) {
		// ce ni igra racunalnik proti racunalnik
		if (Frame.racunalnikRacunalnik == false) {
			x = e.getX();
			y = e.getY();
			
			
			clovekPoteza = (new Koordinati((pretvoriKoordinatoX(x, rows, width)), pretvoriKoordinatoY(y, cols, height)));
			
		    if (igra.poteza % 2 == 0) {
			    if (igra.moznePoteze.contains(clovekPoteza)) {
			    	if (igra.preveriZmago() == Igra.PRAZNO) {
			    		igra.odigrajPotezo(clovekPoteza);
			    	}
			    }
		    }
		    
		    if (Frame.clovekClovek == false) {
			    if (igra.poteza % 2 != 0) {
			    	Koordinati k = igra.racunalnikPoteza(igra);
			    	if (igra.preveriZmago() == Igra.PRAZNO) {
					    igra.odigrajPotezo(k);
			    	}
			    }
		    
		    }
		    
		    else {
		    	if (igra.poteza % 2 != 0) {
				    if (igra.moznePoteze.contains(clovekPoteza)) {
				    	if (igra.preveriZmago() == Igra.PRAZNO) {
				    		igra.odigrajPotezo(clovekPoteza);
				    	}
				    }
			    }
		    	
		    	
		    }
		    
		    
		    
			repaint();
			}
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
