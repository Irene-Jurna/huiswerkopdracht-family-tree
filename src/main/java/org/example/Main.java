package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Dit is mijn familie:");
        Person me = new Person("Irene", "Judith", "Jurna", "vrouw", 34 );
        Person mother = new Person("Hanneke", "Johanna Christina Wilhelmina", "Abbring", "vrouw", 61);
        Person father = new Person("Martin", "Gerardus", "Jurna", "man", 61);
        Person sister = new Person("Rianne", "Hanna", "Jurna", "vrouw", 30);
        Person brother = new Person ("Joris", "Maarten", "Jurna", "man", 32);
        Person niece = new Person ("Maud", "Anne", "Bansberg", "vrouw", 1);
        Person nephew = new Person ("Moos", "Joas", "Jurna", "man", 2);

        me.addParents(mother, father);
        }
    }