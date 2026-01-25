package io.github.some_example_name.lwjgl3;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TriangleClass extends EntityClass{
    private float base;
    private float height;

    public TriangleClass() {
        this.base = 0;
        this.height = 0;
    }

    public TriangleClass(Color color, float x, float y, float speed, float base, float height) {
        super(x, y, speed, color);
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw(ShapeRenderer shape) {
        shape.setColor(super.getColor());

        float x1 = super.getX();
        float y1 = super.getY();
        float x2 = super.getX() + base;
        float y2 = super.getY();
        float x3 = super.getX() + (base/2);
        float y3 = super.getY() + height;

        shape.triangle(x1, y1, x2, y2, x3, y3);
    }

    public float getBase() { return base; }
    public void setBase(float base) { this.base = base; }

    public float getHeight() { return height; }
    public void setHeight(float height) { this.height = height; }
}