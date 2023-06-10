package com.example.demodao.DAO;
import com.example.demodao.DAO.DAO;
import com.example.demodao.RoomData;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Класс, реализующий интерфейс DAO, используя ArrayList в качестве хранилища программ.
 * @author Щербатых О.С.
 * @version 2.0
 */
public class ListP implements DAO
{
    /**
     * Список, содержащий объекты из базы.
     */
    private List<RoomData> roomData;
    /**
     * Конструктор класса ListP, создает список объектов программ заданного размера и заполняет его случайными данными.
     *
     * @param size Размер списка объектов программ.
     */

    public ListP(int size) {

        roomData = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < size; i++) {

            RoomData roomData = new RoomData(

                    i + 1,
                    "RoomData" + (i+1),
                    "RoomData " + (i + 1),
                    i+1

            );
            this.roomData.add(roomData);
        }
    }
    /**
     * Возвращает все списки.
     *
     */
    public List<RoomData> getAllTasks()
    {
        return roomData;
    }
    /**
     * Возвращает список  с заданным условием.
     *

     */
    public List<RoomData> getTaskByWhere(String name)
    {
            return roomData;

    }

    @Override
    public List<String> getDataName() {
        return null;
    }

    /**
     * Добавляет новый список в базу.
     *
     */
    public void addTask(RoomData roomData)
    {
        this.roomData.add(roomData);
    }
    /**
     * Изменяет выбранный список из базы.
     *
     */
    public void updateTask(RoomData roomData) {

        for (int i = 0; i < this.roomData.size(); i++) {

            if (this.roomData.get(i).getId() == roomData.getId()) {

                this.roomData.set(i, roomData);

                return;

            }
        }
    }
    /**
     * Удаляет выбранный из базы список.
     *
     */
    public void deleteTask(RoomData roomData) {

        for (int i = 0; i < this.roomData.size(); i++) {

            if (this.roomData.get(i).getId() == roomData.getId()) {

                this.roomData.remove(i);

                return;

            }

        }
    }
}
