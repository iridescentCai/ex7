package floopowder;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FlooPowderTest {

    /* the timeout interval per test is 60 seconds */
    private static int TIMEOUT = 60;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(TIMEOUT);

    private int gridSize;
    private int timeSteps;
    private Set<Integer> jumpDistances;
    private int answer;

    public FlooPowderTest(int gridSize, int timeSteps, Set<Integer> jumpDistances, int answer) {
        this.gridSize = gridSize;
        this.timeSteps = timeSteps;
        this.jumpDistances = jumpDistances;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testInstances() {

        int[] gridSize = {
            2,
            2,
            2,
            3,
            5,
            5,
            5,
            10,
            6,
            3
        };

        int[] timeSteps = {
            1,
            2,
            3,
            3,
            3,
            3,
            3,
            6,
            6,
            5
        };

        List<Set<Integer>> jumpDistances = Arrays.asList(
            Set.of(1),
            Set.of(1),
            Set.of(1),
            Set.of(3, 5),
            Set.of(3, 5),
            Set.of(3, 5, 0),
            Set.of(1, 0),
            Set.of(1, 2, 8),
            Set.of(3),
            Set.of(0, 4)
        );

        int[] answers = {
            2,
            8,
            32,
            12,
            30224,
            36704,
            0,
            19219180,
            23567578,
            512
        };

        Object[][] parameters = new Object[gridSize.length][4];
        for (int i = 0; i < gridSize.length; i++) {
            parameters[i] =
                new Object[] {gridSize[i], timeSteps[i], jumpDistances.get(i), answers[i]};
        }
        return Arrays.asList(parameters);
    }

    @Test
    public void test() {
        assertEquals("Incorrect answer -- ", answer,
            GridAndFloo.countMeetingPaths(gridSize, timeSteps, jumpDistances));
    }

}
