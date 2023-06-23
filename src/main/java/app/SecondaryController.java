package app;

import java.io.FileNotFoundException;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SecondaryController {
    String str = " ";
    @FXML
    private CheckBox c1,c2,c3,c4;

    @FXML
    private AnchorPane anchorPane1;

    @FXML
    private AnchorPane anchorPane2;

    @FXML
    private Button buttonA;

    // @FXML
    // private Button buttonB;

    // @FXML
    // private Button buttonC;

    // @FXML
    // private Button buttonD;

    // @FXML
    // private Button buttonE;

    // @FXML
    // private Button buttonF;

    @FXML
    private Menu helpMenu;

    @FXML
    private Menu menuButton;

    @FXML
    private MenuItem aboutMenu;

    @FXML
    private BorderPane borderPane;

    @FXML
    private MenuItem theam;

    //Code for Button A

    @FXML
    void btnClickedPageA(ActionEvent event) throws FileNotFoundException {
        anchorPane1.getChildren().clear();
        anchorPane1.setStyle("-fx-background-color:#ADD8E6");

        //TestField
        TextField root = new TextField("Page A");
        root.setId("textFieldA");
        root.setPrefWidth(418);
        root.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));

        //Table View
        Button button = new Button("Table View");
        button.setId("tableViewButton");

        button.setLayoutY(27);
        button.setOnAction(e -> {
            TableView tableView = new TableView();
            tableView.setId("tableView");
            tableView.setLayoutX(70);
            tableView.setLayoutY(100);
            tableView.setPrefSize(300, 250);
            TableColumn<Person, String> column1 = new TableColumn<>("First Name");
            column1.setId("column");
            column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

            TableColumn<Person, String> column2 = new TableColumn<>("Last Name");
            column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));

            TableColumn<Person, String> column3 = new TableColumn<>("Address");
            column3.setCellValueFactory(new PropertyValueFactory<>("address"));

            tableView.getColumns().add(column1);
            tableView.getColumns().add(column2);
            tableView.getColumns().add(column3);

            tableView.getItems().add(new Person("Ram" , "Pawar","Ahmednagar"));
            tableView.getItems().add(new Person("Ankit" , "More","Jalgaon"));

            anchorPane1.getChildren().add(tableView);
        });

        //Tree View
        Button treeViewbtn = new Button("Tree View");
        treeViewbtn.setId("treeViewButton");
        treeViewbtn.setLayoutY(27);
        treeViewbtn.setLayoutX(90);

        treeViewbtn.setOnAction(e -> {
            TreeTableView<Person> treeTableView = new TreeTableView<Person>();
            treeTableView.setId("treeTableView");
            treeTableView.setLayoutX(70);
            treeTableView.setLayoutY(100);
            treeTableView.setPrefSize(300, 250);
            TreeTableColumn<Person, String> treeTableColumn1 = new TreeTableColumn<>("First Name");
            TreeTableColumn<Person, String> treeTableColumn2 = new TreeTableColumn<>("Last Name");
            TreeTableColumn<Person, String> treeTableColumn3 = new TreeTableColumn<>("Address");

            treeTableColumn1.setCellValueFactory(new TreeItemPropertyValueFactory<>("firstName"));
            treeTableColumn2.setCellValueFactory(new TreeItemPropertyValueFactory<>("lastName"));
            treeTableColumn3.setCellValueFactory(new TreeItemPropertyValueFactory<>("address"));

            treeTableView.getColumns().add(treeTableColumn1);
            treeTableView.getColumns().add(treeTableColumn2);
            treeTableView.getColumns().add(treeTableColumn3);

            TreeItem t1 = new TreeItem(new Person("Alia","Bhat", "Pune"));
            TreeItem t2 = new TreeItem(new Person("Sidharth","Malhotra", "Mumbai"));
            TreeItem t3 = new TreeItem(new Person("Ram","Pawar", "Maharashtra"));

            TreeItem alia = new TreeItem(new Person("Alia","Bhat", "Pune"));
            alia.getChildren().addAll(t1,t2,t3);

            TreeItem t4 = new TreeItem(new Person("Virat","Kohli", "Mumbai"));
            TreeItem t5 = new TreeItem(new Person("Ms","Dhoni", "Ranchi"));
            TreeItem t6 = new TreeItem(new Person("Ram","Pawar", "Maharashtra"));

            TreeItem virat = new TreeItem<>(new Person("Virat","Kohli", "Mumbai"));
            virat.getChildren().addAll(t4,t5,t6);

            TreeItem celebrities = new TreeItem<>(new Person("celebrities","-----","-----"));
            celebrities.getChildren().addAll(alia,virat);
            treeTableView.setRoot(celebrities);
            anchorPane1.getChildren().add(treeTableView);
        });

        //List View
        Button listViewBtn = new Button("Languages");
        listViewBtn.setId("listViewBtn");
        listViewBtn.setLayoutY(51);
        listViewBtn.setOnAction(event1 -> {
            ListView<String> listView1 = new ListView<>();
            listView1.setLayoutX(70);
            listView1.setLayoutY(100);
            listView1.setPrefSize(300, 250);
            listView1.setId("listView");
            listView1.setItems(FXCollections.observableArrayList("Java","C", "C++", "PHP", "JavaScript"));
            listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            anchorPane1.getChildren().add(listView1);
        });

        //Dialog Box
        Button dialogBoxBtn = new Button("DialogBox");
        dialogBoxBtn.setId("dialogBoxBtn");
        dialogBoxBtn.setLayoutX(89);
        dialogBoxBtn.setLayoutY(51);
        dialogBoxBtn.setOnAction(e -> {
            String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sxunday"};
            String defaultValue = days[0];

            ChoiceDialog<String> dialog = new ChoiceDialog<String>(defaultValue, days);
            dialog.setTitle("Days Selection");
            dialog.setHeaderText("Select a day");
            dialog.showAndWait();
        });
        anchorPane1.getChildren().addAll(button,root,treeViewbtn,listViewBtn,dialogBoxBtn);
    }
}
