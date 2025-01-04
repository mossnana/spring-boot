package com.mossnana.utility.name;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NameJoinerTest {
    @Test
    void emptyValue() {
        Assertions.assertEquals("", NameJoiner.join(new String[]{}));
        Assertions.assertEquals("", NameJoiner.join(new String[]{null}));
        Assertions.assertEquals("", NameJoiner.join(new String[]{
                null,
                null,
                null,
        }));
    }

    @Test
    void firstNameOnly() {
        Assertions.assertEquals("Perm", NameJoiner.join(new String[]{
                "Perm"
        }));
    }

    @Test
    void firstNameAndLastName() {
        Assertions.assertEquals("Perm Chao", NameJoiner.join(new String[]{
                "Perm", "Chao"
        }));
        Assertions.assertEquals("Perm ณ. จ้ะ", NameJoiner.join(new String[]{
                "Perm", "ณ. จ้ะ"
        }));
    }

    @Test
    void multiNamePosition() {
        Assertions.assertEquals("Perm Chao", NameJoiner.join(new String[]{
                "Perm", "Chao"
        }));
        Assertions.assertEquals("เพิ่ม ณ. จ้ะ จ้ะ", NameJoiner.join(new String[]{
                "เพิ่ม", "ณ.", "จ้ะ", "จ้ะ"
        }));
    }
}