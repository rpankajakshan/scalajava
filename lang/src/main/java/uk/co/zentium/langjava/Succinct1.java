package uk.co.zentium.langjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Succinct1 {

    private static Map<String, List<String>> validKeyMap = new HashMap<>();

    static {
        List<String> l = new ArrayList<>();
        l.add("src");
        validKeyMap.put("logo", l);

        l = new ArrayList<>();
        l.add("cgid");
        l.add("src");
        validKeyMap.put("uuid", l);

        l = new ArrayList<>();
        l.add("cgid");
        l.add("src");
        validKeyMap.put("pcms", l);
    }

    private static Boolean hasValidAttributeKeys(String idType, Map<String, String> attributes) {

        return attributes.keySet()
                .stream()
                .mapToLong(item ->
                        validKeyMap.keySet().contains(idType)
                                && validKeyMap.get(idType).contains(item) ? 0L : 1L)
                .sum() == 0;
    }

    public static void main(String[] args) {
        assertFalse(hasValidAttributeKeys("uuid", map(new String[]{"who", "valsome"})));
        assertFalse(hasValidAttributeKeys("uuid", map(new String[]{"src", "EDITORIAL"},
                new String[]{"who", "valsome"})));
        assertTrue(hasValidAttributeKeys("uuid", map(new String[]{"src", "EDITORIAL"})));
    }

    private static Map<String, String> map(String[]... pairs) {
        Map<String, String> map = new HashMap<>();
        for (String[] pair : pairs) {
            map.put(pair[0], pair[1]);
        }
        return map;
    }
}