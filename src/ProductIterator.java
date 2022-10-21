
public class ProductIterator extends ListIterator {

	ProductIterator(ClassProductList list) {
		this._list=list;
		pos = -1;
	}

	@Override
	void moveToHead() {
		pos=0;
	}

	@Override
	public boolean hasNext() {
		return pos<_list.size()-1;
	}

	@Override
	public Object next() {
		if(hasNext()) {
			pos++;
			return _list.get(pos);
		}
		return null;
	}

	@Override
	public void remove() {
		if(pos<_list.size())
			_list.remove(pos);
	}
}
