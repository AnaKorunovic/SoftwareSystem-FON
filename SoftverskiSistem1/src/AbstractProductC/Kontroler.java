/* Kontroler.java
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 */

package AbstractProductC;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.DKIspitnaPrijava;

public abstract class Kontroler {
    EkranskaForma ef;
    BrokerBazePodataka bbp;
    DKIspitnaPrijava ip;   // Promenljivo!!!
    String poruka;
         
}
