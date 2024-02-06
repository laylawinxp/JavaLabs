import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void segregate(Collection<? extends Chordates> srcCollection, Collection<? super Hedgehogs>
            collection1, Collection<? super Manul> collection2, Collection<? super Lynx> collection3) {
        for (Chordates animal : srcCollection) {
            if (animal instanceof Hedgehogs) {
                collection1.add((Hedgehogs) animal);
            }
            if (animal instanceof Manul) {
                collection2.add((Manul) animal);
            }
            if (animal instanceof Lynx) {
                collection3.add((Lynx) animal);
            }
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Mammals> mammals = new ArrayList<>();
        ArrayList<Hedgehogs> hedgehogs = new ArrayList<>();
        ArrayList<Felines> felines = new ArrayList<>();
        ArrayList<Predators> predators = new ArrayList<>();
        ArrayList<Chordates> chordates = new ArrayList<>();
        ArrayList<Manul> manuls = new ArrayList<>();
        ArrayList<Insectivores> insectivores = new ArrayList<>();
        mammals.add(new Felines(1));
        mammals.add(new DefaultHedgehog(2));
        mammals.add(new Manul(3));
        mammals.add(new Lynx(4));
        mammals.add(new Lynx(5));
        mammals.add(new Felines(6));
        mammals.add(new Predators(7));
        mammals.add(new Hedgehogs(8));
        System.out.println("segregate(Млекопитающие, Ежовые, Кошачьи, Хищные)\n");
        segregate(mammals, hedgehogs, felines, predators);
        System.out.println("Млекопитающие: " + mammals);
        System.out.println("Ежовые: " + hedgehogs);
        System.out.println("Кошачьи: " + felines);
        System.out.println("Хищные: " + predators);
        System.out.println("\nsegregate(Хищные, Хордовые, Манулы, Кошачьи)\n");
        predators.add(new Felines(9));
        predators.add(new Manul(10));
        predators.add(new Felines(11));
        predators.add(new Predators(12));
        segregate(predators, chordates, manuls, felines);
        System.out.println("Хищные: " + predators);
        System.out.println("Хордовые: " + chordates);
        System.out.println("Манулы: " + manuls);
        System.out.println("Кошачьи: " + felines);
        System.out.println("\nsegregate(Ежовые, Насекомоядные, Хищные, Хищные)\n");
        segregate(hedgehogs, insectivores, predators, predators);
        System.out.println("Ежовые: " + hedgehogs);
        System.out.println("Насекомоядные: " + insectivores);
        System.out.println("Хищные: " + predators);
    }
}