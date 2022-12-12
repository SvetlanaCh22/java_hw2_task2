// Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.

// Чубченко Светлана

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class main {

    public static void main(String[] args) {
        // задаем массив
        int [] arr = {19, 3, 14, 16, 7, 64, 15, 87, 22};
        // вызываем сортировку и выводим промежуточные значения в лог
        writeLog("Промежуточные значения сортировки:");
        int [] sorted_arr = sort(arr);
        // выводим результат
        String result = Arrays.toString(sorted_arr);
        // сначала в лог
        writeLog("Результат сортировки:");
        writeLog(result);
        // потом в консоль
        System.out.println("Sorted: " + result);
    }

    public static int [] sort(int [] arr) {
        // сортировка пузырьком
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    isSorted = false;
                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                    // выводим промежуточное значение
                    writeLog(Arrays.toString(arr));
                }
            }
        }
        return arr;
    }
    public static void writeLog(String msg) {
        // задаем формат даты и времени
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        // открываем файл для добавления строк
        try (PrintWriter p = new PrintWriter(new FileOutputStream("log.txt", true))) {
            // пишем в лог
            p.println(dtf.format(now) + "\t\t" + msg);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

}