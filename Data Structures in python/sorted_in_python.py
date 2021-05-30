The syntax of the sorted() function is:

sorted(iterable, key=None, reverse=False)
Parameters for the sorted() function
sorted() can take a maximum of three parameters:

iterable - A sequence (string, tuple, list) or collection (set, dictionary, frozen set) or any other iterator.
reverse (Optional) - If True, the sorted list is reversed (or sorted in descending order). Defaults to False if not provided.
key (Optional) - A function that serves as a key for the sort comparison. Defaults to None.
Example 1: Sort string, list, and tuple
# vowels list
py_list = ['e', 'a', 'u', 'o', 'i']
print(sorted(py_list))

# string
py_string = 'Python'
print(sorted(py_string))

# vowels tuple
py_tuple = ('e', 'a', 'u', 'o', 'i')
print(sorted(py_tuple))
Output

['a', 'e', 'i', 'o', 'u']
['P', 'h', 'n', 'o', 't', 'y']
['a', 'e', 'i', 'o', 'u']
Notice that in all cases that a sorted list is returned.

Note: A list also has the sort() method which performs the same way as sorted(). The only difference is that the sort() method doesn't return any value and changes the original list.

Example 2: Sort in descending order
The sorted() function accepts a reverse parameter as an optional argument.

Setting reverse = True sorts the iterable in the descending order.

# set
py_set = {'e', 'a', 'u', 'o', 'i'}
print(sorted(py_set, reverse=True))

# dictionary
py_dict = {'e': 1, 'a': 2, 'u': 3, 'o': 4, 'i': 5}
print(sorted(py_dict, reverse=True))

# frozen set
frozen_set = frozenset(('e', 'a', 'u', 'o', 'i'))
print(sorted(frozen_set, reverse=True))
Output

['u', 'o', 'i', 'e', 'a']
['u', 'o', 'i', 'e', 'a']
['u', 'o', 'i', 'e', 'a']
key Parameter in Python sorted() function
If you want your own implementation for sorting, sorted() also accepts a key function as an optional parameter.

Based on the returned value of the key function, you can sort the given iterable.

sorted(iterable, key=len)
Here, len() is Python's in-built function to count the length of an object.

The list is sorted based on the length of the element, from the lowest count to highest.

Example 3: Sort the list using sorted() having a key function
# take the second element for sort
def take_second(elem):
    return elem[1]


# random list
random = [(2, 2), (3, 4), (4, 1), (1, 3)]

# sort list with key
sorted_list = sorted(random, key=take_second)

# print list
print('Sorted list:', sorted_list)
Output

Sorted list: [(4, 1), (2, 2), (1, 3), (3, 4)]
Example 4: Sorting with multiple keys
Let us suppose that we have the following list:

# Nested list of student's info in a Science Olympiad
# List elements: (Student's Name, Marks out of 100, Age)

participant_list = [
    ('Alison', 50, 18),
    ('Terence', 75, 12),
    ('David', 75, 20),
    ('Jimmy', 90, 22),
    ('John', 45, 12)
]
