package generic_package.dao;

import generic_package.db.Database;
import generic_package.enums.Gender;
import generic_package.genericService.GenericService;
import generic_package.model.Animal;
import generic_package.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonDaoImpl implements GenericService<Person> {
    @Override
    public String add(List<Person> t) {
        Database.getPersons.addAll(t);
        return "Success added!✅";
    }

    @Override
    public Person getById(Long id) {
        for (Person getPerson : Database.getPersons) {
            if (getPerson.getId().equals(id)){
                return getPerson;
            }
        }
        System.out.println("Person not correct!❌");
        return null;
    }

    @Override
    public List<Person> getAll() {
        return Database.getPersons;
    }

    @Override
    public List<Person> sortByName(int number) {
        if (number == 1) {
            Comparator<Person> personComparator = Comparator.comparing(Person::getName);
            Database.getPersons.sort(personComparator);
            return Database.getPersons;
        } else if (number == 2) {
            Comparator<Person> personComparator = Comparator.comparing(Person::getName).reversed();
            Database.getPersons.sort(personComparator);
            return Database.getPersons;
        }
        System.out.println("Родной 1 же 2 танда");
        return null;
    }

    @Override
    public List<Person> filterByGender(int number) {
        List<Person> male = new ArrayList<>();
        List<Person> female= new ArrayList<>();
        if (number==1){
            for (Person person : Database.getPersons) {
                if (person.getGender().equals(Gender.male)) {
                    male.add(person);
                }
            }
            return male;
        } else if (number==2) {
            for (Person person : Database.getPersons) {
                if (person.getGender().equals(Gender.female)){
                    female.add(person);
                }
            }
            return female;


        }
        System.out.println("Gender not found!");
        return null;
    }

    @Override
    public List<Person> clear() {
        Database.getPersons.clear();
        return Database.getPersons;
    }
}
