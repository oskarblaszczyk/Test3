package test;

import java.util.ArrayList;
import java.util.List;

public class Lekarz extends Osoba{

    private String specjalnosc;
    private final String nip;
    private List<Wizyta> wizyty = new ArrayList<>();

    public Lekarz(String iD, String nazwisko, String imie, String dataUrodzenia, String pesel, String specjalnosc, String nip) {
        super(iD, nazwisko, imie, dataUrodzenia, pesel);
        this.specjalnosc = specjalnosc;
        this.nip = nip;
    }

    public String getSpecjalnosc() {
        return specjalnosc;
    }

    public void setSpecjalnosc(String specjalnosc) {
        this.specjalnosc = specjalnosc;
    }

    public String getNip() {
        return nip;
    }

    public List<Wizyta> getWizyty() {
        return wizyty;
    }
}
