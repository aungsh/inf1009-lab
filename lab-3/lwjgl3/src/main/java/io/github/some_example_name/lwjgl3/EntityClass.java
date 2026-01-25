package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class EntityClass {
    private float x;
    private float y;
    private float speed;
    private Color color;

    public EntityClass() {
        x = 0;
        y = 0;
        speed = 0;
        color = null;
    }

    public EntityClass(float x, float y, float speed, Color color) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;
    }

    public void draw(ShapeRenderer shapeRenderer) {}

    public void draw(SpriteBatch spriteBatch) {}

    // public void movement() {}

    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }

    public float getX() { return x; }
    public void setX(float x) { this.x = x; }

    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public float getSpeed() { return speed; }
    public void setSpeed(float speed) { this.speed = speed; }
}
