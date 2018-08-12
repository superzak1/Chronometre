package com.jbf.java.util;
/**
 * @(#)TimeListener.java
 *
 *
 * @author Jean-Baptiste Fromenteau
 * @version 1.0.0 2008/4/16
 */

import com.jbf.java.util.TimeEvent;

/**
 * That class contain each possible time events.
 *
 **/

public interface TimeListener {

	/**
	 * When the time has changed.
	 *
	 * @param TimeEvent
	 *            te The occured TimeEvent.
	 *
	 **/
	public void timeChanged(TimeEvent te);

	/**
	 * When seconds have changed.
	 *
	 * @param TimeEvent
	 *            te The occured TimeEvent.
	 *
	 **/
	public void secondsChanged(TimeEvent te);

	/**
	 * When minutes have changed.
	 *
	 * @param TimeEvent
	 *            te The occured TimeEvent.
	 *
	 **/
	public void minutesChanged(TimeEvent te);

	/**
	 * When hours have changed.
	 *
	 * @param TimeEvent
	 *            te The occured TimeEvent.
	 *
	 **/
	public void hoursChanged(TimeEvent te);

	/**
	 * When the time has started.
	 *
	 * @param TimeEvent
	 *            te The occured TimeEvent.
	 *
	 **/
	public void timeStarted(TimeEvent te);

	/**
	 * When the time has been stoped.
	 *
	 * @param TimeEvent
	 *            te The occured TimeEvent.
	 *
	 **/
	public void timeStoped(TimeEvent te);

	/**
	 * When time has been suspended.
	 *
	 * @param TimeEvent
	 *            te The occured TimeEvent.
	 *
	 **/
	public void timeSuspended(TimeEvent te);

	/**
	 * When time has been resumed.
	 *
	 * @param TimeEvent
	 *            te The occured TimeEvent.
	 *
	 **/
	public void timeResumed(TimeEvent te);

	/**
	 * When the time has been reset.
	 *
	 * @param TimeEvent
	 *            te The occured TimeEvent.
	 *
	 **/
	public void timeReseted(TimeEvent te);

}
