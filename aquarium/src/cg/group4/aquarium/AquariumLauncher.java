package cg.group4.aquarium;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * The AquariumLauncher is the starting point to launch a fish-tank version of the game.
 * This class is mostly used for displaying a group collection aquarium on a display.
 */
public class AquariumLauncher {


    /**
     * Starts the application.
     * Uses a borderless fullscreen window.
     *
     * @param arg Arguments of the application.
     */
    public static void main(final String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
        config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
        config.fullscreen = false;


        // set the border to undecorated (no minus/resize/close and thinner borders) to better emulate fullscreen,
        // without actually setting fullscreen mode on.
        System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");

        new LwjglApplication(new DisplayLauncher(), config);
    }

}