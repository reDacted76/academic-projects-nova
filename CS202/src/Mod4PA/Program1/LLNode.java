package Mod4PA.Program1;

/**----------------------------------------------------------------------------
*
* Implements <T> nodes for a Linked List.
*
*/


public class LLNode<T>
{
  protected LLNode<T> link;

  protected T info;

  public LLNode(T info)
  {
    this.info = info;
    link = null;
  }

  public void setInfo(T info){ this.info = info;}
  public T getInfo(){ return info; }
  public void setLink(LLNode<T> link){this.link = link;}
  public LLNode<T> getLink(){ return link;}
}

