The syntax of enumerate() is:

enumerate(iterable, start=0)
enumerate() Parameters
enumerate() method takes two parameters:

iterable - a sequence, an iterator, or objects that supports iteration
start (optional) - enumerate() starts counting from this number. If start is omitted, 0 is taken as start.
Return Value from enumerate()
enumerate() method adds counter to an iterable and returns it. The returned object is a enumerate object.

You can convert enumerate objects to list and tuple using list() and tuple() method respectively.


Example 1: How enumerate() works in Python?
grocery = ['bread', 'milk', 'butter']
enumerateGrocery = enumerate(grocery)

print(type(enumerateGrocery))

# converting to list
print(list(enumerateGrocery))

# changing the default counter
enumerateGrocery = enumerate(grocery, 10)
print(list(enumerateGrocery))
Output

<class 'enumerate'>
[(0, 'bread'), (1, 'milk'), (2, 'butter')]
[(10, 'bread'), (11, 'milk'), (12, 'butter')]
Example 2: Looping Over an Enumerate object
grocery = ['bread', 'milk', 'butter']

for item in enumerate(grocery):
  print(item)

print('\n')
for count, item in enumerate(grocery):
  print(count, item)

print('\n')
# changing default start value
for count, item in enumerate(grocery, 100):
  print(count, item)
Output

(0, 'bread')
(1, 'milk')
(2, 'butter')

0 bread
1 milk
2 butter

100 bread
101 milk
102 butter
