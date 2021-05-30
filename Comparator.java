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

Here's a super short template to do the sorting right away :

Collections.sort(people,new Comparator<Person>(){
   @Override
   public int compare(final Person lhs,Person rhs) {
     //TODO return 1 if rhs should be before lhs 
     //     return -1 if lhs should be before rhs
     //     return 0 otherwise (meaning the order stays the same)
     }
 });
if it's hard to remember, try to just remember that it's similar (in terms of the sign of the number) to:

 lhs-rhs 
That's in case you want to sort in ascending order : from smallest number to largest number.
     
 20

For the sake of completeness, here's a simple one-liner compare method:

Collections.sort(people, new Comparator<Person>() {
    @Override
    public int compare(Person lhs, Person rhs) {  
        return Integer.signum(lhs.getId() - rhs.getId());  
    }
});
/////////////////////////////////////////////////////////
3

Two corrections:

You have to make an ArrayList of People objects:

ArrayList<People> preps = new ArrayList<People>(); 
After adding the objects to the preps, use:

Collections.sort(preps, new CompareId());
Also, add a CompareId class as:

class CompareId implements Comparator {  
    public int compare(Object obj1, Object obj2) {  
        People t1 = (People)obj1;  
        People t2 = (People)obj2;  

        if (t1.marks > t2.marks)  
            return 1;   
        else  
            return -1;
    }  
}
