package org.lessons.java.travelagency;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//creare la classe Vacanza
public class Holidays {
    ///caratterizzata da:destinazion ,data inizio,data fine

    private String destination;
    private LocalDate startingDate, endingDate;

     //COSTRUTTORI


    public Holidays(String destination, LocalDate startingDate, LocalDate endingDate) throws RuntimeException {
        //controlli
        //  se destinazione è null data inizio e data fine non possono essere null
if (destination==null){
    // sollevo un'eccezione
    throw new RuntimeException("destination must not be null or empty");

}
// se data inizio  è null e gia passata
        if (startingDate == null || startingDate.isBefore(LocalDate.now())) {
            // sollevo un'eccezione
            throw new RuntimeException("Starting date must not be null or in the past");
        }
        //  se  data fine  è null e prima della data d'inizio
        if (endingDate == null || endingDate.isBefore(startingDate)) {
            // sollevo un'eccezione
            throw new RuntimeException("Ending date must not be null or before the starting date");
        }
        this.destination=destination;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }
    //METODI
    //metodo per calcolare la durata in giorni della vacanza
    public long getDuration(){
        return ChronoUnit.DAYS.between(startingDate,endingDate);
    }

    @Override
    public String toString() {
        return (" You have reserved a vacation of " + getDuration() +"Days"+ " in " + destination + " from " + startingDate + " to " + endingDate);
    }
}
