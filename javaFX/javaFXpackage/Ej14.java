package javaFXpackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * 14. Disponer dos controles de tipo JTextArea, luego al presionar un bot�n
 * verificar si tienen exactamente el mismo contenido.
 * 
 * @author Juan Antonio Rodriguez
 *
 */
public class Ej14 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Ejercicio 14");
		VBox root = new VBox(20);
		root.setPadding(new Insets(20));
		Scene escena = new Scene(root, 300, 250);

		TextArea campo1 = new TextArea();
		campo1.setPromptText("Primera Palabra");
		TextArea campo2 = new TextArea();
		campo2.setPromptText("Segunda Palabra");
		Button bComprobar = new Button("Comprobar");
		bComprobar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String texto1 = campo1.getText();
				String texto2 = campo2.getText();

				boolean sonIguales = texto1.equals(texto2);
				Alert alert;

				if (sonIguales) {
					System.out.println("ok");
					alert = new Alert(AlertType.CONFIRMATION, "Los contenidos son iguales", ButtonType.OK);
					alert.showAndWait();
				} else {
					System.out.println("Not ok");
					alert = new Alert(AlertType.ERROR, "Los contenidos NO son iguales", ButtonType.OK);
					alert.showAndWait();
				}

			}
		});

		root.getChildren().addAll(campo1, campo2, bComprobar);

		primaryStage.setScene(escena);
		primaryStage.show();

		root.requestFocus();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
