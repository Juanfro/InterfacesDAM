package javaFXpackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * <ul>
 * <li>Ej4 - Crear tres objetos de la clase JLabel, ubicarlos uno debajo de otro
 * y mostrar nombres de colores.</li>
 * <li>Ej5 - Desarrollar una ventana que muestre un botón. Cuando se presione
 * finalizar la ejecución del programa Java.</li>
 * </ul>
 * 
 * @author Juan Antonio Rodriguez
 *
 */
public class Ej04_5 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Ejercicio 4");

		// StackPane root = new StackPane();
		VBox root = new VBox(20);
		root.setPadding(new Insets(20));

		Scene escena = new Scene(root, 300, 250);

		Label rojo = new Label("rojo");
		rojo.setTextFill(Color.RED);
		Label verde = new Label("verde");
		verde.setTextFill(Color.GREEN);
		Label azul = new Label("azul");
		azul.setTextFill(Color.BLUE);

		Button bCerrar = new Button("Cerrar");
		bCerrar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.close();
			}
		});

		// root.getChildren().addAll(rojo, verde, azul, bCerrar);

		root.getChildren().addAll(rojo, verde, azul, bCerrar);

		primaryStage.setScene(escena);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
