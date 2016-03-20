package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
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

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class Main extends Application {


    private TableView<StudentRecords> table;
    private TextField sidField, firstNameField, lastNmaeField, gpaField;
    private BorderPane border = new BorderPane();





    @Override
    public void start(Stage primaryStage) throws Exception{



        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);

        table = new TableView<>();
        table.setItems(DataSource.getAllMarks());
        table.setEditable(true);

        TableColumn<StudentRecords,Integer> SID = new TableColumn<>("SID");
        SID.setMinWidth(100);
        SID.setCellValueFactory(new PropertyValueFactory<>("SID"));

        TableColumn<StudentRecords,Double> Assignemnts = new TableColumn<>("Assignemnts");
        Assignemnts.setMinWidth(100);
        Assignemnts.setCellValueFactory(new PropertyValueFactory<>("Assignments"));

        TableColumn<StudentRecords,Double> MidTerm = new TableColumn<>("Midterm");
        SID.setMinWidth(100);
        SID.setCellValueFactory(new PropertyValueFactory<>("Midterm"));

        TableColumn<StudentRecords,Integer> FinalExam = new TableColumn<>("Final Exam");
        SID.setMinWidth(100);
        SID.setCellValueFactory(new PropertyValueFactory<>("FinalExam"));

        TableColumn<StudentRecords,Integer> FinalMark = new TableColumn<>("Final Mark");
        SID.setMinWidth(100);
        SID.setCellValueFactory(new PropertyValueFactory<>("FinalMark"));

        TableColumn<StudentRecords,Integer> LetterGrade = new TableColumn<>("Letter Grade");
        SID.setMinWidth(100);
        SID.setCellValueFactory(new PropertyValueFactory<>("LetterGrade"));

        table.getColumns().add(SID);
        table.getColumns().add(Assignemnts);
        table.getColumns().add(MidTerm);
        table.getColumns().add(FinalExam);
        table.getColumns().add(FinalMark);
        table.getColumns().add(LetterGrade);

        Label SIDLabel = new Label("SID:");
        grid.add(SIDLabel, 0, 0);
        TextField SIDField = new TextField();
        SIDField.setPromptText("SID");
        grid.add(SIDField, 1, 0);

        Label assignmentsLabel = new Label("Assignments:");
        grid.add(assignmentsLabel, 2, 0);
        TextField assignmentsField = new TextField();
        assignmentsField.setPromptText("Assignments/100");
        grid.add(assignmentsField, 3, 0);

        Label midtermLabel = new Label("Midterm:");
        grid.add(midtermLabel, 0, 1);
        TextField midtermField = new TextField();
        midtermField.setPromptText("Midterm/100");
        grid.add(midtermField, 1, 1);

        Label finalExamLabel = new Label("Final Exam:");
        grid.add(finalExamLabel, 2, 1);
        TextField finalExamField = new TextField();
        finalExamField.setPromptText("Final Exam/100");
        grid.add(finalExamField, 3, 1);

        Button Button = new Button("Add");
        Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String SID = sidField.getText();
                float Assignments = Float.parseFloat(assignmentsField.getText());
                float Midterm     = Float.parseFloat(midtermField.getText());
                float FinalExam   = Float.parseFloat(finalExamField.getText());

                table.getItems().add(new StudentRecords(SID, Assignments, Midterm, FinalExam));

                sidField.setText("");
                assignmentsField.setText("");
                midtermField.setText("");
                finalExamField.setText("");
            }
        });

        grid.add(Button, 1, 4);


        border.setBottom(grid);
        border.setCenter(table);

        primaryStage.setTitle("Lab5");
        primaryStage.setScene(new Scene(border, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
