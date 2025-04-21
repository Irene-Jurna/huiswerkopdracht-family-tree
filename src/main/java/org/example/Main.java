package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dit is mijn familie:");
        Person irene = new Person("Irene", "Judith", "Jurna", "vrouw", 34 );
        Person hanneke = new Person("Hanneke", "Johanna Christina Wilhelmina", "Abbring", "vrouw", 61);
        Person martin = new Person("Martin", "Gerardus", "Jurna", "man", 61);
        Person rianne = new Person("Rianne", "Hanna", "Jurna", "vrouw", 30);
        Person joris = new Person ("Joris", "Maarten", "Jurna", "man", 32);
        Person maud = new Person ("Maud", "Anne", "Bansberg", "vrouw", 1);
        Person moos = new Person ("Moos", "Joas", "Jurna", "man", 2);
        Pet punk = new Pet("Punk", 12, "cat");
        Person secondMother = new Person("Tineke", "Wijnstra", 61, "v");

        irene.addBiologicalParents(hanneke, martin);
        irene.addOtherParent(secondMother);
        irene.printParents(irene);

        hanneke.addChild(irene);
        hanneke.addChild(rianne);
        hanneke.addChild(joris);
        hanneke.printChildren();

        irene.addPet(punk);
        irene.printPets();

        rianne.addChild(maud);
        joris.addChild(moos);

        hanneke.getGrandChildren();
        irene.getGrandChildren();

        irene.printSiblings();
        }
    }