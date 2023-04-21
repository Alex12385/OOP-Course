package Units;

public class Monk extends BaseHero {
    public Monk(String name) {

        super(name, 65, 67, 80, 70, 57, 90, 78);
    }

    public void meditate() {
        System.out.println(this.name + " медитирует.");
    }

    public void heal() {
        System.out.println(this.name + " использует их целебную силу.");
    }

    @Override
    public String toString() {
        return name;
    }
}