package Units;


import java.util.ArrayList;


public abstract class BaseShooter extends BaseHero {
    public int ammo;

    public BaseShooter( String name, String herotype, double health, int attack, int defense, int speed, int damageMin, int damageMax ) {
        super( name, herotype, health, attack, defense, speed, damageMin, damageMax );
        this.ammo = 0;
    }

    public int getAmmo() { return ammo; }
    public void setAmmo(int ammo) { this.ammo = ammo; }

    @Override
    public String getInfo() {
        return  "health: " + (int)super.health +
                ", attack: " + super.attack +
                ", defence: " + super.defense +
                ", speed: " + super.speed +
                ", damage: " + super.damageMin + "-" + super.damageMax +
                ", ammo: " + this.ammo;
    }


    @Override
    public void doStep( ArrayList<BaseHero> enemySide ) {
        if ( this.state == State.ready && this.ammo > 0 ) {
            for( BaseHero hero: enemySide ) {
                if ( hero.health > 0 ) {
                    System.out.println( hero + " получает урон " + getDamage( hero.defense ) + " от " + this.side + ":" + this.name);
                    this.doAttack( hero, getDamage( hero.defense ) );
                    this.ammo--;
                    return;
                }
            }
            System.out.println( "У " + this + " Нет цели для атаки" );
        }
    }
}
