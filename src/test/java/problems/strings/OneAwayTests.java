package problems.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OneAwayTests {

    @Test
    public void solution() {

        String one = "pale";
        String two = "ple";
        assertTrue(OneAway.solution(one, two));
    }

    @Test
    public void solution2() {

        String one = "pales";
        String two = "pale";
        assertTrue(OneAway.solution(one, two));
    }

    @Test
    public void solution3() {

        String one = "pale";
        String two = "bale";
        assertTrue(OneAway.solution(one, two));
    }

    @Test
    public void solution4() {

        String one = "pale";
        String two = "bake";
        assertFalse(OneAway.solution(one, two));
    }
}