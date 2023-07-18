import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter '1' to enter text manually or '2' to provide a file: ");
        int option = scan.nextInt();
        scan.nextLine(); // Consume newline character

        String text = "";

        if (option == 1) {                      
            System.out.println("Enter the text: ");
            text = scan.nextLine();
        } else if (option == 2) {
            System.out.println("Enter the file path: ");
            String filePath = scan.nextLine();
            try {
                File file = new File(filePath);
                Scanner fileScan = new Scanner(file);
                while (fileScan.hasNextLine()) {
                    text += fileScan.nextLine() + " ";
                }
                fileScan.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                System.exit(1);
            }
        } else {
            System.out.println("Invalid choice. Exiting the program.");
            System.exit(1);
        }

        int wordCount = countWords(text);
        System.out.println("Total words: " + wordCount);

        
        getUniqueWords(text);
        getWordFrequency(text);
    }

    public static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

        public static void getUniqueWords(String text) {
            String[] words = text.split("\\s+");
            Map<String , Integer> wordCountMap= new HashMap<>();

            // for (String word : words) {
            // wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            // }

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
            System.out.println("Unique words: " + wordCountMap.size());
        }

    public static void getWordFrequency(String text) {
        String[] words = text.split("\\s+");
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

