public class Seat {
  private boolean isSeatReserved;
  private int rowNum;
  private int columnNum;

  public Seat(int rowNum, int columnNum) {
    this.isSeatReserved = false;
    this.rowNum = rowNum;
    this.columnNum = columnNum;
  }

  public void reserveSeat() {
    this.isSeatReserved = true;
  }

  public void freeUpSeat() {
    this.isSeatReserved = false;
  }

  public boolean getSeatStatus() {
    return this.isSeatReserved;
  }
}
