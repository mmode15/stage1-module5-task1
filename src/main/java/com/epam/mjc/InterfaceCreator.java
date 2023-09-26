package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            int count = 0;
            for (String e : x) {
                if (Character.isUpperCase(e.charAt(0))) {
                    count++;
                }
            }
            return count == x.size();
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> evenValues = new ArrayList<>();
            ;
            for (Integer e : x) {
                if (e % 2 == 0) {
                    evenValues.add(e);
                }
            }
            x.addAll(evenValues);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();
            for (String value : values) {
                int size = value.split(" ").length;
                if (size > 3 && Character.isUpperCase(value.charAt(0)) && value.endsWith(".")) {
                    result.add(value);
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> result = new HashMap<>();
            for (String e : x) {
                result.put(e, e.length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> concatenatedList = new ArrayList<>(list1);
            concatenatedList.addAll(list2);
            return concatenatedList;
        };
    }
}
