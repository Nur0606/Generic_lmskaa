package generic_package.genericService;

import java.util.List;

public interface GenericService <T> {
    String add(List<T> t);
    T getById(Long id);
    List<T> getAll();
    List<T> sortByName(int number); //1 ди басканда ascending, 2 ни басканда descending кылып сорттосун
    List<T> filterByGender(int number); //1 ди басканда female, 2 ни басканда male кылып фильтрлесин
    List<T> clear();
}
