package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;
import tn.esprit.gestionzoo.entities.Aquatic;
import tn.esprit.gestionzoo.entities.Terrestrial;
import tn.esprit.gestionzoo.entities.Dolphin;
import tn.esprit.gestionzoo.entities.Penguin;

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

        Animal lion = new Animal("Felidae", "Simba", 5, true);
        Animal tiger = new Animal("Felidae", "Shere Khan", 7, true);
        Animal parrot = new Animal("Psittacidae", "Coco", 2, false);

        Zoo myZoo = new Zoo(zooName, "Tunis");
        myZoo.addAnimal(lion);
        myZoo.addAnimal(tiger);

        Zoo otherZoo = new Zoo("Safari Park", "Sousse");
        otherZoo.addAnimal(parrot);

        System.out.println(myZoo.getName() + " full? " + myZoo.isZooFull());

        Zoo bigger = Zoo.compareZoo(myZoo, otherZoo);
        System.out.println("The zoo with the most animals is " + bigger.getName());

        // Instruction 18: tests of the validation
        lion.setAge(-3);
        myZoo.setName("");
        System.out.println(lion.getName() + " is " + lion.getAge() + " years old");
        // Instruction 22: parameterized constructors
        Aquatic aquatic = new Aquatic(
                "Fish", "Nemo", 2, false, "Ocean"
        );

        Terrestrial terrestrial = new Terrestrial(
                "Felidae", "Leo", 5, true, 4
        );

        Dolphin dolphin = new Dolphin(
                "Delphinidae", "Flipper", 8, true, "Ocean", 40.0f
        );

        Penguin penguin = new Penguin(
                "Spheniscidae", "Pingu", 3, false, "Antarctica", 100.0f
        );

        // Instruction 23: display the objects
        System.out.println("\n--- Animal descriptions ---");
        System.out.println(aquatic);
        System.out.println(terrestrial);
        System.out.println(dolphin);
        System.out.println(penguin);

        // Instruction 24: call swim()
        System.out.println("\n--- Swimming ---");
        aquatic.swim();
        dolphin.swim();
        penguin.swim();

        sc.close();
    }
}