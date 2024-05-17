package b1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Main {
    public static void main(String[] args) {
        // insert a bunch of strings
        String[] strings = { "it", "was", "the", "best", "of", "times", "it", "was", "the", "worst" };

        IndexMaxPQ<String> pq = new IndexMaxPQ<String>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }
        System.out.println("In các từ khoá và vị trí của các từ:");
        // print each key using the iterator
        for (int i : pq) {
            StdOut.println(i + " " + strings[i]);
        }
        // increase or decrease the key
        for (int i = 0; i < strings.length; i++) {
            if (StdRandom.bernoulli(0.5))
                pq.increaseKey(i, strings[i] + strings[i]);
            else
                pq.decreaseKey(i, strings[i].substring(0, 1));
        }
        System.out.println("In các từ khoá và vị trí của các từ sau khi random tăng giảm key:");
        // delete and print each key
        while (!pq.isEmpty()) {
            String key = pq.maxKey();
            int i = pq.delMax();
            StdOut.println(i + " " + key);
        }
    }
}
