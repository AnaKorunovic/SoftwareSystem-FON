/* Kontroler.java
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 */

package AbstractProductC;

import AbstractProductA.Forma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKIspitnaPrijava;

public abstract class Kontroler {
    Forma ef;
    BrokerBazePodataka bbp;
    DKIspitnaPrijava ip;   // Promenljivo!!!
    String poruka;
    
    public void init(Forma ef, BrokerBazePodataka bbp){};
         
}
