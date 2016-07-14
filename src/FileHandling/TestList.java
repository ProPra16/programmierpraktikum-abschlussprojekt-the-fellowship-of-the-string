// Copyright (c) <2016> <Marcel Beek, Patrick Pirig, Phillippe Weise, Sabine Timmer>
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
