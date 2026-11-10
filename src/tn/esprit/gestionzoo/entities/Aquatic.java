package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.InvalidAgeException;

import java.util.Objects;

public abstract class Aquatic extends Animal {

    private String habitat;

    public Aquatic(String family, String name, int age,
                   boolean isMammal, String habitat)
            throws InvalidAgeException {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    @Override
    public String toString() {
        return super.toString() + ", habitat='" + habitat + '\'';
    }

    public abstract void swim();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Aquatic)) {
            return false;
        }

        Aquatic other = (Aquatic) obj;

        return getAge() == other.getAge()
                && Objects.equals(getName(), other.getName())
                && Objects.equals(habitat, other.habitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), habitat);
    }
}