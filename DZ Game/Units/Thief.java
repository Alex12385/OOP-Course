package Units;

public class Thief extends BaseHero {
    public Thief(String name) {

        super(name, 46, 32, 54, 88, 73, 56, 37);
    }

    public void pickPocket() {
        System.out.println(this.name + " обшаривает карманы.");
    }

    public void sneak() {
        System.out.println(this.name + " крадется повсюду.");
    }

    @Override
    public String toString() {
        return name;
    }
}