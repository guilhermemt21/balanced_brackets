package com.challenge.balancedbrackets.service;

import com.challenge.balancedbrackets.controller.form.BalancedBracketsForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BalancedBracketsServiceTest {

    private BalancedBracketsService service;

    @BeforeEach
    void setup() {
        service = new BalancedBracketsService();
    }


    @Nested
    class validScenarios {
        @Test
        void openingClosingBrackets() {
            assertTrue(service.isBalanced( new BalancedBracketsForm("(){}[]")));
        }

        @Test
        void nestedBrackets() {
            assertTrue(service.isBalanced( new BalancedBracketsForm("[{()}](){}")));
        }
    }

    @Nested
    class invalidScenarios {
        @Test
        void mixedOpeningClosingBrackets() {
            assertFalse(service.isBalanced( new BalancedBracketsForm("[]{()")));
        }

        @Test
        void mixedNestedBrackets() {
            assertFalse(service.isBalanced( new BalancedBracketsForm("[{)]")));
        }


        @Test
        void validBracketsWithAnyOtherCharacters() {
            assertFalse(service.isBalanced( new BalancedBracketsForm("(){}[]a")));
        }
    }


}