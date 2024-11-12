public class SingleLinkedList {
  public Node head;
  public Node tail;
  public int listSize;

  // Create Single Linked List
  public Node createSingleLinkedList(int nodeValue) {
    Node newNode = new Node(nodeValue);
    head = newNode;
    tail = newNode;
    listSize = 1;
    return head;
  }

  // Insert
  public void insertInSingleLinkedList(int nodeValue, int positionToInsert) {
    Node newNode = new Node(nodeValue);
    if (head == null) {
      createSingleLinkedList(nodeValue);

    } else if (positionToInsert == 0) {
      newNode.setNextNode(head);
      head = newNode;
    } else if (positionToInsert >= listSize) {
      tail.setNextNode(newNode);
      tail = newNode;
    } else {
      Node nodeBeforePosition = head;
      int index = 0;
      while (index < positionToInsert - 1) {
        nodeBeforePosition = nodeBeforePosition.getNextNode();
        index++;
      }
      newNode.setNextNode(nodeBeforePosition.getNextNode());
      nodeBeforePosition.setNextNode(newNode);
    }
    listSize++;
  }

  public void traverseSingleLinkedList() {
    if (head == null) {
      System.out.println("Single Linked List does not exist.");
    } else {
      Node cursorNode = head;
      System.out.print("[");
      for (int cursorIndex = 0; cursorIndex < listSize; cursorIndex++) {
        System.out.print(cursorNode.getValue());
        if (cursorIndex != listSize - 1) {
          System.out.print(" -> ");
        }
        cursorNode = cursorNode.getNextNode();
      }
      System.out.print("]\n");
    }
  }

  public boolean searchSingleLinkedList (int valueToSearch) {
    if (head != null) {
      Node cursorNode = head;
      for (int cursorIndex = 0; cursorIndex < listSize; cursorIndex ++) {
        if (cursorNode.getValue() == valueToSearch) {
          System.out.println("Found the node '" + cursorNode.getValue() + "' at location '" + cursorIndex + "'");
          return true;
        }
        cursorNode = cursorNode.getNextNode();
      }
    }
    System.out.println("Node not found.");
    return false;
  }

//  Deleting
  public void deleteFromSingleLinkList(int positionToDelete) {
    if (positionToDelete > listSize - 1) {
      System.out.println("Position '" + positionToDelete +"' is not in list.");
      return;
    }
    if (head == null) {
      System.out.println("Single Link List does not exist");
    } else if (positionToDelete == 0) {
      head = head.getNextNode();
      listSize--;
    } else if (positionToDelete == listSize - 1){
      Node nodeBeforeTail = head;
      int index = 0;
      while (index < listSize - 1) {
        nodeBeforeTail = nodeBeforeTail.getNextNode();
        index++;
      }
      nodeBeforeTail.setNextNode(null);
      tail = nodeBeforeTail;
      listSize--;
    } else {
      Node nodeBefore = head;
      int index = 0;
      while (index < positionToDelete - 1) {
        nodeBefore = nodeBefore.getNextNode();
        index++;
      }
      nodeBefore.setNextNode(nodeBefore.getNextNode().getNextNode());
      listSize--;
    }
  }


  public static void main(String[] args) {
    System.out.println("Creating a demo List.");
    SingleLinkedList test = new SingleLinkedList();
    test.insertInSingleLinkedList(1, 1);
    test.insertInSingleLinkedList(2, 2);
    test.insertInSingleLinkedList(3, 3);
    test.insertInSingleLinkedList(4, 4);
    test.insertInSingleLinkedList(5, 5);
    test.traverseSingleLinkedList();
    System.out.println("Inserting value '10' to position '2'.");
    test.insertInSingleLinkedList(10, 2);
    test.traverseSingleLinkedList();
    System.out.println("Searching List for value '10'");
    test.searchSingleLinkedList(10);
    System.out.println("Searching List for value '15'");
    test.searchSingleLinkedList(15);
    System.out.println("Deleting position '2' from the list");
    test.deleteFromSingleLinkList(2);
    System.out.println("Deleting position '5' from the list");
    test.deleteFromSingleLinkList(5);
    System.out.println("Deleting the current head from the list");
    test.deleteFromSingleLinkList(0);
    System.out.println("Deleting the current tail from the list");
    test.deleteFromSingleLinkList(3);
    test.traverseSingleLinkedList();
  }
}
