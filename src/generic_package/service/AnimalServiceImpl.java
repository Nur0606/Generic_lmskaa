package generic_package.service;

import generic_package.dao.AnimalDaoImpl;
import generic_package.genericService.GenericService;
import generic_package.model.Animal;

import java.util.List;

public class AnimalServiceImpl implements GenericService<Animal> {
    GenericService<Animal> animalDao = new AnimalDaoImpl();

    @Override
    public String add(List<Animal> t) {
        return animalDao.add(t);
    }

    @Override
    public Animal getById(Long id) {
        return animalDao.getById(id);
    }

    @Override
    public List<Animal> getAll() {
        return animalDao.getAll();
    }

    @Override
    public List<Animal> sortByName(int number) {
        return animalDao.sortByName(number);
    }

    @Override
    public List<Animal> filterByGender(int number) {
        return animalDao.filterByGender(number);
    }

    @Override
    public List<Animal> clear() {
        return animalDao.clear();
    }
}
