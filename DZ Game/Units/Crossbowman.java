package Units;

public class Crossbowman extends Shooter {
    public Crossbowman(String name) {

        super(name, 65, 50, 70, 56, 75, 90, 67);
    }

    public void reload() {
        System.out.println(this.name + " перезаряжает свой арбалет.");
    }

    public void shoot() {
        System.out.println(this.name + " стреляет из своего арбалета.");
    }

    @Override
    public String toString() {
        return name;
    }
}