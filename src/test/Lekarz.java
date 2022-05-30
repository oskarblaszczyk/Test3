package test;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Lekarz extends Osoba {

    private String specjalnosc;
    private final String nip;
    private List<Wizyta> wizyty = new ArrayList<>();
    private static File plik = new File("lekarze.txt");
    private static List<Lekarz> lekarze = new ArrayList<>();

    public Lekarz(String iD, String nazwisko, String imie, String specjalnosc, String dataUrodzenia, String nip, String pesel) {
        super(iD, nazwisko, imie, dataUrodzenia, pesel);
        this.specjalnosc = specjalnosc;
        this.nip = nip;
        lekarze.add(this);
    }

    public static void odczytPliku() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(plik));
        String line = "";
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] lekarz = line.split("\t");
            try {
                new Lekarz(lekarz[0], lekarz[1], lekarz[2], lekarz[3], lekarz[4], lekarz[5], lekarz[6]);
            } catch (IndexOutOfBoundsException e) {
                // System.out.println("Linia nie zawiera obiektu");
                // Wyjatek ArrayOutOfBoundException wystepuje w przypadku pustych wierszy,
                // Lapiemy wyjatek ale nie ma potrzeby wypisywania go - lecimy dalej z petla aby dodac kolejne obiekty
            }
        }
    }


    public static Lekarz najwiecejWizyt(List<Lekarz> lista) {
        if (lista == null || lista.isEmpty()) {
            throw new IllegalArgumentException(" Lista nie moze byc null ani pusta");
        }
        List<Lekarz> osoby = new ArrayList<>(lista);
        return Collections.max(osoby, Comparator.comparingInt(o -> o.getWizyty().size()));
    }

    public static String najpopularniejszaSpecjalizacja(List<Lekarz> lekarze) {
        if (lekarze == null) {
            throw new IllegalArgumentException(" Lista nie moze byc nullem");
        }
        List<Lekarz> lista = new ArrayList<>(lekarze);
        Map<String, Integer> specjalizacje = new HashMap<>();
        for (Lekarz l : lista) {
            specjalizacje.put(l.specjalnosc, specjalizacje.getOrDefault(l.specjalnosc, 1));
        }
        return Collections.max(specjalizacje.entrySet(), Map.Entry.comparingByValue()).getKey();

    }

    public static List<Lekarz> topNajstarszych(List<Lekarz> lekarze, int n) {
        if (lekarze == null) {
            throw new IllegalArgumentException("Nie moze byc nullem");
        }
        List<Lekarz> lista = new ArrayList<>(lekarze);
        Collections.sort(lista, new Comparator<Lekarz>() {
            @Override
            public int compare(Lekarz o1, Lekarz o2) {
                if (o1.getDataUrodzenia().isBefore(o2.getDataUrodzenia())) {
                    return -1;
                } else if (o1.getDataUrodzenia().isAfter(o2.getDataUrodzenia())) {
                    return +1;
                } else {
                    return 0;
                }
            }
        });
        return lista.subList(0, n - 1);
    }

    public static List<Lekarz> wizytaWMiesiacu(List<Lekarz> lekarze, int rok, int miesiac) {
        if (lekarze == null) {
            throw new IllegalArgumentException("Nie moze byc nullem");
        }
        List<Lekarz> lista = new ArrayList<>();
        for (Lekarz l : lekarze) {
            for (Wizyta w : l.getWizyty()) {
                if (w.getData().getYear() == rok && w.getData().getMonth().getValue() == miesiac) {
                    lista.add(l);
                    break;
                }
            }
        }
        return lista;
    }

    public static Lekarz najwiecejWizytOkresie(List<Lekarz> lekarze, LocalDate przedzialOd, LocalDate przedzialDo) {
        if (lekarze == null || lekarze.isEmpty()) {
            throw new IllegalArgumentException("Nie moze byc nullem ani pusta");
        }
        Lekarz lekarz = lekarze.get(0);
        int wizyty = 0;
        for (Lekarz l : lekarze) {
            int licznik = 0;
            for (Wizyta w : l.getWizyty()) {
                if (w.getData().isAfter(przedzialOd) && w.getData().isBefore(przedzialDo)) {
                    licznik++;
                }
            }
            if (wizyty < licznik) {
                lekarz = l;
                wizyty = licznik;
            }
        }
        return lekarz;

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

    public static File getPlik() {
        return plik;
    }

    public static List<Lekarz> getLekarze() {
        return lekarze;
    }

}
