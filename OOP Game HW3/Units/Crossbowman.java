package Units;


import java.util.ArrayList;


public class Crossbowman extends BaseShooter {
    public Crossbowman( String name,
                        int health, int attack, int defense, int speed,
                        int damageMin, int damageMax, int ammo ) {
        super( name, health, attack, defense, speed, damageMin, damageMax, ammo );
    }


    public Crossbowman( String name, int i ) {
        this( name, 10, 6, 3, 4, 2, 3, 16 );
        this.type = "Shooter";
    }


    @Override
    public void doStep( ArrayList<BaseHero> enemy ) {
        ArrayList<BaseHero> new_enemy = new ArrayList<>();
        for ( BaseHero hero: enemy) {
            if ( hero.type.equals("Magician") && hero.state == 1 ) {
                new_enemy.add( hero );
            }
        }

        doTurn( new_enemy );
    }
}