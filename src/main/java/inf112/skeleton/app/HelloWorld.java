package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class HelloWorld implements ApplicationListener {
    private int spriteSize = 120;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture floor;
    private Texture robot;
    private boolean moveRight, moveLeft, moveUp, moveDown;
    private float animationSpeed = 250.0f;
    private float currentX;
    private float currentY;
    private float xPosition;
    private float yPosition;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 480);
        
        batch = new SpriteBatch();
        
        floor = new Texture(Gdx.files.internal("assets/data/textureStone.png"));
        robot = new Texture(Gdx.files.internal("assets/data/robot.png"));
        
        xPosition = 0;
        yPosition = 0;
        currentX = 0;
        currentY = 0;
    }

    @Override
    public void dispose() {
        floor.dispose();
        robot.dispose();
        batch.dispose();
    }

    @Override
    public void render() {
        // Makes the background white
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            moveRight = true;
        }
        
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                batch.draw(floor, spriteSize * i, spriteSize * j);
            }
        }
        
        if(moveRight) {
            System.out.println("Moving right");
            xPosition += Gdx.graphics.getDeltaTime() * animationSpeed;
            if(xPosition >= currentX + spriteSize) {
                currentX = spriteSize + currentX;
                xPosition = currentX;
                moveRight = false;
            }
        }
        batch.draw(robot, xPosition, yPosition);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
