import java.util.Scanner;
public class Problem1 {

  public static double[] getNumOfTemps() {
    Scanner scanner = new Scanner(System.in);
    double[] temps;
    int numOfTemps;
    System.out.println("Enter the number of temperatures: ");
    while (true) {
      try {
        numOfTemps = scanner.nextInt();
        temps = new double[numOfTemps];
        if (numOfTemps > 0) {
          break;
        } else {
          System.out.println("Invalid input. Please enter a number greater than 0:");
        }
      } catch (Exception e) {
        System.out.println("Invalid input. Please enter a valid number:");
        scanner.nextLine();
      }
    }
    for (int i = 0; i < numOfTemps; i++) {
      try {
        System.out.println("Enter temperature " + (i + 1) + ": ");
        temps[i] = scanner.nextDouble();
      } catch (Exception e) {
        System.out.println("Invalid input. Please enter a valid number.");
        scanner.nextLine();
        i--;
      }
    }
    scanner.close();
    return temps;
  }

  public static double getAverage(double[] temps) {
    double sum = 0;
    for (double temp : temps) {
      sum += temp;
    }
    return sum / temps.length;
  }

  public static double[] getAboveAverage(double[] temps, double average) {
    int count = 0;
    for (double temp : temps) {
      if (temp > average) {
        count++;
      }
    }
    double[] aboveAverage = new double[count];
    int index = 0;
    for (double temp : temps) {
      if (temp > average) {
        aboveAverage[index] = temp;
        index++;
      }
    }
    return aboveAverage;
  }

  public static void main(String[] args) {
    System.out.println("Problem 1");
    double[] temps = getNumOfTemps();
    double average = getAverage(temps);
    double[] aboveAverage = getAboveAverage(temps, average);
    System.out.println("The average temperature is: " + average);
    System.out.println("The number of temperatures above average is: " + aboveAverage.length);
    System.out.println("The temperatures above average are: ");
    System.out.println(java.util.Arrays.toString(aboveAverage));

  }
}
