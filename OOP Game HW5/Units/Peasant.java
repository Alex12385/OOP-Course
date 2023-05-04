package Units;
import java.util.ArrayList;

public class Peasant extends BaseHero {
    public Peasant( String name, int x, int y) {
        super( name, "Peasant", 1, 1, 1, 3, 1 );
        super.setPos( new Point2D( x, y ) );
    }


    @Override
    public void doStep(ArrayList<BaseHero> side) {
        if (this.status != Status.dead) {
            state = State.ready;
        }

    }

}
