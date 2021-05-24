import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner (System.in);
        System.out.println ("Введите количество чисел:");
        int quantityOfNumbers = sc.nextInt ();
        int[] numbers = new int[quantityOfNumbers];
        System.out.println ("Введите " + quantityOfNumbers + " числа, используя клавишу \"Пробел\", по завершению ввода нажмите \"Enter\" ");

        for (int i = 0; i < quantityOfNumbers; i++) {
            numbers[i] = sc.nextInt (); //Вводим числа с консоли
        }
        sc.close ();

        maxminLengthOfNumber (numbers); //Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
        minToMaxLength (numbers); //Вывести числа в порядке возрастания (убывания) значений их длины.
        lessMoreThanAverage (numbers); // Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.


    }

    public static void maxminLengthOfNumber(int[] numbers) {
        int minLength = countOfNumberLength (numbers[0]);
        int maxLength = countOfNumberLength (numbers[0]);
        int k = numbers[0];
        int p = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (countOfNumberLength (numbers[i]) > maxLength) {
                maxLength = countOfNumberLength (numbers[i]);
                p = numbers[i];
            } else if (countOfNumberLength (numbers[i]) < minLength) {
                minLength = countOfNumberLength (numbers[i]);
                k = numbers[i];
            }
        }
        System.out.println ("Самое короткое число: " + k + ". " + "  Его длина: " + minLength);
        System.out.println ("Самое длинное число: " + p + ". " + "Его длина: " + maxLength);


    }

    private static void lessMoreThanAverage(int[] numbers) {
        System.out.println ();
        int[] arr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) { // Создаем массив, элементы - длина элементов массива numbers
            arr[i] = countOfNumberLength (numbers[i]);
        }
        int sumLengthArr = sumArrayItems (arr); // Сумма элементов
        int averageLength = sumLengthArr / numbers.length; //Среднее значение
        for (int i = 0; i < numbers.length; i++) {
            if (arr[i] <= averageLength) {
                System.out.println ("Длина элемента: " + numbers[i] + " составляет " + arr[i] + ", что меньше(либо равно) средней длины.");
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (arr[i] > averageLength) {
                System.out.println ("Длина элемента: " + numbers[i] + " составляет " + arr[i] + ", что больше средней длины.");
            }
        }
    }


    private static int sumArrayItems(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; ++i) {
            sum += a[i];
        }
        return sum;
    }

    public static int countOfNumberLength(int a) { //рассчитываем длину элемента массива
        int count = (a == 0) ? 1 : 0;
        while (a != 0) {
            count++;
            a /= 10;
        }
        return count;
    }

    private static void minToMaxLength(int[] numbers) { //сортировка по возрастанию длины элемента массива
        Arrays.sort (numbers);
        System.out.print ("Сортировка в порядке возрастания: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print (numbers[i] + " ");
        }
        System.out.println ();
        System.out.print ("Сортировка в порядке убывания: ");
        Integer[] integerNumbers = IntStream.of (numbers).boxed ().toArray (Integer[]::new);
        Arrays.sort (integerNumbers, Collections.reverseOrder ());
        for (int i = 0; i < integerNumbers.length; i++) {
            System.out.print (integerNumbers[i] + " ");
        }
    }
}