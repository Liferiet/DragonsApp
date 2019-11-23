package util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataCheckerTest {

    private static DataChecker checker;

    @BeforeAll
    static void init() {
        checker = new DataChecker();
    }

    @Test
    void testCheckEmail1() {
        assertTrue(checker.checkEmail("cat@lady.com"));
    }

    @Test
    void testCheckEmail2() {
        assertTrue(checker.checkEmail("cat.lady@lady.com"));
    }

    @Test
    void testCheckEmail3() {
        assertTrue(checker.checkEmail("cat-dragon@lady.com"));
    }

    @Test
    void testCheckEmail4() {
        assertTrue(checker.checkEmail("cat----@lady.com"));
    }

    @Test
    void testCheckEmail5() {
        assertFalse(checker.checkEmail("catlady.com"));
    }

    @Test
    void testCheckEmail6() {
        assertFalse(checker.checkEmail("cat@ladycom"));
    }

    @Test
    void testCheckEmail7() {
        assertFalse(checker.checkEmail("cat@.com"));
    }
    @Test
    void testCheckEmail8() {
        assertFalse(checker.checkEmail("@lady.com"));
    }

    @Test
    void testCheckEmail9() {
        assertFalse(checker.checkEmail("\'cat----@lady.com"));
    }

    @Test
    void testCheckEmail10() {
        assertFalse(checker.checkEmail("\"cat----@lady.com"));
    }

    @Test
    void testCheckNickname1() {
        assertTrue(checker.checkNickname("KobietaKot"));
    }

    @Test
    void testCheckNickname2() {
        assertFalse(checker.checkNickname("Kobieta Kot"));
    }

    @Test
    void testCheckNickname3() {
        assertTrue(checker.checkNickname("999878"));
    }

    @Test
    void testCheckNickname4() {
        assertFalse(checker.checkNickname(""));
    }

    @Test
    void testCheckNickname5() {
        assertFalse(checker.checkNickname("a"));
    }

    @Test
    void testCheckNickname6() {
        assertFalse(checker.checkNickname("as"));
    }

    @Test
    void testCheckNickname7() {
        assertTrue(checker.checkNickname("asd"));
    }

    @Test
    void testCheckNickname8() {
        assertFalse(checker.checkNickname("asd?"));
    }

    @Test
    void testCheckNickname9() {
        assertFalse(checker.checkNickname("asd="));
    }

    @Test
    void testCheckNickname10() {
        assertFalse(checker.checkNickname("asd:"));
    }

    @Test
    void testCheckPassword1() {
        assertTrue(checker.checkPassword("A1a..."));
    }

    @Test
    void testCheckPassword2() {
        assertTrue(checker.checkPassword("........Agea2"));
    }

    @Test
    void testCheckPassword3() {
        assertFalse(checker.checkPassword(""));
    }

    @Test
    void testCheckPassword4() {
        assertFalse(checker.checkPassword("12312424"));
    }

    @Test
    void testCheckPassword5() {
        assertFalse(checker.checkPassword("AFAWFAWEF"));
    }

    @Test
    void testCheckPassword6() {
        assertFalse(checker.checkPassword("____@!#%%#"));
    }

    @Test
    void testCheckPassword7() {
        assertFalse(checker.checkPassword("AaAaAaAaAaAa"));
    }

    @Test
    void testCheckPassword8() {
        assertTrue(checker.checkPassword("asd1A-"));
    }

    @Test
    void testCheckPassword9() {
        assertFalse(checker.checkPassword("A1a............................"));
    }
}