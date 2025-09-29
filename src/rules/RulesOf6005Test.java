/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {

    /**
     * Un-cited publicly-available code should be disallowed.
     */
    @Test
    public void testUncitedPublicCode() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
    }

    /**
     * Self-written code required by the assignment should be allowed.
     */
    @Test
    public void testSelfWrittenRequiredCode() {
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }

    /**
     * Properly cited publicly-available code, not required by assignment, should be allowed.
     */
    @Test
    public void testCitedPublicCodeNotRequired() {
        assertTrue("Expected true: cited publicly-available code allowed when not required",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
    }

    /**
     * Using another student's coursework should be disallowed.
     */
    @Test
    public void testUsingOthersCoursework() {
        assertFalse("Expected false: using someone else's coursework is not allowed",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }
}