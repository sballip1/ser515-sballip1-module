package ptbs;

import java.util.ArrayList;
import java.util.Iterator;

public class OfferingList extends ArrayList<Offering> {
    @Override
    public Iterator<Offering> iterator() {
        return (Iterator<Offering>) new OfferingIterator(this);
    }
}
