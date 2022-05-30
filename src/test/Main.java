 /*
  * Wykorzystując informacje zawarte w plikach wykonaj następujące polecenia:
  *
  *
  *
  * - znajdź lekarza ktory miał najwięcej wizyt
  *
  * - znajdź pacjenta który miał najwięcej wizyt
  *
  * - która specalizacja cieszy się największym ppowodzeniem
  *
  * - którego roku było najwięcej wizyt?
  *
  * - wypisz top 5 najstarszych lekarzy
  *
  * + dodatek z dat
  *
  *  Wypisz wszystkich pacjentów którzy mieli wizyty od 2000 roku
  *  Wypisz wszystkich lekarzy którzy mieli wizyty w marcu, czerwcu i grudniu 2007
  *  Wypisz lekarza ktory miał najwiecej wizyt w okresie podanym jako parametr
  *
  *
  */

 package test;

 import java.io.IOException;
 import java.time.LocalDate;

 public class Main {
     public static void main(String[] args) throws IOException, ClassNotFoundException {
         /*
          * Wczytanie plikow do ekstensji kazdej z klas.
          */
         try {
             Lekarz.odczytPliku();
         } catch (IOException e) {
             System.out.println("Brak pliku: " + Lekarz.getPlik().getName());
         }
         try {
             Pacjent.odczytPliku();
         } catch (IOException e) {
             System.out.println("Brak pliku: " + Pacjent.getPlik().getName());
         }
         try {
             Wizyta.odczytPliku();
         } catch (IOException e) {
             System.out.println("Brak pliku: " + Wizyta.getPlik().getName());
         }


         /*
          * - znajdź lekarza ktory miał najwięcej wizyt
          */
         System.out.println("\n\nLekarz z najwieksza iloscia wizyt: ");
         try {
             System.out.print(Lekarz.najwiecejWizyt(Lekarz.getLekarze()));
         } catch (IllegalArgumentException e) {
             System.out.print("Brak lekarzy do porównania");
         }


         /*
          * - znajdź pacjenta który miał najwięcej wizyt
          */
         System.out.println("\n\nacjent z najwieksza iloscia wizyt: ");
         try {
             System.out.print(Pacjent.najwiecejWizyt(Pacjent.getPacjenci()));
         } catch (IllegalArgumentException e) {
             System.out.print("Brak pacjentów do porównania");
         }


         /*
          * - która specalizacja cieszy się największym ppowodzeniem
          */
         System.out.println("\n\nSpecjalizacja z najwiekszym powodzeniem: ");
         try {
             System.out.print(Lekarz.najpopularniejszaSpecjalizacja(Lekarz.getLekarze()));
         } catch (IllegalArgumentException e) {
             System.out.print("Brak Lekarzy do porównania");
         }


         /*
          * - którego roku było najwięcej wizyt?
          */
         System.out.println("\n\nNajwiecej wizyt bylo w roku: ");
         try {
             System.out.print(Wizyta.najwiecejWizyt(Wizyta.getWizyty()));
         } catch (IllegalArgumentException e) {
             System.out.print("Brak Wizyt do porównania");
         }


         /*
          * - wypisz top 5 najstarszych lekarzy
          */
         System.out.println("\n\nTop n najstarszych lekarzy: ");
         try {
             System.out.print(Lekarz.topNajstarszych(Lekarz.getLekarze(), 5));
         } catch (IllegalArgumentException e) {
             System.out.print("Brak Lekarzy do porównania");
         }


         /*
          *  Wypisz wszystkich pacjentów którzy mieli wizyty od 2000 roku
          */
         System.out.println("\n\nPacjenci z wizytami po roku N: ");
         try {
             System.out.println(Pacjent.wizytyPoRoku(Pacjent.getPacjenci(), 2000));
         } catch (IllegalArgumentException e) {
             System.out.print("Brak Pacjentow do porównania");
         }


         /*
          *  Wypisz wszystkich lekarzy którzy mieli wizyty w marcu, czerwcu i grudniu 2007
          */
         System.out.println("\n\nLekarze z wizytami w marcu, czerwcu i grudniu 2007: ");
         try {
             System.out.print(Lekarz.wizytaWMiesiacu(Lekarz.getLekarze(), 2007, 3));
             System.out.print(Lekarz.wizytaWMiesiacu(Lekarz.getLekarze(), 2007, 6));
             System.out.print(Lekarz.wizytaWMiesiacu(Lekarz.getLekarze(), 2007, 12));
         } catch (IllegalArgumentException e) {
             System.out.print("Brak Lekarzy do porównania");
         }


         /*
          *  Wypisz lekarza ktory miał najwiecej wizyt w okresie podanym jako parametr
          */
         System.out.println("\n\nLekarz ktory miał najwiecej wizyt w okresie podanym jako parametr: ");
         try {
             System.out.print(Lekarz.najwiecejWizytOkresie(Lekarz.getLekarze(), LocalDate.of(2007,01,01), LocalDate.of(2007,12,31)));
         } catch (IllegalArgumentException e) {
             System.out.print("Brak Lekarzy do porównania");
         }


     }
 }
