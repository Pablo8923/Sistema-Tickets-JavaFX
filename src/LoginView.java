import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView {
    private Stage stage;

    public LoginView(Stage stage) {
        this.stage = stage;
    }

    public VBox getView() {
        VBox layout = new VBox(10);
        TextField userField = new TextField();
        PasswordField passField = new PasswordField();
        Button loginButton = new Button("Iniciar Sesión");

        loginButton.setOnAction(e -> stage.setScene(new Scene(new DashboardView(stage).getView(), 600, 400)));

        layout.getChildren().addAll(new Label("Usuario"), userField, new Label("Contraseña"), passField, loginButton);
        return layout;
    }
}