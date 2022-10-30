import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        while (true){
            System.out.println("Здравствуйте! Введите свои данные: ");
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            String[] data = str.split(" ");
            String fileName = data[0];
            if (checkData(data) == true & checkNumber(data) == true & checkSex(data) == true & checkBirthday(data) == true) {
                try (FileWriter fw = new FileWriter(fileName.toString() + ".txt", true)) {
                    fw.write(str + "\n");
                } catch (
                        IOException e) {
                    System.out.println("troubles with file");
                }
                System.out.println("Файл успешно записан!");
                break;
            }
        }
    }

    public static boolean checkBirthday(String data[]) {
        for (String el : data) {
            if (true == el.matches("[0-9]{2}.[0-9]{2}.[0-9]{4}")) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                sdf.setLenient(false);
                try {
                    Date date = sdf.parse(el);
                    if (20 > date.getYear() || 115 < date.getYear())
                        System.out.println("incorrect year");
                } catch (ParseException e) {
                    System.out.println("incorrect date of birth");
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public static boolean checkData(String[] data) {
        if (data.length != 6) {
            System.out.println("not full info");
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkNumber(String[] data) {
        for (String e : data) {
            if (true == e.matches("[0-9]+"))
                if (e.length() != 11) {
                    System.out.println("incorrect number");
                    return false;
                } else {
                    return true;
                }
        }
        return false;
    }

    public static boolean checkSex(String data[]) {
        for (String e : data) {
            if (e.length() == 1)
                if (true == e.matches("[f,m,F,M]")) {
                    return true;
                } else {
                    System.out.println("incorrect sex");
                    return false;
                }

        }
        return false;
    }
}




