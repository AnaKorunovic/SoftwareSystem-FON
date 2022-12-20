/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractProductC;

import AbstractProductA.*;

import javafx.scene.control.*;


/* Kontroler3.java
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 */
import AbstractProductB.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.DKIspitnaPrijava;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public final class Kontroler3 extends Kontroler {

    public Kontroler3() {
    }

    public void init(Forma ef1, BrokerBazePodataka bbp1) {
        ef = ef1;
        bbp = bbp1;
        Povezi();
        osveziFormu();
    }

    void Povezi() {

        Button Kreiraj = (Button) ef.getPanel().getKreiraj();
        Button Promeni = (Button) ef.getPanel().getPromeni();
        Button Obrisi = (Button) ef.getPanel().getObrisi();
        Button Nadji = (Button) ef.getPanel().getNadji();
        Kreiraj.setOnAction((e) -> {
            kreirajDomenskiObjekat();
        });
        Promeni.setOnAction((e) -> {
            napuniDomenskiObjekatIzGrafickogObjekta();
            promeniDomenskiObjekat();
        });
        Obrisi.setOnAction((e) -> {
            napuniDomenskiObjekatIzGrafickogObjekta();
            obrisiDomenskiObjekat();
        });

        Nadji.setOnAction((e) -> {
            napuniDomenskiObjekatIzGrafickogObjekta();
            nadjiDomenskiObjekat();
        });

        TextField SifraPrijave = (TextField) ef.getPanel().getSifraPrijave1(); // Promenljivo!!!
        SifraPrijave.setOnMouseExited((e) -> {
            napuniDomenskiObjekatIzGrafickogObjekta();
            nadjiDomenskiObjekat();

        });
    }

// Promenljivo!!!    
    void napuniDomenskiObjekatIzGrafickogObjekta() {
        ip = new DKIspitnaPrijava();
        ip.setSifraPrijave(getInteger(ef.getPanel().getSifraPrijave()));
        ip.setBrojIndeksa(ef.getPanel().getBrojIndeksa());
        ip.setSifraPredmeta(getInteger(ef.getPanel().getSifraPredmeta()));
        ip.setOcena(getInteger(ef.getPanel().getOcena()));
        ip.setDatum(konvertujLocalDateUSQLDate((LocalDate) ef.getPanel().getDatum()));

    }

// Promenljivo!!!
    void napuniGrafickiObjekatIzDomenskogObjekta(DKIspitnaPrijava ip) {
        ef.getPanel().setSifraPrijave(Integer.toString(ip.getSifraPrijave()));
        ef.getPanel().setBrojIndeksa(ip.getBrojIndeksa());
        ef.getPanel().setSifraPredmeta(Integer.toString(ip.getSifraPredmeta()));
        ef.getPanel().setOcena(Integer.toString(ip.getOcena()));
        ef.getPanel().setDatum(konvertujUtilDateULocalDate(ip.getDatum()));
    }

    public LocalDate konvertujUtilDateULocalDate(java.util.Date input) {

        LocalDate date = null;

        if (input.getClass().getName().equals("java.util.Date")) {
            date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // konvertuje java.util.Date u LocalDate
        }
        if (input.getClass().getName().equals("java.sql.Date")) {
            date = ((java.sql.Date) input).toLocalDate(); // konvertuje java.sql.Date u LocalDate*/
        }
        return date;
    }

    public static java.util.Date konvertujLocalDateUUtilDate(LocalDate input) {
        Date date = Date.from(input.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
    }
    
     public static java.sql.Date konvertujLocalDateUSQLDate(LocalDate input) {
      return java.sql.Date.valueOf(input);     
    }

// Promenljivo!!!
    void isprazniGrafickiObjekat() {

        ef.getPanel().setSifraPrijave("");
        ef.getPanel().setBrojIndeksa("000000");
        ef.getPanel().setSifraPredmeta("0");
        ef.getPanel().setOcena("5");
        ef.getPanel().setDatum(LocalDate.now());
    }

    void prikaziPoruku() {
        ef.getPanel().setPoruka(poruka);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ef.getPanel().setPoruka("");
            }
        }, 5000);

    }

    void prikaziPoruku(String poruka) {
        ef.getPanel().setPoruka(poruka);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ef.getPanel().setPoruka("");
            }
        }, 1000);

    }

    void osveziFormu() {
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                napuniDomenskiObjekatIzGrafickogObjekta();
                nadjiDomenskiObjekat();
                prikaziPoruku("Освежавање форме!!!");
            }
        }, 0, 30000);

    }

    public int getInteger(String s) {
        int broj = 0;
        try {
            if (s != null) {
                broj = Integer.parseInt(s);
            }
        } catch (NumberFormatException e) {
            broj = 0;
        }

        return broj;
    }

    boolean zapamtiDomenskiObjekat() {

        bbp.makeConnection();
        boolean signal = bbp.insertRecord(ip);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Систем је запамтио нову испитну пријаву."; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            poruka = "Систем не може да запамти нову испитну пријаву."; // Promenljivo!!!  
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;

    }

    boolean kreirajDomenskiObjekat() {
        boolean signal;
        ip = new DKIspitnaPrijava(); // Promenljivo!!!
        AtomicInteger counter = new AtomicInteger(0);

        bbp.makeConnection();
        if (!bbp.getCounter(ip, counter)) {
            return false;
        }
        if (!bbp.increaseCounter(ip, counter)) {
            return false;
        }

        ip.setSifraPrijave(counter.get()); // Promenljivo!!!
        signal = bbp.insertRecord(ip);
        if (signal == true) {
            bbp.commitTransation();
            napuniGrafickiObjekatIzDomenskogObjekta(ip);
            poruka = "Систем је креирао нову испитну пријаву."; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            isprazniGrafickiObjekat();
            poruka = "Систем не може да креира нову испитну пријаву."; // Promenljivo!!!
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    boolean obrisiDomenskiObjekat() {
        bbp.makeConnection();
        boolean signal = bbp.deleteRecord(ip);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Систем je oбрисао испитну пријаву."; // Promenljivo!!!
            isprazniGrafickiObjekat();
        } else {
            bbp.rollbackTransation();
            poruka = "Систем не може да обрише испитну пријаву."; // Promenljivo!!!
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    boolean promeniDomenskiObjekat() {
        bbp.makeConnection();
        boolean signal = bbp.updateRecord(ip);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Систем je променио испитну пријаву."; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            isprazniGrafickiObjekat();
            poruka = "Систем не може да промени испитну пријаву."; // Promenljivo!!!
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    boolean nadjiDomenskiObjekat() {
        boolean signal;
        bbp.makeConnection();
        ip = (DKIspitnaPrijava) bbp.findRecord(ip); // Promenljivo!!!
        if (ip != null) {
            napuniGrafickiObjekatIzDomenskogObjekta(ip);
            poruka = "Систем je нашао испитну пријаву.";  // Promenljivo!!!
            signal = true;
        } else {
            isprazniGrafickiObjekat();
            poruka = "Систем не може да нађе испитну пријаву."; // Promenljivo!!!
            signal = false;
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

}
