package org.lessons.java.travelagency;

import java.time.LocalDate;
import java.util.Scanner;

public class Agency {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
//chiediamo all’operatore se vuole inserire una nuova vacanza o uscire.
        System.out.println("do you wantto insert new holiday? y/n");
        String decision = scan.nextLine();
        boolean isHoliday=true;
        Holidays holidays=null;
        while(isHoliday){
            LocalDate yourStartingDate=null;
            LocalDate yourEndingDate=null;
            String yourDestination=null;

            if (decision.equalsIgnoreCase("n")){
                isHoliday=false;
                System.out.println("i'm sorry you don't want  to insert new holiday");
                break;
            }else if(decision.equalsIgnoreCase("y")){
                //Se vuole proseguire con l’inserimento va chiesta la destinazione, il giorno,
                // mese e anno di partenza e il giorno, mese anno di ritorno.
               try {
                   System.out.println("Please insert your destination:");
                   yourDestination= scan.nextLine();
               }catch (Exception e){
                   System.out.println("destination not valid");
               }

            try{
                System.out.println("Please insert the starting date: ");
                yourStartingDate=LocalDate.parse(scan.nextLine());
            }catch (Exception e){
                System.out.println("Invalid date format");
            }

            try{
                System.out.println("Please insert the ending date:");
                yourEndingDate=LocalDate.parse(scan.nextLine());
            }catch (Exception e){
                System.out.println("Invalid date format");}
            }
            else {
                System.out.println("not valid input");
            }

          try {
              // creo una vacanza con i dati inseriti
              holidays =new Holidays(yourDestination, yourStartingDate,yourEndingDate);
                System.out.println(holidays.toString());
          }catch (RuntimeException e){
              System.out.println("Invalid parameters");
              System.out.println(e.getMessage());
          }

        }

    }
}
