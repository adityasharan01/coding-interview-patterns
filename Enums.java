Enum declaration can be done outside a Class or inside a Class but not inside a Method.

// A simple enum example where enum is declared
// outside any class (Note enum keyword instead of
// class keyword)
enum Color
{
    RED, GREEN, BLUE;
}
  
public class Test
{
    // Driver method
    public static void main(String[] args)
    {
        Color c1 = Color.RED;
        System.out.println(c1);
    }
}

Important points of enum :

Every enum internally implemented by using Class.
/* internally above enum Color is converted to
class Color
{
     public static final Color RED = new Color();
     public static final Color BLUE = new Color();
     public static final Color GREEN = new Color();
}*/
Every enum constant represents an object of type enum.
enum type can be passed as an argument to switch statement.
  
Every enum constant is always implicitly public static final. Since it is static, we can access it by using enum Name. Since it is final, we can’t create child enums.
We can declare main() method inside enum. Hence we can invoke enum directly from the Command Prompt.
