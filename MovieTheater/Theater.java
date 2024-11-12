import java.util.Scanner;

public class Theater {
  private final Seat[][] theaterSeats;
  private final int numOfRows = 9;
  private final int numOfColumns = 9;

  public Theater () {
    theaterSeats = new Seat[numOfRows][numOfColumns];
    for(int rowNum = 0; rowNum < numOfRows; rowNum++) {
      for(int columnNum = 0; columnNum < numOfColumns; columnNum++) {
        theaterSeats[rowNum][columnNum] = new Seat(rowNum, columnNum);
      }
    }
  }

  public boolean reserveSeatAtIndex(int rowNum, int columnNum) {
    Seat seatToReserve = theaterSeats[rowNum - 1][columnNum - 1];
    if (seatToReserve.getSeatStatus()){
      return false;
    } else {
      seatToReserve.reserveSeat();
      return true;
    }
  }

  public boolean freeUpSeatAtIndex(int rowNum, int columnNum) {
    Seat seatToReserve = theaterSeats[rowNum - 1][columnNum - 1];
    if (seatToReserve.getSeatStatus()){
      seatToReserve.freeUpSeat();
      return true;
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    String theaterMap = "   ";
    String mapLeagand = "'o' - Open Seat\n'x' - Reserved Seat\n";
    for (int columnNum = 0; columnNum < numOfColumns; columnNum++) {
      theaterMap += (columnNum + 1) + " ";
    }
    theaterMap += "\n";
    for(int rowNum = 0; rowNum < numOfRows; rowNum++) {
      theaterMap += (rowNum + 1) + "  ";
      for(int columnNum = 0; columnNum < numOfColumns; columnNum++) {
        if (theaterSeats[rowNum][columnNum].getSeatStatus()) {
          theaterMap += "x ";
        } else {
          theaterMap += "o ";
        }
      }
      theaterMap += "\n";
    }
    return mapLeagand + theaterMap;
  }

  public static void main(String[] args) {
    boolean running = true;
    Theater movieTheater = new Theater();
    Scanner input = new Scanner(System.in);
    int numOfSeats;

    System.out.println("Welcome to a Movie Theater!");
    while (running) {
      System.out.println("Select from the menu.");
      System.out.println("1.) Reserve Seats");
      System.out.println("2.) Cancel Seats");
      System.out.println("3.) View Seat Map");
      System.out.println("4.) Exit");
      int selectedOption = input.nextInt();
      switch (selectedOption) {
        case 1:
          System.out.println("How many seats to reserve?");
          numOfSeats = input.nextInt();
          System.out.println(movieTheater);
          for (int seatNum = 0; seatNum < numOfSeats; seatNum++) {
            System.out.println("Row #: ");
            int rowSelected = input.nextInt();
            System.out.println("Column #: ");
            int columnSelected = input.nextInt();
            try {
              if (!movieTheater.reserveSeatAtIndex(rowSelected, columnSelected)) {
                System.out.println("Seat already reserved");
                seatNum--;
              }
            } catch (ArrayIndexOutOfBoundsException e) {
              System.out.println("Seat not in the theater");
              seatNum--;
            }
          }
          break;

        case 2:
          System.out.println("How many seats to cancel?");
          numOfSeats = input.nextInt();
          System.out.println(movieTheater);
          for (int seatNum = 0; seatNum < numOfSeats; seatNum++) {
            System.out.println("Row #: ");
            int rowSelected = input.nextInt();
            System.out.println("Column #: ");
            int columnSelected = input.nextInt();
            try {
              if (!movieTheater.freeUpSeatAtIndex(rowSelected, columnSelected)) {
                System.out.println("Seat not reserved");
                seatNum--;
              }
            } catch (ArrayIndexOutOfBoundsException e) {
              System.out.println("Seat not in theater");
              seatNum--;
            }
          }
          break;

        case 3:
          System.out.println(movieTheater);
          break;

        case 4:
          System.out.println("Thanks for Booking!");
          input.close();
          running = false;
          break;

        default:
          System.out.println("Enter a valid input");
      }
    }
  }
}
