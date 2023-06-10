package com.example.demodao;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 * Класс RoomData
@author Щербатых О.С.
@version 2.0
        */
public class RoomData {
     /**
    Поле, хранящее идентификатор записи
    */
    private SimpleIntegerProperty id;
    /**
     Поле, хранящее значение поля nb записи
     */
    private SimpleStringProperty nb;
    /**
     Поле, хранящее значение поля name записии
     */
    private SimpleStringProperty name;
    /**
     Поле, хранящее значение поля cou записи
     */
    private SimpleIntegerProperty cou;

    public RoomData() {
    }

    /**
    Конструктор класса RoomData
    @param id - идентификатор записи
    @param nb - значение поля nb записи
    @param name - значение поля name записи
    @param cou - значение поля cou записи
    */


    public RoomData(int id, String nb, String name, int cou) {
        this.id= new SimpleIntegerProperty(id);
        this.nb = new SimpleStringProperty(nb);
        this.name = new SimpleStringProperty(name);
        this.cou = new SimpleIntegerProperty(cou);
    /**
        Геттер для поля id
     @return значение поля id
    */
    }
    public int getId() {
        return id.get();
    }
     /**
    Геттер для свойства id
     @return объект SimpleIntegerProperty, представляющий свойство id
    */
    public SimpleIntegerProperty idProperty() {
        return id;
    }
  /**
    Сеттер для поля id
    @param id - новое значение поля id
    */
    public void setId(int id) {
        this.id.set(id);
    }
     /**
    Геттер для поля name
     @return значение поля name
    */
    public String getName() {
        return name.get();
    }
   /**
    Геттер для свойства name
     @return объект SimpleStringProperty, представляющий свойство name
   */
    public SimpleStringProperty nameProperty() {
        return name;
    }
 /**
    Сеттер для поля name
    @param name - новое значение поля name
    */
    public void setName(String name) {
        this.name.set(name);
    }
  /**
    Геттер для поля nb
     @return значение поля nb
    */
    public String getNb() {
        return nb.get();
    }
  /**
    Геттер для свойства nb
     @return объект SimpleStringProperty, представляющий свойство nb
    */
    public SimpleStringProperty nbProperty() {
        return nb;
    }
    /**
    Сеттер для поля nb
    @param nb - новое значение поля nb
    */
    public void setNb(String nb) {
        this.nb.set(nb);
    }
   /**
    Геттер для поля cou
     @return значение поля cou
    */
    public int getcou() {
        return cou.get();
    }
    /**
    Геттер для свойства cou
     @return объект SimpleIntegerProperty, представляющий свойство cou
    */
    public SimpleIntegerProperty couProperty() {
        return cou;
    }
    /**
    Сеттер для поля cou
    @param cou - новое значение поля cou
    */
    public void setcou(int cou) {
        this.cou.set(cou);
    }

}
