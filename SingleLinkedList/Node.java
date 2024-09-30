public class Node {
  private Node nextNode;
  private int value;

  public Node (int nodeValue) {
    this.value = nodeValue;
    this.nextNode = null;
  }

  public void setNextNode(Node newNextNode) {
    this.nextNode = newNextNode;
  }

  public int getValue() {
    return this.value;
  }

  public Node getNextNode() {
    return this.nextNode;
  }
}
