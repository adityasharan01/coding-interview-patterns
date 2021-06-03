Using Java 8 you can do this in a very clean way:

String.join(delimiter, elements);
This works in three ways:

1) directly specifying the elements

String joined1 = String.join(",", "a", "b", "c");
2) using arrays

String[] array = new String[] { "a", "b", "c" };
String joined2 = String.join(",", array);
3) using iterables

List<String> list = Arrays.asList(array);
String joined3 = String.join(",", list);
