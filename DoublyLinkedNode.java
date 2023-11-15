public class DoublyLinkedNode
{
  private DoublyLinkedNode next;
  private DoublyLinkedNode prev;
  private String data;
 
    public DoublyLinkedNode(String dataValue) {
      next = null;
      prev = null;
      data = dataValue;
    }
     
  public String getData()
  { 
    return data; 
  }
  public DoublyLinkedNode getNext()
  {
    return next;
  }
  public DoublyLinkedNode getPrev()
  {
    return prev;
  }

  public void setNode(String newData)
  {
    data = newData;
  }

  public void setNext(DoublyLinkedNode newNode)
  {
    next = newNode;
  }

  public void setPrev(DoublyLinkedNode newNode)
  {
    prev = newNode;
  }
}