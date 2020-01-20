 /**
 * This is the ObjectArrayBag class 
 */
public class ArraySequence {

	private Object[] data;
	private int manyItems;
	private int current;

	public ArraySequence() {
		this.data = new Object[10];
		this.manyItems = 0;
		this.current = 0;
	}

	public ArraySequence(int capacity) {
		this.data = new Object[capacity];
		this.manyItems = 0;
		this.current = 0;
	}

	public void start() {
		this.current = 0;
	}

	public int size() {
		return this.manyItems;
	}

	public void advance() {
		this.current += 1;
	}

	public Object getCurrent() {
		return this.data[this.current];
	}

	public void addAfter(Object element) {

		if (this.manyItems == 0) {
			this.data[current] = element;
			this.manyItems++;
		} else {
			for (int i = this.manyItems - 1; i > this.current; i--)
				this.data[i + 1] = this.data[i];
			this.current++;
			this.data[current] = element;
			this.manyItems++;
		}
	}

	public void addBefore(Object element) {

		if (this.manyItems == 0) {
			this.data[current] = element;
			this.manyItems++;
		} else {
			for (int i = this.manyItems - 1; i >= this.current; i--)
				this.data[i + 1] = this.data[i];
			this.data[current] = element;
			this.manyItems++;
		}
	}

	public void removeCurrent() {

		System.out.println(current);
		for (int i = this.current + 1; i < this.manyItems; i++)
			this.data[i - 1] = this.data[i];

		this.manyItems--;
	}

	@Override
	public String toString() {

		String output = "[";

		for (int i = 0; i < this.manyItems; i++)
			output += this.data[i] + ",";

		output += "]";

		return output;
	}

	public void addAll(ArraySequence otherSeq) {

		int pos = this.manyItems;

		for (int i = 0; i < otherSeq.manyItems; i++) {
			this.data[pos] = otherSeq.data[i];
			pos++;
			this.manyItems++;
		}

	}

	public static ArraySequence catenation(ArraySequence seq1, ArraySequence seq2) {
		ArraySequence seq3 = new ArraySequence(seq1.manyItems + seq2.manyItems);
		System.arraycopy(seq1, 0, seq3, 0, seq1.manyItems);
		System.arraycopy(seq2, 0, seq3, seq1.manyItems, seq2.manyItems);
		seq3.manyItems = (seq1.manyItems + seq2.manyItems);
		return seq3;
	}

	// reverse: a method that returns another sequence that has the same
	// elements but in reverse order

	public ArraySequence reverse() {

		ArraySequence output = new ArraySequence(this.data.length);

		for (int i = this.manyItems - 1; i >= 0; i--)
			output.addAfter(this.data[i]);

		return output;
	}

	public int capacity() {
		return this.data.length;
	}
}
