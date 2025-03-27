package common.datastructures.gsprep;

public class SampleEntityClass implements Comparable<SampleEntityClass> {
    Integer salary;

    @Override
    public int compareTo(SampleEntityClass o) {
        return Integer.compare(this.salary, o.salary);
    }
}
