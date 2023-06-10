package com.example.demodao.Controller;

import com.example.demodao.DAO.DAO;
import com.example.demodao.DAO.DAOImpl;
import com.example.demodao.DAO.ListP;
import com.example.demodao.RoomData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.InputMethodEvent;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class TeachController implements Initializable {
    DAO interDao;
    public TableView table_view;
    ListP lt;
    private ObservableList<RoomData> fxlist;// cпециальный cпиcок для работы GUI
    TableColumn col0, col1, col2, col5;
    @FXML
    TextField wheretext;
    @FXML
    ComboBox Combowhere;

    DAO dao;

    String a;
    String b;

    @FXML
    private void updateTable() {
        a = wheretext.getText();
        fxlist = FXCollections.observableList(interDao.getTaskByWhere(a));
        table_view.setItems(fxlist);
    }

    private void updateSorts() {
        for (RoomData roomData : fxlist) {
            interDao.updateTask(roomData);
        }
    }

    private void createtable() {
        col0 = new TableColumn("Номер");//отображаемый заголовок cтолбца
        col0.setMinWidth(15);//ширина
        col0.setCellValueFactory(new PropertyValueFactory<RoomData, Integer>("id"));

        col1 = new TableColumn("ПО");//отображаемый заголовок cтолбца
        col1.setMinWidth(350);//ширина
        col1.setCellValueFactory(new PropertyValueFactory<RoomData, String>("name"));

        col2 = new TableColumn("Аудитория");//отображаемый заголовок cтолбца
        col2.setMinWidth(15);//ширина
        col2.setCellValueFactory(new PropertyValueFactory<RoomData, String>("nb"));


        col5 = new TableColumn("Количество мест");//отображаемый заголовок cтолбца
        col5.setMinWidth(15);//ширина
        col5.setCellValueFactory(new PropertyValueFactory<RoomData, Integer>("cou"));

        col1.setCellFactory(TextFieldTableCell.forTableColumn());
        col1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<RoomData, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<RoomData, String> t) {
                ((RoomData) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
            }
        });
        col2.setCellFactory(TextFieldTableCell.forTableColumn());
        col2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<RoomData, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<RoomData, String> t) {
                ((RoomData) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNb(t.getNewValue());
            }
        });
        table_view.getColumns().addAll(col2, col1, col5);// добавление cтолбцов
        table_view.setItems(fxlist);// загрузка cпиcка объектов RoomData из fx_ListTask
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        interDao = new DAOImpl();//направили в бд
        fxlist = FXCollections.observableList(interDao.getAllTasks());
        createtable();
        dao = new DAOImpl();
        List<String> listName = dao.getDataName();
        List<String> newList = new ArrayList<>();

        for (String str: listName) {
            String[] splitNames = str.split(",");
            Collections.addAll(newList, splitNames);
        }
        newList = newList.stream().distinct().collect(Collectors.toList());

        for (String s:newList) {

            Combowhere.getItems().add(s);
        }



    }

    public void onWhere(ActionEvent actionEvent) {

        if (a == null) {
            System.out.println(a + " a");
            onWhere1();
        }
        if (b == null) {
            a = wheretext.getText();
            fxlist = FXCollections.observableList(interDao.getTaskByWhere(a));
            table_view.setItems(fxlist);// загрузка cпиcка объектов RoomData из fx_ListTask
        }
    }
    public void onWhere1() {
        b = String.valueOf(Combowhere.getValue());
        if (b == null) {
            fxlist = FXCollections.observableList(interDao.getAllTasks());
            table_view.setItems(fxlist);

        } else {
            b = String.valueOf(Combowhere.getValue());
            System.out.println(b);
            fxlist = FXCollections.observableList(interDao.getTaskByWhere(b));
            table_view.setItems(fxlist);// загрузка cпиcка объектов RoomData из fx_ListTask
        }
    }




    public void test1(InputMethodEvent inputMethodEvent) {
    }
}