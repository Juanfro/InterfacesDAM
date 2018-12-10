package javaFXpackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Confeccionar un programa que permita introducir dos números en controles de
 * tipo JTextField, luego sumar los dos valores introducidos y mostrar la suma
 * en la barra del título del control JFrame.
 * 
 * @author Juan Antonio rodríguez
 *
 */
public class Ej09 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Ejercicio 9");
		VBox root = new VBox(20);
		root.setPadding(new Insets(20));
		Scene escena = new Scene(root, 300, 250);

		TextField num1 = new TextField();
		num1.setPromptText("Primer número");
		TextField num2 = new TextField();
		num2.setPromptText("Segundo número");
		Button bSumar = new Button("Sumar");

		bSumar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				try {
					int resultado = Integer.parseInt(num1.getText()) + Integer.parseInt(num2.getText());
					primaryStage.setTitle(Integer.toString(resultado));
				} catch (NumberFormatException e) {
					primaryStage.setTitle("Datos inválidos, introduce números en los campos");
				}

			}
		});

		root.getChildren().addAll(num1, num2, bSumar);

		primaryStage.setScene(escena);
		primaryStage.show();

		root.requestFocus();// Para que el foco no esté en el primer campo

	}

	public static void main(String[] args) {
		launch(args);

	}

}
