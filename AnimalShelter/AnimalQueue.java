import java.util.ArrayList;
import java.util.List;

public class AnimalQueue {
  List<Animal> listOfAnimalsInTheShelter;

  public AnimalQueue() {
    listOfAnimalsInTheShelter = new ArrayList<>();
  }


  public void enqueueAnimal(Animal newAnimal) {
    listOfAnimalsInTheShelter.add(newAnimal);
    System.out.println(newAnimal + " is joining the Shelter.");
  }

  public void dequeueAny() {
    if (listOfAnimalsInTheShelter.isEmpty()) {
      System.out.println("No Animals in the Shelter.");
    }
    Animal animalLeavingShelter = listOfAnimalsInTheShelter.removeFirst();
    System.out.println(animalLeavingShelter + " is leaving the Shelter.");
  }

  public void dequeueCat() {
    if (listOfAnimalsInTheShelter.isEmpty()) {
      System.out.println("No Animals in the Shelter.");
    }

    Cat catLeavingShelter = null;

    for (Animal animal : listOfAnimalsInTheShelter) {
      if (animal.getClass() == Cat.class) {
        catLeavingShelter = (Cat) animal;
        listOfAnimalsInTheShelter.remove(animal);
        System.out.println(catLeavingShelter + " is leaving the Shelter.");
        return;
      }
    }
    System.out.println("No cat in the Shelter.");
  }

  public void dequeueDog() {
    if (listOfAnimalsInTheShelter.isEmpty()) {
      System.out.println("No Animals in the Shelter.");
    }

    Dog dogLeavingShelter = null;

    for (Animal animal : listOfAnimalsInTheShelter) {
      if (animal.getClass() == Dog.class) {
        dogLeavingShelter = (Dog) animal;
        listOfAnimalsInTheShelter.remove(animal);
        System.out.println(dogLeavingShelter + " is leaving the Shelter.");
        return;
      }
    }
    System.out.println("No dog in the Shelter.");
  }

  @Override
  public String toString() {
    String results = "";
    for (int i = 0; i < listOfAnimalsInTheShelter.size(); i++) {
      results += (i + 1) + ") " + listOfAnimalsInTheShelter.get(i) + "\n";
    }
    return results;
  }
}
