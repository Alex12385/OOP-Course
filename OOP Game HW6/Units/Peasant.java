package Units;


public class Peasant extends BaseMelee {
    public Peasant( String name, int x, int y) {
        super( name, "Peasant", 1, 1, 1, 3, 1 );
        super.setPos( new Point2D( x, y ) );
    }
}
