package lt.mano.iban;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValidateIbanListApp {

    private static String fileName;
    private static String fileLocation;
    private static String fullFilePath = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        menu(1);

        List<String> validatedListOfIBAN = new ArrayList<>();
        IBANValidator c = new IBANValidator();
        for (String tmp : readFile(fullFilePath)) {
            String formatedString = tmp.format("%s;%s", tmp, c.isValid(tmp));
            System.out.println(formatedString);
            validatedListOfIBAN.add(formatedString);
        }

        writeToFile(fullFilePath, validatedListOfIBAN);
    }

    private static List<String> readFile(String filePath) {
        List<String> result = null;
        try (Stream<String> lines = Files.lines(Paths.get(filePath + ".txt"))) {
            result = lines.collect(Collectors.toList());

            for (String tmp : result) {
                System.out.println(tmp);
            }
            System.out.println("---------------------");
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        return result;
    }

    private static void writeToFile(String filePath, List<String> list) {
        try {
            Files.write(Paths.get(filePath + ".out"), list);
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }

    private static void menu(int menuControl) {
        switch (menuControl) {
            case 1:
                System.out.println("Enter the directory path. Example: C:/Users/msi/Desktop/");
                fileLocation = scanner.nextLine();

                if (new File(fileLocation).exists()) {
                    menu(2);
                } else {
                    System.out.println("Directory doesn't exist, try again.");
                    menu(1);
                }
                break;
            case 2:
                System.out.println("Enter a file name  without a type. Example: IBANlist");
                fileName = scanner.nextLine();
                if (new File(fileLocation + File.separator + fileName + ".txt").exists()) {
                    menu(3);
                } else {
                    System.out.println("File doesn't exist, try again.");
                    menu(2);
                }
                break;
            case 3:
                fullFilePath = fileLocation + File.separator + fileName;
                break;
        }
    }
}

