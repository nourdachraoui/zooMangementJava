package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;
import tn.esprit.gestionzoo.entities.Terrestrial;
import tn.esprit.gestionzoo.entities.Dolphin;
import tn.esprit.gestionzoo.entities.Penguin;
import tn.esprit.gestionzoo.exceptions.ZooFullException;
import tn.esprit.gestionzoo.exceptions.InvalidAgeException;

import java.util.Scanner;

public class ZooManagement {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            String zooName;

            do {
                System.out.print("Enter the zoo name: ");
                zooName = sc.nextLine().trim();

                if (zooName.isEmpty()) {
                    System.out.println("The name cannot be empty.");
                }
            } while (zooName.isEmpty());

            Zoo myZoo = new Zoo(zooName, "Tunis");

            System.out.println(
                    myZoo.getName() + " has "
                            + myZoo.getNbrCages() + " cages"
            );

            try {
                Animal lion = new Animal(
                        "Felidae", "Simba", 5, true
                );

                Animal tiger = new Animal(
                        "Felidae", "Shere Khan", 7, true
                );

                Animal parrot = new Animal(
                        "Psittacidae", "Coco", 2, false
                );

                Animal elephant = new Animal(
                        "Elephantidae", "Dumbo", 10, true
                );

                Animal[] animalsToAdd = {
                        lion, tiger, parrot, elephant
                };

                System.out.println("\n--- Adding animals ---");

                for (Animal animal : animalsToAdd) {
                    try {
                        myZoo.addAnimal(animal);

                        System.out.println(
                                "Added: " + animal.getName()
                        );
                    } catch (ZooFullException e) {
                        System.out.println(
                                "Cannot add " + animal.getName()
                                        + ": " + e.getMessage()
                        );
                    } finally {
                        System.out.println(
                                "Number of animals: "
                                        + myZoo.getNbrAnimals()
                        );
                    }
                }

                System.out.println("\n--- Invalid age during creation ---");

                try {
                    Animal invalidAnimal = new Animal(
                            "Felidae", "Invalid animal", -2, true
                    );

                    myZoo.addAnimal(invalidAnimal);
                } catch (InvalidAgeException e) {
                    System.out.println(
                            "Animal rejected: " + e.getMessage()
                    );
                } catch (ZooFullException e) {
                    System.out.println(e.getMessage());
                } finally {
                    System.out.println(
                            "Number of animals: "
                                    + myZoo.getNbrAnimals()
                    );
                }

                System.out.println("\n--- Invalid age during modification ---");

                try {
                    lion.setAge(-3);
                } catch (InvalidAgeException e) {
                    System.out.println(
                            "Age update rejected: " + e.getMessage()
                    );
                }

                System.out.println(
                        "Simba's age is still: " + lion.getAge()
                );

                // A valid age update succeeds.
                lion.setAge(6);

                System.out.println(
                        "Simba's updated age: " + lion.getAge()
                );

                Zoo otherZoo = new Zoo("Safari Park", "Sousse");

                try {
                    otherZoo.addAnimal(parrot);
                } catch (ZooFullException e) {
                    System.out.println(e.getMessage());
                } finally {
                    System.out.println(
                            otherZoo.getName() + " animal count: "
                                    + otherZoo.getNbrAnimals()
                    );
                }

                Zoo bigger = Zoo.compareZoo(myZoo, otherZoo);

                System.out.println(
                        "\nThe zoo with the most animals is "
                                + bigger.getName()
                );

                Terrestrial terrestrial = new Terrestrial(
                        "Felidae", "Leo", 5, true, 4
                );

                Dolphin dolphin = new Dolphin(
                        "Delphinidae", "Flipper", 8,
                        true, "Ocean", 40.0f
                );

                Penguin penguin = new Penguin(
                        "Spheniscidae", "Pingu", 3,
                        false, "Antarctica", 100.0f
                );

                Penguin penguin2 = new Penguin(
                        "Spheniscidae", "Skipper", 5,
                        false, "Antarctica", 200.0f
                );

                System.out.println("\n--- Animal descriptions ---");
                System.out.println(terrestrial);
                System.out.println(dolphin);
                System.out.println(penguin);
                System.out.println(penguin2);

                myZoo.addAquaticAnimal(dolphin);
                myZoo.addAquaticAnimal(penguin);
                myZoo.addAquaticAnimal(penguin2);

                System.out.println("\n--- Swimming ---");
                myZoo.displayAquaticAnimalsSwimming();

                System.out.println(
                        "\nMaximum penguin swimming depth: "
                                + myZoo.maxPenguinSwimmingDepth()
                );

                System.out.println("\n--- Aquatic animals by type ---");
                myZoo.displayNumberOfAquaticsByType();

                Penguin samePenguin = new Penguin(
                        "Spheniscidae", "Pingu", 3,
                        false, "Antarctica", 150.0f
                );

                System.out.println("\n--- Equality checks ---");

                System.out.println(
                        "penguin equals samePenguin: "
                                + penguin.equals(samePenguin)
                );

                System.out.println(
                        "penguin equals penguin2: "
                                + penguin.equals(penguin2)
                );

            } catch (InvalidAgeException e) {
                // Handles unexpected invalid ages in the normal examples.
                System.out.println(
                        "Cannot continue these examples: " + e.getMessage()
                );
            }
        }
    }
}