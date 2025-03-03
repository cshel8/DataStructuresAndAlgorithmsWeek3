import java.util.Map;
import java.util.TreeMap;
public class FrequencyCounter {
    public static void main(String[] args) {
        int minLen = 0;
        Map<String, Integer> st = new TreeMap<>();
        String[] tinyTale = {
                "it was the best of times it was the worst of times",
                "it was the age of wisdom it was the age of foolishness",
                "it was the epoch of belief it was the epoch of incredulity",
                "it was the season of light it was the season of darkness",
                "it was the spring of hope it was the winter of despair"
        };
        for (String sentence : tinyTale) {
            String [] words = sentence.split("\\s+");
            for (String word : words) {
                if (word.length() < minLen) continue;
                if (!st.containsKey(word)) {
                    st.put(word, 1);
                } else {
                    st.put(word, st.get(word) + 1);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : st.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}