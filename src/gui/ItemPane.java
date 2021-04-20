package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

//You might need to do something to the following line
public class ItemPane extends GridPane {

	private ObservableList<ItemButton> itemButtonList = FXCollections.observableArrayList();

	public ItemPane() {
		// TODO implements the ItemPane's constructor
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		ItemButton Corn = new ItemButton("Corn");
		ItemButton Coffee = new ItemButton("Coffee");
		ItemButton Blueberry = new ItemButton("Blueberry");
		ItemButton Strawberry = new ItemButton("Strawberry");
		ItemButton Pineapple = new ItemButton("Pineapple");
		ItemButton DestroyTool = new ItemButton("DestroyTool");
		Corn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (SimulationManager.getMoney() >= Corn.getItem().getPrice()) {
					setSelectedButton(Corn);
				}
				// if click on the other item and can't afford it, this item will be unhighlight
				/*else {
					resetButtonsBackGroundColor();
				}*/
			}
		});
		Coffee.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (SimulationManager.getMoney() >= Coffee.getItem().getPrice()) {
					setSelectedButton(Coffee);
				}
				/*else {
					resetButtonsBackGroundColor();
				}*/
			}
		});

		Blueberry.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (SimulationManager.getMoney() >= Blueberry.getItem().getPrice()) {
					setSelectedButton(Blueberry);
				}
			}
		});
		Strawberry.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (SimulationManager.getMoney() >= Strawberry.getItem().getPrice()) {
					setSelectedButton(Strawberry);
				}
			}
		});
		Pineapple.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (SimulationManager.getMoney() >= Pineapple.getItem().getPrice()) {
					setSelectedButton(Pineapple);
				}
			}
		});
		DestroyTool.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				setSelectedButton(DestroyTool);
			}
		});

		this.add(Corn, 0, 0);
		this.add(Coffee, 1, 0);
		this.add(Blueberry, 2, 0);
		this.add(Strawberry, 0, 1);
		this.add(Pineapple, 1, 1);
		this.add(DestroyTool, 2, 1);
		this.itemButtonList.addAll(Corn, Coffee, Blueberry, Strawberry, Pineapple, DestroyTool);
	}

	public void setSelectedButton(ItemButton selecteditemButton) {
		// TODO set selectedItemButton of SimulationManager to given ItemButton
		// resetButtonsBackgroundColor and the highlight the selecteditemButton
		SimulationManager.setSelectedItemButton(selecteditemButton);
		resetButtonsBackGroundColor();
		selecteditemButton.highlight();
	}

	public void resetButtonsBackGroundColor() {
		// TODO unhighlight each button in itemButtonList
		for (int i = 0; i < this.itemButtonList.size(); i++) {
			this.itemButtonList.get(i).unhighlight();
		}
	}

}
