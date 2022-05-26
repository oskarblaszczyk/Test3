package test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ekstensja {

    private static Map<Class<?>, List<Lekarz>> ekstensje = new HashMap<>();

    public Ekstensja() {
        Ekstensja.getEkstensja(Lekarz.class).add(this);

//        List<T> lista = new ArrayList<T>();
//        Class<?> klasa = this.getClass();
//
//        if (ekstensje.containsKey(klasa)) {
//            //przypisanie istniejacych obiektow do listy
//            lista = (List<T>) ekstensje.get(klasa);
//        } else {
//            lista = new ArrayList<>();
//
//            ekstensje.put(klasa, (List<Class<?>>) lista);
//        }
//
//        lista.add((T) this);
    }

//    public static void save(FileWriter stream) throws IOException {
//        stream.
//        stream.writeObject(ekstensje.get(Lekarz.class));
//    }

    public static void load(FileReader stream) throws IOException {
        BufferedReader br = new BufferedReader(stream);
        String line = "";
        List<Lekarz> lista = new ArrayList<>();
        Lekarz dodaj = null;
        while ((line = br.readLine()) != null) {
            try {
                String[] lekarz = line.split("\t");
                dodaj = new Lekarz(lekarz[0], lekarz[1], lekarz[2], lekarz[3], lekarz[4], lekarz[5], lekarz[6]);
                lista.add(dodaj);
            }catch (IndexOutOfBoundsException e){
                System.out.println("cos nie tak");
            }

        }
        ekstensje.putIfAbsent(Lekarz.class, lista);
    }

    public static <T> List<Lekarz> getEkstensja(Class<T> klasa) {
        return ekstensje.get(klasa);
    }

}
