public class Main {
  public static void main(String[] args) {
    AnimalQueue shelter = new AnimalQueue();
    for (int i = 0; i < 5; i++) {
      shelter.enqueueAnimal(new Cat("cat" + i));
      shelter.enqueueAnimal(new Dog("Dog" + i));
    }
    System.out.println("\n" + shelter);

    shelter.enqueueAnimal(new Cat("Anna"));

    shelter.dequeueAny();
    shelter.dequeueCat();
    shelter.dequeueDog();
    shelter.dequeueDog();
    shelter.dequeueDog();
    shelter.dequeueDog();
    shelter.dequeueDog();

    System.out.println("\n" + shelter);

  }
}
