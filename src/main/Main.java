package main;

import gui.ControlPane;
import gui.FieldPane;
import gui.SimulationManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO
		HBox rootContainer = new HBox(10);
		rootContainer.setPadding(new Insets(10));
		rootContainer.setPrefHeight(400);
		ControlPane controlMain =  new ControlPane();
		FieldPane fieldPaneMain = new FieldPane();
		rootContainer.getChildren().addAll(controlMain,fieldPaneMain);
		SimulationManager.setControlPane(controlMain);
		SimulationManager.setFieldPane(fieldPaneMain);
		Scene scene = new Scene(rootContainer);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Harvest Simulator");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
