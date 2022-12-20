package AbstractProductA;


import AbstractProductC.Kontroler3;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Panel3 implements IPanel{

    @FXML
    public TextField SifraPrijave;

    @FXML
    public TextField BrojIndeksa;

    @FXML
    public TextField SifraPredmeta;

    @FXML
    public ComboBox<Integer> Ocena;

    @FXML
    public DatePicker Datum;

    @FXML
    public TextField Poruka;

    @FXML
    public Button Nadji;

    @FXML
    public Button Kreiraj;

    @FXML
    public Button Promeni;

    @FXML
    public Button Obrisi;

    @FXML
    public Button naPrvi;

    @FXML
    public Button naPredhodni;

    @FXML
    public Button naSledeci;

    @FXML
    public Button naPoslednji;

    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        //Kontroler3 kngui = new Kontroler3(this);
        Ocena.getItems().removeAll(Ocena.getItems());
        Ocena.getItems().addAll(5, 6, 7, 8, 9, 10,11);
        Ocena.getSelectionModel().select(0);
        
        Datum.setValue(LocalDate.now());
        
    }

    @Override
    public String getSifraPrijave() {
        return SifraPrijave.getText();
    }

    @Override
    public String getSifraPredmeta() {
        return SifraPredmeta.getText();
    }

    @Override
    public String getBrojIndeksa() {
        return BrojIndeksa.getText();
    }

    @Override
    public String getOcena() {
        return String.valueOf(Ocena.getValue());
    }

    @Override
    public void setSifraPrijave(String SifraPrijave) {
        this.SifraPrijave.setText(SifraPrijave);
    }

    @Override
    public void setSifraPredmeta(String SifraPredmeta) {
        this.SifraPredmeta.setText(SifraPredmeta);
    }

    @Override
    public void setBrojIndeksa(String BrojIndeksa) {
        this.BrojIndeksa.setText(BrojIndeksa);
    }

    @Override
    public void setOcena(String Ocena) {
        this.Ocena.setValue(Integer.parseInt(Ocena));
    }

    @Override
    public void setPoruka(String Poruka) {
        this.Poruka.setText(Poruka);
    }

    @Override
    public Object getKreiraj() {
        return Kreiraj;
    }

    @Override
    public Object getPromeni() {
        return Promeni;
    }

    @Override
    public Object getObrisi() {
        return Obrisi;
    }

    @Override
    public Object getNadji() {
        return Nadji;
    }

    @Override
    public Object getSifraPrijave1() {
        return SifraPrijave;
    }

    @Override
    public Object getDatum() {
        return this.Datum.getValue();
    }

    @Override
    public void setDatum(Object Datum) {
        this.Datum.setValue((LocalDate)Datum);
    }
}
