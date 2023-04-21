// Добавить файл с описанием интерфейса. В котором описать два метода, void step(); и String getInfo(); 
// Реализовать интерфейсs в абстрактном классе и в наследниках так, чтобы getInfo возвращал информацию о персонаже. 
// Создать два списка в классе main. В каждый список добавить по десять экземпляров наследников BaseHero. В main пройти по спискам и вызвать у всех персонажей getInfo.


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Units.*;

public class Main {
    public static void main( String[] args ) {
        List<BaseHero> crewList1 = generateHeroes( 10 );
        List<BaseHero> crewList2 = generateHeroes( 10 );
        System.out.println( "\nГруппа_1:" );
        crewList1.forEach( u -> System.out.println( u.getName() + " - " + u.getInfo() ) );

        System.out.println( "\nГруппа_2:" );
        crewList2.forEach( u -> System.out.println( u.getName() + " - " + u.getInfo() ) );
        System.out.println();
    }


    public static List<BaseHero> generateHeroes( int count ) {
        List<BaseHero> list = new ArrayList<>();
        for ( int i = 0; i < count; i++ ) {
            switch( new Random().nextInt( 7 ) ) {
                case 0:
                    list.add( new Peasant( getName() ) );
                    break;
                case 1:
                    list.add( new Thief( getName() ) );
                    break;
                case 2:
                    list.add( new Sniper( getName()) );
                    break;
                case 3:
                    list.add( new Magician( getName() ) );
                    break;
                case 4:
                    list.add( new Spearman( getName() ) );
                    break;
                case 5:
                    list.add( new Crossbowman( getName() ) );
                    break;
                default:
                    list.add( new Monk( getName() ) );
            }
        }
        return list;
    }

    
    private static String getName(){
        return String.valueOf(Names.values()[ new Random().nextInt( Names.values().length ) ]);
    }
}