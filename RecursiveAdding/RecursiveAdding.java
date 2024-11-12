public class RecursiveAdding {
  public static int addDigitsOfNumber(int value) {
    if (value  == 0) {
      return 0;
    }
    return (value % 10) + addDigitsOfNumber(value / 10);
  }

  public static String decimalToBinary(int value) {
    if (value == 0) {
      return "";
    }
    return (value % 2) + decimalToBinary(value / 2).toString();
  }

  public static void main(String[] args) {
    System.out.println(addDigitsOfNumber(123));

    System.out.println(decimalToBinary(15));
  }
}
