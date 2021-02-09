package com.company;

// интерфейс участника

public interface Participant {
    boolean isActive(); //возвращает флаг: истина - участник активен и соревнуется, ложь - выбыл из соревнования
    void setActive(boolean flag); //установка флага активности
    ObstacleReal[] getObstacles(); //возвращает массив ПРЕПЯТСТВИЙ, которые участник может преодолевать
    String getName(); // возвращает имя участника
}
