import java.util.*;

public class Linia {

	private int id;
	private ArrayList<Przystanek> listaPrzystankow = new ArrayList<>();
	private Przystanek kierunek;

	/**
	 * 
	 * @param id
	 * @param listaPrzystankow
	 * @param kierunek
	 */
	public Linia(int id, ArrayList<Przystanek> listaPrzystankow, Przystanek kierunek) {
        this.id = id;
        this.listaPrzystankow = listaPrzystankow;
        this.kierunek = kierunek;
    }

	public String toString() {
		// TODO - implement Linia.toString
		throw new UnsupportedOperationException();
	}

}