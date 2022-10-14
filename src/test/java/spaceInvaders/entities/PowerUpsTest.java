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

class PowerUpsTest {
    @Mock
    Position position;
    @InjectMocks
    PowerUps powerUps = new PowerUps(0,0,0);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
//Should return a new position with the same y and x + 1
    void testMoveRight() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        powerUps.setPosition(position);
        Position newPosition = powerUps.moveRight();
        Assertions.assertEquals(newPosition.getX(), 1);
        Assertions.assertEquals(newPosition.getY(), 0);
    }

    @Test
//Should return a new position with the same y and x - 1
    void testMoveLeft() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        powerUps.setPosition(position);
        Position newPosition = powerUps.moveLeft();
        Assertions.assertEquals(newPosition.getX(), -1);
        Assertions.assertEquals(newPosition.getY(), 0);
    }

    @Test
//Should return a new position with the same x and y + 1
    void testDrawElements() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        powerUps.setPosition(position);
        TextGraphics graphics = mock(TextGraphics.class);

        powerUps.drawElements(graphics, "#ff0000", "/");
    }

    @Test //Should return the power up type
    void testGetPowerUps() {
        assertEquals(new PowerUps(0,0,0).getPowerUpType(), powerUps.getPowerUpType());

    }
}

