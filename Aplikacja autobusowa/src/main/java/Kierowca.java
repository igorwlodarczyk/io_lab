public class Kierowca {

	private int id;
	private String imie;
	private String nazwisko;
	private boolean dostepny;

	/**
	 * 
	 * @param id
	 * @param imie
	 * @param nazwisko
	 * @param dostepny
	 */
	public Kierowca(int id, String imie, String nazwisko, boolean dostepny) {
		// TODO - implement Kierowca.Kierowca
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param dostepny
	 */
	public void setDostepny(boolean dostepny) {
		this.dostepny = dostepny;
	}

	public boolean getDostepny() {
		return this.dostepny;
	}

	public String toString() {
		// TODO - implement Kierowca.toString
		throw new UnsupportedOperationException();
	}

}