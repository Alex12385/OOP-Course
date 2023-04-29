package Units;


import java.util.ArrayList;


public abstract class BaseShooter extends BaseHero {
    public int arrows;


    public BaseShooter( String name,
                        int health, int attack, int defense, int speed,
                        int damageMin, int damageMax, int posX, int posY, int arrows, ArrayList<BaseHero> team ) {
        super( name, health, attack, defense, speed, damageMin, damageMax, posX, posY, team );
        this.arrows = arrows;

    }

    public void doTurn( ArrayList<BaseHero> enemy ) {
        if ( this.arrows > 0 && this.health > 0 ) {
            for( BaseHero hero: enemy ) {
                if ( hero.health > 0 ) {
                    findEnemyNear(enemy);
                    System.out.println("\nВыстрел");
                    System.out.print(hero + " получает урон " + getDamage( hero.defense ) );
                    this.doAttack( hero, getDamage( hero.defense ) );
                    this.arrows--;
                    return;
                }
            }
            for( BaseHero hero : BaseHero.team){
                if (hero.toString().equals("Farmer") && hero.health>0 && hero.state==State.ready){
                        this.arrows++;
                        hero.state = State.busy;
                        break;
                }
            }
            System.out.println( "У " + this + " Нет цели для стрельбы" );
        }
    }
}