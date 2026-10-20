import java.util.Scanner;

public class ZooManagement {

    public static void main(String[] args) {
        // Instruction 1: initial values
        int nbrCages = 20;
        String zooName = "my zoo";
        System.out.println(zooName + " has " + nbrCages + " cages");

        // Instruction 2: user input with validation
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter the zoo name: ");
            zooName = sc.nextLine().trim();
            if (zooName.isEmpty()) {
                System.out.println("The name cannot be empty.");
            }
        } while (zooName.isEmpty());

        nbrCages = 0;
        while (nbrCages <= 0) {
            System.out.print("Enter the number of cages: ");
            if (sc.hasNextInt()) {
                nbrCages = sc.nextInt();
                if (nbrCages <= 0) {
                    System.out.println("The number of cages must be greater than 0.");
                }
            } else {
                System.out.println("Invalid input: please enter an integer.");
                sc.next();
            }
        }

        // Instruction 3: display the changes
        System.out.println(zooName + " has " + nbrCages + " cages");

        // Instruction 5: create objects and assign attributes line by line
        Animal lion = new Animal();
        lion.family = "Felidae";
        lion.name = "Simba";
        lion.age = 5;
        lion.isMammal = true;

        Zoo myZoo = new Zoo();
        myZoo.name = zooName;
        myZoo.city = "Tunis";
        myZoo.nbrCages = nbrCages;
        myZoo.animals[0] = lion;

        // Instruction 6: same thing with the parameterized constructors
        Animal lion2 = new Animal("Felidae", "Simba", 5, true);
        Zoo myZoo2 = new Zoo(zooName, "Tunis", 25);
        myZoo2.animals[0] = lion2;

        System.out.println(lion2.name + " lives in " + myZoo2.name + ", " + myZoo2.city);

        sc.close();
    }
}