public class Prob1 {
    public static void main(String args[]) {
        Hero h1 = new Warrior(), h2 = new Ninja();
        Hero h3 = new Rogue();
        BadLuck bl = new StormFire();
        bl.execute(h1);
        bl.execute(h2);
        bl.execute(h3);
    }
}

abstract class Hero {
    abstract void execute();
}

class Warrior extends Hero {
    @Override
    void execute() {
        System.out.println("StormFire affecting a Warrior.");
    }
}

class Ninja extends Hero {
    @Override
    void execute() {
        System.out.println("StormFire affecting a Ninja.");
    }
}

class Rogue extends Hero {
    @Override
    void execute() {
        System.out.println("StormFire affecting a Rogue.");
    }
}

abstract class BadLuck {
    abstract void execute(Hero h);
    abstract void execute(Warrior w);
    abstract void execute(Ninja n);
    abstract void execute(Rogue r);
}

class StormFire extends BadLuck {
    @Override
    void execute(Hero h) {
        h.execute();
    }

    @Override
    void execute(Warrior w) {

    }

    @Override
    void execute(Ninja n) {

    }

    @Override
    void execute(Rogue r) {

    }
}
