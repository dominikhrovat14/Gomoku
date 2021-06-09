package test;

public class TestDivide {

	public static void main(String[] args) {

		int rows = 15;
		int velikost = 700;
		
		System.out.println(velikost / (rows));
		System.out.println(velikost / (double)(rows));
		
	    int rowHt = (int)Math. round((velikost / (double)(rows)));
	    System.out.println(rowHt);
		
	    
	    rowHt = velikost / (rows);
	    System.out.println(rowHt);
	    
	}
}
