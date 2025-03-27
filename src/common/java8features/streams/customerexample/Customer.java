package common.java8features.streams.customerexample;

import java.util.Date;

public class Customer {
    Long id;
    String name;
    Date dob;
    String department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Customer(Long id, String name, Date dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public Customer(Long id, String name, Date dob, String department) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.department = department;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
