package Units;

import java.util.ArrayList;

public class Magician extends BaseHero {
    public Magician( String name,
                   int health, int attack, int defense, int speed,
                   int damage ) {
        super( name, health, attack, defense, speed, damage );
        this.type = "Magician";
    }


    public Magician( String name, int i  ) {
        this( name, 3, 1, 1, 1, 1 );
    }


    public void doTurn( ArrayList<BaseHero> enemy ) {
      
    }
}