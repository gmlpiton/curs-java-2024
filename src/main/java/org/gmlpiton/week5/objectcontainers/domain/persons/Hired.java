package org.gmlpiton.week5.objectcontainers.domain.persons;

public class Hired extends Person{
    private String company;
    final private String type = "employee";
    public Hired(String name, String cnp, int age) {
        super(name, cnp, age);

    }

    public Hired(String name, String cnp, int age, String company) {
        super(name, cnp, age);
        this.company = company;

    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + " Hired{" +
                "company='" + company + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
