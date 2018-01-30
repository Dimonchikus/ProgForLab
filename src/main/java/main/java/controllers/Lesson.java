package main.java.controllers;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Lesson  {
    private int id;
    private int number;
    private String aud;
    private String lesson;
    private String group;
    private String teacher;


    private Connection connection;

    public Lesson(){}

    public Lesson(int id,String aud,  String group,String lesson, String teacher,int number) {
        this.id = id;
        this.number = number;
        this.aud = aud;
        this.lesson = lesson;
        this.group = group;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getAud() {

        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String toString() {
       return String.format("id : %d\nnumber : %d\naud : %s\ngroup : %s\nlesson : %s\nteacher : %s\n",id,number,aud,group,lesson,teacher );
    }
}

