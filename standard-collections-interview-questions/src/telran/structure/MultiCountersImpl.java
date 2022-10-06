package telran.structure;


import java.util.*;

public class MultiCountersImpl implements MultiCounters {
	HashMap<Object, Integer> items = new HashMap<>(); // key - item, value - counter
	TreeMap<Integer, HashSet<Object>> counters = new TreeMap<>();
	// key - counter,
	// value - set of items having the key counter

	@Override
	public Integer addItem(Object item) {
		counters.computeIfAbsent(getValue(item), k -> new HashSet<Object>()).add(item);
		return items.merge(item, 1, Integer::sum);
	}

	@Override
	public Integer getValue(Object item) {
		return items.getOrDefault(item, 0);
	}

	@Override
	public boolean remove(Object item) {
		if (!items.containsKey(item)) {
			return false;
		}
		if (items.get(item) == 1) {
			items.remove(item);
		} else {
			Integer newValue = getValue(item) - 1;
			items.put(item, newValue);
			counters.computeIfAbsent(newValue, k -> new HashSet<Object>()).add(item);
		}
		counters.computeIfAbsent(getValue(item), k -> new HashSet<Object>()).remove(item);
		return true;
	}

	@Override
	public Set<Object> getMaxItems() {
		return counters.get(counters.lastKey());
	}
}
