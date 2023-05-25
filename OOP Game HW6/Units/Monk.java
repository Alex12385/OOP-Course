package Units;


public class Monk extends BaseMelee {
    public Monk( String name, int x, int y) {
        super( name, "Monk", 30, 12, 7, 5, 4 );
        super.setPos( new Point2D( x, y ) );
    }
}
