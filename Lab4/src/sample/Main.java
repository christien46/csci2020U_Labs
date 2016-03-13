package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Skeleton Version
        /*Group root = new Group();
        Scene scene = new Scene(root, 640, 480);
        canvas = new Canvas();
        canvas.widthProperty().bind(primaryStage.widthProperty());
        canvas.heightProperty().bind(primaryStage.heightProperty());

        root.getChildren().add(canvas);
        primaryStage.setScene(scene);
        primaryStage.show();

        draw(root); */

        //BorderPane
        BorderPane Layout = new BorderPane();



        //Grid
        GridPane Grid1 = new GridPane();
        Grid1.setPadding(new Insets(10,10,10,10));
        Grid1.setVgap(10);
        Grid1.setHgap(10);

        //Label
        Label Username = new Label("Username:");
        Grid1.add(Username, 0,1);
        TextField UsernameText = new TextField();
        UsernameText.setPromptText("Username");
        Grid1.add(UsernameText,1,1);

        Label Password = new Label("Password:");
        Grid1.add(Password,0,2);
        TextField PasswordText = new TextField();
        PasswordText.setPromptText("Password");
        Grid1.add(PasswordText,1,2);

        Label fullName = new Label("Full Name:");
        Grid1.add(fullName,0,3);
        TextField fullNameText = new TextField();
        fullNameText.setPromptText("Full Name");
        Grid1.add(fullNameText,1,3);

        Label Email = new Label("Email:");
        Grid1.add(Email,0,4);
        TextField EmailText = new TextField();
        EmailText.setPromptText("Email");
        Grid1.add(EmailText,1,4);

        Label Phone = new Label("Phone #:");
        Grid1.add(Phone,0,5);
        TextField PhoneText = new TextField();
        PhoneText.setPromptText("Full Name");
        Grid1.add(PhoneText,1,5);

        //Calender setup Button

        Label CalenderLabel = new Label("Date of Birth:");
        Grid1.add(CalenderLabel,0,6);
        DatePicker Calender = new DatePicker();
        Grid1.add(Calender,1,6);




        //Button
        Button register  = new Button("Register");
        register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            String User = UsernameText.getText();
            String pass = PasswordText.getText();
            String email = EmailText.getText();
            String Fn = fullNameText.getText();

                System.out.println(Fn);
                System.out.println(User);
                System.out.println(pass);
                System.out.println(email);
            }
        });

        Grid1.add(register,1,7);



        //Stage-Basic stage setup
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //Setup Grid
        Layout.setTop(Grid1);
        primaryStage.setTitle("Hello");
        primaryStage.setScene(new Scene(Layout, 690, 360));
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
