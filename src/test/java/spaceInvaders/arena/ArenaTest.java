package spaceInvaders.arena;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import spaceInvaders.entities.*;
import spaceInvaders.model.Position;
import spaceInvaders.model.createElements.CreateElements;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArenaTest {
    @Mock
    SpaceShip spaceShip;
    @Mock
    List<Bullet> bullets;
    @Mock
    List<Bullet> enemyBullets;
    @Mock
    List<PowerUps> powerUps;
    @Mock
    List<AlienFleet> alienFleet;
    @Mock
    List<SpaceShipHP> spaceShipHP;
    @Mock
    CreateElements createElements;
    @InjectMocks
    Arena arena;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
/*
    @Test
    void testDraw() {
        when(spaceShip.getSpaceShipHP()).thenReturn(List.of(new SpaceShipHP(0, 0)));
      /*when(bullets.size()).thenReturn(2);
        when(enemyBullets.size()).thenReturn(2);
        when(powerUps.size()).thenReturn(3);
        when(alienFleet.size()).thenReturn(5);
        TextGraphics graphics = mock(TextGraphics.class);

        arena.draw(graphics);
    }*/

    @Test
    void testProcessKey() {
        when(spaceShip.getFireMultipleBullets()).thenReturn(true);
        when(spaceShip.getShootFaster()).thenReturn(0);
        when(spaceShip.getPosition()).thenReturn(new Position(0, 0));
        when(spaceShip.moveRight()).thenReturn(new Position(0, 0));
        when(spaceShip.moveLeft()).thenReturn(new Position(0, 0));
        when(createElements.createBullets(any(), anyBoolean())).thenReturn(List.of(new Bullet(0, 0)));

        KeyStroke keyStroke = mock(KeyStroke.class);
        arena.processKey(new KeyStroke(KeyType.Enter));
    }

    @Test
    void testShootBullet() {
        int shotNumb = 3;

        when(alienFleet.size()).thenReturn(5);
        when(spaceShip.getPosition()).thenReturn(new Position(0, 0));
        when(createElements.createEnemyBullets(any())).thenReturn(List.of(new Bullet(0, 0)));

        //arena.shootBullet(shotNumb);
    }

    @Test
    void testGetIsInvincible() {
        when(spaceShip.getIsInvincible()).thenReturn(true);

        boolean result = arena.getIsInvincible();
        Assertions.assertEquals(true, result);
    }

    @Test
    void testSetIsInvincible() {
        arena.setIsInvincible(true);
    }

    @Test
    void testSetShootFaster() {
        arena.setShootFaster(0);
    }

    @Test
    void testGetShootFaster() {
        when(spaceShip.getShootFaster()).thenReturn(0);

        int result = arena.getShootFaster();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testSetFireMultipleBullets() {
        arena.setFireMultipleBullets(true);
    }

    @Test
    void testGetFireMultipleBullets() {
        when(spaceShip.getFireMultipleBullets()).thenReturn(true);

        boolean result = arena.getFireMultipleBullets();
        Assertions.assertEquals(true, result);
    }

    @Test
    void testAliensIsEmpty() {
        boolean result = arena.aliensIsEmpty();
        Assertions.assertEquals(false, result);
    }

    @Test
    void testRemoveSpaceShip() {
        arena.removeSpaceShip(new SpaceShip(0, 0));
    }

    @Test
    void testGetRunTimer() {
        arena.setRunTimer(1);
        assertEquals(1, arena.getRunTimer());
    }

    @Test
    void shootBulletWhenAlienFleetIsEmptyThenDoNotCreateBullet() {
        when(alienFleet.size()).thenReturn(0);
        arena.shootBullet(1);
        verify(createElements, never()).createEnemyBullets(any());
    }

    @Test
    void testGetAlienFleet() {
        assertEquals(0,arena.getAlienFleet().size());
    }
    @Test
    void testGetEnemyBullets() {
        assertEquals(0,arena.getEnemyBullets().size());
    }
    @Test
    void testGetBullets() {
        assertEquals(0,arena.getBullets().size());
    }
    @Test
    void testGetPowerUps() {
        assertEquals(0,arena.getPowerUps().size());
    }
    @Test
    void testGetIsInvisible() {
        assertFalse(arena.getIsInvincible());
    }
    @Test
    void testGetSpaceship() {
        assertNull(arena.getSpaceShip().getPosition());
    }






}
