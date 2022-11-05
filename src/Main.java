import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Tag> tags = new ArrayList<Tag>();
        try {
            Scanner cin = new Scanner(new FileInputStream("input.txt"));
            int b, l;
            char c;
            while (cin.hasNextLine()) {
                b = cin.nextInt();
                l = cin.nextInt();
                c = cin.next().charAt(0);
                tags.add(new Tag(b, l, c));
            }
        } catch (Exception e) {

        }
        String s = "";
        int curLen = 0;
        for (Tag tag : tags) {
            int beg = curLen - tag.back;
            for (int i = beg; i < (beg + tag.len); i++) {
                s += s.charAt(i);
            }
            s += tag.nextChar;
            curLen += tag.len + 1;
        }
        try {
            PrintWriter out = new PrintWriter("output.txt");
            out.println(s);
            out.close();
        } catch (Exception e) {
            return;
        }

    }
}