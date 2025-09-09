package Game;

class Archer extends Character {
    public Archer(String name, int health, int resource) {
        super(name, health, resource);
    }

    @Override
    public void attack(Character target) {
        System.out.println("--------------------");
        if (target.isAlive()) {
            System.out.println(target.getName() + " is already dead. Attack wasted!");
            return;
        }
        if (resource >= 1) {
            System.out.println(name + " the Archer fires a swift arrow!");
            int damage = 20;
            target.takeDamage(damage);
            resource -= 1;
        } else {
            System.out.println(name + " is out of arrows!");
        }
    }
}