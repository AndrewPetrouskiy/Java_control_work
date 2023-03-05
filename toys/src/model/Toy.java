package model;

//класс игрушка
public class Toy {
    // поля которые в себя принимают id который по умолчанию id = "", название игрушки, их количества и вес
    private String id = "";
    private String toyName;
    private int count;
    private int weight;

    // 2 конструктора
    public Toy(String toyName, int count, int weight) {
        this.toyName = toyName;
        this.count = count;
        this.weight = weight;
    }


    public Toy(String id, String toyName, int count, int weight) {
        this(toyName, count, weight);
        this.id = id;
    }

    // GETTERS AND SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    // переопределяем метод toString
    @Override
    public String toString() {
        return "Toys{" +
                "id ='" + id + '\'' +
                ", toyName: '" + toyName + '\'' +
                ", count: " + count +
                ", weight: " + weight +
                " grams}";
    }

}
