package gui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

//You might need to do something to the following line
public class ControlPane extends VBox {

	private ItemPane itemPane;
	private Button harvestButton;
	private Label moneyLabel;

	public ControlPane() {
		// TODO complete the ControlPane's constructor
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(300);
		this.setSpacing(15);
		this.setFillWidth(true);

		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.moneyLabel = new Label("");
		setMoneyLabelText();
		this.moneyLabel.setFont(Font.font(20));
		Label PopUp = new Label("Please select a seed or removal tool");
		PopUp.setFont(Font.font(14));
		this.itemPane = new ItemPane();
		this.harvestButton = new Button("Harvest");
		this.harvestButton.setPrefWidth(150);

		this.harvestButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				SimulationManager.harvestHandler();
			}
		});

		this.getChildren().addAll(this.moneyLabel, PopUp, this.itemPane, this.harvestButton);

	}

	public void setMoneyLabelText() {
		moneyLabel.textProperty().setValue("Money: " + SimulationManager.getMoney());
	}

	public ItemPane getItemPane() {
		return itemPane;
	}

	public Button getHarvestButton() {
		return harvestButton;
	}

	public Label getMoneyLabel() {
		return moneyLabel;
	}

}
