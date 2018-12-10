package javaFXpackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * <ol start="6">
 * <li>Confeccionar una ventana que contenga tres objetos de la clase JButton
 * con las etiquetas "1", "2" y "3". Al presionarse cambiar el título del JFrame
 * indicando cuál botón se presionó.</li>
 * 
 * <li>Disponer dos objetos de la clase JButton con las etiquetas: "varón" y
 * "mujer", al presionarse mostrar en la barra de títulos del JFrame la etiqueta
 * del botón presionado.</li>
 * <li>Confeccionar un programa que permita ingresar el nombre de usuario y
 * cuando se presione un botón mostrar el valor ingresado en la barra de títulos
 * del JFrame.</li>
 * </ol>
 * 
 * @author Juan Antonio rodríguez
 *
 */
public class Ej6_7_8 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Ejercicio 6, 7 y 8");
		VBox root = new VBox(20);
		root.setPadding(new Insets(20));
		Scene escena = new Scene(root, 300, 250);

		FlowPane numberPane = new FlowPane();
		FlowPane genderPane = new FlowPane();
		FlowPane textPane = new FlowPane();

		root.getChildren().addAll(numberPane, genderPane, textPane);

		// Numeros
		Button b1 = new Button("1");
		Button b2 = new Button("2");
		Button b3 = new Button("3");
		numberPane.getChildren().addAll(b1, b2, b3);

		// Género
		Button bHombre = new Button("Hombre");
		Button bMujer = new Button("Mujer");
		genderPane.getChildren().addAll(bHombre, bMujer);

		// Texto
		Label lUsuario = new Label("Usuario:");
		TextField campoUsuario = new TextField();
		Button bAceptar = new Button("Aceptar");
		textPane.getChildren().addAll(lUsuario, campoUsuario, bAceptar);

		// Manejador de evento
		EventHandler<ActionEvent> eventoBotones = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// Numeros
				if (event.getSource() == b1) {
					primaryStage.setTitle("1");
				}
				if (event.getSource() == b2) {
					primaryStage.setTitle("2");
				}
				if (event.getSource() == b3) {
					primaryStage.setTitle("3");
				}

				// Genero
				if (event.getSource() == bHombre) {
					primaryStage.setTitle("Hombre");
				}
				if (event.getSource() == bMujer) {
					primaryStage.setTitle("Mujer");
				}

				// Texto
				if (event.getSource() == bAceptar) {
					primaryStage.setTitle(campoUsuario.getText());
				}

			}
		};

		// Añadir evento a los botones
		b1.setOnAction(eventoBotones);
		b2.setOnAction(eventoBotones);
		b3.setOnAction(eventoBotones);
		bHombre.setOnAction(eventoBotones);
		bMujer.setOnAction(eventoBotones);
		bAceptar.setOnAction(eventoBotones);

		primaryStage.setScene(escena);
		primaryStage.show();

	}// END start

	public static void main(String[] args) {
		launch(args);

	}

}
