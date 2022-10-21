package ptbs;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class ListIterator<T> implements Iterator<T> {
    public ArrayList<T> _list;
    public int pos;
    abstract void moveToHead();
}
