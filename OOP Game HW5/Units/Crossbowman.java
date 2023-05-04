package Units;

public class Crossbowman extends BaseShooter {
    public Crossbowman( String name, int x, int y ) {
        super( name, "Crossbowman", 10, 6, 3, 4, 2, 3 );
        super.setPos( new Point2D( x, y ) );
        super.ammo = 16;
    }
}
