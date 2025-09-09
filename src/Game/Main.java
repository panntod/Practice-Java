package Game;

public class Main {
    public static void main(String[] args) {
        Character warrior, mage, archer;
        warrior = new Warrior("Suki", 200, 100);
        mage = new Mage("bid", 100, 10);
        archer = new Archer("lakmnu", 120, 200);

//        Character warrior = new Warrior("Grommash", 200, 100);
//        Character mage = new Mage("Jaina", 120, 150);
//        Character archer = new Archer("Sutoyo", 100, 120);

        System.out.println("\nTHE BATTLE BEGINS!");

        warrior.attack(mage);
        mage.attack(warrior);
        warrior.attack(mage);
        archer.attack(warrior);
    }
}
