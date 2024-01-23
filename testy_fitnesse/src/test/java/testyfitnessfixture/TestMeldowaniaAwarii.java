package testyfitnessfixture;

import fit.ColumnFixture;
public class TestMeldowaniaAwarii extends ColumnFixture {
    int id;
    public boolean meldujAwarie() {
        return SetUp.aplikacja.meldujAwarie(id);
    }
}
