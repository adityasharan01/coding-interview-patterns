public class ComparatorDemo {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Joe", 24),
                new Person("Pete", 18),
                new Person("Chris", 21)
        );
        Collections.sort(people, (a, b) -> a.name.compareToIgnoreCase(b.name));
        System.out.println(people);
        Collections.sort(people, (a, b) -> a.age < b.age ? -1 : a.age == b.age ? 0 : 1);
        System.out.println(people);
    }
}
class LexicographicComparator implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        return a.name.compareToIgnoreCase(b.name);
    }
}

class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        return a.age < b.age ? -1 : a.age == b.age ? 0 : 1;
    }
}

class Person {

    String name;
    int age;

    Person(String n, int a) {
        name = n;
        age = a;
    }

    @Override
    public String toString() {
        return String.format("{name=%s, age=%d}", name, age);
    }
}
