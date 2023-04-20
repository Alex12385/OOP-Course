package Units;

public class Peasant extends BaseHero {
    public Peasant(String name) {

        super(name, 70, 80, 55, 65, 77, 80, 59);
    }

    public void plow() {
        System.out.println(this.name + " пашет поле.");
    }

    public void harvest() {
        System.out.println(this.name + " собирает урожай.");
    }

    @Override
    public String toString() {
        return name;
    }
}