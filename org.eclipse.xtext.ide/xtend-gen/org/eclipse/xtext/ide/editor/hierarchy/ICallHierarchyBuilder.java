/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder;

/**
 * It is used to build a call hierarchy structure.
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public interface ICallHierarchyBuilder extends IHierarchyBuilder {
  enum CallHierarchyType {
    CALLER,
    
    CALLEE;
  }
  
  ICallHierarchyBuilder.CallHierarchyType getHierarchyType();
  
  void setHierarchyType(final ICallHierarchyBuilder.CallHierarchyType hierarchyType);
}
