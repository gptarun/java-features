package common.features.shallowdeepcopy;

public class StudentShallow implements Cloneable {
    int id;
    Address address;

    /**---------------------READ ME---------------------------
     * This is the Example of Shallow Copy, as we are directly calling the clone function for StudentShallow.
     * We are not handling the Address here
     * @return student object
     */
    @Override
    public StudentShallow clone() {
        try {
            return (StudentShallow) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
