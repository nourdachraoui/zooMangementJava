
public class Zoo {
    Animal[] animals;
    String name;
    String city;
    int nbrCages;

    public Zoo() {
        animals = new Animal[25]; // a zoo holds at most 25 animals
    }

    // Instruction 6: parameterized constructor
    public Zoo(String name, String city, int nbrCages) {
        animals = new Animal[nbrCages];
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
    }
}