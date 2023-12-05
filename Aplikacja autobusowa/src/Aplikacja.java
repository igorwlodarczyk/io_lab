import java.time.LocalTime;
import java.util.*;

public class Aplikacja {

	private Collection<Kierowca> kierowcy =  new ArrayList<>();
	private Collection<Kurs> kursy = new ArrayList<>();
	private Collection<Autobus> autobusy = new ArrayList<>();
	private Collection<Przystanek> przystanki = new ArrayList<>();
	private Collection<Linia> linie = new ArrayList<>();

	public static void main() {
		// TODO - implement Aplikacja.main
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param przystanek
	 */
	public List<Kurs> pobierzNajblizszeAutobusy(Przystanek przystanek) {
		// TODO - implement Aplikacja.pobierzNajblizszeAutobusy
		throw new UnsupportedOperationException();
	}

	public List<Przystanek> getPrzystanki() {
		// TODO - implement Aplikacja.getPrzystanki
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param przystanek
	 */
	public void setPrzystanek(Przystanek przystanek) {
		// TODO - implement Aplikacja.setPrzystanek
		throw new UnsupportedOperationException();
	}

	public List<Kierowca> getKierowcy() {
		// TODO - implement Aplikacja.getKierowcy
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param kierowca
	 */
	public void setKierowca(Kierowca kierowca) {
		// TODO - implement Aplikacja.setKierowca
		throw new UnsupportedOperationException();
	}

	public List<Linia> getLinie() {
		// TODO - implement Aplikacja.getLinie
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param linia
	 */
	public void setLinia(Linia linia) {
		// TODO - implement Aplikacja.setLinia
		throw new UnsupportedOperationException();
	}

	public List<Autobus> getAutobusy() {
		// TODO - implement Aplikacja.getAutobusy
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param autobus
	 */
	public void setAutobus(Autobus autobus) {
		// TODO - implement Aplikacja.setAutobus
		throw new UnsupportedOperationException();
	}

	public List<Kurs> getKursy() {
		// TODO - implement Aplikacja.getKursy
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param kurs
	 */
	public void setKurs(Kurs kurs) {
		// TODO - implement Aplikacja.setKurs
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param przystanek
	 */
	public List<Map<Linia, LocalTime>> wygenerujRozklad(Przystanek przystanek) {
		// TODO - implement Aplikacja.wygenerujRozklad
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numer
	 */
	public LocalTime wyznaczCzasWzgledemRozkladu(int numer) {
		// TODO - implement Aplikacja.wyznaczCzasWzgledemRozkladu
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numer
	 */
	public boolean meldujPrzyjazd(int numer) {
		// TODO - implement Aplikacja.meldujPrzyjazd
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numer
	 */
	public boolean meldujAwarie(int numer) {
		// TODO - implement Aplikacja.meldujAwarie
		throw new UnsupportedOperationException();
	}

	public boolean anulujKurs() {
		// TODO - implement Aplikacja.anulujKurs
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numerLinii
	 * @param numerKierowcy
	 * @param numerAutobusu
	 * @param czasStartowy
	 */
	public Kurs utworzKurs(int numerLinii, int numerKierowcy, int numerAutobusu, LocalTime czasStartowy) {
		// TODO - implement Aplikacja.utworzKurs
		throw new UnsupportedOperationException();
	}

}