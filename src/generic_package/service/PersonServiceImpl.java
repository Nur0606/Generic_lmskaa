package generic_package.service;

import generic_package.dao.PersonDaoImpl;
import generic_package.genericService.GenericService;
import generic_package.model.Person;

import java.util.List;

public class PersonServiceImpl implements GenericService<Person>{
    GenericService<Person>personDao = new PersonDaoImpl();

    @Override
    public String add(List<Person> t) {
        return personDao.add(t);
    }

    @Override
    public Person getById(Long id) {
        return personDao.getById(id);
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public List<Person> sortByName(int number) {
        return personDao.sortByName(number);
    }

    @Override
    public List<Person> filterByGender(int number) {
        return personDao.filterByGender(number);
    }

    @Override
    public List<Person> clear() {
        return personDao.clear();
    }
}
