package Units;

public class Sniper extends Shooter {
    public Sniper(String name) {

        super(name, 60, 70, 47, 67, 35, 56, 28);
    }

    public void aim() {
        System.out.println(this.name + " целится из снайперской винтовки.");
    }

    public void shoot() {
        System.out.println(this.name + " стреляет из снайперской винтовки.");
    }

    @Override
    public String toString() {
        return name;
    }
}