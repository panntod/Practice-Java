package Laundry;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Admin admin = new Admin();
        Type type = new Type();
        Transaction transaction = new Transaction();

        transaction.interact(admin, customer, type);
    }
}
