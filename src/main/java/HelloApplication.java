import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/hello-view.fxml"));
        primaryStage.setTitle("Fuel Consumption Calculator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
