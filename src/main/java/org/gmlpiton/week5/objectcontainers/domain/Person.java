package org.gmlpiton.week5.objectcontainers.domain;


public abstract class Person implements Comparable<Person>
{
    private String name;
    protected String type;
    private final String cnp;
    private int age;

    public Person(final String name, final String cnp, final int age)
    {
        this.name = name;
        this.cnp = cnp;
        this.age = age;
    }

    public String getCnp()
    {
        return cnp;
    }

    public int getAge()
    {
        return age;
    }

    public void print()
    {
        System.out.println(name + ", " + type);
    }

    @Override
    public boolean equals(Object obj)
    {
        return cnp.equals(((Person) obj).getCnp());
    }

    @Override
    public int hashCode()
    {
        return Integer.parseInt(cnp);
    }

    @Override
    public int compareTo(Person person)
    {
        return this.age - person.getAge();
    }
}
