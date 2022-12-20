/* Sef.java
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 */

package Client;

import AbstractFactory.*;
import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

public class Sef { // Client
        Projektant proj; // Abstract Factory   
        public class SoftverskiSistem // Complex Product
           {  public Forma ef; // AbstractProductA 
              public BrokerBazePodataka bbp; // AbstractProductB 
              public Kontroler kon; // AbstractProductC 
              SoftverskiSistem(Forma ef1,BrokerBazePodataka bbp1,Kontroler kon1){ef=ef1;bbp=bbp1;kon=kon1;}
              void prikaziEkranskuFormu(Sef sef){ef.prikaziEkranskuFormu(sef);}
              
           }
        public SoftverskiSistem ss;

Sef (Projektant proj1){proj = proj1; }   


public static void main(String args[])  {  
Sef sef; 
// ConcreteFactory3
Projektant proj = new Projektant4(); // Promenljivo!!! 
sef = new Sef(proj);
sef.Kreiraj();
}

void Kreiraj()     { 
      Forma ef =proj.kreirajEkranskuFormu();
      BrokerBazePodataka bbp = proj.kreirajBrokerBazePodataka();
      Kontroler kon= proj.kreirajKontroler(ef,bbp);
      ss = new SoftverskiSistem(ef,bbp,kon);
      ss.prikaziEkranskuFormu(this);
} 
    
}
