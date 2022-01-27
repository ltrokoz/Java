/**********************************************
 Workshop # 6
 Course:	    JAC444 - Winter 2021
 Last Name: 	Trokoz
 First Name: 	Liubov
 ID:		    139578199
 Section: 	    NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 		    20-03-2021
 **********************************************/

package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField yearField = new TextField();
    private TextField genderField = new TextField();
    private TextField nameField = new TextField();
    private Text resultText = new Text("");

    @Override
    public void start(Stage primaryStage) throws Exception {

        /******* Query Pane *******/

        // Creating a Grid Query Pane
        GridPane queryPane = new GridPane();

        // Labels
        Label yearLabel = new Label("Enter the Year:");
        Label genderLabel = new Label("Enter the Gender:");
        Label nameLabel = new Label("Enter the Name:");

        // Buttons
        Button submitQueryBtn = new Button("Submit Query");
        Button exitBtn = new Button("Exit");

        // Make buttons uniform size
        submitQueryBtn.setPrefWidth(90);
        exitBtn.setPrefWidth(90);

        // Setting the padding around the grid
        queryPane.setPadding(new Insets(25, 25, 25, 25));
        queryPane.setHgap(10);
        queryPane.setVgap(10);

        // Arranging all the nodes in the grid
        queryPane.add(yearLabel, 0, 0);
        queryPane.add(yearField, 1, 0);
        queryPane.add(genderLabel, 0, 1);
        queryPane.add(genderField, 1, 1);
        queryPane.add(nameLabel, 0, 2);
        queryPane.add(nameField, 1, 2);

        queryPane.add(submitQueryBtn, 0, 3);
        queryPane.add(exitBtn, 1, 3);

        // Setting title to the stage
        primaryStage.setTitle("Search Name Ranking Application");

        // Creating a scene object
        Scene queryScene = new Scene(queryPane, 350, 170);
        primaryStage.setScene(queryScene);

        // Displaying the contents of the stage
        primaryStage.show();

        /*****************************************/

        /******* Result Pane *******/

        // Creating a Grid Result Pane
        GridPane resultPane = new GridPane();

        // Text
        Text searchAgainPrompt = new Text("Do you want to Search for another Name:");

        // Buttons
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");

        // Make buttons uniform size
        yesBtn.setPrefWidth(90);
        noBtn.setPrefWidth(90);

        // Setting the padding around the grid
        //(top/right/bottom/left)
        resultPane.setPadding(new Insets(35, 25, 5, 55));

        // Setting the gap between cells and alignment
        resultPane.setHgap(10);
        resultPane.setVgap(10);

        // Arranging all the nodes in the grid
        resultPane.add(resultText, 0, 0, 10, 1);
        resultPane.add(searchAgainPrompt, 0, 1, 10, 1);

        resultPane.add(yesBtn, 0, 2);
        resultPane.add(noBtn, 1, 2);

        // Creating a result stage
        Stage resultStage = new Stage();

        // Setting title to the stage
        resultStage.setTitle("Search Name Ranking Application");

        // Creating a scene object
        Scene resultScene = new Scene(resultPane, 350, 170);
        resultStage.setScene(resultScene);


        /*****************************************/

        /******* Query Pane Buttons *******/

        submitQueryBtn.setOnAction(e -> {
            results();
            resultStage.show();
        });

        exitBtn.setOnAction(e -> {
            System.exit(0);
        });

        /*****************************************/

        /******* Result Pane Buttons *******/

        yesBtn.setOnAction(e -> {
            resultStage.hide();
        });

        noBtn.setOnAction(e -> {
            System.exit(0);
        });

        /*****************************************/
    }

    private void results() {

        String year = yearField.getText();
        String filename = String.format("babynamesranking%s.txt", year);

        String gender = (genderField.getText().equals("M") ? "Boy" : "Girl");

        String name = nameField.getText();
        String foundResult = "Name was not found";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(name)) {
                    foundResult = line;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String rank = foundResult.substring(0, 3);
        String result = String.format("%s name %s is ranked #%s in %s year", gender, name, rank, year);

        resultText.setText(result);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
