package arrays_and_hashing;

import java.util.HashMap;


class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // Increment count for each char in s, decrement for each char in t
            map.merge(s.charAt(i), 1, Integer::sum);
            map.merge(t.charAt(i), -1, Integer::sum);
        }

        // If strings are anagrams, all values should be 0
        for (int v : map.values()) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();

        System.out.println(validAnagram.isAnagram("racecar", "carrace")); // Output: true

        System.out.println(validAnagram.isAnagram("jar", "jam")); // Output: false
    }

}
