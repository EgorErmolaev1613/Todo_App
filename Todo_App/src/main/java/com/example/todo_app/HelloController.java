package com.example.todo_app;

import java.sql.ResultSet;
import java.sql.SQLException;

import Animations.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Button addTaskButton;

    @FXML
    private Button printTasksButton;

    @FXML
    private TextField toDoField;

    @FXML
    private Button clear;

    @FXML
    private TextArea textArea;


    @FXML
    void initialize() {
            addTaskButton.setOnAction(event -> {
                String toDo = toDoField.getText().trim();
                if (!toDo.equals("")) {
                    DataBaseHandler dbHandler = new DataBaseHandler();
                    dbHandler.addTask(toDo);
                    toDoField.setText("");
                }else {
                   Shake shakeToDoField = new Shake (toDoField);
                   shakeToDoField.playAnimation();
                }

            });


            printTasksButton.setOnAction(event -> {
                DataBaseHandler dbHandler = new DataBaseHandler();
                String task = "",temp;
                int counter = 1;
                try {
                    ResultSet result = dbHandler.getAllTasks();
                    while (result.next()) {
                        temp = "Задание №" + counter + "-" + result.getString(Const.TASK) + "\n";
                        task+=temp;
                        counter++;
                    textArea.setText(task);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });

            clear.setOnAction(event -> {
                DataBaseHandler dbHandler = new DataBaseHandler();

                dbHandler.clearTasks();
            textArea.setText(" ");
            });
    }
}