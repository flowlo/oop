
public interface Car extends Runnable{
	public enum direction {north, east, south, west};


	//liefert die aktuellen punkte zurueck
	public int getPoints();
	
	//erhoeht die punkte um 1 (synchrnonized)
	public void addPoint();
	
	//verringert die punkte um 1 (synchrnonized)
	public void crashed();
	
	//aktuelle Position 
	public int getPosX();
	public int getPosY();
	
	//Zeichen, durch welches das Auto repraesentiert wird
	public char getSymbol();
	
	//toString Methdoe, welche die Punkte anzeigt
	public String toString();

}
