package telran.structure;

import java.util.Map.Entry;
import java.util.*;

public class MultiCountersImpl implements MultiCounters {
	HashMap<Object, Integer> items = new HashMap<>(); // key - item, value - counter
	TreeMap<Integer, HashSet<Object>> counters = new TreeMap<>();
	// key - counter,
	// value - set of items having the key counter

	//Granovsky
	@Override
	public Integer addItem(Object item) {
		Integer res = items.merge(item, 1, Integer::sum);
		if (res > 1) {
			counterItemsRemove(res - 1, item);
		}
		counters.computeIfAbsent(res, e -> new HashSet<>()).add(item);
		return res;
	}

	private void counterItemsRemove(int counter, Object item) {
		HashSet<Object> set = counters.get(counter);
		set.remove(item);
		if (set.isEmpty()) {
			counters.remove(counter);
		}
	}

	@Override
	public Integer getValue(Object item) {
		
		return items.get(item);
	}

	@Override
	public boolean remove(Object item) {
		Integer counter = items.remove(item);
		if (counter != null) {
			counterItemsRemove(counter, item);
		}
		return counter != null;
	}

	@Override
	public Set<Object> getMaxItems() {
		Entry<Integer, HashSet<Object>> maxCounter = counters.lastEntry() ;
		return maxCounter != null ? maxCounter.getValue() : Collections.emptySet();
	}
}
	//my code
//	@Override
//	public Integer addItem(Object item) {
//		counters.computeIfAbsent(getValue(item), k -> new HashSet<Object>()).add(item);
//		return items.merge(item, 1, Integer::sum);
//	}
//
//	@Override
//	public Integer getValue(Object item) {
//		return items.getOrDefault(item, 0);
//	}
//
//	@Override
//	public boolean remove(Object item) {
//		if (!items.containsKey(item)) {
//			return false;
//		}
//		if (items.get(item) == 1) {
//			items.remove(item);
//		} else {
//			Integer newValue = getValue(item) - 1;
//			items.put(item, newValue);
//			counters.computeIfAbsent(newValue, k -> new HashSet<Object>()).add(item);
//		}
//		counters.computeIfAbsent(getValue(item), k -> new HashSet<Object>()).remove(item);
//		return true;
//	}
//
//	@Override
//	public Set<Object> getMaxItems() {
//		return counters.get(counters.lastKey());
//
//	}
//}
