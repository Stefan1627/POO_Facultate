import java.util.*;

class Warrior {
    //0 = dead, 100 = full strength
    public int health;
    public String name;

    public Warrior (int health, String name) {
        this.health = health;
        this.name = name;
    }

    public int getDamage() {
        return 0;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [name=" + name + ", health=" + health + "]";
    }
}

class SnakeWarrior extends Warrior {
    public SnakeWarrior(int health, String name) {
        super(health, name);
    }

    @Override
    public int getDamage() {
        return 10;
    }
}

class OgreWarrior extends Warrior {
    public OgreWarrior(int health, String name) {
        super(health, name);
    }

    @Override
    public int getDamage() {
        return 6;
    }
}

class MarshmallowManWarrior extends Warrior {
    public MarshmallowManWarrior(int health, String name) {
        super(health, name);
    }

    @Override
    public int getDamage() {
        return 1;
    }
}

class WarriorPack {
    private final Vector<Warrior> warriors ;

    public WarriorPack () {
        warriors = new Vector<>();
    }

    public void addWarrior(Warrior newWarrior) {
        warriors.add(newWarrior);
    }

    public Vector<Warrior> getWarriors() {
        return warriors ;
    }

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

        pack.addWarrior(new SnakeWarrior(100, "Alex"));
        pack.addWarrior(new OgreWarrior(100, "Alex1"));
        pack.addWarrior(new MarshmallowManWarrior(100, "Alex2"));

        System.out.println("Total damage: " + pack.calculateDamage());
        System.out.println(pack);
    }
}
