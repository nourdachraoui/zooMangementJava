package tn.esprit.gestionzoo.entities;

public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private static final int NBR_CAGES = 25;
    private int nbrAnimals;
    // Instruction 25
    private Aquatic[] aquaticAnimals = new Aquatic[10];
    private int nbrAquaticAnimals;

    public Zoo() {
        animals = new Animal[NBR_CAGES];
    }

    public Zoo(String name, String city) {
        animals = new Animal[NBR_CAGES];
        setName(name);
        this.city = city;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }

    // Instruction 18: the zoo name must not be empty
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Zoo name cannot be empty.");
        } else {
            this.name = name;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrCages() {
        return NBR_CAGES;
    }

    public int getNbrAnimals() {
        return nbrAnimals;
    }

    // Instruction 17: addAnimal uses isZooFull()
    public boolean addAnimal(Animal animal) {
        if (animal == null || isZooFull()) {
            return false;
        }
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }

    public boolean isZooFull() {
        return nbrAnimals >= NBR_CAGES;
    }

    public static Zoo compareZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals >= z2.nbrAnimals) {
            return z1;
        }
        return z2;
    }
    // Instruction 26
    public void addAquaticAnimal(Aquatic aquatic) {
        if (aquatic == null) {
            System.out.println("Cannot add a null aquatic animal.");
            return;
        }

        if (nbrAquaticAnimals >= aquaticAnimals.length) {
            System.out.println("The aquatic animal array is full.");
            return;
        }

        aquaticAnimals[nbrAquaticAnimals] = aquatic;
        nbrAquaticAnimals++;
    }

    // Instruction 27
    public void displayAquaticAnimalsSwimming() {
        for (int i = 0; i < nbrAquaticAnimals; i++) {
            aquaticAnimals[i].swim();
        }
    }

    // Instruction 29
    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0.0f;

        for (int i = 0; i < nbrAquaticAnimals; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin penguin = (Penguin) aquaticAnimals[i];

                if (penguin.getSwimmingDepth() > maxDepth) {
                    maxDepth = penguin.getSwimmingDepth();
                }
            }
        }

        return maxDepth;
    }

    // Instruction 30
    public void displayNumberOfAquaticsByType() {
        int dolphins = 0;
        int penguins = 0;

        for (int i = 0; i < nbrAquaticAnimals; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                dolphins++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                penguins++;
            }
        }

        System.out.println("Number of dolphins: " + dolphins);
        System.out.println("Number of penguins: " + penguins);
    }
}