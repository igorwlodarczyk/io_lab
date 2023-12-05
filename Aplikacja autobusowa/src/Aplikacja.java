import java.time.LocalTime;
import java.util.*;

public class Aplikacja {

	private Collection<Kierowca> kierowcy =  new ArrayList<>();
	private Collection<Kurs> kursy = new ArrayList<>();
	private Collection<Autobus> autobusy = new ArrayList<>();
	private Collection<Przystanek> przystanki = new ArrayList<>();
	private Collection<Linia> linie = new ArrayList<>();

	/**
	 *
	 * @param numerLinii: Numer linii
	 * @param numerKierowcy: Numer kierowcy
	 * @param numerAutobusu: Numer autobusu
	 * @param czasStartowy: Czas startowy
	 */
	public Kurs utworzKurs(int numerLinii, int numerKierowcy, int numerAutobusu, LocalTime czasStartowy) {
		// TODO - implement Aplikacja.utworzKurs
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param przystanek: Przystanek autobusowy
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
	 * @param przystanek: Przystanek autobusowy
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
	 * @param kierowca: Kierowca autobusu
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
	 * @param linia: Linia autobusowa
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
	 * @param autobus: Autobus
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
	 * @param kurs: Kurs autobusowy
	 */
	public void setKurs(Kurs kurs) {
		// TODO - implement Aplikacja.setKurs
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param przystanek: przystanek autobusowy
	 */
	public List<Map<Linia, LocalTime>> wygenerujRozklad(Przystanek przystanek) {
		// TODO - implement Aplikacja.wygenerujRozklad
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numer: numer
	 */
	public LocalTime wyznaczCzasWzgledemRozkladu(int numer) {
		// TODO - implement Aplikacja.wyznaczCzasWzgledemRozkladu
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numer: numer
	 */
	public boolean meldujPrzyjazd(int numer) {
		// TODO - implement Aplikacja.meldujPrzyjazd
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numer: numer
	 */
	public boolean meldujAwarie(int numer) {
		// TODO - implement Aplikacja.meldujAwarie
		throw new UnsupportedOperationException();
	}

	public boolean anulujKurs() {
		// TODO - implement Aplikacja.anulujKurs
		throw new UnsupportedOperationException();
	}

	public static void printMenu(){
		System.out.println("MENU:\n1.Przystanki\n2.Kierowcy\n3.Linie\n4.Autobusy\n5.Kursy\nWprowadz numer:\n");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			printMenu();
			Integer choice = scanner.nextInt();

			switch (choice) {
				case 1: {
					System.out.println("CASE 1");
					break;
				}
				case 2: {
					System.out.println("CASE 2");
					break;
				}
				case 3: {
					System.out.println("CASE 3");
					break;
				}
				case 4: {
					System.out.println("CASE 4");
					break;
				}
				case 5: {
					System.out.println("CASE 5");
					break;
				}
				case 0:
				{
					return;
				}
			}



		}
	}

}