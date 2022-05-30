package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pacjent extends Osoba {
    private List<Wizyta> wizyty = new ArrayList<>();
    private static File plik = new File("pacjenci.txt");
    private static List<Pacjent> pacjenci = new ArrayList<>();


    public Pacjent(String iD, String nazwisko, String imie, String pesel, String dataUrodzenia) {
        super(iD, nazwisko, imie, dataUrodzenia, pesel);
        pacjenci.add(this);
    }

    public static void odczytPliku() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(plik));
        String line = "";
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] lekarz = line.split("\t");
            try {
                new Pacjent(lekarz[0], lekarz[1], lekarz[2], lekarz[3], lekarz[4]);
            } catch (IndexOutOfBoundsException e) {
                // System.out.println("Linia nie zawiera obiektu");
                // Wyjatek ArrayIndexOutOfBoundException wystepuje w przypadku pustych wierszy,
                // Lapiemy wyjatek ale nie ma potrzeby wypisywania go - lecimy dalej z petla aby dodac kolejne obiekty
            }
        }
    }

    public static Pacjent najwiecejWizyt(List<Pacjent> pacjenci) {
        if (pacjenci == null || pacjenci.isEmpty()) {
            throw new IllegalArgumentException(" Lista nie moze byc null ani pusta");
        }
        List<Pacjent> wynik = new ArrayList<>(pacjenci);
        return Collections.max(wynik, Comparator.comparingInt(o -> o.getWizyty().size()));
    }

    public static List<Pacjent> wizytyPoRoku(List<Pacjent> pacjenci, int n) {
        if (pacjenci == null) {
            throw new IllegalArgumentException("Nie moze byc nullem");
        }
        List<Pacjent> lista = new ArrayList<>();
        for (Pacjent p : pacjenci) {
            for (Wizyta w : p.wizyty) {
                if (w.getData().getYear() == n) {
                    lista.add(p);
                    break;
                }
            }
        }
        return lista;
    }

    public static List<Pacjent> getPacjenci() {
        return pacjenci;
    }

    public static File getPlik() {
        return plik;
    }

    public List<Wizyta> getWizyty() {
        return wizyty;
    }
}
