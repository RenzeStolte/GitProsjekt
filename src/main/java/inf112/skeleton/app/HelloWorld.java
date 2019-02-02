package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class HelloWorld implements ApplicationListener {
    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;
    private OrthographicCamera camera;
    private ScreenViewport viewport;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        viewport = new ScreenViewport();
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("assets/data/Floor2.png"));
        sprite = new Sprite(texture);
    }

    @Override
    public void dispose() {
        texture.dispose();
        batch.dispose();
    }

    @Override
    public void render() {
        // Makes the background white
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // Updates the camera
        camera.update();
        
        
        batch.begin();
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                batch.draw(sprite, 16 * i, 16 * j);
            }
        }
        //sprite.draw(batch);
        //font.draw(batch, "Hello World Edited", 200, 200);
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
