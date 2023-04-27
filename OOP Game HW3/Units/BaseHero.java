package Units;

import java.util.ArrayList;

public abstract class BaseHero implements HeroInterface, Comparable<BaseHero> {
    public String name;
    public String type;

    public int health;
    public int healthMax;

    public int attack;
    public int defense;
    public int speed;

    public int damageMin;
    public int damageMax;

    public int state;


    // Полный конструктор
    public BaseHero( String name,
                     int health, int attack, int defense, int speed,
                     int damageMin, int damageMax ) {
        this.name       = name;
        this.type       = "";

        this.health     = health;
        this.healthMax  = health;

        this.attack     = attack;
        this.defense    = defense;
        this.speed      = speed;

        this.damageMin = damageMin;
        this.damageMax = damageMax;


        this.state      = 1;
    }

    // Полный конструктор, без разброса в уроне
    public BaseHero( String name,
                     int health, int attack, int defense, int speed,
                     int damage ) {
        this( name, health, attack, defense, speed, damage, damage );
    }


    // Геттеры, для изменения значений приватных полей
    public String getName  () { return this.name;      }
    public int getHealth   () { return this.health;    }
    public int getHealthMax() { return this.healthMax; }
    public int getAttack   () { return this.attack;    }
    public int getDefense  () { return this.defense;   }
    public int getSpeed    () { return this.speed;     }
    public int getDamageMin() { return this.damageMin; }
    public int getDamageMax() { return this.damageMax; }
    public int getState    () { return this.state;     }
 

    // Сеттеры, для получения значений приватных полей
    public void setName     ( String name   ) { this.name      = name;      }
    public void setAttack   ( int attack    ) { this.attack    = attack;    }
    public void setDefense  ( int defense   ) { this.defense   = defense;   }
    public void setSpeed    ( int speed     ) { this.speed     = speed;     }
    public void setDamageMin( int damageMin ) { this.damageMin = damageMin; }
    public void setDamageMax( int damageMax ) { this.damageMax = damageMax; }
    public void setHealth   ( int health    ) { this.health    = health;    }
    public void setState    ( int state     ) { this.state     = state;     }

    
    // Рассчет урона по цели, минимальный урон == 1
    public int getDamage( int heroDefense ) {
        int damage = heroDefense - this.attack - ( int )( ( damageMin + damageMax ) / 2 );
        if ( damage < 0 )
            return damage * -1;
        return 1;
    }



    public void doStep( ArrayList<BaseHero> enemy ) {
        doTurn( enemy );
    }

    public void doTurn( ArrayList<BaseHero> enemy ) {
        
    }

    // Атака
    public void doAttack( BaseHero hero, int damage ) {
        hero.doDamage( damage );
    }


    // Получаемый урон 
    public void doDamage( float damage ) {
            setHealth( getHealth() - (int)damage );
        if ( getHealth() <= 0 ) {
            setHealth( 0 );
            setState ( -1 );
            System.out.println( this + " персонаж погиб" );
        }
    }


  
    public String toString() {
        return String.format( "\n%s: health: [%d/%d], attack: %d, defense: %d, speed: %d, damage: %d-%d, state: %s",
            this.name,

            this.health,
            this.healthMax,

            this.attack,
            this.defense,
            this.speed,

            this.damageMin,
            this.damageMax,


            this.state );
    }


 
    // Сотировка по убыванию скорости
    @Override
    public int compareTo( BaseHero hero ) {
        if ( this.speed < hero.speed )
            return 1;
        else if ( this.speed > hero.speed )
            return -1;
        else
            return 0;
    }
}