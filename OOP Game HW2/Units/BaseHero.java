package Units;

public class BaseHero implements GameInterface {
   protected String name; //Имя

   protected int strength;  // Сила
   protected int dexterity;  // Ловкость
   protected int intelligence; // Интеллект
   protected int endurance;  // Выносливость

   protected int health;  // Здоровье
   protected int healthMax;  // Максимальное здоровье
   protected int accuracy;  // Точность попадания

   public BaseHero(String name, int strength, int dexterity, int intelligence, int endurance, int health, int healthMax, int accuracy) {
      this.name = name;

      this.strength = strength;
      this.dexterity = dexterity;
      this.intelligence = intelligence;
      this.endurance = endurance;

      this.health = health;
      this.healthMax = healthMax;
   }


    @Override
    public String getName()      { return name; }

    public int getStrength()     { return strength; }
    public int getDexterity()    { return dexterity; }
    public int getIntelligence() { return intelligence; }
    public int getEndurance()    { return endurance; }

    public int getHealth()       { return health; }
    public int getHealthMax()    { return healthMax; }


    public void setName(         String name )      { this.name         = name; }

    public void setStrength(     int strength )     { this.strength     = strength; }
    public void setDexterity(    int dexterity )    { this.dexterity    = dexterity; }
    public void setIntelligence( int intelligence ) { this.intelligence = intelligence; }
    public void setEndurance(    int endurance )    { this.endurance    = endurance; }

    public void setHealth(       int health )       { this.health       = health; }
    public void setHealthMax(    int health )       { this.healthMax    = health; }

    // Смерть
    public void die() {
        setHealth( 0 );
        setHealthMax( 0 );
    }

    // Ранение или смерть
    public void takeDamage( int damage ) {
        if ( this.health > damage ) {
            this.health -= damage;
            System.out.println( this.name + " получил повреждения на " + damage + " очков здоровья!" );
        } else {
            this.die();
            System.out.println( this.name + " побеждён!" );
        }
    }

    // Атака
    public void attack( BaseHero target ) {
        int damage = this.strength * 1;
        
        System.out.println( this.name + " атакует " + target.getName() + " с нанесением урона на " + damage + " очков здоровья!" );
        target.takeDamage( damage );

    }

    // Лечение, не больше максимума
    public void rest( int hp ) {
        this.health = this.health + hp > this.healthMax ? this.healthMax : hp + this.health;
        System.out.println( this.name + " отдыхает и восстанавливается на " + hp + " очков здоровья." );
    }
    @Override
    public String toString() {
        return String.format("-- %s -- %s[%d/%d], Сила: %d --",
        this.getClass().getName(), this.name, this.health, this.healthMax, this.strength);
    }
  
}