// Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах". 
// Для каждого определить 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд). 
// Создать абстрактный класс и иерархию наследников. Расположить классы в пакет так, чтобы в основной программе небыло видно их полей. 
// В не абстрактных классах переопределить метод toString() так чтобы он возвращал название класса или имя. 
// Создать в основной программе по одному обьекту каждого не абстрактного класса и вывести в консоль его имя.



package Units;


public class Game {
    public static void main(String[] args) {

        // Крестьянин
        Peasant peasant = new Peasant("Иван");
        // Разбойник
        Thief thief = new Thief("Емельян");
        // Снайпер
        Sniper sniper = new Sniper("Егор");
        // Колдун
        Magician magician = new Magician("Вольдемар");
        // Копейщик
        Spearman spearman = new Spearman("Давид");
        // Арбалетчик
        Crossbowman crossbowman = new Crossbowman("Ярослав");
        // Монах
        Monk monk = new Monk("Сергей");

        // тут можем использовать каждый персонаж и вызывать его методы
        System.out.println(  );
        peasant.attack(thief);
        peasant.harvest();
        thief.attack(spearman);
        thief.die();
        sniper.rest(58);
        sniper.aim();
        magician.rest(43);
        magician.curse();
        crossbowman.attack(monk);
        crossbowman.reload();
        spearman.takeDamage(61);
        spearman.brace();
        monk.rest(20);
        monk.heal();

        System.out.println( "\n" + peasant );
        System.out.println( thief );
        System.out.println( sniper );
        System.out.println( magician );
        System.out.println( crossbowman );
        System.out.println( spearman );
        System.out.println( monk + "\n" );
    }
}
