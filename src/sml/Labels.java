package sml;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

// TODO: write a JavaDoc for the class

/**
 * 1.0v
 * Represents the "dictionary" of the labels where each label points to an address to the memory.
 * @author gakid
 */
public final class Labels {
	private final Map<String, Integer> labels = new HashMap<>();

	/**
	 * Adds a label with the associated address to the map.
	 *
	 * @param label the label
	 * @param address the address the label refers to
	 */
	public void addLabel(String label, int address) {
		Objects.requireNonNull(label);
		// TODO: Add a check that there are no label duplicates.
		if (labels.containsKey(label)){
			throw new IllegalArgumentException("The label is already used.");
		}
		labels.put(label, address);
	}

	/**
	 * Returns the address associated with the label.
	 *
	 * @param label the label
	 * @return the address the label refers to
	 */
	public int getAddress(String label) {
		// TODO: Where can NullPointerException be thrown here?
		//       (Write an explanation.)
		//       Add code to deal with non-existent labels.
		// The NullPointerException should be put before we try to access the value of the requested label.
		// If a reference variable is set to null or either explicitly by us or Java automatically, and
		// we attempt to deference it, we should get a NullPointerException.
		if (labels.get(label) == null){
			throw new NullPointerException("The label does not contain any value.");
		}

		return labels.get(label);
	}

	/**
	 * representation of this instance,
	 * in the form "[label -> address, label -> address, ..., label -> address]"
	 *
	 * @return the string representation of the labels map
	 */
	@Override
	public String toString() {
		// TODO: Implement the method using the Stream API (see also class Registers).
		return labels.entrySet().stream()
				.map(e -> e.getKey() + " -> " + e.getValue())
				.collect(Collectors.joining(", ", "[","]"));
	}

	// TODO: Implement equals and hashCode (needed in class Machine).
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Labels labels1 = (Labels) o;
		return Objects.equals(labels, labels1.labels);
	}

	@Override
	public int hashCode() {
		return Objects.hash(labels);
	}

	/**
	 * Removes the labels
	 */
	public void reset() {
		labels.clear();
	}
}
