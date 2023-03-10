package Mod8PA.Problem2;
/**
* @author EMILIA BUTU
* version 1.0
* since   2020-06
*
* Student name:  John Stelly
* Completion date: 12/03/2020
*
*	SortedABPriQ.txt: download and save as SortedABPriQ.java
* 	Priority Queue using a Sorted Array
*
*	Class offers two constructors:  one that use the natural order of the
*	elements as defined by their compareTo method and one that uses an
*	ordering based on a comparator argument.
*
*	 Null elements are not allowed.
*
*	 Duplicate elements are allowed.
*
* 	Student tasks: complete tasks specified in the file
*/

import java.util.Comparator;

public class SortedABPriQ<T> implements PriQueueInterface<T>

{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // array to hold priority queue�s elements
  protected int numElements = 0;    // number of elements in this priority queue

  protected Comparator<T> comp;

  public SortedABPriQ()
  // Precondition: T implements Comparable
  {
    elements = (T[]) new Object[DEFCAP];
    comp = new Comparator<T>()
    {
       public int compare(T element1, T element2)
       {
         return ((Comparable)element1).compareTo(element2);
       }
    };
  }

  public SortedABPriQ(Comparator<T> comp)
  {
    elements = (T[]) new Object[DEFCAP];
    this.comp = comp;
  }

  protected void enlarge()
  // Increments the capacity of the priority queue by an amount
  // equal to the original capacity.
  {
    // Create the larger array.
    T[] larger = (T[]) new Object[elements.length + DEFCAP];

    // Copy the contents from the smaller array into the larger array.
    for (int i = 0; i < numElements; i++)
    {
      larger[i] = elements[i];
    }

    // Reassign priority queue reference.
    elements = larger;
  }

  public void enqueue(T element)
  // Adds element to this priority queue.
  {
     if (numElements == elements.length)
       enlarge();

     int index = numElements;
     while ((index > 0) && (comp.compare(elements[index - 1], element) > 0))
     {
       elements[index] = elements[index - 1];
       index--;
     }
     elements[index] = element;

     numElements++;
  }

		//*** Task #1: implement method renqueue(T element) in which elements are added in reverse order

  public void renqueue(T element)
  // Adds element to this priority queue.
  {
    //*** Task #1: implement method renqueue(T element) in which elements are added in reverse order

    if (numElements == elements.length)
      enlarge();

    int index = DEFCAP - numElements - 1;



    while (index < (elements.length - 1) && comp.compare(elements[index + 1], element ) > 0) {

      elements[index] = elements[index + 1];

      index++;

    }
    elements[index] = element;
    numElements++;
  }

  public T dequeue()
  // Throws PriQUnderflowException if this priority queue is empty;
  // otherwise, removes element with highest priority from this
  // priority queue and returns it.
  {
    if (!isEmpty())
    {
      T temp = elements[numElements - 1];
      elements[numElements - 1] = null;
      numElements--;
      return temp;
    }
    else
      throw new PriQUnderflowException("dequeue attempted on an empty priority queue.");
  }

  public int size()
  // Returns the number of elements on this priority queue.
  {
    return numElements;
  }

  public boolean isEmpty()
  // Returns true if this priority queue is empty; otherwise, returns false.
  {
    return (numElements == 0);
  }

  public boolean isFull()
  // This priority queue is unbounded so always returns false.
  {
    return false;
  }

  public String toString()
  // Returns a nicely formatted string that represents this priority queue.
  {
    String temp = "\nPriority Queue: \n";
    for (int i = 0; i < numElements; i++) {
      temp = temp + "  " + elements[i];
      int j = i + 1;
      if ((j % 10) == 0) temp = temp + "\n";
    }
    //temp = temp + "\n";
    return temp;
  }
}
