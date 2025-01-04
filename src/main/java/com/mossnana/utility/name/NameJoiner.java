package com.mossnana.utility.name;

import java.util.Arrays;
import java.util.Optional;

public class NameJoiner {
    public static String join(String[] args) {
        try {
            Optional<String> primary = Arrays.stream(args).findFirst();
            if (primary.isEmpty()) {
                return "";
            }

            String secondary = Arrays.stream(args).skip(1).filter(arg -> !arg.isEmpty()).reduce("", "%s %s"::formatted);
            return primary.get()+secondary;
        } catch (NullPointerException error) {
            return "";
        }
    }
}
