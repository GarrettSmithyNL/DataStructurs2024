import java.util.Arrays;

public class DoubleDimensionArray {
  int[][] arr;

  public DoubleDimensionArray (int columnLength, int rowLength) {
    arr = new int[columnLength][rowLength];
    for (int[] ints : arr) {
      Arrays.fill(ints, Integer.MIN_VALUE);
    }
  }

  public void insert(int valueToInsert, int columnPosition, int rowPosition) {
    try {
      if (arr[columnPosition][rowPosition] == Integer.MIN_VALUE) {
        arr[columnPosition][rowPosition] = valueToInsert;
      } else {
        System.out.println("This cell is already occupied.");
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid index to access array.");
    }
  }

  public void traverse() {
    try {
      for (int[] ints : arr) {
        for (int j = 0; j < ints.length; j++) {
          if (j == 0) {
            System.out.print("[" + ints[j] + ",");
          } else if (j == ints.length - 1) {
            System.out.println(ints[j] + "]");
          } else {
            System.out.print(ints[j] + ",");
          }
        }
      }
    } catch (Exception e) {
      System.out.println("Array no longer exists.");
    }
  }

  public void searchFor(int valueToSearch) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == valueToSearch) {
          System.out.println(valueToSearch + " was found at [" + i + "," + j + "].");
          return;
        }
      }
    }
    System.out.println(valueToSearch + " was not found.");
  }

  public void deleteValueAtPosition(int columnPosition, int rowPosition) {
    try {
      arr[columnPosition][rowPosition] = Integer.MIN_VALUE;
      System.out.println("Position has been deleted successfully.");
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("The position that was provided was not in the range of the array.");
    }
  }

  public static void main(String[] args) {
    DoubleDimensionArray doubleDimensionArray = new DoubleDimensionArray(3, 3);
    doubleDimensionArray.insert(1, 0,0);
    doubleDimensionArray.insert(2, 0,1);
    doubleDimensionArray.insert(3, 0,2);
    doubleDimensionArray.insert(4, 1,0);
    doubleDimensionArray.insert(5, 1,1);
    doubleDimensionArray.insert(6, 1,2);
    doubleDimensionArray.insert(7, 2,0);
    doubleDimensionArray.insert(8, 2,1);
    doubleDimensionArray.insert(9, 2,2);
    doubleDimensionArray.traverse();
    doubleDimensionArray.searchFor(5);
    doubleDimensionArray.deleteValueAtPosition(1,1);
    doubleDimensionArray.traverse();



  }

}
