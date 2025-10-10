package Project.Game;

class Warrior extends Character {
    public Warrior(String name, int health, int resource) {
        super(name, health, resource);
    }

    @Override
    public void attack(Character target) {
        System.out.println("--------------------");
        if (target.isAlive()) {
            System.out.println(target.getName() + " is already dead. Attack wasted!");
            return;
        }
        if (resource >= 10) {
            System.out.println(name + " the Warrior swings their mighty axe!");
            int damage = 25;
            target.takeDamage(damage);
            resource -= 10;
        } else {
            System.out.println(name + " is too exhausted to swing their axe!");
        }
    }
}
