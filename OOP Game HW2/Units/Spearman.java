package Units;

public class Spearman extends Shooter {
    public Spearman(String name) {

        super(name, 55, 48, 45, 34, 63, 70, 24);
    }

    public void brace() {
        System.out.println(this.name + " готовится к удару своим копьем.");
    }

    public void thrust() {
        System.out.println(this.name + " пронзает их копьем.");
    }

    @Override
    public String toString() {
        return name;
    }

}