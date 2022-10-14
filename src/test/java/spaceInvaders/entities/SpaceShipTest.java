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
import static org.mockito.Mockito.*;

class SpaceShipTest {
    @Mock
    Position position;
    @InjectMocks
    SpaceShip spaceShip = new SpaceShip(0, 0);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
//Should return a new position with the same y and x + 1
    void testMoveRight() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        spaceShip.setPosition(position);
        Position newPosition = spaceShip.moveRight();
        Assertions.assertEquals(newPosition.getX(), 1);
        Assertions.assertEquals(newPosition.getY(), 0);
    }

    @Test
//Should return a new position with the same y and x - 1
    void testMoveLeft() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        spaceShip.setPosition(position);
        Position newPosition = spaceShip.moveLeft();
        Assertions.assertEquals(newPosition.getX(), -1);
        Assertions.assertEquals(newPosition.getY(), 0);
    }

    @Test
//Should draw the elements
    void testDrawElements() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        spaceShip.setPosition(position);
        TextGraphics graphics = mock(TextGraphics.class);

        spaceShip.drawElements(graphics, "#ff0000", "/");
    }



    @Test
    void testGetShootFaster() {
        Assertions.assertEquals(4, spaceShip.getShootFaster());

    }

    @Test
    void testGetIsInvincible() {
        Assertions.assertEquals(false, spaceShip.getIsInvincible());

    }

    @Test
    void testGetFireMultipleBullets() {
        Assertions.assertEquals(false, spaceShip.getFireMultipleBullets());

    }


}

