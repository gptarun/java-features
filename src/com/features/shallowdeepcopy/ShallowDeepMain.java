package com.features.shallowdeepcopy;

public class ShallowDeepMain {
    /**------------------------------------- READ ME-------------------------------
     *
     * Shallow Copy: Shallow repetition is quicker. However, it’s “lazy” it handles pointers and references.
     * Rather than creating a contemporary copy of the particular knowledge the pointer points to,
     * it simply copies over the pointer price. So, each of the first and therefore the copy can have pointers
     * that reference constant underlying knowledge.
     *
     * Deep Copy: Deep repetition truly clones the underlying data. It is not shared between the first and therefore the
     * copy.
     *
     * @param args string array
     */
    public static void main(String[] args) {
        //------------------------- Shallow Copy Example------------------------------
        StudentShallow studentShallow = new StudentShallow();
        studentShallow.id = 1;
        Address address = new Address();
        address.id = 1;
        studentShallow.address = address;
        StudentShallow studentShallow1 = studentShallow.clone();
        studentShallow1.id = 5;
        studentShallow1.address.id = 2;

        /*
         * Expected output:
         * 1
         * 2
         * 5
         * 2
         */
        System.out.println(studentShallow.id);
        System.out.println(studentShallow.address.id);
        System.out.println(studentShallow1.id);
        System.out.println(studentShallow1.address.id);


        //------------------------- Deep Copy Example------------------------------
        StudentDeep studentDeep = new StudentDeep();
        studentDeep.id = 11;
        Address addressDeep = new Address();
        addressDeep.id = 11;
        studentDeep.address = addressDeep;
        StudentDeep studentDeep1 = studentDeep.clone();
        studentDeep1.address.id = 22;

        /*
         * Expected output:
         * 11
         * 22
         */
        System.out.println(studentDeep.address.id);
        System.out.println(studentDeep1.address.id);
    }
}
