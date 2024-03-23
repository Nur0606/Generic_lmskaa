package generic_package.dao;

import generic_package.db.Database;
import generic_package.enums.Gender;
import generic_package.genericService.GenericService;
import generic_package.model.Animal;

import java.util.*;

public class AnimalDaoImpl implements GenericService<Animal> {
    @Override
    public String add(List<Animal> t) {
        Database.getAnimals.addAll(t);
        return "Success added!✅";
    }

    @Override
    public Animal getById(Long id) {
        for (Animal getAnimal : Database.getAnimals) {
            if (getAnimal.getId().equals(id)) {
                return getAnimal;
            }
        }
        System.out.println("Animal not correct!");
        return null;
    }

    @Override
    public List<Animal> getAll() {
        return Database.getAnimals;
    }

    @Override
    public List<Animal> sortByName(int number) {
        if (number == 1) {
            Comparator<Animal> animalComparator = Comparator.comparing(Animal::getName);
            Database.getAnimals.sort(animalComparator);
            return Database.getAnimals;
        } else if (number == 2) {
            Comparator<Animal> animalComparator = Comparator.comparing(Animal::getName).reversed();
            Database.getAnimals.sort(animalComparator);
            return Database.getAnimals;
        }
        System.out.println("Родной 1 же 2 танда");
        return null;
    }


    @Override
    public List<Animal> filterByGender(int number) {
        List<Animal> male = new ArrayList<>();
        List<Animal> female= new ArrayList<>();
        if (number==1){
            for (Animal getAnimal : Database.getAnimals) {
                if (getAnimal.getGender().equals(Gender.male)) {
                    male.add(getAnimal);
                }
            }
            return male;
        } else if (number==2) {
            for (Animal getAnimal : Database.getAnimals) {
                if (getAnimal.getGender().equals(Gender.female)){
                    female.add(getAnimal);
                }
            }
            return female;


        }
        System.out.println("Gender not found!");
        return null;
    }

    @Override
    public List<Animal> clear() {
        Database.getAnimals.clear();
        return Database.getAnimals;
    }

}
