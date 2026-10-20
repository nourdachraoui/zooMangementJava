public class Animal {
    String family;
    String name;
    int age;
    boolean isMammal;

    public Animal() {
    }

    // Instruction 6: parameterized constructor
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }
}