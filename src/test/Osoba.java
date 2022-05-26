package test;

public class Osoba {
    private final String iD;
    private String nazwisko;
    private String imie;
    private final String dataUrodzenia;
    private final String pesel;

    public Osoba(String iD, String nazwisko, String imie, String dataUrodzenia, String pesel) {
        this.iD = iD;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.dataUrodzenia = dataUrodzenia;
        this.pesel = pesel;
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

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String getPesel() {
        return pesel;
    }
    public static void load(){

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
