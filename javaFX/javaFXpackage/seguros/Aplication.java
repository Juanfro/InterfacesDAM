package javaFXpackage.seguros;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Aplicación seguros");
		TabPane root = new TabPane();

		Scene escena = new Scene(root, 700, 600);
		//escena.getStylesheets().add("javaFX/javaFXpackage/resources/seguros.css");
		//escena.getStylesheets().add("seguros.css");
		escena.getStylesheets().add(getClass().getResource("seguros.css").toExternalForm());
		//escena.getStylesheets().add(Aplication.class.getResource("seguros.css").toExternalForm());
		//escena.getStylesheets().add(Aplication.class.getResource("/Interfaces/javaFX/javaFXpackage/resources/seguros.css").toExternalForm());

		
		
		
		// Pestañas
		Tab catalogo = new Tab("Catalogo de productos");
		VBox paneCatalogo = new VBox(20);
		catalogo.setContent(paneCatalogo);

		Tab agrupaciones = new Tab("Gestión de agrupaciones");
		VBox paneAgrupaciones = new VBox(20);
		agrupaciones.setContent(paneAgrupaciones);

		Tab normativas = new Tab("Gestión de normativas");
		VBox paneNormativas = new VBox(20);
		normativas.setContent(paneNormativas);

		Tab ficheros = new Tab("Gestión de ficheros");
		VBox paneFicheros = new VBox(20);
		ficheros.setContent(paneFicheros);

		// Pane Catálogo

		// Opciones
		Label lramo = new Label("Ramo");
		ComboBox<String> comboRamo = new ComboBox<>();
		comboRamo.getItems().addAll("Vida", "Generales");
		HBox ramo = new HBox(15, lramo, comboRamo);

		Label lSubramo = new Label("Subramo");
		ComboBox<String> comboSubramo = new ComboBox<>();
		comboSubramo.getItems().addAll("Vida", "Generales");
		HBox subRamo = new HBox(15, lSubramo, comboSubramo);

		Label lCategoria = new Label("Categoria");
		ComboBox<String> comboCategoria = new ComboBox<>();
		comboCategoria.getItems().addAll("Vida", "Generales");
		HBox categoria = new HBox(15, lCategoria, comboCategoria);

		VBox paneOpciones = new VBox(ramo, subRamo, categoria);
		paneOpciones.getStyleClass().add("seccion");
		paneOpciones.setId("opciones");

		paneCatalogo.getChildren().add(paneOpciones);
		// END Opciones

		Separator separadorOpciones = new Separator(Orientation.HORIZONTAL);
		paneCatalogo.getChildren().add(separadorOpciones);

		// Busqueda avanzada

		// Botón
		Button btAvanzada = new Button("Búsqueda Avanada");
		
		VBox boxBoton = new VBox(5, btAvanzada);

		// Parámetros
		Label titulo = new Label("Búsqueda Avanzada");
		titulo.setId("busquedatitulo");

		Label lFechaAlta = new Label("Fecha de alta");
		DatePicker fechaAltaInicio = new DatePicker();
		DatePicker fechaAltaFin = new DatePicker();
		HBox alta = new HBox(5, lFechaAlta, fechaAltaInicio, fechaAltaFin);

		Label lFechabaja = new Label("Fecha de baja");
		DatePicker fechabajaInicio = new DatePicker();
		DatePicker fechabajaFin = new DatePicker();
		HBox baja = new HBox(5, lFechabaja, fechabajaInicio, fechabajaFin);

		Label lFechacancelacion = new Label("Fecha de cancelacion");
		DatePicker fechacancelacionInicio = new DatePicker();
		DatePicker fechacancelacionFin = new DatePicker();
		HBox cancelacion = new HBox(5, lFechacancelacion, fechacancelacionInicio, fechacancelacionFin);

		Label lNombre = new Label("Nombre");
		TextField campoNombre = new TextField();
		campoNombre.setPromptText("Escribe el nombre");
		HBox boxNombre = new HBox(5, lNombre, campoNombre);

		Label ltipo = new Label("Tipo");
		TextField campotipo = new TextField();
		campotipo.setPromptText("Escribe el tipo");
		HBox boxTipo = new HBox(5, ltipo, campotipo);

		VBox boxParametrosBusqueda = new VBox(5, titulo, alta, baja, cancelacion, boxNombre, boxTipo);

		// END Parámetros

		HBox paneAvanzada = new HBox(5, boxBoton, boxParametrosBusqueda);
		paneAvanzada.getStyleClass().add("seccion");

		paneCatalogo.getChildren().add(paneAvanzada);
		// END Búsqueda Avanzada

		Separator separadorBusqueda = new Separator(Orientation.HORIZONTAL);
		paneCatalogo.getChildren().add(separadorBusqueda);

		// Acciones
		Button btBuscar = new Button("Buscar");
		Button btInforme = new Button("Generar Informe");
		Button btLimpiar = new Button("Limpiar");
		HBox boxOpciones = new HBox(20, btBuscar, btInforme, btLimpiar);
		boxOpciones.getStyleClass().add("seccion");

		paneCatalogo.getChildren().add(boxOpciones);
		// END acciones

		// END Pane Catálogo

		root.getTabs().addAll(catalogo, agrupaciones, normativas, ficheros);

		primaryStage.setScene(escena);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
