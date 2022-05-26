package test;

import java.time.LocalDate;

public class Wizyta {
    private final int idPacjenta;
    private final int idLekarza;
    private final LocalDate data;

    public Wizyta(int idPacjenta, int idLekarza, LocalDate data) {
        this.idPacjenta = idPacjenta;
        this.idLekarza = idLekarza;
        this.data = data;
    }

    public int getIdPacjenta() {
        return idPacjenta;
    }

    public int getIdLekarza() {
        return idLekarza;
    }

    public LocalDate getData() {
        return data;
    }

}
