public class Solution extends Reader4 {
    private char[] buffer = new char[4];
    private int size = 0;
    private int offset = 0;
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int read = 0;
        boolean eof = false;
        while(eof == false && read < n){
            int tmp = size > 0? size : read4(buffer);
            if(size == 0 && tmp == 0) eof = true;
            int bytes = Math.min(n - read, tmp);
            System.arraycopy(buffer, offset, buf, read, bytes);
            offset = (offset + bytes) % 4;
            size = tmp - bytes;
            read += bytes;
        }
        return read;
    }
}