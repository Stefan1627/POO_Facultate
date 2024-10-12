
import java.util.Vector;

class Warrior {
    private int health;
    private String name;

    public Warrior(int health, String name) {
        this.health = health;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return 0;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [name=" + name + ", health=" + health + "]";
    }
}

// Derived class for Snake Warrior
class SnakeWarrior extends Warrior {
    public SnakeWarrior(int health, String name) {
        super(health, name);
    }

    @Override
    public int getDamage() {
        return 10; // Snake does 10 damage
    }
}

// Derived class for Ogre Warrior
class OgreWarrior extends Warrior {
    public OgreWarrior(int health, String name) {
        super(health, name);
    }

    @Override
    public int getDamage() {
        return 6; // Ogre does 6 damage
    }
}

// Derived class for Marshmallow Man Warrior
class MarshmallowManWarrior extends Warrior {
    public MarshmallowManWarrior(int health, String name) {
        super(health, name);
    }

    @Override
    public int getDamage() {
        return 1; // Marshmallow Man does 1 damage
    }
}

// Class for handling a pack of warriors
class WarriorPack {
    private Vector<Warrior> warriors;

    public WarriorPack() {
        warriors = new Vector<>();
    }

    public void addWarrior(Warrior newWarrior) {
        warriors.add(newWarrior);
    }

    // Calculates total damage based on the specific damage of each warrior type
    public int calculateDamage() {
        int totalDamage = 0;
        for (Warrior warrior : warriors) {
            totalDamage += warrior.getDamage();
        }
        return totalDamage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("WarriorPack [");
        for (Warrior warrior : warriors) {
            sb.append(warrior.toString()).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

public class Prob4 {
    public static void main(String[] args) {
        WarriorPack pack = new WarriorPack();
        pack.addWarrior(new SnakeWarrior(100, "Serpentor"));
        pack.addWarrior(new OgreWarrior(100, "Grog"));
        pack.addWarrior(new MarshmallowManWarrior(100, "Fluffy"));

        // Test damage calculation
        System.out.println("Total damage: " + pack.calculateDamage());

        // Test toString methods
        System.out.println(pack);
    }
}
