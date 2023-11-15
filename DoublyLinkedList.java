public class DoublyLinkedList{
 private DoublyLinkedNode head;
 
  
  public void insertAtHead(String info) {
    // Inserts a node at the head with 'info' as the value.
    DoublyLinkedNode temp = new DoublyLinkedNode(info);

    //if head is not there yet
    if (head == null){
      //make the head the new one
     head = temp;
    }
    else{
      //set the next of the new one to the old head
      temp.setNext(head);

      //set the previous one for the old head to the new one
      head.setPrev(temp);

      //set head to new one
      head = temp;
    } 
  }
  public void insertAtTail(String info) {
    // Inserts a node at the tail with 'info' as the value.
    DoublyLinkedNode temp = new DoublyLinkedNode(info);
    //insert code here
    if (head == null)
    {
      head = temp;
    }
    else
    {
      DoublyLinkedNode iterator = head;
      while (iterator.getNext() != null)
      {
        iterator = iterator.getNext();
      }
      iterator.setNext(temp);
      temp.setPrev(iterator);
    }
   
  }
 
  public void insertAfter(DoublyLinkedNode before, String info) {
    // Will be the new node
    DoublyLinkedNode temp = new DoublyLinkedNode(info);//D

    DoublyLinkedNode iterator = head;//starting point

    //loop until iterator is the node after the "before" node
    while (iterator.getNext() != before)
    {
      iterator = iterator.getNext();
    }
    
    //if head is null we will just add the new info into
    if(head == null)
    {
      head = temp;
    }
    if(iterator.getNext() != null)
    {
      temp.setNext(iterator.getNext());
    }
    temp.setPrev(iterator);
    
    if(iterator.getNext() != null)
    {
      iterator.getNext().setPrev(temp);
    }
    iterator.setNext(temp);

    head = temp;
  }
 
  public boolean deleteNode(String info) {
     // returns true if successful, and returns false if node is not found
    DoublyLinkedNode iterator = head;
    
    //loop until iterator has the necessary data
    while (iterator.getData() != info && iterator.getNext() != null)
    {
      iterator = iterator.getNext();
    }

    //return false if node was not found
    if (iterator.getNext() == null && iterator.getData() != info){
      return false;
    }

    if (iterator.getPrev() != null){
      //set next node after one before deleted to the one that comes after deleted
     iterator.getPrev().setNext(iterator.getNext());
     if (iterator.getNext() != null)
     {
        //set previous node of node deleted to one that comes after
        iterator.getNext().setPrev(iterator.getPrev());
      }
    }

    if (iterator == head){
      if(iterator.getNext() != null)
      {
        iterator.getNext().setPrev(iterator.getPrev());
        head = iterator.getNext();
      }
    }
    else{
      head = null;
    }
    //return true if node was found and deleted
    return true;
   
  }
 
  public void printList() {
    DoublyLinkedNode cur = head;

    //print data in the list one by one
    while (cur.getNext() != null)
    {
      System.out.println(cur.getData());
      cur = cur.getNext();
    }

    //print list tail
    System.out.println(cur.getData());
  }
 
  public DoublyLinkedNode find(String target) {
    DoublyLinkedNode cur = head;
    while (cur.getData() != target && cur.getNext() != null)
    {
      cur = cur.getNext();
    }
    if (cur.getData() == target)
    {
      return cur;
    }
    return null;
  }
 
  public DoublyLinkedNode getHead() {
    return head;
  }
  public DoublyLinkedNode getTail() {
    DoublyLinkedNode cur = head;
    while (cur.getNext() != null && cur.getPrev() == null)
    {
      cur = cur.getNext();
    }
    return cur;
  }
}
