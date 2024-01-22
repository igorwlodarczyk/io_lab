package org.example;

public class Przystanek {

	private String nazwa;
	private double wspolrzedneX;
	private double wspolrzedneY;

	/**
	 * 
	 * @param nazwa
	 * @param wspolrzedneX
	 * @param wspolrzedneY
	 */
	public Przystanek(String nazwa, double wspolrzedneX, double wspolrzedneY) {
        this.nazwa = nazwa;
        this.wspolrzedneX = wspolrzedneX;
        this.wspolrzedneY = wspolrzedneY;
    }

	/**
	 * 
	 * @param nazwa
	 */
	public Przystanek(String nazwa) {
		// TODO - implement Przystanek.Przystanek
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO - implement Przystanek.toString
		throw new UnsupportedOperationException();
	}

	public String getNazwa() {
		return nazwa;
	}

	public double getWspolrzedneX() {
		return wspolrzedneX;
	}

	public double getWspolrzedneY() {
		return wspolrzedneY;
	}
}