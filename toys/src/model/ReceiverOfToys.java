package model;

import java.util.ArrayList;
import java.util.List;

// класс который принимает от граждан игрушки на благотворительность
public class ReceiverOfToys {
    // создаем поля
    private UserMapper mapper = new UserMapper();
    private FileOperation fileOperation;

    // Создаем конструкор
    public ReceiverOfToys(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    // метод которые парсит данные с файла
    public List<Toy> getAllToys() {
        List<String> lines = fileOperation.readAllLines();
        List<Toy> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(mapper.map(line));
        }
        return notes;
    }

    // метод который считывает размер списка
    public int size() {
        List<Toy> toys = getAllToys();
        return toys.size();
    }

    // метод который показывает все игрушки которые пожертвовали люди
    public void showAllToys() {
        List<Toy> toys = getAllToys();
        toys.forEach(i -> System.out.println(i + "\n"));
    }

    // метод который позволяет добавить новую игрушку в список и дать ему id
    public String createToy(Toy toy) {
        List<Toy> toys = getAllToys();
        int max = 1;
        if (size() != 0) {
            for (Toy item : toys) {
                String id = String.format("%d", max);
                item.setId(id);
                max++;
            }
        }
        int newId = max;
        String id = String.format("%d", newId);
        toy.setId(id);
        toys.add(toy);
        saveNotes(toys);
        return id;
    }

    // метод которые через fileOperation записывает данные в файл
    public void saveNotes(List<Toy> toys) {
        List<String> lines = new ArrayList<>();
        for (Toy item : toys) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }
}

