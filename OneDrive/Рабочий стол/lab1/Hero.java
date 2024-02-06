import java.util.Scanner;

public class Hero {
    MoveStrategy moveType;

    Hero() {
        moveType = null;
    }

    protected void move() {
        if (this.moveType != null) {
            this.moveType.move();
        }
    }

    protected void chooseStrategy() {
        String type = "Способ перемещения героя:";
        System.out.println("Выберите способ перемещения для вашего георя. Для этого введите цифру из списка, соответствующую номеру способа:\n1.Бегать\n2.Прыгать\n3.Идти пешком\n4.Лететь\n5.Ехать верхом");
        Scanner scanner = new Scanner(System.in);
        int numOfMoveType;
        if (scanner.hasNextInt()) {
            numOfMoveType = scanner.nextInt();
            switch (numOfMoveType) {
                case 1:
                    this.setStrategy(new RunStrategy());
                    System.out.println(type);
                    this.move();
                    break;
                case 2:
                    this.setStrategy(new JumpStrategy());
                    System.out.println(type);
                    this.move();
                    break;
                case 3:
                    this.setStrategy(new WalkStrategy());
                    System.out.println(type);
                    this.move();
                    break;
                case 4:
                    this.setStrategy(new FlyStrategy());
                    System.out.println(type);
                    this.move();
                    break;
                case 5:
                    this.setStrategy(new HorseStrategy());
                    System.out.println(type);
                    this.move();
                    break;
                default:
                    System.out.println("Способ был выбран неверно");
            }

            System.out.println("Если хотите поменять стратегию, введите 1, иначе введите 0");
            if (scanner.hasNextInt()) {
                int needChoose = scanner.nextInt();
                if (needChoose != 1) {
                    if (needChoose == 0) {
                        return;
                    }
                    System.out.println("Неверный ввод, завершение программы");
                    return;
                }
                this.chooseStrategy();
            } else {
                System.out.println("Некорректный ввод");
            }
        } else {
            System.out.println("Некорректный ввод");
        }

    }

    protected void setStrategy(MoveStrategy moveStrategy) {
        this.moveType = moveStrategy;
    }
}
