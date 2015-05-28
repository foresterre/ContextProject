package cg.group4.view.screen_mechanics;

import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;

/**
 * Abstract class which defines the base screen logic.
 * Should be extended by all other screens in the application.
 *
 * @author Jurgen van Schagen
 */
public abstract class ScreenLogic {
    /**
     * The name of the previous screen. Used to go back to that screen through the ScreenStore.
     */
    protected final String cPreviousScreenName;
    /**
     * Reference to the default game skin.
     */
    protected GameSkin cGameSkin;
    /**
     * This group will be the active Actor in the WorldRenderer when this screen becomes
     * active.
     */
    protected WidgetGroup cWidgetGroup;
    /**
     * Reference to the ScreenStore. Used to switch to other screens.
     */
    protected ScreenStore cScreenStore;

    /**
     * A default constructor which initializes the screen logic.
     */
    public ScreenLogic() {
        cScreenStore = ScreenStore.getInstance();
        cGameSkin = cScreenStore.getGameSkin();
        cPreviousScreenName = setPreviousScreenName();

    }

    /**
     * Creates the WidgetGroup that contains the logic of this Screen.
     *
     * @return The WidgetGroup that will be added to the Stage.
     */
    protected abstract WidgetGroup createWidgetGroup();

    /**
     * This method is called whenever the game is resized. In this method the all the UI elements need to update
     * their styles using .setStyle().
     */
    protected abstract void rebuildWidgetGroup();

    /**
     * This method defines the Screen to go back to. Simply supplying the name of the Screen is sufficient since
     * the ScreenStore will handle the rest.
     *
     * @return Name of the previous Screen name. Can be null.
     */
    protected abstract String setPreviousScreenName();

    /**
     * Returns the previous Screen name. Has to be set through the setPreviousScreenName() method.
     *
     * @return The previous Screen name.
     */
    public final String getPreviousScreenName() {
        return cPreviousScreenName;
    }

    /**
     * Returns the WidgetGroup of this Screen. This will be added to the Stage in the WorldRenderer.
     *
     * @return The WidgetGroup containing the logic of this Screen.
     */
    public final WidgetGroup getWidgetGroup() {
        if (cWidgetGroup == null) {
            cWidgetGroup = createWidgetGroup();
        }
        return cWidgetGroup;
    }


}
