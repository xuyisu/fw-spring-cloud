package com.fwcloud.fwcloud_demo1;

import java.io.Serializable;

public class Person implements Serializable {

    static final long serialVersionUID = 1L;
    private java.lang.String id;
    private java.lang.String name;
    private int age;

    public Person() {
    }

    public java.lang.String getId() {
        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Person(java.lang.String id, java.lang.String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
