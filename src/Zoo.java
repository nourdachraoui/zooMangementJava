public class Zoo {
    Animal[] animals;
    String name;
    String city;
    static final int NBR_CAGES = 25;   // Instruction 14: constant, max 25 animals
    int nbrAnimals;                    // current number of animals

    public Zoo() {
        animals = new Animal[NBR_CAGES];
    }

    // Instruction 14: nbrCages is no longer a parameter
    public Zoo(String name, String city) {
        animals = new Animal[NBR_CAGES];
        this.name = name;
        this.city = city;
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            return false;
        }
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }

    // Instruction 15: is the zoo full?
    public boolean isZooFull() {
        return nbrAnimals >= NBR_CAGES;
    }

    // Instruction 16: returns the zoo with the most animals
    public static Zoo compareZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals >= z2.nbrAnimals) {
            return z1;
        }
        return z2;
    }
}