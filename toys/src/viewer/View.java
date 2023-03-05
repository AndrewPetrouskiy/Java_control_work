package viewer;

import model.Charity;
import model.ReceiverOfToys;
import model.Toy;

import java.util.Scanner;

// класс View нужен нам для работы с клиентом
public class View {


    private ReceiverOfToys receiver;
    private Charity prizes;

    public View(ReceiverOfToys receiver, Charity prizes) {
        this.receiver = receiver;
        this.prizes = prizes;
    }

    // метод нужен для работы с клиентом как нитерфейс
    public void run() {
        System.out.println("Hello. I welcome you to my gift's charity application");
        try {
            while (true) {
                // через while мы будем пользоваться программой до тех, пор пока не прервем ее
                // если в файле нет не одной записи на считывание, то прошу у клиента внести первую запись
                // (принести 1 игрушку) если клиент нажмет 1, то он добавит новую игрушку, а если 2, то выйдет из программы
                if (receiver.size() == 0) {
                    System.out.println("You don't have any toys in your charity list. Please add the first toy");
                    int command = number("Please enter that do you want to do.\n" +
                            "enter 1: to give a toy to our charitable organization,\nenter 2: to exit the application");
                    if (command == 1) {
                        String toyName = prompt("Enter a toy's Name: ");
                        int count = number("Enter a toys' number : ");
                        int weight = number("Enter a weight of toy: ");
                        receiver.createToy(new Toy(toyName, count, weight));
                        receiver.showAllToys();
                    }
                    if (command == 2) {
                        System.out.println("Thank you that you use my little application. Bye - Bye");
                        break;
                    }
                    if (command > 2 || command < 1) {
                        System.out.println("You entered incorrect number, try again");
                        continue;

                    }
                }
                //тут я прошу чтобы клиент выбрал один из вариантов
                //1 - добавить игрушку
                //2 - посмотреть все игрушки которые принесли люди для пожертвования
                //3 - Подарить игрушки и подготовить к отправке в детский дом
                //4 - отправить игрушку из очереди в детский дом
                //5 - показать игрушки готовые к отправке в детский дом
                //6 - показать все игрушки, которые мы уже отправили в дет дом
                //7 - прервать использование программы
                int command = number("Please enter that do you want to do.\n" +
                        "enter 1: to give a toy for our charitable organization,\n" +
                        "enter 2: to show all given toys to our charitable organization,\n" +
                        "enter 3: to donate the toy to  poor children,\nenter 4: to send the donated toy,\n" +
                        "enter 5: to show all toys ready to sent,\n" +
                        "enter 6: to show all sent toys,\nenter 7: to exit the application\n");

                if (command == 7) {
                    System.out.println("Thank you that you use my little application. Bye - Bye");
                    break;
                }

                if (command == 1) {
                    String toyName = prompt("Enter a toy's Name: ");
                    int count = number("Enter a toys' number : ");
                    int weight = number("Enter a weight of toy: ");
                    receiver.createToy(new Toy(toyName, count, weight));
                }
                if (command == 2) {
                    receiver.showAllToys();
                }
                if (command == 3) {
                    receiver.showAllToys();
                    String num = prompt("Enter the toy id, which you want to send to children");
                    int toyNumbers = number("Please enter how many toys do you want to send to children");
                    prizes.add_element(num, toyNumbers);

                }
                if (command == 4) {
                    prizes.show_first_element();
                    prizes.send_toy();
                    System.out.println("Sent");
                }
                if (command == 5) {
                    prizes.show_all_elements();
                    System.out.println("Toys are ready to sent");
                }
                if (command == 6) {
                    System.out.println("These toys were to sent for poor children");
                    prizes.ShowAllSentToys();
                }

                if (command > 7 || command < 1) {
                    System.out.println("You entered incorrect number, try again");
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("AAAAA It's a trap " + e.getMessage());
        }
    }

    // методы для считывания с консоли данных
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private int number(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextInt();
    }


}

