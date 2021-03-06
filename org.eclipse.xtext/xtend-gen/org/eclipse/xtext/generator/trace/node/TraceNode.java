/**
 * Copyright (c) 2017 TypeFox (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace.node;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * A trace node maps the text generated through its children to a source location.
 * 
 * @author Sven Efftinge - initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public class TraceNode extends CompositeGeneratorNode {
  private ILocationData sourceLocation;
  
  public TraceNode(final ILocationData sourceLocation) {
    this.sourceLocation = sourceLocation;
  }
  
  private boolean useForDebugging;
  
  @Pure
  public ILocationData getSourceLocation() {
    return this.sourceLocation;
  }
  
  public void setSourceLocation(final ILocationData sourceLocation) {
    this.sourceLocation = sourceLocation;
  }
  
  @Pure
  public boolean isUseForDebugging() {
    return this.useForDebugging;
  }
  
  public void setUseForDebugging(final boolean useForDebugging) {
    this.useForDebugging = useForDebugging;
  }
}
