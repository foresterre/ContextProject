package cg.group4.util.timer;

/**
 * 
 * @author Jurgen van Schagen
 * @author Benjamin Los
 */
public abstract class TimerTask {

	/**
	 * Timer belonging to this task.
	 */
	private Timer cTimer;

	/** Returns the timer it belongs too.
	 * @return	The timer this task belongs too.
	 */
	public final Timer getTimer() {
		return cTimer;
	}

	/**
	 * Sets the timer the task belongs to.
	 * @param timer The timer the task belongs to
	 */
	public final void setTimer(final Timer timer) {
		cTimer = timer;
	}

	/**
	 * Abstract method for what a task should do on a certain amount of ticks.
	 * @param seconds	What should it do after this amount of seconds?
	 */
	public abstract void onTick(int seconds);

	/**
	 * Abstract method for what a task should do on startup of the timer.
	 */
	public abstract void onStart();
	/**
	 * Abstract method for what a task should do on the ending of the timer.
	 */
	public abstract void onStop();
}