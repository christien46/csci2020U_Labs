package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL url;

    @FXML
    private TableColumn<StudentRecord, Integer> SID;

    @FXML
    private TableColumn<StudentRecord, Double> Assignments;

    @FXML
    private TableColumn<StudentRecord, Double> Midterm;

    @FXML
    private TableColumn<StudentRecord, Double> finalExam;

    @FXML
    private TableColumn<StudentRecord, Double> finalMark;

    @FXML
    private TableColumn<StudentRecord, String> letterGrade;











    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
