package cg.group4.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Timer;


/**
 * Displays the main menu screen.
 */
public class MainMenu implements Screen {
	
	/**
	 * Stores the background for drawing on the screen.
	 */
	SpriteBatch batch = new SpriteBatch();
	
	/**
	 * Background image of the main menu.
	 */
	Texture background = new Texture(Gdx.files.internal("demobackground.jpg"));
    
	/**
	 * A button, for testing events.
	 */
	TextButton button;
	
	/**
	 *  
	 */
	Stage stage = new Stage();
	BitmapFont font = new BitmapFont();
    
	int width, height, time=0, delay = 10, passed = 0;

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);

        TextButtonStyle style = new TextButtonStyle();
        style.font = font;
        button = new TextButton("Settings", style);
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();

        button.setPosition(width / 2f - button.getWidth() / 2f, height / 2f);
        button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new Settings());
				System.out.println("Settings");
			}
		});
		Timer.schedule(new Timer.Task() {
			@Override
			public void run() {
				time=delay-passed;
				if (time == 0){
					System.out.println("done");
				}
				else {
					passed++;
				}
			}
		},0,1,delay);

        stage.addActor(button);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 132 / 255f, 197 / 255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
        batch.draw(background, 0, 0);
        font.draw(batch, Long.toString(time), width / 2f - 10, height - 100);
		batch.end();
		
		stage.act();
		
        stage.draw();
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

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
		font.dispose();
		batch.dispose();
		background.dispose();
		stage.dispose();
	}
}
