import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    static MoveStrategy e(int param)
    {
        return () -> {};
    }
    static <T> Consumer<T> er(int param)
    {
        return (a) -> {};
    }
    static <T> void ae(Supplier<T> param)
    {
        param.get();
        System.out.println(0);
    }
    public static void main(String[] args) {
        Hero smurfik = new Hero();
        Hero king = new Hero();
        Hero forrest = new Hero();
        System.out.println("Способ перемещения смурфика:");
        smurfik.setStrategy(new WalkStrategy());
        smurfik.move();
        System.out.println("Способ перемещения короля:");
        king.setStrategy(new HorseStrategy());
        king.move();
        System.out.println("Способ перемещения смурфика:");
        smurfik.setStrategy(new JumpStrategy());
        smurfik.move();
        System.out.println("Способ перемещения Форреста:");
        forrest.setStrategy(new RunStrategy());
        forrest.move();
        Hero yourHero = new Hero();
        yourHero.move();
        yourHero.chooseStrategy();
        MoveStrategy moves = () -> {};
        moves.move();
    }
}