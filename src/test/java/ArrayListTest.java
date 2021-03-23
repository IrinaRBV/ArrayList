import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayListTest {

    private ArrayListInterface people;

    @BeforeEach
    void createPerson() {
        people = new ArrayListPerson();
        // Заполняем массив из людей
        for (int i = 0; i < 10; i++) {
            people.add(new Person("Person" + i, 25, "Tester"));
        }
    }

    @Test
    void getIncorrectIndexShouldBeException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            people.get(10);
        });
    }

    @Test
    void getCorrectIndexShouldBeRightElement() {
        Person person = people.get(3);
        Assertions.assertEquals("Person3", person.getName());
    }

    @Test
    void getSizeListShouldBe10() {
        Assertions.assertEquals(10, people.size());
    }

    @Test
    void getClearListShouldBe0() {
        people.clear();
        Assertions.assertEquals(0, people.size());
    }

    @Test
    void whenRemoveByIndexSizeShouldBeDecreased() {
        Assertions.assertTrue(people.removeByIndex(2));
        Assertions.assertEquals(9, people.size());
    }

    @Test
    void whenRemoveByElementSizeShouldBeDecreased() {
        Person person = new Person("Tom", 20, "Manager");
        people.add(person);
        Assertions.assertEquals(11, people.size());
        Assertions.assertTrue(people.remove(person));
        Assertions.assertEquals(10, people.size());
    }

    @Test
    void whenAddElementSizeShouldBeIncreased() {
        Person person = new Person("Tom", 20, "Manager");
        people.add(person);
        Assertions.assertEquals(11, people.size());
    }

}
