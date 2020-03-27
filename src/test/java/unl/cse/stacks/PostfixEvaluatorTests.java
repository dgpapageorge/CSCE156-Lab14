package unl.cse.stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PostfixEvaluatorTests {

    PostfixEvaluator postfixEvaluator;

    @BeforeEach
    void stackSetup() {
        postfixEvaluator = new PostfixEvaluator();

    }

    @Test
    void evaluateTest() {
        assertEquals(1, postfixEvaluator.evaluateExpression("1"));
        assertEquals(5, postfixEvaluator.evaluateExpression("3 2 +"));
        assertEquals(1.5, postfixEvaluator.evaluateExpression("3 2 /"));
        assertEquals(1, postfixEvaluator.evaluateExpression("2 2 /"));
        assertEquals(6, postfixEvaluator.evaluateExpression("3 2 *"));
        assertEquals(1, postfixEvaluator.evaluateExpression("1 1 /"));
        assertEquals(0, postfixEvaluator.evaluateExpression("0 2 /"));

        assertEquals(1, postfixEvaluator.evaluateExpression("1.5 3 2 / /"));
        assertEquals(10, postfixEvaluator.evaluateExpression("2 3 2 + *"));
        assertEquals(10, postfixEvaluator.evaluateExpression("3 2 + 2 *"));
        assertEquals(15, postfixEvaluator.evaluateExpression("2 5 * 3 2 + +"));
        assertEquals(0, postfixEvaluator.evaluateExpression("3 2 * 6 -"));

        try {
            // failure to throw an exception fails the test
            postfixEvaluator.evaluateExpression("3 4 T");
            fail();
        } catch (IllegalStateException|NumberFormatException ignored) {}
    }
}
