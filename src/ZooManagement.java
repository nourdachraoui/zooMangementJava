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
            if (sc.hasNextInt()) {af
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

        // Prosit 2 + 3: objects with constructors
        Animal lion = new Animal("Felidae", "Simba", 5, true);
        Animal tiger = new Animal("Felidae", "Shere Khan", 7, true);
        Animal parrot = new Animal("Psittacidae", "Coco", 2, false);

        Zoo myZoo = new Zoo(zooName, "Tunis");
        myZoo.addAnimal(lion);
        myZoo.addAnimal(tiger);

        Zoo otherZoo = new Zoo("Safari Park", "Sousse");
        otherZoo.addAnimal(parrot);

        // Instruction 15
        System.out.println(myZoo.name + " full? " + myZoo.isZooFull());

        // Instruction 16
        Zoo bigger = Zoo.compareZoo(myZoo, otherZoo);
        System.out.println("The zoo with the most animals is " + bigger.name);

        sc.close();
    }
}