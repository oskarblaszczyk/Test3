package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Osoba {
    private final String iD;
    private String nazwisko;
    private String imie;
    private final LocalDate dataUrodzenia;
    private final String pesel;

    public Osoba(String iD, String nazwisko, String imie, String dataUrodzenia, String pesel) {
        this.iD = iD;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.dataUrodzenia = parsowanieDaty(dataUrodzenia);
        this.pesel = pesel;
    }

    private LocalDate parsowanieDaty(String s) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d");
        return LocalDate.parse(s, dtf);
    }

    public String getiD() {
        return iD;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }


    public String getPesel() {
        return pesel;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "iD='" + iD + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                '}';
    }
}
