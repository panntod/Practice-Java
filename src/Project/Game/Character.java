package Project.Game;

abstract class Character {
    protected String name;
    protected int health;
    protected int resource;

    public Character(String name, int health, int resource) {
        this.name = name;
        this.health = health;
        this.resource = resource;
    }

    public abstract void attack(Character target);

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return health <= 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            System.out.println(name + " takes " + damage + " damage and has fallen!");
        } else {
            System.out.println(name + " takes " + damage + " damage. Remaining health: " + health);
        }
    }
}