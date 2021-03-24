import org.junit.jupiter.api.*;

@DisplayName("test arrayList")
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

    @Nested
    @DisplayName("index check method")
    class checkIndex{

        @Test
        @DisplayName("when incorrect index")
        void getIncorrectIndexShouldBeException() {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                people.get(10);
            });
        }

        @Test
        @DisplayName("when correct index")
        void getCorrectIndexShouldBeRightElement() {
            Person person = people.get(3);
            Assertions.assertEquals("Person3", person.getName());
        }

        @Test
        @DisplayName("when get size list")
        void getSizeListShouldBe10() {
            Assertions.assertEquals(10, people.size());
        }
    }

    @Test
    @DisplayName("when clear list")
    void getClearListShouldBe0() {
        people.clear();
        Assertions.assertEquals(0, people.size());
    }

    @Nested
    @DisplayName("change arrayList object method")
    class changeListObject {

        @Test
        @DisplayName("when remove object by index in the list")
        void whenRemoveByIndexSizeShouldBeDecreased() {
            Assertions.assertTrue(people.removeByIndex(2));
            Assertions.assertEquals(9, people.size());
        }

        @Test
        @DisplayName("when remove object in the list")
        void whenRemoveByElementSizeShouldBeDecreased() {
            Person person = new Person("Tom", 20, "Manager");
            people.add(person);
            Assertions.assertEquals(11, people.size());
            Assertions.assertTrue(people.remove(person));
            Assertions.assertEquals(10, people.size());
        }

        @Test
        @DisplayName("when add object in the list")
        void whenAddElementSizeShouldBeIncreased() {
            Person person = new Person("Tom", 20, "Manager");
            people.add(person);
            Assertions.assertEquals(11, people.size());
        }
    }

}
