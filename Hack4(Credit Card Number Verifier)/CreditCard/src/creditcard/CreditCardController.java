package creditcard;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class CreditCardController implements Initializable {

    @FXML
    private MenuItem home;

    @FXML
    private MenuItem last_no;

    @FXML
    private TextField ccno_input;

    @FXML
    private Button validate_btn;

    @FXML
    private Button fill_btn;
    
// clear field method
    public void clear() {
        ccno_input.setText("");
    }
//  called when the fill last no menu item is clicked
    @FXML
    private void fill(ActionEvent event) {
        ccno_input.setPromptText("Enter 15 credit card numbers");
        fill_btn.setVisible(true);
        validate_btn.setVisible(false);
    }
    
    //  method that handles fill button click
    @FXML
    public void fillClick(ActionEvent event) {
        String ccString = ccno_input.getText();
        if (Pattern.matches("^[0-9]{15}$", ccString)) {
            String[] cc = ccString.split("");
            int[] ccno = new int[cc.length];
            int i = 0;
            for (String c : cc) {
                ccno[i] = Integer.parseInt(c);
                i++;
            }
            int lastDigit = fillLN(ccno);
            Alert alert = new Alert(Alert.AlertType.INFORMATION,
                    "Credit card number is: " +ccString + lastDigit, ButtonType.CANCEL);
            alert.setHeaderText("");
            alert.setTitle("Valid CC No");
            alert.showAndWait();
            clear();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Please enter 15 credit card numbers", ButtonType.CANCEL);
            alert.setHeaderText("");
            alert.setTitle("Invalid CC No");
            alert.showAndWait();
            clear();
        }
    }
    
    // method to generate last digit
    public int fillLN(int[] digits) {
        int sum = 0;
        int length = digits.length;
        for (int i = 0; i < length; i++) {
            int digit = digits[length - i - 1];
            if (i % 2 == 0) {
                digit *= 2;
            }
            sum += digit > 9 ? digit - 9 : digit;
        }
        return 10 - sum % 10;
    }
    
    
    
    
    //  called when the home item is clicked
     @FXML
    public void home(ActionEvent event) {
        ccno_input.setPromptText("Enter credit card numbers");
        fill_btn.setVisible(false);
        validate_btn.setVisible(true);
    }
//  method that handles validate button click
    @FXML
    private void ValidateAction(ActionEvent event) {
        String ccString = ccno_input.getText();
        if (Pattern.matches("^[0-9]{16}$", ccString)) {
            String[] cc = ccString.split("");
            int[] ccno = new int[cc.length];
            int i = 0;
            for (String c : cc) {
                ccno[i] = Integer.parseInt(c);
                i++;
            }
            if (validate(ccno)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,
                        "Credit card number is valid", ButtonType.CANCEL);
                alert.setHeaderText("");
                alert.setTitle("Valid CC No");
                alert.showAndWait();
                clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        "Credit card number is invalid", ButtonType.CANCEL);
                alert.setHeaderText("");
                alert.setTitle("Invalid CC No");
                alert.showAndWait();
                clear();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Credit card number is invalid", ButtonType.CANCEL);
            alert.setHeaderText("");
            alert.setTitle("Invalid CC No");
            alert.showAndWait();
            clear();
        }
    }
//  method to validate ccno 
    public boolean validate(int[] digits) {
        int sum = 0;
        int length = digits.length;
        for (int i = 0; i < length; i++) {
            int digit = digits[length - i - 1];
            if (i % 2 == 1) {
                digit *= 2;
            }
            sum += digit > 9 ? digit - 9 : digit;
        }
        return sum % 10 == 0;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ccno_input.setStyle("-fx-text-inner-color: #2a2b30;");
    }

}
