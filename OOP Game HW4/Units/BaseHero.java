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

    public int posX;
    public int posY;

    public static ArrayList<BaseHero> team;

    public enum State {
        ready, busy, disabled
    }
    public State state;

    enum Status {
        alive, dead
    }
    public Status status;


    // Полный конструктор
    public BaseHero( String name,
                     int health, int attack, int defense, int speed,
                     int damageMin, int damageMax, int posX, int posY, ArrayList<BaseHero> team ) {
        this.name       = name;
        this.type       = "";

        this.health     = health;
        this.healthMax  = health;

        this.attack     = attack;
        this.defense    = defense;
        this.speed      = speed;

        this.damageMin = damageMin;
        this.damageMax = damageMax;

        this.posX      = posX;
        this.posY      = posY;
        BaseHero.team = team;
        
        this.state = State.ready;
        this.status = Status.alive;
    }

    // Полный конструктор, без разброса в уроне
    public BaseHero( String name,
                     int health, int attack, int defense, int speed,
                     int damage, int posX, int posY, ArrayList<BaseHero> team ) {
        this( name, health, attack, defense, speed, damage, damage, posX, posY, team );
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
    public int getPosX     () { return this.posX;      }
    public int getPosY     () { return this.posY;      }
    public Point2D getPos  () { return new Point2D(posX, posY); }
    public State getState    () { return this.state;     }
    public Status getStatus    () { return this.status;     }


    // Сеттеры, для получения значений приватных полей
    public void setName     ( String name   ) { this.name      = name;      }
    public void setAttack   ( int attack    ) { this.attack    = attack;    }
    public void setDefense  ( int defense   ) { this.defense   = defense;   }
    public void setSpeed    ( int speed     ) { this.speed     = speed;     }
    public void setDamageMin( int damageMin ) { this.damageMin = damageMin; }
    public void setDamageMax( int damageMax ) { this.damageMax = damageMax; }
    public void setHealth   ( int health    ) { this.health    = health;    }
    public void setState    ( State state   ) { this.state     = state;     }
    public void setStatus   ( Status status ) { this.status = status;       }


    // Сеттеры, для позиционирования
    public void setPos      ( Point2D pos ) { this.posX = pos.posX; this.posY = pos.posY; }
    public void setPosX     ( int posX    ) { setPos( new Point2D( posX, this.posY ) ); }
    public void setPosY     ( int posY    ) { setPos( new Point2D( this.posX, posY ) ); }

    // Рассчитываем урон по цели, минимальный урон == 1
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

    // Действие Атака
    public void doAttack( BaseHero hero, int damage ) {
        hero.doDamage( damage );
        
    }


    public void doDamage( float damage ) {
            setHealth( getHealth() - (int)damage );
        if ( getHealth() <= 0 ) {
            setHealth( 0 );
            setState ( this.state = State.disabled );
            setStatus(this.status = Status.dead); 
            System.out.println( this + " персонаж погиб" );
        }
    }


    // Вывод всех полей в строковом виде
    public String toString() {
        return String.format( "\n%s: health: [%d/%d], Type: %s, attack: %d, defense: %d, speed: %d, damage: %d-%d, pos: %s, status: %s,",
            this.name,
            
            this.health,
            this.healthMax,
            this.getClass().getSimpleName(),
            this.attack,
            this.defense,
            this.speed,

            this.damageMin,
            this.damageMax,

            this.getPos(),
            this.status);
          
           
    }


    protected int findEnemyNear( ArrayList<BaseHero> allHeroes ) {
        double min = Double.MAX_VALUE;
        int index = 0;
        for ( int i = 0; i < allHeroes.size(); i++ ) {
            if ( min > getPos().getDistance( allHeroes.get( i ).getPos() ) ) {
                index = i;
                min = getPos().getDistance( allHeroes.get( i ).getPos() );
            }
        }
        return index;
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