package cg.group4.view.screen;

import cg.group4.game_logic.StandUp;
import cg.group4.util.timer.TimeKeeper;
import cg.group4.util.timer.Timer;
import cg.group4.view.screen_mechanics.ScreenLogic;
import cg.group4.view.screen_mechanics.ScreenStore;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import java.util.Observable;
import java.util.Observer;

/**
 * First screen displayed when opening the application.
 */
public final class HomeScreen extends ScreenLogic {
    /**
     * Container group used for the layout of the view.
     */
    protected Table cTable;

    /**
     * Buttons for the stroll, settings.
     */
    protected TextButton cStrollButton, cSettingsButton;

    /**
     * Labels for cTitle, timer.
     */
    protected Label cTitle, cTimer;

    /**
     * Determines if the stroll button is clickable.
     */
    protected boolean cIsClickable = false;

    /**
     * Observer that gets called on the start of a new stroll.
     */
    protected Observer cNewStrollObserver = new Observer() {
        @Override
        public void update(final Observable o, final Object arg) {
            ScreenStore.getInstance().addScreen("Stroll", new StrollScreen());
        }
    };

    /**
     * Observer to subscribe to the tick subject of the interval timer.
     */
    protected Observer cIntervalTickObserver;

    /**
     * The interval timer of the game.
     */
    protected Timer cIntervalTimer, cStrollTimer;

    /**
     * Creates the home screen.
     */
    public HomeScreen() {
        StandUp.getInstance().getNewStrollSubject().addObserver(cNewStrollObserver);
    }

    @Override
    protected WidgetGroup createWidgetGroup() {
        cTable = new Table();
        cTable.setFillParent(true);

        initTimers();
        initHomeScreenTitle();
        initStrollIntervalTimer();

        initStrollButton();
        initSettingsButton();

        return cTable;
    }

    @Override
    protected void rebuildWidgetGroup() {
        cTitle.setStyle(cGameSkin.getDefaultLabelStyle());
        cTimer.setStyle(cGameSkin.getDefaultLabelStyle());
        cStrollButton.setStyle(cGameSkin.getDefaultTextButtonStyle());
        cSettingsButton.setStyle(cGameSkin.getDefaultTextButtonStyle());
    }

    /**
     * Obtains both the STROLL and INTERVAL Timers so we can properly create the GUI.
     */
    protected void initTimers() {
        cIntervalTimer = TimeKeeper.getInstance().getTimer(Timer.Global.INTERVAL.name());
        cStrollTimer = TimeKeeper.getInstance().getTimer(Timer.Global.STROLL.name());
        cIsClickable = cStrollTimer.isRunning() || !cIntervalTimer.isRunning();
    }

    /**
     * Initializes the title on the home screen.
     */
    public void initHomeScreenTitle() {
        cTitle = new Label("Super StarFish Mania", cGameSkin.get("default_labelStyle", Label.LabelStyle.class));
        cTable.row().expandY();
        cTable.add(cTitle);
    }

    /**
     * Gets the IntervalTimer and initializes buttons and behaviour. Then adds the label to the WidgetGroup.
     */
    public void initStrollIntervalTimer() {
        String textToDisplay;
        if (cIsClickable) {
            if (cStrollTimer.isRunning()) {
                textToDisplay = "Stroll running!";
            } else {
                textToDisplay = "Ready!";
            }
        } else {
            textToDisplay = Integer.toString(Timer.Global.INTERVAL.getDuration());
        }
        cTimer = new Label(textToDisplay, cGameSkin.get("default_labelStyle", Label.LabelStyle.class));

        cIntervalTickObserver = new Observer() {
            @Override
            public void update(final Observable o, final Object arg) {
                if (!cStrollTimer.isRunning()) {
                    cTimer.setText(arg.toString());
                }
            }
        };

        Observer cIntervalStopObserver = new Observer() {
            @Override
            public void update(final Observable o, final Object arg) {
                if (!cStrollTimer.isRunning()) {
                    cIsClickable = true;
                    cTimer.setText("Ready!");
                }
            }
        };

        Observer cIntervalStartObserver = new Observer() {
            @Override
            public void update(final Observable o, final Object arg) {
                if (!cStrollTimer.isRunning()) {
                    cIsClickable = false;
                    cTimer.setText(Integer.toString(Timer.Global.INTERVAL.getDuration()));
                }
            }
        };

        cIntervalTimer.getStartSubject().addObserver(cIntervalStartObserver);
        cIntervalTimer.getStopSubject().addObserver(cIntervalStopObserver);
        cIntervalTimer.getTickSubject().addObserver(cIntervalTickObserver);

        cTable.row().expandY();
        cTable.add(cTimer);
    }

    /**
     * Initializes the stroll buttons on the home screen.
     */
    public void initStrollButton() {
        cStrollButton = cGameSkin.generateDefaultMenuButton("Stroll");
        cStrollButton.addListener(new ChangeListener() {
            @Override
            public void changed(final ChangeEvent event, final Actor actor) {
                if (cIsClickable) {
                    StandUp.getInstance().startStroll();
                    ScreenStore.getInstance().setScreen("Stroll");
                }
            }
        });
        cTable.row().expandY();
        cTable.add(cStrollButton);
    }

    /**
     * Initializes the settings button on the home screen.
     */
    public void initSettingsButton() {
        cSettingsButton = cGameSkin.generateDefaultMenuButton("Settings");
        cSettingsButton.addListener(new ChangeListener() {
            @Override
            public void changed(final ChangeEvent event, final Actor actor) {
                ScreenStore.getInstance().setScreen("Settings");
            }
        });
        cTable.row().expandY();
        cTable.add(cSettingsButton);
    }

    @Override
    protected String setPreviousScreenName() {
        return null;
    }
}
