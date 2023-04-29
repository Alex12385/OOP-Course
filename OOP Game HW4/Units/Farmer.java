package Units;

import java.util.ArrayList;

public class Farmer extends BaseHero {
    public Farmer( String name,
                   int health, int attack, int defense, int speed,
                   int damage, int posX, int posY, ArrayList<BaseHero> team ) {
        super( name, health, attack, defense, speed, damage, posX, posY, team );
        this.type = "Farmer";
    }


    public Farmer( String name, int posX, int posY, ArrayList<BaseHero> team  ) {
        this( name, 3, 1, 1, 1, 1, posX, posY, team );
    }

    
    @Override
    public String toString() {
        if (this.status == Status.dead) 
            {this.state = State.disabled;}
        return super.toString()+", state: " + state;
       
    }


    public void doTurn( ArrayList<BaseHero> enemy ) {
        
    }
}