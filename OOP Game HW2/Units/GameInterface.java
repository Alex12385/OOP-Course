package Units;

public interface GameInterface {

    // Действие - Шаг...
    public default void step() {
        System.out.println( getName() + " прошел еще немного... " );
    }

    // Действие - Шаг в направлении...
    public default void step( String direction ) {
        System.out.println( getName() + " прошел " + direction + " еще немного... " );
    }
    public default void stepUp()    { this.step( "вперед" ); }
    public default void stepDown()  { this.step( "назад" ); }
    public default void stepLeft()  { this.step( "влево" ); }
    public default void stepRight() { this.step( "вправо" ); }


    public default String getInfo() {
        return getClass().getName();
    }

    public default String getName()      { return ""; }
   
}
