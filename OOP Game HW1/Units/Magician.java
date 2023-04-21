package Units;

public class Magician extends BaseHero {
    public Magician(String name) {

        super(name, 82, 46, 78, 23, 45, 26, 44);
    }

    public void curse() {
        System.out.println(this.name + " проклинает врага.");
    }

    public void summonDemon() {
        System.out.println(this.name + " вызывает демона.");
    }

    @Override
    public String toString() {
        return name;
    }
}