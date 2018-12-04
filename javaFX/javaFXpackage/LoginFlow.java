package javaFXpackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginFlow extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Login Screen");
		GridPane root = new GridPane();
		Scene escena = new Scene(root, 300, 250);

		// Elementos
		Label lUsuario = new Label("Usuario");
		Label lPwd = new Label("Contraseña");
		TextField campoUsuario = new TextField();
		PasswordField campoPwd = new PasswordField();
		Button btLogin = new Button("Iniciar Sesión");

		btLogin.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Usuario: " + campoUsuario.getText());
				System.out.println("Contraseña: " + campoPwd.getText());

			}
		});

		root.add(lUsuario, 0, 0, 1, 1);
		root.add(campoUsuario, 1, 0, 1, 1);
		root.add(lPwd, 0, 1, 1, 1);
		root.add(campoPwd, 1, 1, 1, 1);
		root.add(btLogin, 0, 2, 2, 1);

		primaryStage.setScene(escena);
		primaryStage.show();

	}

}
