package com.jbf.java.util;
/**
 * @(#)TimeEvent.java
 *
 *
 * @author Jean-Baptiste Fromenteau
 * @version 1.0.0 2008/4/16
 */

import java.util.EventObject;

/**
 * That class represent a <code>TimeEvent</code> object.
 *
 **/

public class TimeEvent extends EventObject {

	/**
	 * Which class has generate this event .. ?
	 *
	 **/
	protected Object source = null;

	/**
	 * A new <code>TimeEvent</code> object.
	 *
	 * @param Object
	 *            s The event's source.
	 *
	 **/
	public TimeEvent(Object s) {

		super(s);

		this.source = s;

	}

	/**
	 * To get the event's source.
	 *
	 * @return Object The source of that event.
	 *
	 **/
	public Object getSource() {

		return this.source;

	}

}
