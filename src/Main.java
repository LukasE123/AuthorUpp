import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        arrayListAuthor();
 

    }

    private static void arrayListAuthor() {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Author> authors = new ArrayList<>();

        //set av personer
        authors.add(new Author("Lukas", "lukas@gmail.com", 'm'));
        authors.add(new Author("Victor", "victor.baro@gmail.com", 'f'));
        authors.add(new Author("Hadi", "hadi@gmail.com", 'm'));


        for (Author author : authors) {
            System.out.print("Vill du ändra informationen för " + author.getName() + "? (ja/nej): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("ja")) {
                System.out.print("Nytt namn för " + author.getName() + ": ");
                String newName = scanner.nextLine();

                System.out.print("Ny e-postadress för " + author.getName() + ": ");
                String newEmail = scanner.nextLine();

                System.out.print("Nytt kön för " + author.getName() + ": ");
                char newGender = scanner.nextLine().charAt(0);


                if (isValidEmail(newEmail)) {
                    author.setName(newName);
                    author.setEmail(newEmail);
                    author.setGender(newGender);
                    System.out.println("Uppdaterad information för " + author.getName() + ": " + author.toString());
                } else {
                    System.out.println("Ogiltig e-postadress. Informationen för " + author.getName() + "kommer inte att uppdateras.");
                }


            }
        }


        for (Author author : authors) {
            System.out.println(author.toString());
        }


    }

    private static boolean isValidEmail(String email) {

        String regex = "^.+@.+\\..+$";
        return Pattern.matches(regex, email);
    }
}