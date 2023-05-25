package Units;


public class Spearman extends BaseMelee {
    public Spearman( String name, int x, int y) {
        super( name, "Spearman", 10, 4, 5, 4, 1, 3 );
        super.setPos( new Point2D( x, y ) );
    }
}
