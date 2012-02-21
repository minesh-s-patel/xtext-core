/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.eclipse.jdt.annotation.NonNullByDefault;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 */
@NonNullByDefault
public interface ITextRegionWithLineInformation extends ITextRegion {

	int getLineNumber();
	
	int getEndLineNumber();
	
	ITextRegionWithLineInformation merge(ITextRegionWithLineInformation other);
	
	static ITextRegionWithLineInformation EMPTY_REGION = new ITextRegionWithLineInformation() {

		public int getOffset() {
			return 0;
		}

		public int getLength() {
			return 0;
		}

		public ITextRegion merge(ITextRegion region) {
			return region;
		}

		public boolean contains(ITextRegion other) {
			return false;
		}

		public boolean contains(int offset) {
			return false;
		}

		public int getLineNumber() {
			return 0;
		}

		public int getEndLineNumber() {
			return 0;
		}

		public ITextRegionWithLineInformation merge(ITextRegionWithLineInformation other) {
			return other;
		}
		
	};
	
}
