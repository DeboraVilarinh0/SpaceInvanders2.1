package spaceInvaders.model.createElements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import spaceInvaders.entities.AlienFleet;
import spaceInvaders.entities.Bullet;
import spaceInvaders.entities.PowerUps;
import spaceInvaders.model.Position;
import spaceInvaders.utility.SimpleAudioPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.*;

import static org.mockito.Mockito.*;

class CreateElementsTest {
    @Mock
    List<AlienFleet> alienFleet;
    @Mock
    List<Bullet> bullets;
    @Mock
    List<Bullet> enemyBullets;
    @Mock
    List<PowerUps> powerUps;
    @Mock
    SimpleAudioPlayer audioPlayer;
    @InjectMocks
    CreateElements createElements = new CreateElements();

    CreateElementsTest() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
    }

   /* @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    */

    @Test
    void testCreateAlienFleet() {

        createElements.createAlienFleet(2, 2);
    }

    @Test
    void testCreateBullets() {
        List<Bullet> result = createElements.createBullets(new Position(0, 0), false);
        List<Bullet> resultMultipleShoots = createElements.createBullets(new Position(0, 0), true);
        Assertions.assertEquals(List.of(new Bullet(0, -1)).get(0).getPosition().getY(), result.get(0).getPosition().getY());
        Assertions.assertEquals(List.of(new Bullet(0, -1)).get(0).getPosition().getY(), resultMultipleShoots.get(0).getPosition().getY());
    }

    @Test
    void testCreatePowerUps() {
        List<PowerUps> result = createElements.createPowerUps();
        Assertions.assertEquals(List.of(new PowerUps(0, 0, result.get(0).getPowerUpType())).get(0).getPowerUpType(), result.get(0).getPowerUpType());
    }

    @Test
    void testCreateEnemyBullets() {
        List<Bullet> result = createElements.createEnemyBullets(new Position(0, 0));
        Assertions.assertEquals(List.of(new Bullet(0, 0)).get(0).getPosition(), result.get(0).getPosition());
    }
}

