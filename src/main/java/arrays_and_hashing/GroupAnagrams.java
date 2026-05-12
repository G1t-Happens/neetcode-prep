package arrays_and_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>((int) (strs.length / 0.75f) + 1);

        for (String word : strs) {
            // Positional char-encoding
            char[] key = new char[26];
            for (int i = 0; i < word.length(); i++) {
                key[word.charAt(i) - 'a']++;
            }

            // Single-lookup get-or-create
            groups.computeIfAbsent(new String(key), k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();

        // Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"act", "pots", "tops", "cat", "stop", "hat"}));

        // Output: [["x"]]
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"x"}));

        // Output: [[""]]
        System.out.println(groupAnagrams.groupAnagrams(new String[]{""}));
    }

}
