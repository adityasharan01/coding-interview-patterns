The syntax of ascii() is:

ascii(object)
ascii() Parameters
ascii() method takes an object (like: strings, list etc).

Return Value from ascii()
It returns a string containing a printable representation of an object.

For example, ö is changed to \xf6n, √ is changed to \u221a

The non-ASCII characters in the string are escaped using \x, \u or \U.

Example 1: How ascii() method works?
normalText = 'Python is interesting'
print(ascii(normalText))

otherText = 'Pythön is interesting'
print(ascii(otherText))

print('Pyth\xf6n is interesting')
Output

'Python is interesting'
'Pyth\xf6n is interesting'
Pythön is interesting
More Examples
randomList = ['Python', 'Pythön', 5]
print(ascii(randomList))
Output

['Python', 'Pyth\xf6n', 5]
