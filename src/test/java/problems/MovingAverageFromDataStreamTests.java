package problems;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class MovingAverageFromDataStreamTests {

    @Test
    public void canCalculateIfSmaller() {
        var stream = new MovingAverageFromDataStream(3);
        assertEquals((double) 1, stream.next(1));
        assertEquals((double) 3, stream.next(5));
    }

    @Test
    public void canCalculateLargerThanWindow() {
        var stream = new MovingAverageFromDataStream(3);
        stream.next(1);
        stream.next(4);
        stream.next(5);
        var expected = (double) (4 + 5 + 9) / 3;
        assertEquals(expected, stream.next(9));
    }
}
