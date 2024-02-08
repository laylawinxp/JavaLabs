import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Gift> gifts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int start = scanner.nextInt();
            int preparationTime = scanner.nextInt();
            int end = scanner.nextInt();
            gifts.add(new Gift(start, preparationTime, end));
        }
        Collections.sort(gifts);
        int[] arr = new int[gifts.get(gifts.size() - 1).end + 1];
        boolean flag = false;
        for (Gift gift : gifts) {
            if (gift.start + gift.preparationTime <= gift.end) {
                if (arr[gift.end] == 0) {
                    arr[gift.end]++;
                } else {
                    int i = 1;
                    while (gift.start + gift.preparationTime <= gift.end - i && !flag) {
                        if (arr[gift.end - i] == 0) {
                            arr[gift.end - i]++;
                            flag = true;
                        }
                        i++;
                    }
                    if (!flag) {
                        System.out.println("NO");
                        return;
                    }
                }
            } else {
                System.out.println("NO");
                return;
            }
            flag = false;
        }
        System.out.println("YES");
    }
}
class Gift implements Comparable<Gift> {
    int start;
    int preparationTime;
    int end;

    public Gift(int start, int preparationTime, int end) {
        this.start = start;
        this.preparationTime = preparationTime;
        this.end = end;
    }

    @Override
    public int compareTo(Gift other) {
        int first = this.end - this.start - this.preparationTime;
        int second = other.end - other.start - other.preparationTime;
        if (this.end != other.end) {
            return Integer.compare(this.end, other.end);
        } else if (first != second) {
            return Integer.compare(first, second);
        } else {
            return Integer.compare(this.start, other.start);
        }
    }

    @Override
    public String toString() {
        return ((Integer) start).toString() + " " + ((Integer) preparationTime).toString() + " "
                + ((Integer) end).toString();
    }
}


