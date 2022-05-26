package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileReader fr = new FileReader("lekarze.txt");
        Ekstensja.load(fr);
        for(Lekarz l : Ekstensja.getEkstensja(Lekarz.class)){
            System.out.println(l);
        }
    }
}
