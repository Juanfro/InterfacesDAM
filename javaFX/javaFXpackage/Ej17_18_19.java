package javaFXpackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * <ol start="17">
 * <li>Realizar un programa que solicite el nombre de una persona y que permita
 * un pais mediante el control JComboBox. Al presionar un botón, mostrar en la
 * barra del título del JFrame el nombre y el país seleccionado.</li>
 * 
 * <li>Desarrollar un menú de opciones que contenga tres opciones que permita
 * cambiar el color de fondo del JFrame a los colores: verde, verde y azul.</li>
 * 
 * <li>Desarrollar un programa con un menú de opciones que contenga además del
 * JMenu de la barra otros dos objetos de la clase JMenu que dependan del
 * primero. Uno debe mostrar dos JMenuItem que permitan modificar el tamaño del
 * JFrame y el segundo también debe mostrar dos JMenuItem que permitan cambiar
 * el color de fondo.</li>
 * </ol>
 * 
 * @author Juan Antonio Rodriguez
 *
 */
public class Ej17_18_19 extends Application {

	// VBox root;
	// Stage primaryStage;

	@Override
	public void start(Stage primaryStage) /* throws Exception */ {
		primaryStage.setTitle("Ejercicio 17, 18 y 19");
		VBox root = new VBox(20);
		// root.setPadding(new Insets(20));
		Scene escena = new Scene(root, 300, 250);

		/* ejercicio17(primaryStage); */

		TextField campoNombre = new TextField();
		campoNombre.setPromptText("Escribe tu nombre");

		ComboBox<String> selectPais = new ComboBox<>();
		selectPais.getItems().addAll("Elige un Pais", "España", "Ejpaña", "Spain", "Jpain");
		selectPais.getSelectionModel().selectFirst();

		Button miButton = new Button("Aceptar");
		miButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String nombre = campoNombre.getText();
				String pais = selectPais.getSelectionModel().getSelectedItem();

				primaryStage.setTitle(nombre + " | " + pais);
			}
		});

		MenuBar miMenuBar = new MenuBar();

		Menu menuColor = new Menu("Color");
		Menu menuSize = new Menu("Tamaño");

		MenuItem rojo = new MenuItem("Rojo");
		MenuItem verde = new MenuItem("Verde");
		MenuItem azul = new MenuItem("Azul");

		MenuItem small = new MenuItem("Pequeño");
		MenuItem medium = new MenuItem("Mediano");
		MenuItem big = new MenuItem("Grande");

		menuColor.getItems().addAll(rojo, verde, azul);
		menuSize.getItems().addAll(small, medium, big);

		miMenuBar.getMenus().addAll(menuColor, menuSize);

		EventHandler<ActionEvent> eventoColor = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Entra Color");
				if (event.getSource() == rojo) {
					root.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
				}
				if (event.getSource() == verde) {
					root.setBackground(
							new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
				}
				if (event.getSource() == azul) {
					root.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
				}
			}
		};

		rojo.setOnAction(eventoColor);
		verde.setOnAction(eventoColor);
		azul.setOnAction(eventoColor);

		EventHandler<ActionEvent> eventoSize = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (event.getSource() == small) {
					primaryStage.setWidth(150);
					primaryStage.setHeight(130);
				}
				if (event.getSource() == medium) {
					primaryStage.setWidth(300);
					primaryStage.setHeight(250);
				}
				if (event.getSource() == big) {
					primaryStage.setWidth(500);
					primaryStage.setHeight(400);
				}

			}
		};

		small.setOnAction(eventoSize);
		medium.setOnAction(eventoSize);
		big.setOnAction(eventoSize);

		root.getChildren().addAll(miMenuBar, campoNombre, selectPais, miButton);

		primaryStage.setScene(escena);
		primaryStage.show();
		root.requestFocus();
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Realizar un programa que solicite el nombre de una persona y que permita un
	 * pais mediante el control JComboBox. Al presionar un botón, mostrar en la
	 * barra del título del JFrame el nombre y el país seleccionado.
	 */
	/*
	 * private void ejercicio17(Stage stage) { TextField campoNombre = new
	 * TextField(); campoNombre.setPromptText("Escribe tu nombre");
	 * 
	 * ComboBox<String> selectPais = new ComboBox<>();
	 * selectPais.getItems().addAll("Elige un Pais", "España", "Ejpaña", "Spain",
	 * "Jpain"); selectPais.getSelectionModel().selectFirst();
	 * 
	 * Button miButton = new Button("Aceptar"); miButton.setOnAction(new
	 * EventHandler<ActionEvent>() {
	 * 
	 * @Override public void handle(ActionEvent event) { String nombre =
	 * campoNombre.getText(); String pais =
	 * selectPais.getSelectionModel().getSelectedItem();
	 * 
	 * stage.setTitle(nombre + " | " + pais);
	 * 
	 * root.getChildren().addAll(campoNombre, selectPais, miButton);
	 * 
	 * } });
	 * 
	 * }
	 */

}
