package javaFXpackage;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * <ol start="15">
 * <li>Cargar en un JComboBox los nombres de varios colores. Al seleccionar
 * alguno mostrar en la barra de título del JFrame el String seleccionado.</li>
 * <li>Disponer tres controles de tipo JComboBox con valores entre 0 y 255 (cada
 * uno representa la cantidad de rojo, verde y azul). Luego al presionar un
 * botón pintar el mismo con el color que se genera combinando los valores de
 * los JComboBox.</li>
 * </ol>
 * 
 * @author Juan Antonio Rodriguez
 *
 */
public class Ej15_16 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Ejercicio 15 y 16");
		VBox root = new VBox(20);
		root.setPadding(new Insets(20));
		Scene escena = new Scene(root, 300, 250);

		ComboBox<String> selectColores = new ComboBox<>();
		selectColores.getItems().addAll("Color", "Rojo", "Verde", "Azul");
		selectColores.getSelectionModel().selectFirst();

		ObservableList<Integer> listaRojo = FXCollections.observableArrayList();
		for (int i = 0; i < 256; i++) {
			listaRojo.add((Integer) i);
		}
		ComboBox<Integer> rojo = new ComboBox<>(listaRojo);
		rojo.getSelectionModel().selectFirst();

		ObservableList<Integer> listaVerde = FXCollections.observableArrayList();
		for (int i = 0; i < 256; i++) {
			listaVerde.add((Integer) i);
		}
		ComboBox<Integer> verde = new ComboBox<>(listaVerde);
		verde.getSelectionModel().selectFirst();

		ObservableList<Integer> listaAzul = FXCollections.observableArrayList();
		for (int i = 0; i < 256; i++) {
			listaAzul.add((Integer) i);
		}
		ComboBox<Integer> azul = new ComboBox<>(listaAzul);
		azul.getSelectionModel().selectFirst();

		Button bCambiaColor = new Button("Cambiar Color");

		// Eventos

		selectColores.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Entra");
				String seleccionado = selectColores.getSelectionModel().getSelectedItem();
				bCambiaColor.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		});

		root.getChildren().addAll(selectColores, rojo, verde, azul, bCambiaColor);

		primaryStage.setScene(escena);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
