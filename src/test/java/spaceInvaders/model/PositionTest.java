package spaceInvaders.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

class PositionTest {
    Position position = new Position(0, 0);



    @Test
    void testGetX() {
        int result = position.getX();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testGetY() {
        int result = position.getY();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testEquals() {
        Object object = mock(Object.class);
        boolean result = position.equals(object);
        Assertions.assertEquals(false, result);
    }
}
