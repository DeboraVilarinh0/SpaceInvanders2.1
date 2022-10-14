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

class BulletTest {
    @Mock
    Position position;
    @InjectMocks
    Bullet bullet = new Bullet(0, 0);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
//Should return a new position with the same x and y + 1
    void testMoveDown() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        bullet.setPosition(position);
        Position newPosition = bullet.bulletMovementDOWN();
        Assertions.assertEquals(newPosition.getX(), 0);
        Assertions.assertEquals(newPosition.getY(), 1);
    }

    @Test
//Should return a new position with the same x and y -1
    void testMoveUP() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        bullet.setPosition(position);
        Position newPosition = bullet.bulletMovementUP();
        Assertions.assertEquals(newPosition.getX(), 0);
        Assertions.assertEquals(newPosition.getY(), -1);
    }

    @Test
//Should return a new position with the same y and x + 1
    void testMoveRight() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        bullet.setPosition(position);
        Position newPosition = bullet.moveRight();
        Assertions.assertEquals(newPosition.getX(), 1);
        Assertions.assertEquals(newPosition.getY(), 0);
    }

    @Test
//Should return a new position with the same y and x - 1
    void testMoveLeft() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        bullet.setPosition(position);
        Position newPosition = bullet.moveLeft();
        Assertions.assertEquals(newPosition.getX(), -1);
        Assertions.assertEquals(newPosition.getY(), 0);
    }

    @Test
//Should return a new position with the same x and y + 1
    void testDrawElements() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        bullet.setPosition(position);
        TextGraphics graphics = mock(TextGraphics.class);
        bullet.drawElements(graphics, "#ff0000", "/");
    }


}

