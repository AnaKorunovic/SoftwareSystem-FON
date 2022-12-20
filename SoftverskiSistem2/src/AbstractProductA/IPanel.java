package AbstractProductA;

import java.util.Date;


public interface IPanel {

    public String getSifraPrijave(); // Promenljivo!!!

    public String getSifraPredmeta(); // Promenljivo!!!

    public String getBrojIndeksa(); // Promenljivo!!!

    public String getOcena(); // Promenljivo!!!

    public void setSifraPrijave(String SifraPrijave); // Promenljivo!!!

    public void setSifraPredmeta(String SifraPredmeta); // Promenljivo!!!

    public void setBrojIndeksa(String BrojIndeksa); // Promenljivo!!!

    public void setOcena(String Ocena); // Promenljivo!!!

    public void setPoruka(String Poruka);

    public Object getKreiraj();

    public Object getPromeni();

    public Object getObrisi();

    public Object getNadji();

    public Object getSifraPrijave1();

    public Object getDatum(); // Promenljivo!!

    public void setDatum(Object Datum); // Promenljivo!!!

}
