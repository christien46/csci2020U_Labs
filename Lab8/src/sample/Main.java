package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.image.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.*;
import javafx.stage.Window;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.IllegalStateException;

public class Main extends Application{
    private Stage window;
    private BorderPane layout;
    private TableView<StudentRecord> table;
    private File currentFilename = null;
    private String thisSID;
    private float thisAssignment,thisMidterm,thisFinalExam;
    private TextField finalExamField,sidField,assignmentsField,midtermField ;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Lab 05 Solutions");


        /* create the menu (for the top of the user interface) */
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New", imageFile("images/new.png"));
        newMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        fileMenu.getItems().add(newMenuItem);
        fileMenu.getItems().add(new SeparatorMenuItem()); //Seperating Line in the drop down menu
        fileMenu.getItems().add(new MenuItem("Open...", imageFile("images/open.png"))); // new option for FIleMenu dropdown containing name and image
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Save", imageFile("images/save.png")));
        fileMenu.getItems().add(new MenuItem("Save As...", imageFile("images/save_as.png")));
        fileMenu.getItems().add(new SeparatorMenuItem());
        MenuItem exitMenuItem = new MenuItem("Exit", imageFile("images/exit.png"));
        fileMenu.getItems().add(exitMenuItem);
        exitMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
        exitMenuItem.setOnAction( e -> System.exit(0) );

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);



        /* create the table (for the center of the user interface) */
        table = new TableView<>();
        table.setItems(DataSource.getAllMarks());
        table.setEditable(true);

        /* create the table's columns */
        TableColumn<StudentRecord,Integer> sidColumn = null;
        sidColumn = new TableColumn<>("SID");
        sidColumn.setMinWidth(150);
        sidColumn.setCellValueFactory(new PropertyValueFactory<>("sid"));

        TableColumn<StudentRecord,Double> assignmentColumn = null;
        assignmentColumn = new TableColumn<>("Assignments");
        assignmentColumn.setMinWidth(150);
        assignmentColumn.setCellValueFactory(new PropertyValueFactory<>("assignments"));

        TableColumn<StudentRecord,Double> midtermColumn = null;
        midtermColumn = new TableColumn<>("Midterm");
        midtermColumn.setMinWidth(150);
        midtermColumn.setCellValueFactory(new PropertyValueFactory<>("midterm"));

        TableColumn<StudentRecord,Double> finalExamColumn = null;
        finalExamColumn = new TableColumn<>("Final Exam");
        finalExamColumn.setMinWidth(150);
        finalExamColumn.setCellValueFactory(new PropertyValueFactory<>("finalExam"));

        TableColumn<StudentRecord,Double> finalMarkColumn = null;
        finalMarkColumn = new TableColumn<>("Final Mark");
        finalMarkColumn.setMinWidth(150);
        finalMarkColumn.setCellValueFactory(new PropertyValueFactory<>("finalMark"));

        TableColumn<StudentRecord,Double> letterGradeColumn = null;
        letterGradeColumn = new TableColumn<>("Letter Grade");
        letterGradeColumn.setMinWidth(150);
        letterGradeColumn.setCellValueFactory(new PropertyValueFactory<>("letterGrade"));

        table.getColumns().add(sidColumn);
        table.getColumns().add(assignmentColumn);
        table.getColumns().add(midtermColumn);
        table.getColumns().add(finalExamColumn);
        table.getColumns().add(finalMarkColumn);
        table.getColumns().add(letterGradeColumn);

        /* create an edit form (for the bottom of the user interface) */
        GridPane editArea = new GridPane();
        editArea.setPadding(new Insets(10, 10, 10, 10));
        editArea.setVgap(10);
        editArea.setHgap(10);

        Label sidLabel = new Label("SID:");
        editArea.add(sidLabel, 0, 0);
        sidField = new TextField();
        sidField.setPromptText("SID");
        editArea.add(sidField, 1, 0);

        Label assignmentsLabel = new Label("Assignments:");
        editArea.add(assignmentsLabel, 2, 0);
        assignmentsField = new TextField();
        assignmentsField.setPromptText("Assignments/100");
        editArea.add(assignmentsField, 3, 0);

        Label midtermLabel = new Label("Midterm:");
        editArea.add(midtermLabel, 0, 1);
        midtermField = new TextField();
        midtermField.setPromptText("Midterm/100");
        editArea.add(midtermField, 1, 1);

        Label finalExamLabel = new Label("Final Exam:");
        editArea.add(finalExamLabel, 2, 1);
        finalExamField = new TextField();
        finalExamField.setPromptText("Final Exam/100");
        editArea.add(finalExamField, 3, 1);

        Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

                float assignments = 1;
                float midterm = 1;
                float finalExam = 1;

            if( invalidInput(e)) {
                String sid = sidField.getText();
                thisSID = sid;

                assignments = Float.parseFloat(assignmentsField.getText());
                thisAssignment = assignments;

                midterm     = Float.parseFloat(midtermField.getText());
                thisMidterm = midterm;

                finalExam   = Float.parseFloat(finalExamField.getText());
                thisFinalExam = finalExam;





                    table.getItems().add(new StudentRecord(sid, assignments, midterm, finalExam));

                    sidField.setText("");
                    assignmentsField.setText("");
                    midtermField.setText("");
                    finalExamField.setText("");
                }
            }


        });
        editArea.add(addButton, 1, 4);

        /* arrange all components in the main user interface */
        layout = new BorderPane();
        layout.setTop(menuBar);
        layout.setCenter(table);
        layout.setBottom(editArea);

        Scene scene = new Scene(layout, 900, 900);
        primaryStage.setScene(scene);
        primaryStage.show();





    }


    private void Save(File file,TableView<StudentRecord> table) {

    }

    private boolean invalidInput(ActionEvent e){

        Boolean isValid = true;

        System.out.println("XXXXXXX");



        if( sidField.getText().trim().isEmpty()){
            isValid = false;

            Alert emptySID = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) e.getTarget()).getScene().getWindow();
            emptySID.setContentText("Please enter a valid SID");
            emptySID.initModality(Modality.APPLICATION_MODAL);
            emptySID.initOwner(owner);
            emptySID.showAndWait();
            if(emptySID.getResult() == ButtonType.OK){
                emptySID.close();
            }
        }

        if(midtermField.getText().trim().isEmpty()){
            isValid = false;

            Alert emptyMidterm = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) e.getTarget()).getScene().getWindow();
            emptyMidterm.setContentText("Please enter a valid Midterm Mark");
            emptyMidterm.initModality(Modality.APPLICATION_MODAL);
            emptyMidterm.initOwner(owner);
            emptyMidterm.showAndWait();
            if(emptyMidterm.getResult() == ButtonType.OK){
                emptyMidterm.close();
            }
        }

        if(finalExamField.getText().trim().isEmpty()){
            isValid = false;

            Alert emptyFinalExam = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) e.getTarget()).getScene().getWindow();
            emptyFinalExam.setContentText("Please enter a valid Final Exam Mark");
            emptyFinalExam.initModality(Modality.APPLICATION_MODAL);
            emptyFinalExam.initOwner(owner);
            emptyFinalExam.showAndWait();
            if(emptyFinalExam.getResult() == ButtonType.OK){
                emptyFinalExam.close();
            }
        }

        if(assignmentsField.getText().trim().isEmpty()){
            isValid = false;

            Alert emptyAssignment = new Alert(Alert.AlertType.WARNING, "Warning", ButtonType.OK);
            Window owner = ((Node) e.getTarget()).getScene().getWindow();
            emptyAssignment.setContentText("Please enter a valid Assignment Mark");
            emptyAssignment.initModality(Modality.APPLICATION_MODAL);
            emptyAssignment.initOwner(owner);
            emptyAssignment.showAndWait();
            if(emptyAssignment.getResult() == ButtonType.OK){
                emptyAssignment.close();
            }
        }


        return isValid;
    }


    private void save(){



    }









    private ImageView imageFile(String filename) {
        return new ImageView(new Image("file:"+filename));
    }

    public static void main(String[] args) {
        launch(args);
    }


}
