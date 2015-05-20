package cg.group4.util.camera;

import cg.group4.view.ScreenLogic;
import cg.group4.view.HomeScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Class handling as the viewport handler.
 * @author Jurgen van Schagen
 */
public class WorldRenderer implements Screen {
    SpriteBatch cBatch;
    Sprite cBackgroundSprite;
    Stage cStage;

    ScreenLogic cScreen;

    OrthographicCamera cCamera;
    Viewport cViewPort;

    final float GAME_WORLD_WIDTH = 12f;
    final float GAME_WORLD_HEIGHT = 9f;
    final float DEV_HEIGHT = 720;
    float UI_SCALAR;

    public WorldRenderer() {
        cCamera = new OrthographicCamera();
        cViewPort = new ExtendViewport(12f, 9f, 16f, 9f, cCamera);
        setBackground("default_background.jpg");

        cBatch = new SpriteBatch();
        cStage = new Stage();
        Gdx.input.setInputProcessor(cStage);

        cScreen = new HomeScreen(this);
    }

    /**
     * Disposes the previous screen and sets the new given screen.
     * @param screen Screen to set the view to
     */
    public final void setScreen(final ScreenLogic screen) {
        cScreen.dispose();
        cScreen = screen;
    }

    public final void setBackground(final String fileName){
        setBackground(Gdx.files.internal(fileName));
    }

    public final void setBackground(final FileHandle file) {
        if (cBackgroundSprite != null) {
            cBackgroundSprite.getTexture().dispose();
        }
        cBackgroundSprite = new Sprite(new Texture(file));
        cBackgroundSprite.setSize(16f, 9f);
        cBackgroundSprite.setPosition(-8f, -4.5f);
    }

    /**
     * Clears the stage and adds a new actor.
     * @param actor Actor to add
     */
    public void setActor(final Actor actor) {
        cStage.clear();
        cStage.addActor(actor);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        cViewPort.apply();
        renderDefaults();
        cBatch.begin();
        cBackgroundSprite.draw(cBatch);
        cBatch.end();
        cStage.act();
        cStage.draw();
    }

    protected final void renderDefaults(){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cCamera.update();
        cBatch.setProjectionMatrix(cCamera.combined);
    }

    @Override
    public void resize(final int width, final int height) {
        UI_SCALAR = height / DEV_HEIGHT;
        cViewPort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        cBackgroundSprite.getTexture().dispose();
    }
}
