package creditcard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CreditCard extends Application {
     
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Image icon = new Image(getClass().getResourceAsStream("icons8_Card_Payment_40px_2.png"));
        Scene scene = new Scene(root);
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setScene(scene);       
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
