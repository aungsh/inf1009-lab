package io.github.some_example_name.lwjgl3;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Gdx;
// import com.badlogic.gdx.Input.Keys;
// import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameMaster extends ApplicationAdapter {

    private TextureObject[] dropImage;
    private TextureObject bucket;
    private SpriteBatch batch;
    private int points = 0;
    private BitmapFont font;

    private ShapeRenderer shapeRenderer;
    private TriangleClass triangle;
    private CircleClass circle;

    @Override
    public void create() {
        bucket = new TextureObject("bucket.png", 50,50,2);
        batch = new SpriteBatch();
        font = new BitmapFont();

        shapeRenderer = new ShapeRenderer();
        triangle = new TriangleClass(Color.GREEN, 200, 200, 0, 100, 100);
        circle = new CircleClass(Color.RED, 100, 100, 0, 50);

        // dropImage = new TextureObject("droplet.png", 100, 100, 2);
        dropImage = new TextureObject[10];

        Random rand = new Random();

        for (int i = 0; i < dropImage.length; i++) {
            int xPos = rand.nextInt(800);
            int yPos = rand.nextInt(600) + 400;

            dropImage[i] = new TextureObject("droplet.png", xPos, yPos, 2);
        }
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        // Move bucket left/right
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            bucket.setX(bucket.getX() - 5); // move left
        }

        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            bucket.setX(bucket.getX() + 5); // move right
        }

        if (Gdx.input.isKeyPressed(Keys.UP)) {
            circle.setY(circle.getY() + 5);
        }

        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            circle.setY(circle.getY() - 5);
        }

        if (Gdx.input.isKeyPressed(Keys.A)) {
            triangle.setY(triangle.getY() + 5);
        }

        if (Gdx.input.isKeyPressed(Keys.D)) {
            triangle.setY(triangle.getY() - 5);
        }

        // Prevent bucket from going off-screen
        if (bucket.getX() < 0) bucket.setX(0);
        if (bucket.getX() > 650 - bucket.getTexture().getWidth()) {
            bucket.setX(650 - bucket.getTexture().getWidth());
        }

        batch.begin();

        font.draw(batch, "Points: " + points, 100, 380);

        for (TextureObject drop : dropImage) {
            drop.draw(batch);

            // Move drop down
            drop.setY(drop.getY() - drop.getSpeed());

            // Reset to top if it goes off screen
            if (drop.getY() < 0) {
                drop.setY(600);

                if (drop.getSpeed() < 10) {
                    drop.setSpeed(drop.getSpeed() + 2);
                }
            }

            // Check collision with bucket
            if (isColliding(drop, bucket)) {
                points++;                // increment score
                drop.setY(600);          // reset drop to top

                // randomize X for fun
                drop.setX(new Random().nextInt(800));
            }
        }
        bucket.draw(batch);
        batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        triangle.draw(shapeRenderer);
        circle.draw(shapeRenderer);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        bucket.dispose();
        for (TextureObject drop : dropImage) {
            drop.dispose();
        }
        font.dispose();
    }

    boolean isColliding(TextureObject drop, TextureObject bucket) {
        float dropX = drop.getX();
        float dropY = drop.getY();
        float dropWidth = drop.getTexture().getWidth();
        float dropHeight = drop.getTexture().getHeight();

        float bucketX = bucket.getX();
        float bucketY = bucket.getY();
        float bucketWidth = bucket.getTexture().getWidth();
        float bucketHeight = bucket.getTexture().getHeight();

        // AABB collision check
        return dropX < bucketX + bucketWidth &&
            dropX + dropWidth > bucketX &&
            dropY < bucketY + bucketHeight &&
            dropY + dropHeight > bucketY;
    }

}
