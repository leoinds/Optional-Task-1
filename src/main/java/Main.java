import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print ("Введите целые числа через пробел " + "и нажмите <Enter>: ");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String longWord = "", shortWord = line;
        for (String s : line.split(" ")) {
            if (s.length() > longWord.length()) longWord = s;
            if (s.length() < shortWord.length()) shortWord = s;
        }
        System.out.println("Самое длинное число: '" + longWord + "'");
        System.out.println("Длина: " + longWord.length());
        System.out.println("Самое короткое число: '" + shortWord + "'");
        System.out.println("Длина: " + shortWord.length());
    }
}