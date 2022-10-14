package spaceInvaders.entities;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import spaceInvaders.model.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AlienFleetTest {
    @Mock
    Position position;
    @InjectMocks
    AlienFleet alienFleet = new AlienFleet(0, 0, 1);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
//Should return a new position with the same x and y + 1
    void testMoveDown() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        alienFleet.setPosition(position);
        Position newPosition = alienFleet.moveDown();
        Assertions.assertEquals(newPosition.getX(), 0);
        Assertions.assertEquals(newPosition.getY(), 1);
    }

    @Test
//Should return a new position with the same y and x + 1
    void testMoveRight() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        alienFleet.setPosition(position);
        Position newPosition = alienFleet.moveRight();
        Assertions.assertEquals(newPosition.getX(), 1);
        Assertions.assertEquals(newPosition.getY(), 0);
    }

    @Test
//Should return a new position with the same y and x - 1
    void testMoveLeft() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        alienFleet.setPosition(position);
        Position newPosition = alienFleet.moveLeft();
        Assertions.assertEquals(newPosition.getX(), -1);
        Assertions.assertEquals(newPosition.getY(), 0);
    }

    @Test
    void testDrawElements() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        alienFleet.setPosition(position);
        TextGraphics graphics = mock(TextGraphics.class);
        alienFleet.drawElements(graphics, "#ff0000", "/");
    }


}

