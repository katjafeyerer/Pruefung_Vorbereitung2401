package src.A01_VerketteteListen;

public class Main {
    public static void main(String[] args) {

        GenericStacki gs = new GenericStacki();
        gs.insert(34);
        gs.insert(23);
        gs.insert(67);

        System.out.println("Das ist die übergebene Liste: ");
        gs.show();
    }
}
