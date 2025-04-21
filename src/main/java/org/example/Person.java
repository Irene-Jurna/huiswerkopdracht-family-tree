package org.example;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    String middleName;
    String lastName;
    Gender sex;
    int age;
    Person mother;
    Person father;
    List<Person> otherParent;
    List<Person> siblings = new ArrayList<>();
    List<Person> children;
    List<Pet> pets;

    public Person(String name, String lastName, int age, String sex) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = Gender.fromString(sex);
    }

    public Person(String name, String middleName, String lastName, String sex, int age) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = Gender.fromString(sex);
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

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
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

    public List<Person> getOtherParent() {
        return otherParent;
    }

    public void setOtherParent(List<Person> otherParent) {
        this.otherParent = otherParent;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() {
        if (children == null) {
            children = new ArrayList<>();
        }
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Pet> getPets() {
        if (pets == null) {
            pets = new ArrayList<>();
        }
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    // FAMILY FUNCTIONS
    public void addBiologicalParents(Person mother, Person father) {
        setMother(mother);
        setFather(father);

        mother.addChild(this);
        father.addChild(this);

        addSiblings(this);
    };

    public void addChild(Person child) {
        if (children == null) {
            children = new ArrayList<>();
        }

        if (!children.contains(child)) {
            children.add(child);
        }

        assignParent(child);
    };

    void assignParent(Person child) {
        if (this.sex == Gender.VROUW) {
            child.setMother(this);
        } else if (this.sex == Gender.MAN) {
            child.setFather(this);
        } else if (this.sex == Gender.NON_BINAIR || this.sex == Gender.ANDERS) {
            child.addOtherParent(this);
        }
    }

    void addOtherParent(Person otherParent) {
        if (this.otherParent == null) {
            this.otherParent = new ArrayList<>();
        }

        if (!this.otherParent.contains(otherParent)) {
            this.otherParent.add(otherParent);
        }
    }

    void addSiblings(Person person) {
        if (person.getMother() != null && person.getMother().getChildren() != null) {
            for (Person child : person.getMother().getChildren()) {
                if (!child.equals(person) && !person.getSiblings().contains(child)) {
                    person.getChildren().add(child);
                }
            }
        }

        if (person.getFather() != null && person.getFather().getChildren() != null) {
            for (Person child : person.getFather().getChildren()) {
                if (!child.equals(person) && !person.getSiblings().contains(child)) {
                    person.getSiblings().add(child);
                }
            }
        }
    };

    public void getGrandChildren() {
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

    public void addPet(Pet pet) {
        if (pets == null) {
            pets = new ArrayList<>();
        }

        if (!pets.contains(pet)) {
            pets.add(pet);
        }
    };

    // PRINT FUNCTIONS
    void printParents(Person person) {
        Person mother = person.getMother();
        Person father = person.getFather();
        List<Person> otherParents = person.getOtherParent();
        System.out.println("Mijn biologische moeder is: " + mother.name + " " + mother.lastName + ".\nMijn biologische vader is: " + father.name + " " + father.lastName + ". Verder zijn mijn ouders: ");
        for (Person otherParent : otherParents) {
            System.out.println("- " + otherParent.name + " " + otherParent.lastName);
        }
    }

    void printSiblings() {
        if (siblings != null && !siblings.isEmpty()) {
            System.out.println("Broers/zussen van " + name);
            for (Person sibling : siblings) {
                System.out.println("- " + sibling.getName() + " " + sibling.getLastName());
            }
        } else {
            System.out.println(name + " heeft geen broers of zussen.");
        }
    }

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
}
