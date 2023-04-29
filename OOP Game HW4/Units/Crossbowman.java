package Units;

import java.util.ArrayList;

public class Crossbowman extends BaseShooter {
    public Crossbowman(String name,
            int health, int attack, int defense, int speed,
            int damageMin, int damageMax, int posX, int posY, int arrows) {
        super(name, health, attack, defense, speed, damageMin, damageMax, posX, posY, arrows, team);
    }

    public Crossbowman(String name, int posX, int posY) {
        this(name, 10, 6, 3, 4, 2, 3, posX, posY, 16);
        
    }

    @Override
    public void doStep(ArrayList<BaseHero> enemy) {
        ArrayList<BaseHero> new_enemy = new ArrayList<>();
        for (BaseHero hero : enemy) {
            if (hero.type.equals("Farmer") && hero.status == Status.alive) {
                new_enemy.add(hero);
            }
        }

        doTurn(new_enemy);
    }
}