package me.sepdron.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CollectionUtils {

	private CollectionUtils() {}

	public static <K, V> Map<K, V> getMapAs(Map<?, ?> unconvertedMap, Class<K> keyClass, Class<V> valueClass) {
		Map<K, V> map = new LinkedHashMap<K, V>();
		unconvertedMap.forEach((key, val) -> {
			if(keyClass.isInstance(key)) {
				K castedKey = keyClass.cast(key);
				if (valueClass.isInstance(val)) map.put(castedKey, valueClass.cast(val));
				else if (val == null) map.put(castedKey, null);
			}
		});
		return map;
	}
	public static <K, V> Map<K, V> getAsMap(Object object, Class<K> keyClass, Class<V> valueClass) {
		if (!(object instanceof Map<?, ?>)) return null;
		return getMapAs((Map<?, ?>) object, keyClass, valueClass);
	}

	public static <T> List<T> getListAs(List<?> unconvertedList, Class<T> itemClass) {
		List<T> list = new ArrayList<T>();
		unconvertedList.forEach((item) -> {
			if (itemClass.isInstance(item)) list.add(itemClass.cast(item));
			else if (item == null) list.add(null);
		});
		return list;
	}
	public static <T> List<T> getAsList(Object object, Class<T> itemClass) {
		if (!(object instanceof List<?>)) return null;
		return getListAs((List<?>) object, itemClass);
	}

}
