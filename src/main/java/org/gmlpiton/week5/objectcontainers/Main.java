package org.gmlpiton.week5.objectcontainers;

import org.gmlpiton.week5.objectcontainers.domain.hobbies.Address;
import org.gmlpiton.week5.objectcontainers.domain.hobbies.Country;
import org.gmlpiton.week5.objectcontainers.domain.hobbies.Hobby;
import org.gmlpiton.week5.objectcontainers.domain.persons.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting object containers appli");

        Address myAddress = new Address();
        System.out.println(myAddress);

        Address myAddress1 = new Address("Florilor", 1, "700400");
        myAddress1.setOtherAddressData("Bl. M2 et. 1 ap. 7");
        System.out.println(myAddress1);
        myAddress1.setCountry("France");

        Address myAddress2 = new Address("Florilor", 1, "700400");
        myAddress2.setOtherAddressData("Bl. M2 et. 1 ap. 7");
        System.out.println(myAddress2);
        myAddress1.setCountry("UK");

        Person person1 = new Student("John Smith", "1901231221111", 21, "Info");
        Person person2 = new Student("John Adams", "1921231221111", 19, "Math");
        Person person3 = new Student("Ada Jones", "1891231221111", 23, "AC");
        Person person4 = new Hired("Zada Zoak", "1891231221111", 18, "Amazon");
        Person person5 = new Unemployed("Ada Adamson", "1891231221111", 18);


        Hobby hobby1 = new Hobby("swimming");
        hobby1.setFrequency(3);

        person1.addHobby(hobby1);
        person2.addHobby(hobby1);
        person3.addHobby(hobby1);

        Hobby hobby2 = new Hobby("cycling");
        hobby2.setFrequency(3);
        person3.addHobby(hobby2);
        person4.addHobby(hobby2);
        person5.addHobby(hobby2);

        Hobby hobby3 = new Hobby("climbing");
        hobby2.setFrequency(4);
        person1.addHobby(hobby3);
        person4.addHobby(hobby3);
        person5.addHobby(hobby3);

        Country c1 = new Country("UK");
        Country c2 = new Country("France");
        Country c3 = new Country("Romania");
        Country c4 = new Country("US", "North America");
        Country c5 = new Country("Japan", "Asia");
        Country c6 = new Country("Brasil", "South America");

        Address a1 = new Address(c1);
        Address a2 = new Address(c2);
        Address a3 = new Address(c3);
        Address a4 = new Address(c4);
        Address a5 = new Address(c5);
        Address a6 = new Address(c6);


        List<Address> hobby1Addresses = new ArrayList<>();
        hobby1Addresses.add(a1);
        hobby1Addresses.add(a2);
        hobby1Addresses.add(a4);
        hobby1Addresses.add(a6);

        hobby1.setAddressList(hobby1Addresses);

        List<Address> hobby2Addresses = new ArrayList<>();
        hobby2Addresses.add(a1);
        hobby2Addresses.add(a2);
        hobby2Addresses.add(a3);
        hobby2Addresses.add(a5);

        hobby2.setAddressList(hobby2Addresses);


        List<Address> hobby3Addresses = new ArrayList<>();
        hobby3Addresses.add(a1);
        hobby3Addresses.add(a2);
        hobby3Addresses.add(a3);
        hobby3Addresses.add(a5);
        hobby3Addresses.add(a4);
        hobby3Addresses.add(a6);

        hobby3.setAddressList(hobby3Addresses);


        TreeSet<Person> personSet = new TreeSet<>(new CombinedComparator());
        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person4);
        personSet.add(person3);
        personSet.add(person5);

        for (Person person : personSet) {
            System.out.println(person);
        }


        HashMap<Person, List<Hobby>> hobbiesPersons = new HashMap<>();
        hobbiesPersons.put(person1, person1.getHobbies());
        hobbiesPersons.put(person2, person2.getHobbies());
        hobbiesPersons.put(person3, person3.getHobbies());

        System.out.println(hobbiesPersons.keySet());

        for (Person person : hobbiesPersons.keySet()) {
            System.out.println(person);
            System.out.println(person.getName() + " hobbies: ");
            System.out.println("--" + hobbiesPersons.get(person));
        }

        System.out.println("Printing where person3 can practice the hobbies");
        List<Hobby> li =  hobbiesPersons.get(person3);

        for (Hobby hobby : li)
        {
            System.out.println(hobby.getHobbyName());
            for (Address a: hobby.getAddressList())
            {
                System.out.println("Country : " + a.getCountry());
            }
        }




    }
}
