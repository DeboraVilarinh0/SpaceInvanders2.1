package spaceInvaders.entities;

public class PowerUps extends Element {
    int Type;

    public PowerUps(int x, int y, int type) {
        super(x, y);
        this.Type = type;
    }

    public int getPowerUpType() {
        return Type;
    }

}

