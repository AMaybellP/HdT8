import java.util.Vector;

/**
 * A vector-based implementation of a priority queue.  Similar to
 * an ordered vector, except that only the smallest value may be
 * accessed in this structure.
 * @see structure.OrderedVector
 * @version $Id: PriorityVector.java 22 2006-08-21 19:27:26
 * @author Z bailey $
 * Modificada por: Andrea Maybell Pena 15127 // Steven Rubio, 15044 
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>
{
    /**
     * The vector of data that is maintained in increasing order.
     */
    protected Vector<E> data;

    /**
     * Construct an empty priority queue.
     *
     * @post constructs a new priority queue
     */
    public VectorHeap()
    {
        data = new Vector<E>();
    }

    /**
     * Fetch the smallest value of the priority queue.
     *
     * @pre !isEmpty()
     * @post returns the minimum value in the priority queue
     * 
     * @return The smallest value of the structure.
     */
    public E getFirst()
    {
        return data.get(0);
    }

    /**
     * Remove the smallest value of the structure.
     *
     * @pre !isEmpty()
     * @post removes and returns minimum value in priority queue
     * 
     * @return The smallest value of the structure.
     */
    public E remove()
    {
        return data.remove(0);
    }
    /**
     * Add a comparable value to the priority queue.
     *
     * @pre value is non-null
     * @post inserts value in priority queue
     *       leaves elements in order
     * 
     * @param value The comparable value to be added.
     */
    public void add(E value)
    {
        int position = indexOf(value);
        data.add(position,value);
    }

    protected int indexOf(E target)
    {
        E midValue;
        int low = 0;  // lowest possible location
        int high = data.size(); // highest possible location
        int mid = (low + high)/2; // low <= mid <= high
        // mid == high iff low == high
        while (low < high) {
            Assert.condition(mid < high,"Middle element exists.");
            midValue = data.get(mid);
            if (midValue.compareTo(target) > 0) {
                low = mid+1;
            } else {
                high = mid;
            }
            mid = (low+high)/2;
        }
        return low;
    }

    /**
     * Determine if the priority queue is empty.
     *
     * @post returns true iff the priority queue is empty
     * 
     * @return True iff there are no elements in the priority queue.
     */
    public boolean isEmpty()
    {
        return data.size() == 0;
    }

    /**
     * Determine the size of the priority queue.
     *
     * @post returns number of elements in priority queue
     * 
     * @return The number of elements in the priority queue.
     */
    public int size()
    {
        return data.size();
    }

    /**
     * Remove all the values from the priority queue.
     *
     * @post removes all elements from priority queue
     */
    public void clear()
    {
        data.clear();
    }

    /**
     * Construct a string representation of the priority vector.
     *
     * @post returns string representation of priority vector
     * 
     * @return String describing priority vector.
     */
    public String toString()
    {
    	String s="";
    	for (int i=0; i<data.size(); i++)
    	{
    		s= s+ data.get(i).toString()+"\n";
    	}
        return "\nLos pacientes deben ser atendidos en el siguiente orden: \n\n"+s+"\n";
        
    }
}
