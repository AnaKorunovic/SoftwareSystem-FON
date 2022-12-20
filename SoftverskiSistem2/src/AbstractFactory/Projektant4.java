/* Projektant4.java
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 */
package AbstractFactory;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

// Promenljivo!!!
public class Projektant4 implements Projektant {

    @Override
    public Forma kreirajEkranskuFormu() {
        return new EkranskaForma3();
    }

    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka() {
        return new BrokerBazePodataka2();
    }

    @Override
    public Kontroler kreirajKontroler(Forma ef, BrokerBazePodataka dbbr) {        
        return new Kontroler3();
    }

}
