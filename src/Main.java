import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductCatalog productCatalog = new ProductCatalog();
        Product p1 = new Product("mar",2,3,4);
        Product p2 = new Product("para",2,3,4);
        Product p3 = new Product("branza",2,3,4);
        Product p4 = new Product("lapte",2,3,4);
        productCatalog.addProduct(p1);
        productCatalog.addProduct(p2);
        productCatalog.addProduct(p3);
        productCatalog.addProduct(p4);

        int selection;
        do{
            printMenu();
            selection = scanner.nextInt();
            performSelectedAction(selection, productCatalog);
        } while (selection !=6);
    }

    public static void printMenu(){
        System.out.println("MENIU: \n" +
                "\"1. Adauga produs in calculator si calculeaza-i caloriile\"\n" +
                "\"2. Calculeaza caloriile pentru un produs fara a fi adaugat in catalog\"\n" +
                "\"3. Afiseaza toate produsele din catalog si caloriile pentru fiecare\"\n" +
                " \"4. Sterge un produs din catalog\"\n" +
                " \"5. Gaseste produs dupa nume\"\n" +
                " \"6. EXIT (Iesi din aplicatie)\"\n" +
                " \"----------------------------------------------------------------”\n" +
                "\"Alege actiunea cu numarul:\" ;");
    }

    public static void performSelectedAction(int selection, ProductCatalog productCatalog){
        if(selection == 1){
            addProduct(productCatalog);
        } else if (selection == 2) {
            computeCalories();
        } else if (selection == 3) {
            productCatalog.printProducts();
        } else if (selection == 4){
            deleteProduct(productCatalog);
        } else if (selection == 5){
            findProduct(productCatalog);
        } else if (selection == 6){
            System.out.println("Ai ales sa iesi din aplicatie");
        } else{
            System.out.println("Optiunea introdusa este gresita. Introdu un numar de la 1 la 6");
        }
    }

    public static void findProduct(ProductCatalog productCatalog){
        Scanner scanner = new Scanner(System.in);
        System.out.println("ai ales sa cauti un produs");
        System.out.println("Da-mi numele produsului");
        String name = scanner.nextLine();
        Product product = productCatalog.getProductByName(name);
        if (product == null){
            System.out.println("produsul cu numele " + name + " nu exista");
        } else {
            System.out.println(product.toString());
        }
    }
    public static void computeCalories(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ai ales sa calculezi caloriile unui produs fara sa il adaugi in catalog");
        System.out.println("Da-mi grasimi");
        int fats = scanner.nextInt();
        System.out.println("Da-mi carbohidrati");
        int carbohydrates = scanner.nextInt();
        System.out.println("Da-mi proteine");
        int proteins = scanner.nextInt();
        int kcal = Product.computeCalories(fats,carbohydrates,proteins);
        System.out.println("Produsul are "+ kcal + " calorii");
    }
    public static void deleteProduct(ProductCatalog productCatalog){
        Scanner scanner = new Scanner(System.in);
        System.out.println("ai ales sa stergi un produs");
        System.out.println("Da-mi numele produsului");
        String name = scanner.nextLine();

        boolean deleted = productCatalog.deleteProduct(name);
        if (deleted){
            System.out.println("produsul cu numele " + name + " a fost sters");
        } else {
            System.out.println("produsul cu numele " + name + " nu a fost gasit");
        }
    }
    private static void addProduct(ProductCatalog productCatalog) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ai ales sa adaugi un produs");
        System.out.println("Da-mi numele produsului");
        String name = scanner.nextLine();
        System.out.println("Da-mi grasimi");
        int fats = scanner.nextInt();
        System.out.println("Da-mi carbohidrati");
        int carbohydrates = scanner.nextInt();
        System.out.println("Da-mi proteine");
        int proteins = scanner.nextInt();
        Product product = new Product(name, fats, carbohydrates, proteins);
        boolean added = productCatalog.addProduct(product);
        if (added) {
            System.out.println("produsul cu numele " + name + " a fost adaugat");
        } else {
            System.out.println("produsul cu numele " + name + " exista deja");
        }
    }
}













