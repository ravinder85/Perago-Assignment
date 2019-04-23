package xyz.foobar.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import xyz.foobar.Diff;
import xyz.foobar.DiffEngineService;
import xyz.foobar.DiffException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DiffEngineServiceTest {
	@Mock
    private DiffEngineService service;

    @Before
    public void setUp() throws Exception {
        service = new DiffEngineService();
    }

 /*@Test
    public void ModifiedValuesNull throws Exception {
        assertNull(service.calculate(null, null));
    }*/

  /* @Test
    public void shouldReturnValues() throws Exception {
        assertNull(service.calculate(new Person(), null).getObj());
    }*/

   @Test
    public void expectedDiffWhenOriginal() throws Exception {
	   //when(service.calculate(original(), modified())).thenReturn(modified().getPet());
        assertThat(service.calculate(original(), modified()), is(modified()));
    }

  /*  @Test
    public void ListofChangedVales() throws Exception {
        assertThat(service.calculate(original(), modified()).getFields(), is(changedFields()));

    }*/

   /* @Test
    public void shouldReturnExpectedDiffWhenOriginalIsNullAndModifiedIsNotNull() throws Exception {
        assertThat(service.calculate(null, modified()).getFields(), is(allFields()));
    }*/
  /*  @Test
    public void shouldReturnExpectedDiffWhenOriginalIsNullAndModifiedIsNotNull() throws Exception {
        assertThat(service.calculate(original().getPet(), modified()).getFields(), is(allFields()));
    }*/

    
    private List<String> allFields() {
    	  Person pet1 = new Person();
          Pet pet=new Pet();
          pet.setName("Tom");
          pet.setType("Brown");
         pet1.setPet(pet);
         
          pet1.setPet(pet);
        List<String> changedFields = new ArrayList<>();
        changedFields.add("firstName");
        changedFields.add("surname");
        changedFields.add("friend");
        changedFields.add("pet");
        changedFields.add("nickNames");
        System.out.println("changedFields==="+changedFields);
        return changedFields;
    }

    private List<String> changedFields() {
        List<String> changedFields = new ArrayList<>();
        changedFields.add("firstName");
        changedFields.add("friend");
        changedFields.add("pet");
        changedFields.add("nickNames");
        System.out.println("changedFields2==="+changedFields);
        return changedFields;
    }

    private Diff<Person> diffObject() {
        Diff<Person> diff = new Diff<>();
        Person person = modified();
        diff.setObj(person);
        diff.getFields().addAll(changedFields());
        Diff<Person> friend = new Diff<>();
        Diff<Pet> pet1 = new Diff<>();
        friend.setObj(person.getFriend());
        friend.setParent("friend");
        friend.getFields().add("firstName");
        diff.setInner(friend);
        Pet pet=new Pet();
        pet.setName("Tom");
        pet.setType("Brown");
        person.setPet(pet);
        pet1.setObj(pet);
        System.out.println("diff1==="+diff); 
        return diff;
    }

    private Person original() {
        Person person = new Person();
        person.setFirstName("Fred");
        person.setSurname("Brown");
        Person friend = new Person();
        friend.setFirstName("Jim");
        Person pet1 = new Person();
        Pet pet=new Pet();
        pet.setName("Tom");
        pet.setType("Brown");
        person.setFriend(friend);
       
        pet1.setPet(pet);
        System.out.println("person original==="+person);
        return person;
    }

    private Person modified() {
        Person person = new Person();
        person.setFirstName("Fred");
        person.setSurname("Smith");
        Person friend = new Person();
        friend.setFirstName("Jim");
        person.setFriend(friend);
        person.getNickNames().add("scooter");
        person.getNickNames().add("biff");
        Person pet1 = new Person();
        Pet pet=new Pet();
        pet.setName("PetN");
        pet.setType("PetType");
        pet1.setPet(pet);
        System.out.println("person modified==="+person);
        return person;
    }



 

  @Test
    public void returnDiffValues() throws Exception {
        assertNull(service.apply(original(), null));
    } 

}    
