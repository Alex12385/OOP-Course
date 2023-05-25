package Units;

public class Rogue extends BaseMelee {
    public Rogue( String name, int x, int y ) {
        super( name, "Rogue", 10, 8, 3, 6, 2, 4 );
        super.setPos( new Point2D( x, y ) );
    }
}
