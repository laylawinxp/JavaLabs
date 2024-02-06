public class Main {
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
    }
}
