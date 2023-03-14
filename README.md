# Inheritance Lab 2

## Learning Goals

- Call a superclass constructor to initialize inherited fields
- Override abstract methods

## Introduction

Fork and clone this project.  The code contains an abstract class
`Pet`.  You will create subclasses `Dog` and `Cat`.


![pet class hierarchy](https://curriculum-content.s3.amazonaws.com/6677/pillars/pet_uml_lab.png)

Do not modify the `Pet` class.

```java
public abstract class Pet {

    private String name;
    private boolean likesBaths;

    public Pet(String name, boolean likesBaths) {
        this.name = name;
        this.likesBaths = likesBaths;
    }

    public String getName() { return name; }
    public boolean likesBaths() { return likesBaths; }

    public abstract void giveTreat();
    public abstract void giveBath();

}
```



## Task #1 - Implement the `Dog` subclass

Create a new class named `Dog` that extends `Pet`.

- `Dog` should have an additional instance variable `tailWagging` of type `boolean`.
- The `Dog` constructor should take 3 parameters: `name`, `likesBaths`, and `tailWagging`.
    - Call the superclass constructor to initialize the inherited `name` and `likesBaths` fields.
    - Initialize the `tailWagging` field.
- Add an accessor method `isTailWagging` to return the value of the `tailWagging` field.
- Override `giveTreat()` to assign `tailWagging` to `true`.
- Override `giveBath()` to assign `tailWagging` based on the value of the inherited field `likesBaths`.
    - NOTE: The inherited field is private, so call the public accessor method of the same name.

Create a new Junit class in the `test/java` folder to test the `Dog` class:

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    private Dog dog1, dog2;

    @BeforeEach
    void setUp() {
        dog1 = new Dog("Rex", true, false);
        dog2 = new Dog("Rover", false, true);
    }

    @Test
    void constructor() {
        assertEquals("Rex", dog1.getName());
        assertTrue(dog1.likesBaths());
        assertFalse(dog1.isWaggingTail());

        assertEquals("Rover", dog2.getName());
        assertFalse(dog2.likesBaths());
        assertTrue(dog2.isWaggingTail());

    }

    @Test
    void giveTreat() {
        dog1.giveTreat();
        assertTrue(dog1.isWaggingTail());

        dog2.giveTreat();
        assertTrue(dog2.isWaggingTail());
    }

    @Test
    void giveBath() {
        dog1.giveBath();
        assertTrue(dog1.isWaggingTail());

        dog2.giveBath();
        assertFalse(dog2.isWaggingTail());
    }
}
```


## Task #2 - Implement the `Cat` subclass

Create a new class named `Cat` that extends `Pet`.

- `Cat` should have an additional instance variable `purring` of type `boolean`.
- We will assume all cats **do not** like baths, so the `Cat` constructor only takes
  2 parameters: `name` and `purring`.
    - Call the superclass constructor to initialize the inherited `name` and `likesBaths` fields.
      Remember, cats do not like baths!
    - Initialize the `purring` field.
- Add an accessor method `isPurring` to return the value of the `purring` field.
- Override `giveTreat()` to assign `purring` to `true`.
- Override `giveBath()` to assign `purring` based on the value of the inherited field `likesBaths`.

Create a new Junit class in the `test/java` folder to test the `Cat` class:

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    private Cat cat1, cat2;

    @BeforeEach
    void setUp() {
        cat1 = new Cat("Fluffy", true);
        cat2 = new Cat("MewMew", false);
    }

    @Test
    void constructor() {
        assertEquals("Fluffy", cat1.getName());
        assertFalse(cat1.likesBaths());
        assertTrue(cat1.isPurring());

        assertEquals("MewMew", cat2.getName());
        assertFalse(cat2.likesBaths());
        assertFalse(cat2.isPurring());
    }


    @Test
    void giveTreat() {
        cat1.giveTreat();
        assertTrue(cat1.isPurring());

        cat2.giveTreat();
        assertTrue(cat2.isPurring());
    }

    @Test
    void giveBath() {
        cat1.giveBath();
        assertFalse(cat1.isPurring());

        cat2.giveBath();
        assertFalse(cat2.isPurring());
    }
}
```

