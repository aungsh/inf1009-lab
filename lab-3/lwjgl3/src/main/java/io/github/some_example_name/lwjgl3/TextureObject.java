package io.github.some_example_name.lwjgl3;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextureObject extends EntityClass{
    private Texture texture;

    public TextureObject(String fileName, float x, float y, float speed) {
        super(x, y, speed, null);
        this.texture = new Texture(Gdx.files.internal(fileName));
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture, super.getX(), super.getY());
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
}
