package codes.test;

import codes.*;

import org.junit.Assert;
import org.junit.Test;

public class PositionTest {

    @Test
    public void getPositionValuesTest() {
        Position position = new Position(2, 3);

        Assert.assertEquals(2, position.getRow());
        Assert.assertEquals(3, position.getCol());
    }

    @Test
    public void notEqualsTest() {
        Position position1 = new Position(2, 3);
        Position position2 = new Position(4, 1);

        Assert.assertNotEquals(position1, position2);
    }

    
}
