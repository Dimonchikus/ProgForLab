package main.java.controllers;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import javax.annotation.processing.Messager;
import javax.swing.SingleSelectionModel;

import static java.text.SimpleDateFormat.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Date;

public class Controller implements Initializable {

    @FXML
    private TextField a219;
    @FXML
    private TextField a219a;
    @FXML
    private TextField a221;
    @FXML
    private TextField a223;
    @FXML
    private TextField a223a;
    @FXML
    private TextField a224;
    @FXML
    private TextField a226;
    @FXML
    private TextField a230;
    @FXML
    private TextField g219;
    @FXML
    private TextField g219a;
    @FXML
    private TextField g221;
    @FXML
    private TextField g223;
    @FXML
    private TextField g223a;
    @FXML
    private TextField g224;
    @FXML
    private TextField g226;
    @FXML
    private TextField g230;

    @FXML
    private DatePicker date;

    @FXML
    private ComboBox<String> classesBox;

    @FXML
    private ComboBox<String> c219;

    @FXML
    private ComboBox<String> c219a;

    @FXML
    private ComboBox<String> c221;

    @FXML
    private ComboBox<String> c223;

    @FXML
    private ComboBox<String> c223a;

    @FXML
    private ComboBox<String> c224;

    @FXML
    private ComboBox<String> c226;

    @FXML
    private ComboBox<String> c230;

    @FXML
    private CheckBox kondratuk;

    @FXML
    private CheckBox nesterenko;

    @FXML
    private CheckBox shkitskiy;

    @FXML
    private CheckBox redzuk;

    @FXML
    private CheckBox fesyoham;

    @FXML
    private CheckBox fesyohaf;

    @FXML
    private CheckBox mykituk;

    @FXML
    private CheckBox vlasenko;

    @FXML
    private CheckBox samohvalov;

    @FXML
    private CheckBox lubarskiy;

    @FXML
    private CheckBox sokolov;

    @FXML
    private CheckBox subach;

    @FXML
    private CheckBox gorbenko;

    @FXML
    private CheckBox stempkovska;

    @FXML
    private CheckBox uspenskiy;

    @FXML
    private CheckBox goncharov;

    @FXML
    private CheckBox makarchuk;

    @FXML
    private CheckBox tkachov;

    @FXML
    private CheckBox teteryatnyk;

    @FXML
    private CheckBox stotckiy;

    @FXML
    private VBox vBox;

    @FXML
    private Button ok;

    ObservableList<String> list219 = FXCollections.observableArrayList();
    ObservableList<String> list219a = FXCollections.observableArrayList();
    ObservableList<String> list221 = FXCollections.observableArrayList();
    ObservableList<String> list223 = FXCollections.observableArrayList();
    ObservableList<String> list223a = FXCollections.observableArrayList();
    ObservableList<String> list224 = FXCollections.observableArrayList();
    ObservableList<String> list226 = FXCollections.observableArrayList();
    ObservableList<String> list230 = FXCollections.observableArrayList();
    ObservableList<String> classes = FXCollections.observableArrayList();
    ObservableList<ObservableList<String>> list = FXCollections.observableArrayList();

    Lesson [] lessons1 = new Lesson[8];
    Lesson [] lessons2 = new Lesson[8];
    Lesson [] lessons3 = new Lesson[8];
    Lesson [] lessons4 = new Lesson[8];
    Lesson [] lessons5 = new Lesson[8];
    Lesson []lessons = new Lesson [5];
    @FXML
    public void onSelect(ActionEvent a) {
        CheckBox rad = (CheckBox) a.getSource();
        if (rad.isSelected())
            for(ObservableList<String> elem : list)
                elem.add(rad.getText());
         else
            for(ObservableList<String> elem : list)
                elem.remove(rad.getText());
        int i = 0;
        c219.setItems(list.get(i++));
        c219a.setItems(list.get(i++));
        c221.setItems(list.get(i++));
        c223.setItems(list.get(i++));
        c223a.setItems(list.get(i++));
        c224.setItems(list.get(i++));
        c226.setItems(list.get(i++));
        c230.setItems(list.get(i++));
    }

    @FXML
    public void onSelectTeacher(ActionEvent a) {
    }

    public boolean check(){
        String error = null;
        if(classesBox.getSelectionModel().isEmpty())
            error+="Виберіть пару\n";
        if(date.getValue() == null)
            error+="Виберіть дату\n";
        if(!error.isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText(null);
            alert.setContentText(error);
            alert.showAndWait();
            return false;
        }
        return true;
    }
    String [] auds = new String[]{"219","219a","221","223","223a","224","226","230"};
    String currentLesson = "1";
    @FXML
    public void onSelectLesson(ActionEvent a){
        String s = ((ComboBox<String>) a.getSource()).getSelectionModel().getSelectedItem();

                    lessons[Integer.valueOf(currentLesson)-1].setAud("219");
                    lessons[Integer.valueOf(currentLesson)-1].setLesson(a219.getText());
                    lessons[Integer.valueOf(currentLesson)-1].setGroup(g219.getText());
                    lessons[Integer.valueOf(currentLesson)-1].setTeacher(c219.getSelectionModel().getSelectedItem());
                    lessons[Integer.valueOf(currentLesson)-1].setNumber(Integer.valueOf(currentLesson));

                    lessons[Integer.valueOf(currentLesson)-1].setAud("219a");
                    lessons[Integer.valueOf(currentLesson)-1].setLesson(a219a.getText());
                    lessons[Integer.valueOf(currentLesson)-1].setGroup(g219a.getText());
                    lessons[Integer.valueOf(currentLesson)-1].setTeacher(c219a.getSelectionModel().getSelectedItem());
                    lessons[Integer.valueOf(currentLesson)-1].setNumber(Integer.valueOf(currentLesson));

                    lessons[Integer.valueOf(currentLesson)-1].setAud("221");
                    lessons[Integer.valueOf(currentLesson)-1].setLesson(a221.getText());
                    lessons[Integer.valueOf(currentLesson)-1].setGroup(g221.getText());
                    lessons[Integer.valueOf(currentLesson)-1].setTeacher(c221.getSelectionModel().getSelectedItem());
                    lessons[Integer.valueOf(currentLesson)-1].setNumber(Integer.valueOf(currentLesson));

                    lessons[Integer.valueOf(currentLesson)-1].setAud("223");
                    lessons[Integer.valueOf(currentLesson)-1].setLesson(a223.getText());
                    lessons[Integer.valueOf(currentLesson)-1].setGroup(g223.getText());
                    lessons[Integer.valueOf(currentLesson)-1].setTeacher(c223.getSelectionModel().getSelectedItem());
                    lessons[Integer.valueOf(currentLesson)-1].setNumber(Integer.valueOf(currentLesson));

                    lessons[Integer.valueOf(currentLesson)-1].setAud("223a");
                    lessons[Integer.valueOf(currentLesson)-1].setLesson(a223a.getText());
                    lessons[Integer.valueOf(currentLesson)-1].setGroup(g223a.getText());
                    lessons[Integer.valueOf(currentLesson)-1].setTeacher(c223a.getSelectionModel().getSelectedItem());
                    lessons[Integer.valueOf(currentLesson)-1].setNumber(Integer.valueOf(currentLesson));

                    lessons[Integer.valueOf(currentLesson)-1].setAud("224");
                    lessons[Integer.valueOf(currentLesson)-1].setLesson(a224.getText());
                    lessons[Integer.valueOf(currentLesson)-1].setGroup(g224.getText());
                    lessons[Integer.valueOf(currentLesson)-1].setTeacher(c224.getSelectionModel().getSelectedItem());
                    lessons[Integer.valueOf(currentLesson)-1].setNumber(Integer.valueOf(currentLesson));

                    lessons[Integer.valueOf(currentLesson)-1].setAud("226");
                    lessons[Integer.valueOf(currentLesson)-1].setLesson(a226.getText());
                    lessons[Integer.valueOf(currentLesson)-1].setGroup(g226.getText());
                    lessons[Integer.valueOf(currentLesson)-1].setTeacher(c226.getSelectionModel().getSelectedItem());
                    lessons[Integer.valueOf(currentLesson)-1].setNumber(Integer.valueOf(currentLesson));

                    lessons[Integer.valueOf(currentLesson)-1].setAud("230");
                    lessons[Integer.valueOf(currentLesson)-1].setLesson(a230.getText());
                    lessons[Integer.valueOf(currentLesson)-1].setGroup(g230.getText());
                    lessons[Integer.valueOf(currentLesson)-1].setTeacher(c230.getSelectionModel().getSelectedItem());
                    lessons[Integer.valueOf(currentLesson)-1].setNumber(Integer.valueOf(currentLesson));

    }
            }


            }
        }
    }

    @FXML
    public void onOk(ActionEvent a) {
        if(check()){



        }
    }




   /* public void writeToFile(String s) throws IOException {
        File file = new File("D:/Java/ProgForLab/src/main/resources/".concat(date.getValue().toString()).concat(".txt"));
        if(!file.exists())
            file.createNewFile();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        ArrayList<Lesson> first = new ArrayList<>();
            first.add(new Lesson(Integer.parseInt(s),"219",a219.getText(),g219.getText(),c219.getSelectionModel().getSelectedItem()));
            first.add(new Lesson(Integer.parseInt(s),"219a",a219a.getText(),g219a.getText(),c219a.getSelectionModel().getSelectedItem()));
            first.add(new Lesson(Integer.parseInt(s),"221",a221.getText(),g221.getText(),c221.getSelectionModel().getSelectedItem())))
            first.add( new Lesson(Integer.parseInt(s),"223",a223.getText(),g223.getText(),c223.getSelectionModel().getSelectedItem()));
            first.add(new Lesson(Integer.parseInt(s),"223a",a223a.getText(),g223a.getText(),c223a.getSelectionModel().getSelectedItem()));
            first.add(new Lesson(Integer.parseInt(s),"224",a224.getText(),g224.getText(),c224.getSelectionModel().getSelectedItem()));
            first.add(new Lesson(Integer.parseInt(s),"226",a226.getText(),g226.getText(),c226.getSelectionModel().getSelectedItem()));
            first.add(new Lesson(Integer.parseInt(s),"230",a230.getText(),g230.getText(),c230.getSelectionModel().getSelectedItem()));
        out.writeObject(first);
    }


    @FXML
    public void onSelectClasses(ActionEvent a) throws IOException {
       String choise  = ((ComboBox<String>) a.getSource()).getSelectionModel().getSelectedItem();
       switch(choise){
           case "1":writeToFile(choise);break;
           case "2":g219.setText("2");break;
           case "3":g219.setText("3");break;
           case "4":g219.setText("4");break;
       }
    }
*/

    private String URL = "jdbc:mysql://localhost:3306/bd";
    private String USERNAME = "Dimonchikus";
    private String PASSWORD = "Misumuruvey196519791999";

    private final String INSERT_INTO = "INSERT INTO bd.table VALUES(?,?,?,?,?,?,?)";
    private final String GET_ALL = "SELECT * FROM bd.table";
    private final String DELETE = "DELETE  FROM bd.table where id = ?";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        classes.addAll("1","2","3","4","5");
        classesBox.setItems(classes);
        lessons.add(lessons1);
        lessons.add(lessons2);
        lessons.add(lessons3);
        lessons.add(lessons4);
        lessons.add(lessons5);
        for(Lesson[] elem: lessons) {
        int i = 0;
        for (Lesson item : elem) {
        item.setAud(auds[i++]);
        list.add(list219);
        list.add(list219a);
        list.add(list221);
        list.add(list223);
        list.add(list223a);
        list.add(list224);
        list.add(list226);
        list.add(list230);

      /*  try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("Error");
        }
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statemnt = connection.createStatement()){
                if (!connection.isClosed())
                    System.out.println("Connected");
                statemnt.execute("insert into bd.table(aud,bd.table.group,lesson,teacher,data,number) values ('219a','261','CPP','Redzuk','2018-01-28','1');");
                int res = statemnt.executeUpdate("update bd.table set teacher = 'Shkitskuy'  where id = 4;");
                System.out.println(res);
                ResultSet resultSet = statemnt.executeQuery("SELECT * FROM bd.table");

            statemnt.addBatch("insert into bd.table(aud,bd.table.group,lesson,teacher,data,number) values ('219a','261','CPP','Redzuk','2018-01-28','4');");
            statemnt.addBatch("insert into bd.table(aud,bd.table.group,lesson,teacher,data,number) values ('219a','261','CPP','Redzuk','2018-01-28','5');");
            statemnt.addBatch("insert into bd.table(aud,bd.table.group,lesson,teacher,data,number) values ('219a','261','CPP','Redzuk','2018-01-28','6');");
            statemnt.executeBatch();
            statemnt.clearBatch();
            statemnt.executeBatch();
            boolean b = connection.isClosed();
            System.out.println(b);
            connection.close();
                if (connection.isClosed())
                    System.out.println("Disconnected");
            }catch (SQLException e){
            e.printStackTrace();
        }
*/


           /* String query  = "select * from bd.table";
        try {


            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                lesson.setId(resultSet.getInt("id"));
                lesson.setNumber(resultSet.getInt("number"));
                lesson.setAud(resultSet.getString("aud"));
                lesson.setGroup(resultSet.getString("group"));
                lesson.setLesson(resultSet.getString("lesson"));
                lesson.setTeacher(resultSet.getString("teacher"));
                System.out.println(lesson);
            }
           //try {
             // Driver driver = new FabricMySQLDriver();
              // DriverManager.registerDriver(driver);
        //   }catch (SQLException e){
        //       e.printStackTrace();
        //   }
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

               //Set
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
                preparedStatement.setInt(1, 78);
                preparedStatement.setString(2, "221");
                preparedStatement.setString(3, "261");
                preparedStatement.setString(4, "OS");
                preparedStatement.setString(5, "Redzuk");
                preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
                preparedStatement.setInt(7, 10);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //Get
            Lesson lesson = new Lesson();
            try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
                 ResultSet resultSet1 = preparedStatement.executeQuery()) {
                while (resultSet1.next()) {
                    lesson.setId(resultSet1.getInt("id"));
                    lesson.setNumber(resultSet1.getInt("number"));
                    lesson.setAud(resultSet1.getString("aud"));
                    lesson.setGroup(resultSet1.getString("group"));
                    lesson.setLesson(resultSet1.getString("lesson"));
                    lesson.setTeacher(resultSet1.getString("teacher"));
                    System.out.println(lesson);

                    //System.out.println("id:" + id + "\naud:" + aud + "\ngroup:" + group + "\nlesson:" + lesson1 + "\nteacher:" + teacher + "\ndate:" + date+"\n\n\n");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //Update
            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
                preparedStatement.setInt(1, 9);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }*/


    }


}

