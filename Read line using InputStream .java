Java - Read line using InputStream [duplicate]
Link :https://stackoverflow.com/questions/34954630/java-read-line-using-inputstream?noredirect=1&lq=1
ou should use BufferedReader with FileInputStreamReader if your read from a file

BufferedReader reader = new BufferedReader(new FileInputStreamReader(pathToFile));
or with InputStreamReader if you read from any other InputStream

BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
Then use its readLine() method in a loop

while(reader.ready()) {
     String line = reader.readLine();
}
But if you really love InputStream then you can use a loop like this

InputStream stream; 
char c; 
String s = ""; 
do {
   c = stream.read(); 
   if (c == '\n')
      break; 
   s += c + "";
} while (c != -1);
