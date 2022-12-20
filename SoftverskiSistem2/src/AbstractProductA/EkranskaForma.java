/* EkranskaForma.java
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 */

package AbstractProductA;


import Client.Sef;
import java.awt.Panel;
import javax.swing.JFrame;


public abstract class EkranskaForma extends JFrame implements Forma{
    //Panel pan;
    
    @Override
    public IPanel getPanel() {return (IPanel)getContentPane();}  
    public void setPanel(IPanel pan1) {setContentPane((Panel)pan1);//pan=pan1;
    
        
    }
    @Override
    public void prikaziEkranskuFormu(Sef sef){setVisible(true);}
    abstract public void odrediDekoracijuForme();
}
