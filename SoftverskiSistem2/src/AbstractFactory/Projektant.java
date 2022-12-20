/* Projektant.java
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 */

package AbstractFactory;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

public interface Projektant {
       Forma kreirajEkranskuFormu();   
       BrokerBazePodataka kreirajBrokerBazePodataka ();
       Kontroler kreirajKontroler (Forma ef,BrokerBazePodataka dbbr);   
}
