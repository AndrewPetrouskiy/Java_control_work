package model;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


//Создаем класс благотворительность (Charity)
public class Charity {
    //Добавляем поля которые ссылаются на класс ReceiverOfToys, UserMapper и интерфейс FileOperation.
    private ReceiverOfToys receiver;
    private FileOperation fileOperation;

    private UserMapper mapper = new UserMapper();

    // Создаем конструкор
    public Charity(ReceiverOfToys receiver, FileOperation fileOperation) {
        this.receiver = receiver;
        this.fileOperation = fileOperation;
    }

    // добавляем массив определяющий поведение двунаправленной очереди
    ArrayDeque<Toy> charityToys = new ArrayDeque<Toy>();

    // метод возвращаем длину массива
    public int size() {
        return charityToys.size();
    }

    // метод который показывает тот элемент который мы будем вытаскивать
    public void show_first_element() {
        System.out.println(charityToys.peek());
    }

    // метод показывающий все элементы в очереди
    public void show_all_elements() {
        for (Toy item : charityToys) {

            System.out.println(item);
        }
    }

    // метод добавляет элемент в очередь
    // метод который принимает первым аргументом строку с числом которое будет сравнивать с id и 2 аргумент принимающий
    // количество игрушек которые мы будем передавать в детский дом
    // если количества игрушек которые мы передаем в аргументе больше чем количество игрушек в списке, или меньше 0,
    // то автоматически изменяется число игрушек на максимально возможные в этой партии
    // если количество игрушек станет равное 0, то мы удаляем из списка именование игрушки
    public void add_element(String num, int count) {
        List<Toy> toys = receiver.getAllToys();
        for (Toy item : toys) {
            if (item.getId().equals(num)) {
                int oldCount = item.getCount();
                if (oldCount < count || count < 0) {
                    count = oldCount;
                }
                charityToys.addFirst(new Toy(item.getToyName(), count, item.getWeight()));
                oldCount -= count;
                if (oldCount == 0) {
                    toys.remove(item);
                    break;
                } else {
                    item.setCount(oldCount);
                }
            }
        }
        receiver.saveNotes(toys);
    }

    // метод который отправляет игрушку в файл
    public void send_toy() {
        if (size() != 0) {
            Toy toy = charityToys.poll();
            List<Toy> listToys = new ArrayList<>();
            listToys.add(toy);
            List<String> lines = new ArrayList<>();
            for (Toy item : listToys) {
                lines.add(mapper.map2(item));
            }
            fileOperation.saveAllLines(lines);
        }
    }

    // метод который считывает с файла все данные и с помощью map парсит данные в лист
    public List<Toy> getAllSentToys() {
        List<String> lines = fileOperation.readAllLines();
        List<Toy> toys = new ArrayList<>();
        for (String line : lines) {
            toys.add(mapper.map2(line));
        }
        return toys;
    }

    // показывает все элементы которые мы отправили в дет дом из файла
    public void ShowAllSentToys() {
        List<Toy> toys = getAllSentToys();
        toys.forEach(i -> System.out.println(i + "\n"));
    }

}
