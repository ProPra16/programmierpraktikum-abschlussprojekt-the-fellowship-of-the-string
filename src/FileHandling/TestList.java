/*******************************************************************************
 * Copyright (c) 2016 The Fellowship of the String and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Marcel Beek - initial API and implementation
 *     Patrick Pirig - initial API and implementation
 *     Phillippe Weise - initial API and implementation
 *     Sabine Timmer - initial API and implementation
 *******************************************************************************/
package FileHandling;

import java.util.ArrayList;

public class TestList extends ArrayList<Test> {

	private static final long serialVersionUID = 1L;
	private boolean running;

	public TestList() {
		super();
	}

	public boolean allPassing() {

		Object[] codeArray = this.toArray();

		for (int i = 0; i < codeArray.length; i++) {
			running = ((Test) codeArray[i]).oneTestFailing();

			if (running == false)
				return false;
		}
		return true;
	}
}
