import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class wordcounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Word Counter!");

        boolean validInput = false;
        String text = "";
        while (!validInput) {
            System.out.println("Enter 'text' to input text manually or 'file' to provide a file:");
            String inputType = sc.nextLine().trim().toLowerCase();

            if (inputType.equals("text")) {
                System.out.println("Enter your text:");
                text = sc.nextLine();
                validInput = true;
            } else if (inputType.equals("file")) {
                System.out.println("Enter the path to your file:");
                String filePath = sc.nextLine();
                File file = new File(filePath);

                try {
                    Scanner fileScanner = new Scanner(file);
                    StringBuilder stringBuilder = new StringBuilder();

                    while (fileScanner.hasNextLine()) {
                        stringBuilder.append(fileScanner.nextLine()).append("\n");
                    }

                    text = stringBuilder.toString();
                    validInput = true;
                } catch (FileNotFoundException e) {
                    System.out.println("File not found.Please enter a valid file path.");
                }
            } else {
                System.out.println("Invalid input.Please enter 'text' or 'file'.");
            }
        }
        String[] words = text.split("[\\s\\p{Punct}]+");
        int wordCount = 0;

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
            }
        }
        System.out.println("Total number of words:" + wordCount);

        sc.close();
    }
}
