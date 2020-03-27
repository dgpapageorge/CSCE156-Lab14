package unl.cse.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonValidatorTests {

    @Test
    void validatorTest() {
        //Valid tests
        assertTrue(JsonValidator.isValidJSON("{}"));
        assertTrue(JsonValidator.isValidJSON("[]"));
        assertTrue(JsonValidator.isValidJSON("{[]}"));
        assertTrue(JsonValidator.isValidJSON("{}[]{}[]{}"));
        assertTrue(JsonValidator.isValidJSON("{[{[[[]]]}]}"));
        assertTrue(JsonValidator.isValidJSON("{{{{{{{{}}}}}}}}"));

        assertFalse(JsonValidator.isValidJSON("{"));
        assertFalse(JsonValidator.isValidJSON("["));
        assertFalse(JsonValidator.isValidJSON("}"));
        assertFalse(JsonValidator.isValidJSON("]"));
        assertFalse(JsonValidator.isValidJSON("}{"));
        assertFalse(JsonValidator.isValidJSON("]["));
        assertFalse(JsonValidator.isValidJSON("{[{[}]}"));
        assertFalse(JsonValidator.isValidJSON("{[][][]"));
        assertFalse(JsonValidator.isValidJSON("{}{}{}{}{}{}{}{}[][][]["));
    }

    @Test
    void quotationBonusTest(){
        assertTrue(JsonValidator.isValidJSON("[\"\"]"));
        assertTrue(JsonValidator.isValidJSON("\"{\""));
        assertTrue(JsonValidator.isValidJSON("{\"\"}"));
        assertTrue(JsonValidator.isValidJSON("\"\\\"{\""));
        assertTrue(JsonValidator.isValidJSON("\"{[{[}]}\""));
        assertTrue(JsonValidator.isValidJSON("{\"{[{[}]}\"\"\"\"{{{\"}"));
        assertTrue(JsonValidator.isValidJSON("{[{{{{{{{{{\"\"}}}}}}}}}]}"));
        assertTrue(JsonValidator.isValidJSON("{\"\\\"\\\"\\\"\\\"\\\"\\\"\"}"));

        assertFalse(JsonValidator.isValidJSON("\""));
        assertFalse(JsonValidator.isValidJSON("[\"]"));
        assertFalse(JsonValidator.isValidJSON("{}\""));
        assertFalse(JsonValidator.isValidJSON("\"\\\""));
        assertFalse(JsonValidator.isValidJSON("\"{{{\"]"));
        assertFalse(JsonValidator.isValidJSON("\"\"{}{}\""));
    }
}
