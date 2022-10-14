package spaceInvaders.model.verifications;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import spaceInvaders.arena.Arena;
import spaceInvaders.entities.AlienFleet;
import spaceInvaders.entities.Bullet;
import spaceInvaders.entities.PowerUps;
import spaceInvaders.entities.SpaceShip;
import spaceInvaders.model.Position;
import spaceInvaders.utility.SimpleAudioPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class VerificationsTest {
    @Mock
    SimpleAudioPlayer audioPlayer;

    @InjectMocks
    Verifications verifications;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    /*

    @Test//Should remove one life from the spaceship when it collides with an alien
    void testRemoveLifeSpaceshipCollisionAlien() throws UnsupportedAudioFileException, IOException, InterruptedException {
        SpaceShip spaceShip = new SpaceShip(1, 1);
        List<AlienFleet> alienFleet = new ArrayList<>();
        alienFleet.add(new AlienFleet(1, 1, 1));
        List<Bullet> enemyBullets = new ArrayList<>();

        verifications.verifySpaceShipCollision(spaceShip, alienFleet, enemyBullets);

        assertEquals(0, spaceShip.getSpaceShipHP().size());
    }

    @Test//Should remove one life from the spaceship when it collides with a bullet
    void testRemoveLifeSpaceshipCollisionBullet() throws UnsupportedAudioFileException, IOException, InterruptedException {
        List<Bullet> enemyBullets = new ArrayList<>();
        List<AlienFleet> alienFleet = new ArrayList<>();
        SpaceShip spaceShip = new SpaceShip(1, 1);
        Bullet bullet = new Bullet(1, 1);
        enemyBullets.add(bullet);

        verifications.verifySpaceShipCollision(spaceShip, alienFleet, enemyBullets);

        assertEquals(0, spaceShip.getSpaceShipHP().size());
    }

    @Test //Should exit the game when the spaceship has no more lives
    void testVerifyExitGame() throws UnsupportedAudioFileException, IOException, InterruptedException {
        SpaceShip spaceShip = new SpaceShip(1, 1);
        List<AlienFleet> alienFleet = new ArrayList<>();
        List<Bullet> enemyBullets = new ArrayList<>();
        alienFleet.add(new AlienFleet(1, 1, 1));
        enemyBullets.add(new Bullet(1, 1));

        verifications.verifySpaceShipCollision(spaceShip, alienFleet, enemyBullets);

        assertEquals(0, spaceShip.getSpaceShipHP().size());
    }
    
     */


    @Test
//Should remove the power up when the spaceship is on the same position as the power up
    void testVerificationPowerUpCollision() {
        SpaceShip spaceShip = new SpaceShip(1, 1);
        PowerUps powerUps = new PowerUps(1, 1, 0);
        List<PowerUps> powerUpsList = new ArrayList<>(List.of(powerUps));

        verifications.verifyPowerUpCollision(spaceShip, powerUpsList);

        Assertions.assertTrue(powerUpsList.isEmpty());
    }

    @Test
//Should set shoot faster to 0 when the power up type is 0
    void testVerifyShootFaster() {
        SpaceShip spaceShip = new SpaceShip(0, 0);
        List<PowerUps> powerUps = new ArrayList<>();
        PowerUps powerUp = new PowerUps(0, 0, 0);
        powerUps.add(powerUp);

        verifications.verifyPowerUpCollision(spaceShip, powerUps);

        Assertions.assertEquals(0, spaceShip.getShootFaster());
    }

    @Test
//Should set is invincible to true when the power up type is 1
    void testVerifyIsInvincible() {
        SpaceShip spaceShip = new SpaceShip(1, 1);
        List<PowerUps> powerUps = new ArrayList<>();
        PowerUps powerUp = new PowerUps(1, 1, 1);
        powerUps.add(powerUp);

        verifications.verifyPowerUpCollision(spaceShip, powerUps);

        assertTrue(spaceShip.getIsInvincible());
    }

    @Test
//Should set fire multiple bullets to true when the power up type is 2
    void testVerifyMultipleBullets() {
        SpaceShip spaceShip = mock(SpaceShip.class);
        PowerUps powerUps = mock(PowerUps.class);
        when(powerUps.getPowerUpType()).thenReturn(2);
        when(spaceShip.getPosition()).thenReturn(new Position(1, 1));
        when(powerUps.getPosition()).thenReturn(new Position(1, 1));
        verifications.verifyPowerUpCollision(spaceShip, new ArrayList<>(List.of(powerUps)));
    }

    @Test
        //Should remove the bullet when the next position of a bullet is in the same position as an enemy bullet
    void testVerifyCleanBullet() {
        Bullet bullet = new Bullet(1, 1);
        Bullet enemyBullet = new Bullet(1, 1);
        List<Bullet> bullets = new ArrayList<>(List.of(bullet));
        List<Bullet> enemyBullets = new ArrayList<>(List.of(enemyBullet));

        verifications.verifyCollisionBetweenBullets(bullets, enemyBullets);

        assertTrue(bullets.isEmpty());
    }

    @Test
        //Should remove the enemy bullet when the next position of a bullet is in the same position as an enemy bullet
    void testVerifyCleanEnemyBullet() {
        Bullet bullet = new Bullet(1, 1);
        Bullet enemyBullet = new Bullet(1, 1);
        List<Bullet> bullets = new ArrayList<>(List.of(bullet));
        List<Bullet> enemyBullets = new ArrayList<>(List.of(enemyBullet));

        verifications.verifyCollisionBetweenBullets(bullets, enemyBullets);

        assertTrue(bullets.isEmpty());
        assertTrue(enemyBullets.isEmpty());
    }

    @Test
//Should remove the enemy bullet when the bullet is in the same position as an enemy bullet
    void
    testVerifyCollisionBetweenBullets() {
        Bullet bullet = new Bullet(1, 1);
        Bullet enemyBullet = new Bullet(1, 1);
        List<Bullet> bullets = new ArrayList<>(List.of(bullet));
        List<Bullet> enemyBullets = new ArrayList<>(List.of(enemyBullet));

        verifications.verifyCollisionBetweenBullets(bullets, enemyBullets);

        assertTrue(enemyBullets.isEmpty());
    }
    @Test
//Should remove the enemy bullet when the bullet is in the previous position as an enemy bullet
    void
    testVerifyCollisionBetweenBullets1() {
        Bullet bullet = new Bullet(1, 2);
        Bullet enemyBullet = new Bullet(1, 1);
        List<Bullet> bullets = new ArrayList<>(List.of(bullet));
        List<Bullet> enemyBullets = new ArrayList<>(List.of(enemyBullet));

        verifications.verifyCollisionBetweenBullets(bullets, enemyBullets);

        assertTrue(enemyBullets.isEmpty());
    }

    @Test
//Should remove the alien when the bullet hits the alien with 0 hit points
    void testVerifyAlienFleetCollisionRemoveAlien() {
        AlienFleet alienFleet = new AlienFleet(1, 1, 0);
        Bullet bullet = new Bullet(1, 1);
        List<AlienFleet> alienFleets = new ArrayList<>(List.of(alienFleet));
        List<Bullet> bullets = new ArrayList<>(List.of(bullet));

        verifications.verifyAlienFleetCollision(bullets, alienFleets);

        assertTrue(alienFleets.isEmpty());
    }

    @Test
//Should remove the bullet when the bullet hits the alien
    void testVerifyAlienFleetCollisionRemoveBullet() {
        AlienFleet alienFleet = new AlienFleet(1, 1, 1);
        Bullet bullet = new Bullet(1, 1);
        List<AlienFleet> alienFleets = new ArrayList<>(List.of(alienFleet));
        List<Bullet> bullets = new ArrayList<>(List.of(bullet));

        verifications.verifyAlienFleetCollision(bullets, alienFleets);

        assertTrue(bullets.isEmpty());
    }

    @Test //Should decrease hit points of alien when the bullet hits the alien
    void verifyAlienFleetCollisionHitPoints() {
        AlienFleet alienFleet = new AlienFleet(1, 1, 1);
        Bullet bullet = new Bullet(1, 1);
        List<AlienFleet> alienFleetList = List.of(alienFleet);
        List<Bullet> bulletList = new ArrayList<>(List.of(bullet));

        verifications.verifyAlienFleetCollision(bulletList, alienFleetList);

        assertEquals(0, alienFleet.getHitPoints());
    }

    @Test
//Should remove the bullet when the bullet is out of the screen
    void testCleanBulletOutScreen() {
        List<Bullet> bullets = new ArrayList<>(List.of(new Bullet(1, -1)));
        verifications.cleanBullet(bullets);
        assertTrue(bullets.isEmpty());
    }

    @Test
//Should return 0 when the alien fleet is not empty and run timer is 80
    void testLevel() {
        List<AlienFleet> alienFleet = new ArrayList<>();
        alienFleet.add(new AlienFleet(1, 1, 1));
        long runTimer = 80;
        assertEquals(0, verifications.level(alienFleet, runTimer));
    }

    @Test
        //Should return 0 when the alien fleet is empty and run timer is not 80
    void testLevel1() {
        List<AlienFleet> alienFleet = new ArrayList<>();
        long runTimer = 0;
        assertEquals(0, verifications.level(alienFleet, runTimer));
    }

    @Test
//Should return 1 when the alien fleet is empty and run timer is 80
    void testLevelUp() {
        List<AlienFleet> alienFleet = new ArrayList<>();
        long runTimer = 80;
        int expectedLevel = 1;

        int actualLevel = verifications.level(alienFleet, runTimer);

        assertEquals(expectedLevel, actualLevel);
    }
}