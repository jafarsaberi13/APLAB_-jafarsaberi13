public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Menu menu = new Menu(hospital);
        menu.start();
    }
}
