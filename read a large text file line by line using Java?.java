How can I read a large text file line by line using Java?
Link : https://stackoverflow.com/questions/5868369/how-can-i-read-a-large-text-file-line-by-line-using-java?rq=1
A common pattern is to use

try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    String line;
    while ((line = br.readLine()) != null) {
       // process the line.
    }
}
You can read the data faster if you assume there is no character encoding.
e.g. ASCII-7 but it won't make much difference. It is highly likely that what you do with the data will take much longer.

EDIT: A less common pattern to use which avoids the scope of line leaking.

try(BufferedReader br = new BufferedReader(new FileReader(file))) {
    for(String line; (line = br.readLine()) != null; ) {
        // process the line.
    }
    // line is not visible here.
}
UPDATE: In Java 8 you can do

try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
        stream.forEach(System.out::println);
}
NOTE: You have to place the Stream in a try-with-resource block to ensure the #close method is called on it,
otherwise the underlying file handle is never closed until GC does it much later.
