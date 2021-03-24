import java.util.Arrays;

public class ArrayListPerson implements ArrayListInterface {
    private int size = 0;
    private Person[] array = new Person[10];

    @Override
    public void add(Person person) {
        // Если массив заполнен, то увеличиваем на x2
        if(size >= array.length) {
            Person[] newArray = new Person[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = person;
        size++;
    }

    @Override
    public Person get(int index) {
        checkIndexArray(index);
        return array[index];
    }

    @Override
    public boolean remove(Person person) {
        for (int i = 0; i < size; i++) {
            if(array[i].equals(person)) {
                return removeByIndex(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeByIndex(int index) {
        checkIndexArray(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        Person[] array = new Person[10];
    }

    @Override
    public int size() {
        return size;
    }

    // Бросаем exception, если выходим за предел массива
    private void checkIndexArray(int index) {
        if(index < 0 || index >= size) {
            String textError = String.format("Index %d not found", index);
            throw new IndexOutOfBoundsException(textError);
        }
    }

    @Override
    public String toString() {
        return "ArrayListPerson{" +
                "size=" + size +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
