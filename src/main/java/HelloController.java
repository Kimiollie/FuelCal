import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private Label lblDistance;
    @FXML
    private Label lblFuel;
    @FXML
    private Label lblResult;
    @FXML
    private TextField txtDistance;
    @FXML
    private TextField txtFuel;
    @FXML
    private Button btnCalculate;

    private ResourceBundle bundle;
    private Double lastConsumption = null;

    @FXML
    public void initialize() {
        setLanguage(new Locale("en", "US"));
    }

    @FXML
    private void setLanguage(Locale locale) {
        try {
            bundle = ResourceBundle.getBundle("messages", locale);
            lblDistance.setText(bundle.getString("distance.label"));
            lblFuel.setText(bundle.getString("fuel.label"));
            btnCalculate.setText(bundle.getString("calculate.button"));
            if (lastConsumption != null) {
                lblResult.setText(MessageFormat.format(bundle.getString("result.label"), lastConsumption));
            } else {
                lblResult.setText("");
            }
        } catch (Exception e) {
            lblResult.setText("Error loading language resources");
        }
    }

    @FXML
    private void onCalculateClick() {
        try {
            double distance = Double.parseDouble(txtDistance.getText());
            double fuel = Double.parseDouble(txtFuel.getText());
            lastConsumption = (fuel / distance) * 100;
            lblResult.setText(MessageFormat.format(bundle.getString("result.label"), lastConsumption));
        } catch (NumberFormatException e) {
            lblResult.setText(bundle.getString("invalid.input"));
        }
    }

    @FXML
    private void onENClick() {
        setLanguage(new Locale("en", "US"));
    }

    @FXML
    private void onFRClick() {
        setLanguage(new Locale("fr", "FR"));
    }

    @FXML
    private void onJPClick() {
        setLanguage(new Locale("ja", "JP"));
    }

    @FXML
    private void onIRClick() {
        setLanguage(new Locale("fa", "IR"));
    }
}