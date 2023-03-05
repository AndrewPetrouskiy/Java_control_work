package viewer;

import model.*;
// производим создание экземпляров всех нужных нам классов и запуск программы
public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationReceiver("Toys.txt");
        ReceiverOfToys receiverOfToys = new ReceiverOfToys(fileOperation);
        FileOperationCharity fileOperationCharity = new FileOperationCharity("Charity.txt");
        Charity charity = new Charity(receiverOfToys, fileOperationCharity);
        View view = new View(receiverOfToys, charity);
        view.run();
    }
}