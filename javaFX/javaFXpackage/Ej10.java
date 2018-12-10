package javaFXpackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 10. Introducir el nombre de usuario y clave en controles de tipo JTextField.
 * Si se introducen las cadenas(usuario: juan, clave=abc123), mostrar en el
 * título del JFrame el mensaje "Correcto" en caso contrario, mostrar el mensaje
 * "Incorrecto".
 * 
 * @author Juan Antonio rodríguez
 *
 */
public class Ej10 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Ejercicio 10");
		VBox root = new VBox(20);
		root.setPadding(new Insets(20));
		Scene escena = new Scene(root, 300, 250);

		Label lUsuario = new Label("Usuario");
		TextField campoUsuario = new TextField();
		campoUsuario.setPromptText("Nombre de usuario");

		Label lpwd = new Label("Contraseña");
		PasswordField campoPwd = new PasswordField();
		campoPwd.setPromptText("Contraseña");

		Button bAcceder = new Button("Acceder");

		bAcceder.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (campoUsuario.getText().equals("Juan") && campoPwd.getText().equals("abc123")) {
					Alert alert = new Alert(AlertType.NONE, "Login Correcto", ButtonType.OK);
					alert.showAndWait();
					System.out.println("ok");
				} else {
					Alert alert = new Alert(AlertType.ERROR, "Login Incorrecto", ButtonType.PREVIOUS);
					System.out.println("Not ok");
					alert.showAndWait();

					campoUsuario.setText("");
					campoPwd.setText("");
				}

			}
		});

		root.getChildren().addAll(lUsuario, campoUsuario, lpwd, campoPwd, bAcceder);

		primaryStage.setScene(escena);
		primaryStage.show();
		root.requestFocus();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
