package io.github.some_example_name.lwjgl3;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextureObject {

    private Texture texture;
    private int xPos;
    private int yPos;
    private int speed;

    public TextureObject(String fileName, int xPos, int yPos, int speed) {
        this.texture = new Texture(Gdx.files.internal(fileName));
        this.xPos = xPos;
        this.yPos = yPos;
        this.speed = speed;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, xPos, yPos);
    }

    public void dispose() {
        texture.dispose();
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public int getX() {
        return xPos;
    }

    public void setX(int xPos) {
        this.xPos = xPos;
    }

    public int getY() {
        return yPos;
    }

    public void setY(int yPos) {
        this.yPos = yPos;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
