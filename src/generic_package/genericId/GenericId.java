package generic_package.genericId;

public class GenericId {
    public static Long animalId = 0L;
    public static Long personId = 0L;
    public static long genericAnimalId(){
        return ++animalId;
    }
    public static long genericPersonId(){
        return ++personId;
    }
}
