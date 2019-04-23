package xyz.foobar.test;

import xyz.foobar.Diff;
import xyz.foobar.DiffEngineService;
import xyz.foobar.DiffException;

public class TestDifff {

    public static void main(String[] args) throws DiffException {
        DiffEngineService x = new DiffEngineService();
        Person original = new Person();
        Pet pet=new Pet();
        pet.setName("Dog");
        pet.setType("Rover");
        original.setPet(pet);
        original.setFirstName("Fred");
        original.setSurname("Smith");
        original.setFriend(null);
        original.setPet(pet);
        original.setNickNames(null);
        
        
       
        Person modified = new Person();
        modified.setSurname("Jones");
        modified.setFirstName("Ravinder");
        modified.setPet(pet);
      
      
        Diff<Person> calculate = x.calculate(original, modified);
        System.out.println("calculate==="+calculate);
        Person apply = x.apply(original, calculate);
        System.out.println(apply);
        
        Person friend = new Person();
        friend.setFirstName("Tom");
        friend.setSurname("Brown");
        modified.setFriend(friend);
        
        
        original.setFirstName("Fred");
        original.setSurname("Smith");
        
      

        
    }
}
