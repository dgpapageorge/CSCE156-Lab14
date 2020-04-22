package unl.cse.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdvancedJsonValidatorTests {

    /**
     * Test the extra portion of the JSON validator
     */
    @Test
    void quotationExtraTest(){
        assertTrue(JsonValidator.isValidJSON("[\"\"]"), "The brackets and quotes are balanced, making this a valid JSON string");
        assertTrue(JsonValidator.isValidJSON("\"{\""), "The brackets and quotes are balanced, making this a valid JSON string");
        assertTrue(JsonValidator.isValidJSON("{\"\"}"), "The brackets and quotes are balanced, making this a valid JSON string");
        assertTrue(JsonValidator.isValidJSON("\"{{{\""), "The brackets and quotes are balanced, making this a valid JSON string");
        assertTrue(JsonValidator.isValidJSON("\"\\\"{\""), "The brackets and quotes are balanced, making this a valid JSON string");
        assertTrue(JsonValidator.isValidJSON("\"{[{[}]}\""), "The brackets and quotes are balanced, making this a valid JSON string");
        assertTrue(JsonValidator.isValidJSON("{\"{[{[}]}\"\"\"\"{{{\"}"), "The brackets and quotes are balanced, making this a valid JSON string");
        assertTrue(JsonValidator.isValidJSON("{[{{{{{{{{{\"\"}}}}}}}}}]}"), "The brackets and quotes are balanced, making this a valid JSON string");
        assertTrue(JsonValidator.isValidJSON("{\"\\\"\\\"\\\"\\\"\\\"\\\"\"}"), "The brackets and quotes are balanced, making this a valid JSON string");

        assertFalse(JsonValidator.isValidJSON("\""), "Unbalanced quote mark");
        assertFalse(JsonValidator.isValidJSON("[\"]"), "Unbalanced quote mark");
        assertFalse(JsonValidator.isValidJSON("{}\""), "Unbalanced quote mark");
        assertFalse(JsonValidator.isValidJSON("\"\\\""), "Unbalanced quote mark (The second quote is escaped)");
        assertFalse(JsonValidator.isValidJSON("\"{{{\"]"), "The last array bracket is unmatched");
        assertFalse(JsonValidator.isValidJSON("\"\"{}{}\""), "Unmatched quote mark");
    }
}

