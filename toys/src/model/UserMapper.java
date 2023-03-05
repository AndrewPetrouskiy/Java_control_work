package model;
// класс UserMapper который нужен для парсинга данных
public class UserMapper {
    public String map(Toy toy) {
        return String.format("%s;%s;%s;%s", toy.getId(),
                toy.getToyName(), toy.getCount(), toy.getWeight());
    }
    public String map2(Toy toy) {
        return String.format("%s;%s;%s", toy.getToyName(), toy.getCount(), toy.getWeight());
    }

    public Toy map(String line) {
        String[] lines = line.split(";");
        int count = Integer.parseInt(lines[2]);
        int weight = Integer.parseInt(lines[3]);
        return new Toy(lines[0], lines[1], count, weight);
    }
    public Toy map2(String line) {
        String[] lines = line.split(";");
        int count = Integer.parseInt(lines[1]);
        int weight = Integer.parseInt(lines[2]);
        return new Toy(lines[0], count, weight);
    }


}
