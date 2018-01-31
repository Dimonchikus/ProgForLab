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
import javax.lang.model.type.NullType;
import javax.swing.SingleSelectionModel;
import javax.swing.plaf.nimbus.State;

import static java.text.SimpleDateFormat.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

    private boolean ifSaved = false;
    private String currentLesson = "1";
    private  java.util.Date data = new java.util.Date();
    private java.time.LocalDate localDate = LocalDate.now();
    private ObservableList<String> list219 = FXCollections.observableArrayList();
    private ObservableList<String> list219a = FXCollections.observableArrayList();
    private ObservableList<String> list221 = FXCollections.observableArrayList();
    private ObservableList<String> list223 = FXCollections.observableArrayList();
    private ObservableList<String> list223a = FXCollections.observableArrayList();
    private ObservableList<String> list224 = FXCollections.observableArrayList();
    private ObservableList<String> list226 = FXCollections.observableArrayList();
    private ObservableList<String> list230 = FXCollections.observableArrayList();
    private ObservableList<String> classes = FXCollections.observableArrayList();
    private ObservableList<ObservableList<String>> list = FXCollections.observableArrayList();


    @FXML
    public void onSelect(ActionEvent a) {
        CheckBox rad = (CheckBox) a.getSource();
        if (rad.isSelected())
            for (ObservableList<String> elem : list)
                elem.add(rad.getText());
        else
            for (ObservableList<String> elem : list)
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


    public boolean check() {
        String error = "";
        if (classesBox.getSelectionModel().isEmpty())
            error = "Виберіть пару\n";
       // if (date.getValue() == null)
      //      error += "Виберіть дату\n";
        if (!error.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setContentText(error);
            alert.showAndWait();
            return false;
        }
        return true;
    }

    String[] auds = new String[]{"219", "219a", "221", "223", "223a", "224", "226", "230"};


    private Lesson[] lessons1 = new Lesson[8];
    private Lesson[] lessons2 = new Lesson[8];
    private Lesson[] lessons3 = new Lesson[8];
    private Lesson[] lessons4 = new Lesson[8];
    private Lesson[] lessons5 = new Lesson[8];
    private ArrayList<Lesson[]> lessons = new ArrayList<>();


    @FXML
    public void onSelectLesson(ActionEvent a) {
        if(((ComboBox<String>) a.getSource()).getSelectionModel().getSelectedItem()!=null) {
            String s = ((ComboBox<String>) a.getSource()).getSelectionModel().getSelectedItem();

            if (!currentLesson.equals(s)) {


                lessons.get(Integer.valueOf(currentLesson) - 1)[0].setAud("219");
                lessons.get(Integer.valueOf(currentLesson) - 1)[0].setLesson(a219.getText());
                lessons.get(Integer.valueOf(currentLesson) - 1)[0].setGroup(g219.getText());
                if (c219.getSelectionModel().getSelectedItem() != null)
                    lessons.get(Integer.valueOf(currentLesson) - 1)[0].setTeacher(c219.getSelectionModel().getSelectedItem());
                else
                    lessons.get(Integer.valueOf(currentLesson) - 1)[0].setTeacher(c219.getPromptText());
                lessons.get(Integer.valueOf(currentLesson) - 1)[0].setNumber(Integer.valueOf(currentLesson));


                lessons.get(Integer.valueOf(currentLesson) - 1)[1].setAud("219a");
                lessons.get(Integer.valueOf(currentLesson) - 1)[1].setLesson(a219a.getText());
                lessons.get(Integer.valueOf(currentLesson) - 1)[1].setGroup(g219a.getText());
                if (c219a.getSelectionModel().getSelectedItem() != null)
                    lessons.get(Integer.valueOf(currentLesson) - 1)[1].setTeacher(c219a.getSelectionModel().getSelectedItem());
                else
                    lessons.get(Integer.valueOf(currentLesson) - 1)[1].setTeacher(c219a.getPromptText());
                lessons.get(Integer.valueOf(currentLesson) - 1)[1].setNumber(Integer.valueOf(currentLesson));


                lessons.get(Integer.valueOf(currentLesson) - 1)[2].setAud("221");
                lessons.get(Integer.valueOf(currentLesson) - 1)[2].setLesson(a221.getText());
                lessons.get(Integer.valueOf(currentLesson) - 1)[2].setGroup(g221.getText());
                if (c221.getSelectionModel().getSelectedItem() != null)
                    lessons.get(Integer.valueOf(currentLesson) - 1)[2].setTeacher(c221.getSelectionModel().getSelectedItem());
                else
                    lessons.get(Integer.valueOf(currentLesson) - 1)[2].setTeacher(c221.getPromptText());
                lessons.get(Integer.valueOf(currentLesson) - 1)[2].setNumber(Integer.valueOf(currentLesson));


                lessons.get(Integer.valueOf(currentLesson) - 1)[3].setAud("223");
                lessons.get(Integer.valueOf(currentLesson) - 1)[3].setLesson(a223.getText());
                lessons.get(Integer.valueOf(currentLesson) - 1)[3].setGroup(g223.getText());
                if (c223.getSelectionModel().getSelectedItem() != null)
                    lessons.get(Integer.valueOf(currentLesson) - 1)[3].setTeacher(c223.getSelectionModel().getSelectedItem());
                else
                    lessons.get(Integer.valueOf(currentLesson) - 1)[3].setTeacher(c223.getPromptText());
                lessons.get(Integer.valueOf(currentLesson) - 1)[3].setNumber(Integer.valueOf(currentLesson));

                lessons.get(Integer.valueOf(currentLesson) - 1)[4].setAud("223a");
                lessons.get(Integer.valueOf(currentLesson) - 1)[4].setLesson(a223a.getText());
                lessons.get(Integer.valueOf(currentLesson) - 1)[4].setGroup(g223a.getText());
                if (c223a.getSelectionModel().getSelectedItem() != null)
                    lessons.get(Integer.valueOf(currentLesson) - 1)[4].setTeacher(c223a.getSelectionModel().getSelectedItem());
                else
                    lessons.get(Integer.valueOf(currentLesson) - 1)[4].setTeacher(c223a.getPromptText());
                lessons.get(Integer.valueOf(currentLesson) - 1)[4].setNumber(Integer.valueOf(currentLesson));

                lessons.get(Integer.valueOf(currentLesson) - 1)[5].setAud("224");
                lessons.get(Integer.valueOf(currentLesson) - 1)[5].setLesson(a224.getText());
                lessons.get(Integer.valueOf(currentLesson) - 1)[5].setGroup(g224.getText());
                if (c224.getSelectionModel().getSelectedItem() != null)
                    lessons.get(Integer.valueOf(currentLesson) - 1)[5].setTeacher(c224.getSelectionModel().getSelectedItem());
                else
                    lessons.get(Integer.valueOf(currentLesson) - 1)[5].setTeacher(c224.getPromptText());
                lessons.get(Integer.valueOf(currentLesson) - 1)[5].setNumber(Integer.valueOf(currentLesson));

                lessons.get(Integer.valueOf(currentLesson) - 1)[6].setAud("226");
                lessons.get(Integer.valueOf(currentLesson) - 1)[6].setLesson(a226.getText());
                lessons.get(Integer.valueOf(currentLesson) - 1)[6].setGroup(g226.getText());
                if (c226.getSelectionModel().getSelectedItem() != null)
                    lessons.get(Integer.valueOf(currentLesson) - 1)[6].setTeacher(c226.getSelectionModel().getSelectedItem());
                else
                    lessons.get(Integer.valueOf(currentLesson) - 1)[6].setTeacher(c226.getPromptText());
                lessons.get(Integer.valueOf(currentLesson) - 1)[6].setNumber(Integer.valueOf(currentLesson));

                lessons.get(Integer.valueOf(currentLesson) - 1)[7].setAud("230");
                lessons.get(Integer.valueOf(currentLesson) - 1)[7].setLesson(a230.getText());
                lessons.get(Integer.valueOf(currentLesson) - 1)[7].setGroup(g230.getText());
                if (c230.getSelectionModel().getSelectedItem() != null)
                    lessons.get(Integer.valueOf(currentLesson) - 1)[7].setTeacher(c230.getSelectionModel().getSelectedItem());
                else
                    lessons.get(Integer.valueOf(currentLesson) - 1)[7].setTeacher(c230.getPromptText());
                lessons.get(Integer.valueOf(currentLesson) - 1)[7].setNumber(Integer.valueOf(currentLesson));
                a219.setText(lessons.get(Integer.valueOf(s) - 1)[0].getLesson());
                g219.setText(lessons.get(Integer.valueOf(s) - 1)[0].getGroup());
                c219.setPromptText(lessons.get(Integer.valueOf(s) - 1)[0].getTeacher());

                a219a.setText(lessons.get(Integer.valueOf(s) - 1)[1].getLesson());
                g219a.setText(lessons.get(Integer.valueOf(s) - 1)[1].getGroup());
                c219a.setPromptText(lessons.get(Integer.valueOf(s) - 1)[1].getTeacher());

                a221.setText(lessons.get(Integer.valueOf(s) - 1)[2].getLesson());
                g221.setText(lessons.get(Integer.valueOf(s) - 1)[2].getGroup());
                c221.setPromptText(lessons.get(Integer.valueOf(s) - 1)[2].getTeacher());

                a223.setText(lessons.get(Integer.valueOf(s) - 1)[3].getLesson());
                g223.setText(lessons.get(Integer.valueOf(s) - 1)[3].getGroup());
                c223.setPromptText(lessons.get(Integer.valueOf(s) - 1)[3].getTeacher());

                a223a.setText(lessons.get(Integer.valueOf(s) - 1)[4].getLesson());
                g223a.setText(lessons.get(Integer.valueOf(s) - 1)[4].getGroup());
                c223a.setPromptText(lessons.get(Integer.valueOf(s) - 1)[4].getTeacher());

                a224.setText(lessons.get(Integer.valueOf(s) - 1)[5].getLesson());
                g224.setText(lessons.get(Integer.valueOf(s) - 1)[5].getGroup());
                c224.setPromptText(lessons.get(Integer.valueOf(s) - 1)[5].getTeacher());

                a226.setText(lessons.get(Integer.valueOf(s) - 1)[6].getLesson());
                g226.setText(lessons.get(Integer.valueOf(s) - 1)[6].getGroup());
                c226.setPromptText(lessons.get(Integer.valueOf(s) - 1)[6].getTeacher());

                a230.setText(lessons.get(Integer.valueOf(s) - 1)[7].getLesson());
                g230.setText(lessons.get(Integer.valueOf(s) - 1)[7].getGroup());
                c230.setPromptText(lessons.get(Integer.valueOf(s) - 1)[7].getTeacher());
            }

            currentLesson = classesBox.getSelectionModel().getSelectedItem();
        }
    }

    private String URL = "jdbc:mysql://localhost:3306/bd";
    private String USERNAME = "Dimonchikus";
    private String PASSWORD = "Misumuruvey196519791999";

    private final String INSERT_INTO = "INSERT INTO bd.table VALUES(?,?,?,?,?,?,?)";
    private final String GET_ALL = "SELECT * FROM bd.table";
    private final String DELETE = "DELETE  FROM bd.table where id = ?";

    @FXML
    public void onOk(ActionEvent a) throws SQLException{

        if (check()) {
            Date date1 = Date.valueOf(date.getValue());
            ifSaved = true;
            try {
                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);
            } catch (SQLException e) {
                System.out.println("Error");
            }
            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
         //           preparedStatement.setInt(1, );
                        int i = 0;
//                        ResultSet tableKeys = preparedStatement.getGeneratedKeys();
  //                      tableKeys.next();
    //                    int preparedStatement.getGeneratedKeys().getInt(1) = tableKeys.getInt(1);
                        preparedStatement.setInt(1, 0);
                        preparedStatement.setString(2, auds[i++]);
                        preparedStatement.setString(3, g219.getText());
                        preparedStatement.setString(4, a219.getText());
                        if(c219.getSelectionModel().isEmpty())
                            preparedStatement.setString(5, "");
                        else preparedStatement.setString(5, c219.getSelectionModel().getSelectedItem());
                        preparedStatement.setDate(6, date1);
                        preparedStatement.setInt(7, Integer.parseInt(classesBox.getSelectionModel().getSelectedItem()));
                        preparedStatement.execute();

                        preparedStatement.setInt(1, 0);
                        preparedStatement.setString(2, auds[i++]);
                        preparedStatement.setString(3, g219a.getText());
                        preparedStatement.setString(4, a219a.getText());
                        if(c219a.getSelectionModel().isEmpty())
                            preparedStatement.setString(5, "");
                        else preparedStatement.setString(5, c219a.getSelectionModel().getSelectedItem());
                        preparedStatement.setDate(6, date1);
                        preparedStatement.setInt(7, Integer.parseInt(classesBox.getSelectionModel().getSelectedItem()));
                        preparedStatement.execute();

                        preparedStatement.setInt(1,0);
                        preparedStatement.setString(2, auds[i++]);
                        preparedStatement.setString(3, a221.getText());
                        preparedStatement.setString(4, a221.getText());
                        if(c221.getSelectionModel().isEmpty())
                             preparedStatement.setString(5, "");
                        else preparedStatement.setString(5, c221.getSelectionModel().getSelectedItem());
                        preparedStatement.setDate(6, date1);
                        preparedStatement.setInt(7, Integer.parseInt(classesBox.getSelectionModel().getSelectedItem()));
                        preparedStatement.execute();

                        preparedStatement.setInt(1, 0);
                        preparedStatement.setString(2, auds[i++]);
                        preparedStatement.setString(3, g223.getText());
                        preparedStatement.setString(4, a223.getText());
                        if(c223.getSelectionModel().isEmpty())
                            preparedStatement.setString(5, "");
                        else preparedStatement.setString(5, c223.getSelectionModel().getSelectedItem());                      ;
                        preparedStatement.setDate(6, date1);
                        preparedStatement.setInt(7, Integer.parseInt(classesBox.getSelectionModel().getSelectedItem()));
                        preparedStatement.execute();

                        preparedStatement.setInt(1, 0);
                        preparedStatement.setString(2, auds[i++]);
                        preparedStatement.setString(3, g223a.getText());
                        preparedStatement.setString(4, a223a.getText());
                        if(c223a.getSelectionModel().isEmpty())
                            preparedStatement.setString(5, "");
                        else preparedStatement.setString(5, c223a.getSelectionModel().getSelectedItem());
                        preparedStatement.setDate(6, date1);
                        preparedStatement.setInt(7, Integer.parseInt(classesBox.getSelectionModel().getSelectedItem()));
                        preparedStatement.execute();

                        preparedStatement.setInt(1, 0);
                        preparedStatement.setString(2, auds[i++]);
                        preparedStatement.setString(3, g224.getText());
                        preparedStatement.setString(4, a224.getText());
                        if(c224.getSelectionModel().isEmpty())
                        preparedStatement.setString(5, "");
                        else preparedStatement.setString(5, c224.getSelectionModel().getSelectedItem());
                        preparedStatement.setInt(7, Integer.parseInt(classesBox.getSelectionModel().getSelectedItem()));
                        preparedStatement.execute();

                        preparedStatement.setInt(1,0);
                        preparedStatement.setString(2, auds[i++]);
                        preparedStatement.setString(3, g226.getText());
                        preparedStatement.setString(4, a226.getText());
                        if(c226.getSelectionModel().isEmpty())
                        preparedStatement.setString(5,"");
                        else preparedStatement.setString(5, c226.getSelectionModel().getSelectedItem());
                        preparedStatement.setDate(6, date1);
                        preparedStatement.setInt(7, Integer.parseInt(classesBox.getSelectionModel().getSelectedItem()));
                        preparedStatement.execute();

                        preparedStatement.setInt(1,0);
                        preparedStatement.setString(2, auds[i++]);
                        preparedStatement.setString(3, g230.getText());
                        preparedStatement.setString(4, a230.getText());
                        if(c230.getSelectionModel().isEmpty())
                        preparedStatement.setString(5, "");
                        else preparedStatement.setString(5, c230.getSelectionModel().getSelectedItem());
                        preparedStatement.setDate(6, date1);
                        preparedStatement.setInt(7, Integer.parseInt(classesBox.getSelectionModel().getSelectedItem()));
                        preparedStatement.execute();


                } catch (SQLException e) {
                    e.printStackTrace();
                }

                //Get
              // Lesson lesson = new Lesson();
               // try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
                //     ResultSet resultSet1 = preparedStatement.executeQuery()) {
                  //  while (resultSet1.next()) {
                   //     lesson.setId(resultSet1.getInt("id"));
                  //      lesson.setNumber(resultSet1.getInt("number"));
                  //      lesson.setAud(resultSet1.getString("aud"));
                  ////      lesson.setGroup(resultSet1.getString("group"));
                  //      lesson.setLesson(resultSet1.getString("lesson"));
                   //     lesson.setTeacher(resultSet1.getString("teacher"));
                    //    System.out.println(lesson);

                        //System.out.println("id:" + id + "\naud:" + aud + "\ngroup:" + group + "\nlesson:" + lesson1 + "\nteacher:" + teacher + "\ndate:" + date+"\n\n\n");
           //         }
            //    } catch (SQLException e) {
            //        e.printStackTrace();
             //   }
//
                //Update
            /*try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
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
        localDate = date.getValue();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.add(list219);
        list.add(list219a);
        list.add(list221);
        list.add(list223);
        list.add(list223a);
        list.add(list224);
        list.add(list226);
        list.add(list230);
        classes.addAll("1", "2", "3", "4", "5");
        classesBox.setItems(classes);
       // classesBox.setPromptText("1");
        lessons.add(lessons1);
        lessons.add(lessons2);
        lessons.add(lessons3);
        lessons.add(lessons4);
        lessons.add(lessons5);
        for(Lesson[] elem : lessons)
            for(int i = 0; i < 8 ; i++)
                elem[i] = new Lesson();
    }


     /*   public void writeToFile (String s) throws IOException {
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
    */


    @FXML
    public void onSelectClasses(ActionEvent a) throws IOException {

    }

    public void onChangeDate(ActionEvent actionEvent) {

      /*  if (!ifSaved) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setContentText("Спочатку збережіть поточну пару");
            alert.showAndWait();
            //date.setValue(localDate);
        }
*/
        localDate = date.getValue();
    }
}
            

        


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


        
        