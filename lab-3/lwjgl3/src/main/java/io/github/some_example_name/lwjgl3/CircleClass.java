package io.github.some_example_name.lwjgl3;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class CircleClass extends EntityClass{
    private float radius;

    public CircleClass() {
        this.radius = 0;
    }

    public CircleClass(Color color, float x, float y, float speed, float radius){
        super(x, y, speed, color);
        this.radius = radius;
    }

    @Override
    public void draw(ShapeRenderer shape) {
        shape.setColor(super.getColor());
        shape.circle(super.getX(), super.getY(), radius);
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
