package spaceInvaders.entities;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import spaceInvaders.model.Position;

import static org.mockito.Mockito.*;

class SpaceShipHPTest {
    @Mock
    Position position;
    @InjectMocks
    SpaceShipHP spaceShipHP = new SpaceShipHP(0,0);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
//Should return a new position with the same y and x + 1
    void testMoveRight() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        spaceShipHP.setPosition(position);
        Position newPosition = spaceShipHP.moveRight();
        Assertions.assertEquals(newPosition.getX(), 1);
        Assertions.assertEquals(newPosition.getY(), 0);
    }

    @Test
//Should return a new position with the same y and x - 1
    void testMoveLeft() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        spaceShipHP.setPosition(position);
        Position newPosition = spaceShipHP.moveLeft();
        Assertions.assertEquals(newPosition.getX(), -1);
        Assertions.assertEquals(newPosition.getY(), 0);
    }

    @Test
//Should return a new position with the same x and y + 1
    void testDrawElements() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        spaceShipHP.setPosition(position);
        TextGraphics graphics = mock(TextGraphics.class);

        spaceShipHP.drawElements(graphics, "#ff0000", "/");
    }
}

