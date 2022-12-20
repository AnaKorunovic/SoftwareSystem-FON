// JFX01


package AbstractProductA;


import Client.Sef;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sinisa
 */
public class EkranskaForma3 extends Application implements Forma{
    Panel3 pan;
    static Sef sef;


    @Override
    public void start(Stage stage) throws Exception {
        String resourcePath = "FXMLPanel.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load(); 
        pan = (Panel3) fxmlLoader.getController();
        
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("PRIJAVA");
        stage.show();
        
        sef.ss.ef = this;
        sef.ss.kon.init(sef.ss.ef, sef.ss.bbp);
        
    }

    public Panel3 getCon() {
        return pan;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
    @Override
    public void prikaziEkranskuFormu(Sef sef) {
        this.sef = sef;
        this.main(null);
        
    }

    @Override
    public IPanel getPanel() {
        return pan;
    }
    
    
}


