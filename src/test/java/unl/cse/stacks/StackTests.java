package unl.cse.stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackTests {

    Stack<String> testStack;

    @BeforeEach
    void stackSetup() {
        testStack = new Stack<>();
    }

    @Test
    void stackTest() {
        // isEmpty - returning true
        assertTrue(testStack.isEmpty());

        // Push
        testStack.push("Test");
        assertEquals(1, testStack.size());

        testStack.push("CSCE");
        assertEquals(2, testStack.size());

        testStack.push("156");
        assertEquals(3, testStack.size());

        testStack.push("156");
        assertEquals(4, testStack.size());

        // isEmpty - returning false
        assertFalse(testStack.isEmpty());

        // Pop
        assertEquals("156", testStack.pop());
        assertEquals("156", testStack.pop());
        assertEquals("CSCE", testStack.pop());
        assertEquals("Test", testStack.pop());

        try {
            // Attempt to pop from an empty stack
            // This permits returning null or throwing an exception
            assertNull(testStack.pop());
        } catch (Exception ignored) {}

        // isEmpty - returning true
        assertTrue(testStack.isEmpty());
    }
}
