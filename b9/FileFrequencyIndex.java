package b9;
import edu.princeton.cs.algs4.*;

import java.io.File;

public class FileFrequencyIndex {
    private ST<String, SET<File>> st;

    public FileFrequencyIndex() {
        st = new ST<String, SET<File>>();
    }

    // Đọc file và tạo chỉ mục tần số
    public void readFile(File file) {
        In in = new In(file);
        while (!in.isEmpty()) {
            String word = in.readString();
            if (!st.contains(word)) st.put(word, new SET<File>());
            SET<File> set = st.get(word);
            set.add(file);
        }
    }

    // Truy vấn tần số xuất hiện của một từ trong chỉ mục
    public int query(String word) {
        if (st.contains(word)) {
            SET<File> set = st.get(word);
            return set.size(); // Trả về số lần xuất hiện của từ trong các file
        } else {
            return 0; // Nếu từ không tồn tại trong chỉ mục
        }
    }

    public static void main(String[] args) {
        FileFrequencyIndex index = new FileFrequencyIndex();

        // Indexing files
        StdOut.println("Indexing files");
        for (String filename : args) {
            StdOut.println("  " + filename);
            File file = new File(filename);
            index.readFile(file);
        }

        // read queries from standard input, one per line
        StdOut.println("Enter word to query:");
        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            int frequency = index.query(query);
            StdOut.println("Frequency of '" + query + "': " + frequency);
        }
    }
}
