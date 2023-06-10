package com.example.demodao.DAO;

import com.example.demodao.DAO.DAO;
import com.example.demodao.RoomData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 Класс, реализующий интерфейс DAO для работы с базой данных
 @author Щербатых О.С.
 @version 2.0
*/
public class DAOImpl implements DAO
{

    /**
    Поле, хранящее соединение с базой данных
    */
    private Connection conn;
     /**
    Конструктор класса - устанавливает соединение с базой данных и создает таблицу, если таковой еще не существует
   */
    public DAOImpl()
    {
        try
        {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/test", "11", "11");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Ttable " +
                    "(id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                    "nb VARCHAR(20)," +
                    "name VARCHAR(255)," +
                    "cou INTEGER AUTO_INCREMENT)");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /**
    Метод, возвращающий список всех записей из таблицы Ttable
    @return список объектов класса RoomData, содержащий информацию из таблицы Ttable
    */
    @Override
    public List<RoomData> getAllTasks()
    {
        List<RoomData> roomData = new ArrayList<>();
        try
        {
            /**Получение всех записей из таблицы Ttable*/
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Ttable");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                RoomData prog = new RoomData(rs.getInt("id"),
                        rs.getString("nb"),
                        rs.getString("name"),
                        rs.getInt("cou"));

                roomData.add(prog);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return roomData;
    }
   /**
    Метод, возвращающий список записей из таблицы Ttable, подходящих под указанный критерий поиска
    @param name - критерий поиска (искомое имя или nb)
     @return список объектов класса RoomData, удовлетворяющих критерию поиска
    */
    @Override
    public List<RoomData> getTaskByWhere(String name)
    {
        List<RoomData> roomData = new ArrayList<>();
        try
        {
            //Выборка записей из таблицы Ttable, удовлетворяющих заданному критерию поиска
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Ttable WHERE name like '%" + name +"%' or nb like '%" + name +"%' ");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
               RoomData prog = new RoomData(rs.getInt("id"),
                        rs.getString("nb"),
                        rs.getString("name"),
                        rs.getInt("cou"));
                // Добавление объекта класса RoomData в список
               roomData.add(prog);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return roomData;
    }

    @Override
    public List<String> getDataName() {
        List<String> roomData = new ArrayList<>();
        try
        {
            //Выборка записей из таблицы Ttable, удовлетворяющих заданному критерию поиска
            PreparedStatement ps = conn.prepareStatement("SELECT name FROM Ttable");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                String prog = rs.getString("name");

                // Добавление объекта класса RoomData в список
                roomData.add(prog);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return roomData;
    }

    /**
    Метод, добавляющий новую запись в таблицу Ttable
    @param roomData - объект класса RoomData, содержащий информацию о новой записи
    */
    @Override
    public void addTask(RoomData roomData)
    {
        try
        {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Ttable (nb,name,cou) VALUES (?,?,?)");
            ps.setString(1, roomData.getNb());
            ps.setString(2, roomData.getName());
            ps.setInt(3, roomData.getcou());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    /**
    Метод, обновляющий запись в таблице Ttable
    @param roomData - объект класса RoomData, содержащий информацию для обновления записи
    */
    @Override
    public void updateTask(RoomData roomData)
    {
        try
        {
            // Обновление записи в таблице Ttable по ее идентификатору
            PreparedStatement ps = conn.prepareStatement("UPDATE Ttable SET nb=?, name=?, cou=? WHERE id = ?");
            ps.setString(1, roomData.getNb());
            ps.setString(2, roomData.getName());
            ps.setInt(3, roomData.getcou());
            ps.setInt(4, roomData.getId());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
     /**
    Метод, удаляющий запись из таблицы Ttable по ее идентификатору
    */
    @Override
    public void deleteTask(RoomData roomData)
    {
        try
        {
            // Удаление записи из таблицы Ttable по ее идентификатору
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Ttable WHERE id = ?");
            ps.setInt(1, roomData.getId());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
