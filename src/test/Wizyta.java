package test;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Wizyta {
    private final Pacjent pacjent;
    private final Lekarz lekarz;
    private final LocalDate data;

    private static File plik = new File("wizyty.txt");
    private static List<Wizyta> wizyty = new ArrayList<>();

    public Wizyta(String idLekarza, String idPacjenta, String data) {
        if (idLekarza == null) {
            throw new NullPointerException("idLekarza jest nullem");
        }
        lekarz = getLekarzID(idLekarza);

        if (idPacjenta == null) {
            throw new NullPointerException("idPacjenta jest nullem");
        }
        pacjent = getPacjentID(idPacjenta);

        this.data = parsowanieDaty(data);
        wizyty.add(this);

        pacjent.getWizyty().add(this);
        lekarz.getWizyty().add(this);
    }

    public static void odczytPliku() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(plik));
        String line = "";
        br.readLine(); //wczytuje nagłówek pliku
        while ((line = br.readLine()) != null) {
            String[] lekarz = line.split("\t");
            try {
                new Wizyta(lekarz[0], lekarz[1], lekarz[2]);
            } catch (IndexOutOfBoundsException e) {
                // System.out.println("Linia nie zawiera obiektu");
                // Wyjatek ArrayOutOfBoundException wystepuje w przypadku pustych wierszy,
                // Lapiemy wyjatek ale nie ma potrzeby wypisywania go - lecimy dalej z petla aby dodac kolejne wizyty
            }
        }
    }


    private LocalDate parsowanieDaty(String s) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d");
        return LocalDate.parse(s, dtf);
    }

    public static Pacjent getPacjentID(String id) {
        for (Pacjent p : Pacjent.getPacjenci()) {
            if (p.getiD().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public static Lekarz getLekarzID(String id) {
        for (Lekarz l : Lekarz.getLekarze()) {
            if (l.getiD().equals(id)) {
                return l;
            }
        }
        return null;
    }

    public static int najwiecejWizyt(List<Wizyta> wizyty) {
        if (wizyty == null) {
            throw new IllegalArgumentException("Nie moze byc nullem");
        }
        List<Wizyta> lista = new ArrayList<>(wizyty);
        return Collections.max(lista, Comparator.comparingInt(o -> o.data.getYear())).data.getYear();
    }

    public LocalDate getData() {
        return data;
    }

    public static List<Wizyta> getWizyty() {
        return wizyty;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public Lekarz getLekarz() {
        return lekarz;
    }

    public static File getPlik() {
        return plik;
    }

    @Override
    public String toString() {
        return "Wizyta{" +
                "pacjent=" + pacjent +
                ", lekarz=" + lekarz +
                ", data=" + data +
                '}';
    }
}
