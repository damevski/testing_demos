import java.text.ParseException;
import java.util.AbstractMap;
import java.util.Map;

/*
 * based on code published on fuzzingbook.org
 */
public class URLDecoder {

    /*
     Decode the CGI-encoded string `s`:
        * replace "+" by " "
        * replace "%xx" by the character with hex number xx.
     Return the decoded string.  Raise `ValueError` for invalid inputs.
     */
    public static String cgi_decode(String s) throws ParseException {
        Map<Character, Integer> map = Map.ofEntries(
                new AbstractMap.SimpleEntry<Character, Integer>('0', 0),
                new AbstractMap.SimpleEntry<Character, Integer>('1', 1),
                new AbstractMap.SimpleEntry<Character, Integer>('2', 2),
                new AbstractMap.SimpleEntry<Character, Integer>('3', 3),
                new AbstractMap.SimpleEntry<Character, Integer>('4', 4),
                new AbstractMap.SimpleEntry<Character, Integer>('5', 5),
                new AbstractMap.SimpleEntry<Character, Integer>('6', 6),
                new AbstractMap.SimpleEntry<Character, Integer>('7', 7),
                new AbstractMap.SimpleEntry<Character, Integer>('8', 8),
                new AbstractMap.SimpleEntry<Character, Integer>('9', 9),
                new AbstractMap.SimpleEntry<Character, Integer>('a', 10),
                new AbstractMap.SimpleEntry<Character, Integer>('b', 11),
                new AbstractMap.SimpleEntry<Character, Integer>('c', 12),
                new AbstractMap.SimpleEntry<Character, Integer>('d', 13),
                new AbstractMap.SimpleEntry<Character, Integer>('e', 14),
                new AbstractMap.SimpleEntry<Character, Integer>('f', 15),
                new AbstractMap.SimpleEntry<Character, Integer>('A', 10),
                new AbstractMap.SimpleEntry<Character, Integer>('B', 11),
                new AbstractMap.SimpleEntry<Character, Integer>('C', 12),
                new AbstractMap.SimpleEntry<Character, Integer>('D', 13),
                new AbstractMap.SimpleEntry<Character, Integer>('E', 14),
                new AbstractMap.SimpleEntry<Character, Integer>('F', 15)
        );

        String t = "";
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '+') {
                t += ' ';
            } else if (c == '%') {
                char digit_high = s.charAt(i + 1);
                char digit_low = s.charAt(i + 2);
                if (map.containsKey(Character.valueOf(digit_high)) && map.containsKey(Character.valueOf(digit_low))) {
                    int v = map.get(Character.valueOf(digit_high)) * 16 + map.get(Character.valueOf(digit_low));
                    t += (char) v;
                } else {
                    throw new ParseException("Invalid encoding", i);
                }
                i += 2;
            } else {
                t += c;
            }
            i += 1;
        }
        return t;
    }
}
