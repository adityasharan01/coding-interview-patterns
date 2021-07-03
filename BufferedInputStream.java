https://stackoverflow.com/questions/18600331/why-is-using-bufferedinputstream-to-read-a-file-byte-by-byte-faster-than-using-f/18600383
Q:
72


37
I was trying to read a file into an array by using FileInputStream, 
and an ~800KB file took about 3 seconds to read into memory. 
I then tried the same code except with the FileInputStream wrapped into a BufferedInputStream and 
it took about 76 milliseconds. Why is reading a file byte by byte done so much faster with a BufferedInputStream even though 
I'm still reading it byte by byte? Here's the code (the rest of the code is entirely irrelevant). 
Note that this is the "fast" code. You can just remove the BufferedInputStream if you want the "slow" code:

InputStream is = null;

    try {
        is = new BufferedInputStream(new FileInputStream(file));

        int[] fileArr = new int[(int) file.length()];

        for (int i = 0, temp = 0; (temp = is.read()) != -1; i++) {
            fileArr[i] = temp;
        }
BufferedInputStream is over 30 times faster. Far more than that. So, why is this, and is it possible to make this code more efficient (without using any external libraries)?

A:
126

In FileInputStream, the method read() reads a single byte. From the source code:

/**
 * Reads a byte of data from this input stream. This method blocks
 * if no input is yet available.
 *
 * @return     the next byte of data, or <code>-1</code> if the end of the
 *             file is reached.
 * @exception  IOException  if an I/O error occurs.
 */
public native int read() throws IOException;
This is a native call to the OS which uses the disk to read the single byte. This is a heavy operation.

With a BufferedInputStream, the method delegates to an overloaded read() method that reads 8192 amount of bytes and buffers them until they are needed. It still returns only the single byte (but keeps the others in reserve). This way the BufferedInputStream makes less native calls to the OS to read from the file.

For example, your file is 32768 bytes long. To get all the bytes in memory with a FileInputStream, you will require 32768 native calls to the OS. With a BufferedInputStream, you will only require 4, regardless of the number of read() calls you will do (still 32768).

As to how to make it faster, you might want to consider Java 7's NIO FileChannel class, but I have no evidence to support this.
