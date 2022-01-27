/**********************************************
 Workshop # 5
 Course:	    JAC444 - Winter 2021
 Last Name: 	Trokoz
 First Name: 	Liubov
 ID:		    139578199
 Section: 	    NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 		    16-03-2021
 **********************************************/

package sample;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class Main extends Application {

    File file;
    int counter = 0;

    ArrayList<String> fname = new ArrayList<>();
    ArrayList<String> lname = new ArrayList<>();
    ArrayList<String> city = new ArrayList<>();
    ArrayList<String> province = new ArrayList<>();
    ArrayList<String> postalCode = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        // Creating a Grid Pane
        GridPane root = new GridPane();
        GridPane buttonGrid = new GridPane();
        GridPane nameGrid = new GridPane();
        GridPane addressGrid = new GridPane();

        // Set flag to true to view grid.
        root.setGridLinesVisible(false);
        nameGrid.setGridLinesVisible(false);

        // Labels
        Text text1 = new Text("First Name:");
        Text text2 = new Text("Last Name:");
        Text text3 = new Text("City:");
        Text text4 = new Text("Province:");
        Text text5 = new Text("Postal Code:");

        // Text fields
        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();
        TextField field5 = new TextField();

        // Buttons
        Button btnAdd = new Button("Add");
        Button btnFirst = new Button("First");
        Button btnNext = new Button("Next");
        Button btnPrevious = new Button("Previous");
        Button btnLast = new Button("Last");
        Button btnUpdate = new Button("Update");

        // Make buttons uniform size
        btnAdd.setPrefWidth(90);
        btnFirst.setPrefWidth(90);
        btnNext.setPrefWidth(90);
        btnPrevious.setPrefWidth(90);
        btnLast.setPrefWidth(90);
        btnUpdate.setPrefWidth(90);

        // Choice box for Province
        ChoiceBox<String> field4 = new ChoiceBox();
        field4.setValue("Province");
        field4.getItems().addAll("AB", "BC", "ON", "QB", "MB");

        // Setting the padding around the grid
        root.setPadding(new Insets(10, 10, 10, 10));
        nameGrid.setPadding(new Insets(10, 10, 10, 10));
        addressGrid.setPadding(new Insets(10, 10, 10, 10));
        buttonGrid.setPadding(new Insets(10, 10, 10, 10));

        // Setting the gap between cells and alignment
        nameGrid.setVgap(5);
        nameGrid.setHgap(5);
        buttonGrid.setVgap(5);
        buttonGrid.setHgap(9);
        addressGrid.setVgap(5);
        addressGrid.setHgap(5);

        root.setAlignment(Pos.TOP_LEFT);
        buttonGrid.setAlignment(Pos.TOP_CENTER);

        // Arranging all the nodes in the grid
        nameGrid.add(text1, 1, 1);
        nameGrid.add(field1, 2, 1, 100, 1);
        nameGrid.add(text2, 1, 4);
        nameGrid.add(field2, 2, 4, 100, 1);

        root.add(nameGrid, 1, 1);

        addressGrid.add(text3, 1, 1);
        addressGrid.add(field3, 2, 1);
        addressGrid.add(text4, 3, 1);
        addressGrid.add(field4, 4, 1);
        addressGrid.add(text5, 5, 1);
        addressGrid.add(field5, 6, 1);

        root.add(addressGrid, 1, 2);

        buttonGrid.add(btnAdd, 1, 1);
        buttonGrid.add(btnFirst, 2, 1);
        buttonGrid.add(btnNext, 3, 1);
        buttonGrid.add(btnPrevious, 4, 1);
        buttonGrid.add(btnLast, 5, 1);
        buttonGrid.add(btnUpdate, 6, 1);

        root.add(buttonGrid, 1, 3);

        // Setting title to the stage
        primaryStage.setTitle("Address Book");

        // Creating a scene object
        Scene scene = new Scene(root, 590, 210);

        // Adding scene to the stage
        primaryStage.setScene(scene);

        // Displaying the contents of the stage
        primaryStage.show();

        // Event handling for buttons
        // Event handling for the ADD button is pressed
        btnAdd.setOnAction( e -> {
            System.out.println("ADD button is pressed.");
            storeInfo(field1.getText(), field2.getText(), field3.getText(), field4.getValue(), field5.getText());
        });

        // Event handling for the FIRST button is pressed
        btnFirst.setOnAction(e -> {
            System.out.println("FIRST button is pressed.");
            field1.setText(fname.get(0));
            field2.setText(lname.get(0));
            field3.setText(city.get(0));
            field4.setValue(province.get(0));
            field5.setText(postalCode.get(0));
            counter = 0;
            String data = "The first contact: " + fname.get(0) + " " + lname.get(0) + " " + city.get(0) + " " + province.get(0) + " " + postalCode.get(0);
            // Display what exactly data in the first string
            System.out.println(data);
        });

        // Event handling for the NEXT button is pressed
        btnNext.setOnAction(e -> {
            counter++;
            System.out.println("NEXT button is pressed.");
            field1.setText(fname.get(counter));
            field2.setText(lname.get(counter));
            field3.setText(city.get(counter));
            field4.setValue(province.get(counter));
            field5.setText(postalCode.get(counter));
            String data = "The next contact: " + fname.get(counter) + " " + lname.get(counter) + " " + city.get(counter) + " " + province.get(counter) + " " + postalCode.get(counter);
            // Display what exactly data in the next string
            System.out.println(data);
        });

        // Event handling for the PREVIOUS button is pressed
        btnPrevious.setOnAction( e -> {
            counter--;
            System.out.println("PREVIOUS button is pressed.");
            field1.setText(fname.get(counter));
            field2.setText(lname.get(counter));
            field3.setText(city.get(counter));
            field4.setValue(province.get(counter));
            field5.setText(postalCode.get(counter));
            String data = "The previous contact: " + fname.get(counter) + " " + lname.get(counter) + " " + city.get(counter) + " " + province.get(counter) + " " + postalCode.get(counter);
            // Display what exactly data in the previous string
            System.out.println(data);
        });

        // Event handling for the last button is pressed
        btnLast.setOnAction( e -> {
            System.out.println("LAST button is pressed.");
            field1.setText(fname.get(fname.size()-1));
            field2.setText(lname.get(lname.size()-1));
            field3.setText(city.get(city.size()-1));
            field4.setValue(province.get(province.size()-1));
            field5.setText(postalCode.get(postalCode.size()-1));
            String data = "The last contact: " + fname.get(fname.size()-1) + " " + lname.get(lname.size()-1) + " " + city.get(city.size()-1) + " " + province.get(province.size()-1) + " " + postalCode.get(postalCode.size()-1);
            // Display what exactly data in the last string
            System.out.println(data);
        });

        // Event handling for the update button is pressed
        btnUpdate.setOnAction( e -> {
            System.out.println("UPDATE button is pressed.");
            fname.set(counter, field1.getText());
            lname.set(counter, field2.getText());
            city.set(counter, field3.getText());
            province.set(counter, field4.getValue());
            postalCode.set(counter, field5.getText());
            String data = "Contact was updated: " + field1.getText() + " " + field2.getText() + " " + field3.getText() + " " + field4.getValue() + " " + field5.getText();
            // Display what exactly data in the last string
            System.out.println(data);

            // Write the updated data into the file
            fileWriting();
        });
    }

    public void storeInfo(String firstName, String lastName, String City, String Province, String pcode){
        fname.add(firstName);
        lname.add(lastName);
        city.add(City);
        province.add(Province);
        postalCode.add(pcode);
        String data = "Contact was added: " + firstName + " " + lastName + " " + City + " " + Province + " " + pcode;
        // Display what exactly data was added
        System.out.println(data);
        //System.out.println("Name was added.");
        counter++;

        // Writes the data into the file
        fileWriting();
    }

    private void fileWriting() {
        try {
            file = new File ("AddressBook.txt");
            if (file.createNewFile()) {
                System.out.println("File was created.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            // Store all the fields as one string
            String[] str = new String[fname.size()];
            for (int i = 0; i < fname.size(); i++) {
                str[i] = fname.get(i) + " " + lname.get(i) + " " + city.get(i) + " " + province.get(i) + " ";
            }

            // Write the string and postal code to the file
            for (int j = 0; j < fname.size(); j++) {
                raf.write(str[j].getBytes());
                raf.write(postalCode.get(j).getBytes());
                raf.writeBytes("\n"); // Add new line
            }
            raf.close();
        } catch(IOException ex) {
            System.out.println(ex.toString());
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}