import generic_package.enums.Gender;
import generic_package.genericId.GenericId;
import generic_package.genericService.GenericService;
import generic_package.model.Animal;
import generic_package.model.Person;
import generic_package.service.AnimalServiceImpl;
import generic_package.service.PersonServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GenericService<Person> personService = new PersonServiceImpl();
        GenericService<Animal>animalService = new AnimalServiceImpl();
        while (true){
            System.out.println("""
                   1.Animal
                   2.Person
                   3.Stop
                    """);
            switch (scanner.nextInt()){
                case 1:
                    boolean animalwhile = true;
                    while (animalwhile){
                        System.out.println("""
                             1.Add Animal
                             2.Get by id Animal
                             3.Get all Animal
                             4.Sort by name Animal
                             5.Filter by gender Animal
                             6.Clear Animal
                             7.Exit
                                """);
                       switch (scanner.nextInt()){
                           case 1->{
                               Animal animal = new Animal();
                               List<Animal> animals = new ArrayList<>(List.of(animal));
                               animal.setId(GenericId.genericAnimalId());
                               System.out.println("Enter Animal Name: ");
                               String name = scanner.next();
                               animal.setName(name);
                               System.out.println("Enter Animal age:");
                               int age = scanner.nextInt();
                               animal.setAge(age);
                               System.out.println("Enter Animal Gender:(male/female)");
                               Gender gender = Gender.valueOf(scanner.next());
                               animal.setGender(gender);
                               System.out.println(animalService.add(animals));
                           }
                           case 2-> {
                               System.out.println("Enter Animal id: ");
                               Long id = scanner.nextLong();
                               System.out.println(animalService.getById(id));
                           }
                           case 3-> System.out.println(animalService.getAll());
                           case 4->{
                               System.out.println("Enter Animal sort number:(1/2)");
                               int number = scanner.nextInt();
                               System.out.println(animalService.sortByName(number));
                           }
                           case 5->{
                               System.out.println("Enter Animal filter Gender number:(1:male/2:female)");
                               int number = scanner.nextInt();
                               System.out.println(animalService.filterByGender(number));
                           }
                           case 6-> System.out.println(animalService.clear());
                           case 7-> animalwhile = false;
                           default -> System.out.println("Number not found!");
                       }
                    }
                    break;
                case 2:
                   boolean personWhile  = true;
                    while (personWhile){
                        System.out.println("""
                                1.Add Person
                             2.Get by id Person
                             3.Get all Person
                             4.Sort by name Person
                             5.Filter by gender Person
                             6.Clear Person
                             7.Exit
                                """);
                        switch (scanner.nextInt()){
                            case 1->{
                                Person person = new Person();
                                List<Person> persons = new ArrayList<>(List.of(person));
                                person.setId(GenericId.genericPersonId());
                                System.out.println("Enter Person Name: ");
                                String name = scanner.next();
                                person.setName(name);
                                System.out.println("Enter Person age:");
                                int age = scanner.nextInt();
                                person.setAge(age);
                                System.out.println("Enter Person Gender:(male/female)");
                                Gender gender = Gender.valueOf(scanner.next());
                                person.setGender(gender);
                                System.out.println(personService.add(persons));
                            }
                            case 2->{
                                System.out.println("Enter Person id: ");
                                Long id = scanner.nextLong();
                                System.out.println(personService.getById(id));
                            }
                            case 3-> System.out.println(personService.getAll());
                            case 4->{
                                System.out.println("Enter Person sort number:(1/2)");
                                int number = scanner.nextInt();
                                System.out.println(personService.sortByName(number));
                            }
                            case 5->{
                                System.out.println("Enter Person sort number:(1:male/2:female)");
                                int number = scanner.nextInt();
                                System.out.println(personService.filterByGender(number));
                            }
                            case 6-> System.out.println(personService.clear());
                            case 7-> personWhile = false;
                            default -> System.out.println("Number not found!");
                        }
                    }
                    break;
                case 3:return;
                default:
                    System.out.println("1/2/3 yes");
            }
        }
    }
}