package common.java8features.functionalinterface;

@FunctionalInterface
public interface FIWithEquals {
    int compare(Object o1, Object o2);
    boolean equals(Object obj);
}
