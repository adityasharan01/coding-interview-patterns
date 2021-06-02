 Using BFS (Breadth–First Search)
We can iteratively traverse the given directory, and print all files present within it and its sub-directories using Breadth–first search. Following is the complete algorithm:

Create an empty queue of File class and enqueue the root directory.
Loop till queue becomes empty (all files and directories present inside the root directory are processed)
Pop front File from the queue.
If the popped File is a directory, get the list of all files and directories present in it, add each directory to the queue and print every file.

import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;
 
class Main
{
    // Iterative function to traverse a given directory in Java using BFS
    public static void listFilesIteratively(File root)
    {
        // maintain a queue to store files and directories
        Queue<File> queue = new ArrayDeque<>();
 
        // add root directory to the queue
        queue.add(root);
 
        // loop till the queue is empty. i.e., all files and directories present
        // inside the root directory are processed
        while (!queue.isEmpty())
        {
            // get the next file/directory from the queue
            File current = queue.poll();
 
            // get the list of all files and directories in `current`
            File[] listOfFilesAndDirectory = current.listFiles();
 
            // `listFiles()` returns non-null array if `current` denotes a directory
            if (listOfFilesAndDirectory != null)
            {
                // iterate over the list of the files and directories in
                // the current directory
                for (File file: listOfFilesAndDirectory)
                {
                    // if the current file is a directory
                    if (file.isDirectory()) {
                        queue.add(file);
                    }
                    // otherwise, print it
                    else {
                        System.out.println(file);
                    }
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        // root directory
        String dir = "/var/www/html";
        File rootDir = new File(dir);
 
        listFilesIteratively(rootDir);
    }
}
