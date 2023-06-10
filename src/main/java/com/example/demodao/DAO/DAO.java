package com.example.demodao.DAO;

import com.example.demodao.RoomData;

import java.util.List;
/**
 * Интерфейс DAO для работы с задачами проекта.
 * @author Щербатых О.С.
 * @version 2.0
 */
public interface DAO {
    /**
     * Возвращает список всех задач.
     *
     * @return список всех задач
     */
    List<RoomData> getAllTasks();
    /**
     * Возвращает список задач по имени.
     *
     * @param name имя задачи
     * @return список задач с указанным параметром
     */
    List<RoomData> getTaskByWhere(String name);

    List<String> getDataName();
    /**
     * Добавляет новую задачу.
     *
     * @param roomData новая задача
     */
    void addTask(RoomData roomData);
    /**
     * Обновляет существующую задачу.
     *
     * @param roomData задача для обновления
     */
    void updateTask(RoomData roomData);
    /**
     * Удаляет задачу по указанному идентификатору.
     *
     */
    void deleteTask(RoomData roomData);
}
