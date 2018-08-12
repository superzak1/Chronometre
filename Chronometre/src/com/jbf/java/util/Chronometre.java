package com.jbf.java.util;
/**
 * @(#)Chronometre.java
 *
 *
 * @author Jean-Baptiste Fromenteau
 * @version 1.0.0 2008/4/16
 */

import com.jbf.java.util.TimeListener;
import com.jbf.java.util.TimeEvent;

/**
 * That class is a chronometre (hours, minutes, seconds).
 *
 **/

public class Chronometre {

	/**
	 * The thread we are using to count the elapsed time.
	 *
	 **/
	protected Thread chronometre;

	/**
	 * The hours of the chronometre.
	 *
	 **/
	protected int hours = 0;

	/**
	 * The minutes of the chronometre.
	 *
	 **/
	protected int minutes = 0;

	/**
	 * The seconds of the chronometre.
	 *
	 **/
	protected int seconds = 0;

	/**
	 * To know which events are happening.
	 *
	 **/
	protected TimeListener timeListener = null;

	/**
	 * To create a new <code>Chronometre</code> with a given start time.
	 *
	 * @param int
	 *            h The number of hours.
	 * @param int
	 *            m The number of minutes (that value must be between 0 and 59).
	 * @param int
	 *            s The number of seconds (that value must be between 0 and 59).
	 *
	 **/
	public Chronometre(int h, int m, int s) {

		setTime(h, m, s);

		init();

	}

	/**
	 * To create a new <code>Chronometre</code>.
	 *
	 **/
	public Chronometre() {

		init();

	}

	/**
	 * To initialize the chronometre.
	 *
	 **/
	private void init() {

		chronometre = new Thread() {

			public void run() {

				while (true) {

					seconds++;

					if (seconds == 59) {

						minutes++;

						seconds = 0;

						if (minutes == 59) {

							hours++;

							minutes = 0;
							seconds = 0;

							timeListener.hoursChanged(new TimeEvent(this));

						}

						timeListener.minutesChanged(new TimeEvent(this));

					}

					timeListener.secondsChanged(new TimeEvent(this));
					timeListener.timeChanged(new TimeEvent(this));

					try {
						sleep(1000);
					} catch (InterruptedException ie) {
					}

				}

			}

		};

	}

	/**
	 * To add a <code>TimeListener</code> to that <code>Chronometre</code>.
	 *
	 * @param TimeListener
	 *            tl The listener to add.
	 *
	 **/
	public void addTimeListener(TimeListener tl) {

		this.timeListener = tl;

	}

	/**
	 * To run the chronometre.
	 *
	 **/
	public void start() {

		chronometre.start();

		timeListener.timeStarted(new TimeEvent(this));

	}

	/**
	 * To stop (definitively) the chronometre.
	 *
	 **/
	public void stop() {

		chronometre.stop();

		timeListener.timeStoped(new TimeEvent(this));

	}

	/**
	 * To stop (temporaly) the chronometre.
	 *
	 **/
	public void suspend() {

		chronometre.suspend();

		timeListener.timeSuspended(new TimeEvent(this));

	}

	/**
	 * To run again the chronometre (with previous value).
	 *
	 **/
	public void resume() {

		chronometre.resume();

		timeListener.timeResumed(new TimeEvent(this));

	}

	/**
	 * To reset the chronometre.
	 *
	 **/
	public void reset() {

		hours = 0;
		minutes = 0;
		seconds = -1;

		timeListener.timeReseted(new TimeEvent(this));

	}

	/**
	 * To set the current time.
	 *
	 * @param int
	 *            h The number of hours.
	 * @param int
	 *            m The number of minutes (that value must be between 0 and 59).
	 * @param int
	 *            s The number of seconds (that value must be between 0 and 59).
	 *
	 **/
	public void setTime(int h, int m, int s) {

		this.hours = h;
		this.minutes = m;
		this.seconds = s;

	}

	/**
	 * To get the current time.
	 *
	 * @return String The current time (hours minutes seconds).
	 *
	 **/
	public String getTime() {

		return (hours + ":" + minutes + ":" + seconds);

	}

	/**
	 * To set the number of hours.
	 *
	 * @param int
	 *            h The number of hours to set.
	 *
	 **/
	public void setHours(int h) {

		this.hours = h;

	}

	/**
	 * To get the current number of hours.
	 *
	 * @return int The number of hours.
	 *
	 **/
	public int getHours() {

		return this.hours;

	}

	/**
	 * To set the number of minutes.
	 *
	 * @param int
	 *            m The number of minutes to set (between 0 and 59).
	 *
	 **/
	public void setMinutes(int m) {

		this.minutes = m;

	}

	/**
	 * To get the current number of minutes.
	 *
	 * @return int The number of minutes.
	 *
	 **/
	public int getMinutes() {

		return this.minutes;

	}

	/**
	 * To set the number of seconds.
	 *
	 * @param int
	 *            s The number of seconds to set (between 0 and 59).
	 *
	 **/
	public void setSeconds(int s) {

		this.seconds = s;

	}

	/**
	 * To get the current number of seconds.
	 *
	 * @return int The number of seconds.
	 *
	 **/
	public int getSeconds() {

		return this.seconds;

	}

}
