package javaFXpackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * <ol start ="21">
 * <li>Desarrollar un programa que muestre 3 objetos de la clase JCheckBox con
 * etiquetas de tres idiomas. Cuando se lo selecciona mostrar en el título del
 * JFrame todos los JCheckBox seleccionados hasta el momento.</li>
 * <li>Disponer un control JLabel que muestre el siguiente mensaje: "Esta de
 * acuerdo con las normas del servicio?", luego un JCheckBox y finalmente un
 * objeto de tipo JButton desactivo. Cuando se tilde el JCheckBox debemos
 * activar el botón.</li>
 * </ol>
 * 
 * @author Juan Antonio Rodríguez
 *
 */
public class Ej21_22 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Ejercicio 21 y 22");
		VBox root = new VBox(20);
		root.setPadding(new Insets(20));
		Scene escena = new Scene(root, 300, 250, Color.BLUEVIOLET);

		CheckBox english = new CheckBox("Inglés");
		CheckBox french = new CheckBox("Frances");
		CheckBox german = new CheckBox("Alemán");

		EventHandler<ActionEvent> eventoIdioma = new EventHandler<ActionEvent>() {

			String[] titulo = { "", "", "" };

			@Override
			public void handle(ActionEvent event) {

				if (english.isSelected()) {
					titulo[0] = "Inglés ";
				} else {
					titulo[0] = "";
				}

				if (french.isSelected()) {
					titulo[1] = "Francés ";
				} else {
					titulo[1] = "";
				}

				if (german.isSelected()) {
					titulo[2] = "Alemán";
				} else {
					titulo[2] = "";
				}

				primaryStage.setTitle(titulo[0] + titulo[1] + titulo[2]);

			}
		};

		english.setOnAction(eventoIdioma);
		french.setOnAction(eventoIdioma);
		german.setOnAction(eventoIdioma);

		// EJ 22

		Label texto = new Label("Esta de acuerdo con las normas del servicio?");
		CheckBox chBAcuerdo = new CheckBox("Acepto");
		Button bAcepto = new Button("Continuar");
		bAcepto.setDisable(true);
		chBAcuerdo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (chBAcuerdo.isSelected()) {
					bAcepto.setDisable(false);
				} else {
					bAcepto.setDisable(true);
				}

			}
		});

		root.getChildren().addAll(english, french, german, texto, chBAcuerdo, bAcepto);

		primaryStage.setScene(escena);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
