package test;

import java.util.ArrayList;
import java.util.List;

public class Pacjent extends Osoba{
    private List<Wizyta> wizyty = new ArrayList<>();

    public Pacjent(String iD, String nazwisko, String imie, String dataUrodzenia, String pesel) {
        super(iD, nazwisko, imie, dataUrodzenia, pesel);
    }

    public List<Wizyta> getWizyty() {
        return wizyty;
    }
}
