package Game;

class Mage extends Character {
    public Mage(String name, int health, int resource) {
        super(name, health, resource);
    }

    @Override
    public void attack(Character target) {
        System.out.println("--------------------");
        if (target.isAlive()) {
            System.out.println(target.getName() + " is already dead. Attack wasted!");
            return;
        }
        if (resource >= 20) {
            System.out.println(name + " the Mage casts a powerful fireball!");
            int damage = 40;
            target.takeDamage(damage);
            resource -= 20;
        } else {
            System.out.println(name + " does not have enough mana to cast fireball!");
        }
    }
}