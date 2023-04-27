import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import Units.*;


public class Main {
    public static void main( String[] args ) {
        ArrayList<BaseHero> witchTeam = getTeam( 10, "Witchers", 10 );
        System.out.println("\nКоманда магов");
        System.out.println( witchTeam );
        ArrayList<BaseHero> shootTeam = getTeam( 10, "Shooters", 1 );
        System.out.println("\nКоманда стрелков");
        System.out.println(shootTeam );
        ArrayList<BaseHero> allHeroes = new ArrayList<>();
        allHeroes.addAll( witchTeam );
        allHeroes.addAll( shootTeam );

        System.out.println( "\nПерсонажи отсортированы по инициативе (speed)" );
        sort( allHeroes );
        allHeroes.forEach( n -> {
            if ( n.state != -1 ) {
                System.out.print( n );
            }
        } );

        System.out.println( "\n" );

        for ( BaseHero hero: allHeroes ) {
            if ( shootTeam.contains( hero ) )
                hero.doStep( witchTeam );
            else
                hero.doStep( shootTeam );
        }

        System.out.println( "\nПерсонажи после сражения (погибшие удалены):" );
        allHeroes.forEach( n -> {
            if ( n.state != -1 ) {
                System.out.print( n );
            }
        } );

        System.out.println( "\n" );
    }


    static void sort( ArrayList<BaseHero> team ) {
        team.sort( new Comparator<BaseHero>() {
            @Override
            public int compare( BaseHero o1, BaseHero o2 ) {
                if ( o2.getSpeed() == o1.getSpeed() )
                    return ( int )( o2.health - o1.health );
                return o2.speed - o1.speed;
            }
        } );
    }


    public static ArrayList<BaseHero> getTeam(int groupSize, String teamName, int posY) {
        ArrayList<BaseHero> team = new ArrayList<>();
        int start = 0;
        int end = 0;
        int count = 0;
        if (teamName.equals("Shooters")) {
            start = 0;
            end = 2;
        }
        if (teamName.equals("Witchers")) {
            start = 0;
            end = 2;
        }
        while ( count < groupSize ) {
            switch ( new Random().nextInt( start, end ) ) {
                case 0:
                    team.add( new Crossbowman( getName(), count + 1 ) );
                    break;
                case 1:
                    team.add( new Magician( getName(), count + 1 ) );
                    break;
            }
            count++;
        }
        return team;
    }


    private static String getName() {
        return Names.values()[ new Random().nextInt( Names.values().length ) ].toString();
    }
}