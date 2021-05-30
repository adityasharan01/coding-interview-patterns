The syntax of abs() method is:

abs(num)
abs() Parameters
abs() method takes a single argument:

num - a number whose absolute value is to be returned. The number can be:
integer
floating number
complex number
Return value from abs()
abs() method returns the absolute value of the given number.

For integers - integer absolute value is returned
For floating numbers - floating absolute value is returned
For complex numbers - magnitude of the number is returned
Example 1: Get absolute value of a number
# random integer
integer = -20
print('Absolute value of -20 is:', abs(integer))

#random floating number
floating = -30.33
print('Absolute value of -30.33 is:', abs(floating))
Output

Absolute value of -20 is: 20
Absolute value of -30.33 is: 30.33
Example 2: Get magnitude of a complex number
# random complex number
complex = (3 - 4j)
print('Magnitude of 3 - 4j is:', abs(complex))
Output

Magnitude of 3 - 4j is: 5.0
