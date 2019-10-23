package com.java.context;

import com.java.model.Employee;
import com.java.model.Order;
import com.java.model.Student;
import com.java.model.Trip;

import java.util.ArrayList;
import java.util.List;

public class AppContext {
    public static final List<Employee> EMPLOYEE_LIST=new ArrayList<>();

    public static final List<Student> STUDENT_LIST= new ArrayList<>();
    public static final List<Trip> TRIP_LIST=new ArrayList<>();
    public static final List<Order> ORDER_LIST=new ArrayList<>();
    static {

        Student s1=new Student(1,"harihar");
        Student s2=new Student(2,"ramkrushna");
        STUDENT_LIST.add(s1);
        STUDENT_LIST.add(s2);
    }
    static {
        Employee e1=new Employee(10,"rabindra murkha","bhanjanagar");
        Employee e2=new Employee(11,"rabindra1 murkha","bhanj1anagar");
        EMPLOYEE_LIST.add(e1);
        EMPLOYEE_LIST.add(e2);
    }
    static {
        Trip t1=new Trip("aska","berhampur");
        Trip t2=new Trip("aska","bhanjanagar");
        TRIP_LIST.add(t1);
        TRIP_LIST.add(t2);
    }
    static {
        Order o1=new Order(1,"tv");
        Order o2=new Order(2,"cooler");
        ORDER_LIST.add(o1);
        ORDER_LIST.add(o2);
    }
}
