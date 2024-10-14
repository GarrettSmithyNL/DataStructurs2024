public class UndoRedoManager <T> {
  private class Node {
    private T state;
    private Node previousNode;
    private Node nextNode;

    private Node(T state) {
      this.state = state;
    }
  }

  private Node currentState;

  // Undo Feature
  public T undo() {
    if (currentState == null || currentState.previousNode == null) {
      System.out.println("Nothing to undo.");
      return null;
    }
    currentState = currentState.previousNode;
    return currentState.state;
  }

  // Redo Feature
  public T redo() {
    if (currentState == null || currentState.nextNode == null) {
      System.out.println("Nothing to redo.");
      return null;
    }
    currentState = currentState.nextNode;
    return currentState.state;
  }

  // Add State
  public void addState(T newState) {
    Node newNode = new Node(newState);
    if (currentState != null) {
      currentState.nextNode = newNode;
    }
    newNode.previousNode = currentState;
    currentState = newNode;
  }

  public static void main(String[] args) {
    UndoRedoManager<String> undoRedoManager = new UndoRedoManager<>();
    undoRedoManager.addState("State 1");
    undoRedoManager.addState("State 2");
    undoRedoManager.addState("State 3");
    undoRedoManager.addState("State 4");
    undoRedoManager.addState("State 5");
    undoRedoManager.addState("State 6");
    undoRedoManager.addState("State 7");

    System.out.println("Current State: " + undoRedoManager.currentState.state);
    System.out.println("Undoing.....");
    System.out.println("Current State: " + undoRedoManager.undo());
    System.out.println("Redoing.....");
    System.out.println("Current State: " + undoRedoManager.redo());
    System.out.println("Undoing.....");
    System.out.println("Current State: " + undoRedoManager.undo());
  }
}