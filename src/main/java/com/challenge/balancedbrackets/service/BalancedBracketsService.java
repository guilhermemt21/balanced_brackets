package com.challenge.balancedbrackets.service;

import com.challenge.balancedbrackets.controller.form.BalancedBracketsForm;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BalancedBracketsService {

    public Boolean isBalanced(BalancedBracketsForm form) {
        if (!hasValidCharacters(form)){
            return false;
        }

        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put('(', ')');
        bracketsMap.put('[', ']');
        bracketsMap.put('{', '}');

        Set<Character> openers = bracketsMap.keySet();
        Set<Character> closers = new HashSet<>(bracketsMap.values());

        Deque<Character> openersStack = new ArrayDeque<>();

        for (char character : form.getInput().toCharArray()) {
            if (openers.contains(character)) {
                openersStack.push(character);
            } else if (closers.contains(character)) {
                if (openersStack.isEmpty()) {
                    return false;
                } else {
                    char lastUnclosedOpener = openersStack.pop();
                    if (bracketsMap.get(lastUnclosedOpener) != character) {
                        return false;
                    }
                }
            }
        }

        return openersStack.isEmpty();
    }

    private Boolean hasValidCharacters(BalancedBracketsForm input) {
        List<String> validCharacters = Arrays.asList("(", ")", "{", "}", "[", "]");

        String[] characters = input.getInput().split("");
        for (String character : characters) {
            if (!validCharacters.contains(character)){
                return false;
            }
        }

        return true;
    }

}
