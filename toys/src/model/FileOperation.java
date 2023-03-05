package model;

import java.util.List;
// создаем интерфайс работы с файлом
public interface FileOperation {
    List<String> readAllLines();

    void saveAllLines(List<String> lines);
}
