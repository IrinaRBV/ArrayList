public class Main {
    public static void main(String[] args) {
        ArrayListInterface people = new ArrayListPerson();
        people.add(new Person("Tom", 22, "Tester"));
        people.add(new Person("Carlos", 23, "Tester"));
        people.add(new Person("Cody", 24, "Manager"));
        people.add(new Person("Daniel", 25, "Manager"));
        people.add(new Person("George", 26, "Programmer"));
        people.add(new Person("Gloria", 27, "Programmer"));

        System.out.println(people.size());
        System.out.println(people.get(10));
    }
}
