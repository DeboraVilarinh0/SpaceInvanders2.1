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

class ElementTest {
    @Mock
    Position position;
    @InjectMocks
    Element element = new Element(0,0) {

    };

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test //Should return the position
    void testGetPosition() {
        assertEquals(new Position(0,0).getX(), element.getPosition().getX());
        assertEquals(new Position(0,0).getY(), element.getPosition().getY());
    }

    @Test
//Should return a new position with the same y and x + 1
    void testMoveRight() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        element.setPosition(position);
        Position newPosition = element.moveRight();
        Assertions.assertEquals(newPosition.getX(), 1);
        Assertions.assertEquals(newPosition.getY(), 0);
    }

    @Test
//Should return a new position with the same y and x - 1
    void testMoveLeft() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        element.setPosition(position);
        Position newPosition = element.moveLeft();
        Assertions.assertEquals(newPosition.getX(), -1);
        Assertions.assertEquals(newPosition.getY(), 0);
    }

    @Test
//Should return a new position with the same x and y + 1
    void testDrawElements() {
        when(position.getX()).thenReturn(0);
        when(position.getY()).thenReturn(0);
        element.setPosition(position);
        TextGraphics graphics = mock(TextGraphics.class);

        element.drawElements(graphics, "#ff0000", "/");
    }
}

