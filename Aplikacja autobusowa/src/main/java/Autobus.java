public class Autobus {

    private int id;
    private String model;
    private boolean sprawny;
    private boolean dostepny;

    /**
     * @param id
     * @param model
     * @param sprawny
     */
    public Autobus(int id, String model, boolean sprawny) {
        this.id = id;
        this.model = model;
        this.sprawny = sprawny;
        this.dostepny = true; 
    }

    public String toString() {
        // TODO - implement Autobus.toString
        throw new UnsupportedOperationException();
    }

    public boolean getDostepny() {
        return this.dostepny;
    }

}