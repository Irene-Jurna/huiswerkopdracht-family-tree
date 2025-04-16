package org.example;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    String middleName;
    String lastName;
    String sex;
    int age;
    Person mother;
    Person father;
    List<Person> siblings;
    List<Person> children;
    List<Pet> pets;

    public Person(String name, String lastName, int age, String sex) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name, String middleName, String lastName, String sex, int age) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    void addParents(Person mother, Person father) {
        setMother(mother);
        setFather(father);

        mother.addChild(this);
        father.addChild(this);
    };

    void printParents(Person person) {
        Person mother = person.getMother();
        Person father = person.getFather();
        System.out.println("Mijn moeder is: " + mother.name + " " + mother.lastName + ".\nMijn vader is: " + father.name + " " + father.lastName);
    }

    void addChild(Person child) {
        if (children == null) {
            children = new ArrayList<>();
        }

        if (!children.contains(child)) {
            children.add(child);
        }

        if (this.sex.equalsIgnoreCase("vrouw")) {
            child.setMother(this);
        } else if (this.sex.equalsIgnoreCase("man")) {
            child.setFather(this);
        }
    };

    void printChildren() {
        if (children != null && !children.isEmpty()) {
            System.out.println("Kinderen van " + name + ":");
            for (Person child : children) {
                System.out.println("- " + child.getName() + " " + child.getLastName());
            }
        } else {
            System.out.println(name + " heeft geen kinderen.");
        }
    }

    void addPet(Pet pet) {
        if (pets == null) {
            pets = new ArrayList<>();
        }

        if (!pets.contains(pet)) {
            pets.add(pet);
        }
    };

    void printPets() {
        if (pets != null && !pets.isEmpty()) {
            System.out.println(name + "s huisdieren zijn: ");
            for (Pet pet : pets) {
                System.out.println("- " + pet.name);
            }
        } else {
            System.out.println("Ik heb geen huisdieren");
        }
    }
    void addSiblings() {};

    void getGrandChildren() {
        if (children == null || children.isEmpty()) {
            System.out.println(name + " heeft geen kinderen en dus ook geen kleinkinderen");
            return;
        }

        List<Person> grandChildren = new ArrayList<>();
        for (Person child : children) {
            if (child.getChildren() != null && !child.getChildren().isEmpty()) {grandChildren.addAll(child.getChildren());}
        }

        if (!grandChildren.isEmpty()) {
            System.out.println(name + "s kleinkinderen zijn: ");
            for (Person child : grandChildren) {
                System.out.println("- " + child.getName() + " " + child.getLastName());
            }
        } else {
            System.out.println(name + " heeft geen kleinkinderen");
        }
    };
}
