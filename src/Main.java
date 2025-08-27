import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Book> library = new HashMap<>();
    private static int id = 1;
    private static Scanner scan = new Scanner(System.in);



    public static void main(String[] args) {
        while(true){
            System.out.println("Services: ");
            System.out.println("To add book enter 1");
            System.out.println("To get the list of all the books enter 2");
            System.out.println("To get information about certain book by id enter 3");
            System.out.println("To delete the book enter 4");
            System.out.println("To exit from the system enter 5");
            System.out.println("The choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice){
                case 1 : addBook(); break;
                case 2 : getAllBooks(); break;
                case 3 : getBookById(); break;
                case 4 : deleteBook(); break;
                case 5 :
                    System.out.println("You have exited the system.");
                    return;
                default:
                    System.out.println("Enter the valid option.");
            }
        }

    }


    public static void addBook(){
        System.out.println("Enter the title of the book: ");
        String title = scan.nextLine();

        System.out.print("Enter the author of the book: ");
        String author = scan.nextLine();

        if(title.isEmpty() || author.isEmpty()){
            System.out.println("Title and author should not be empty!");
            return;
        }

        int bookId = id++;
        Book b = new Book(bookId, title, author);
        library.put(bookId, b);
        System.out.println("Book is added.");
    }

    public static void getAllBooks(){
        if(library.isEmpty()){
            System.out.println("There aer no books in the library");
            return;
        }

        library.keySet().stream().sorted().forEach(id-> System.out.println(library.get(id)));
    }

    public static void getBookById(){
        System.out.println("Enter the id of the book: ");
        int id = scan.nextInt();
        Book b = library.get(id);
        System.out.println(b != null ? b.toString() : "No such book in the system");
    }

    public static void deleteBook(){
        System.out.println("Enter the id of the book: ");
        int idx = scan.nextInt();
        Book deleted =  library.remove(idx);
        System.out.println(deleted != null ? "Deleted: "+deleted : "No such book in the system");
        id--;
    }
}