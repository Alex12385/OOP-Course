package Units;


public class Sniper extends BaseShooter {
    public Sniper( String name, int x, int y ) {
        super( name, "Sniper", 15, 12, 10, 9, 8, 10 );
        super.setPos( new Point2D( x, y ) );
        super.ammo = 32;
    }
}
