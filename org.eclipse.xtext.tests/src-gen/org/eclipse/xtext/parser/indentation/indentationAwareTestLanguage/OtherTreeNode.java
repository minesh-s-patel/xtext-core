/**
 * generated by Xtext
 */
package org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Other Tree Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.OtherTreeNode#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.OtherTreeNode#getChildList <em>Child List</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.IndentationAwareTestLanguagePackage#getOtherTreeNode()
 * @model
 * @generated
 */
public interface OtherTreeNode extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.IndentationAwareTestLanguagePackage#getOtherTreeNode_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.OtherTreeNode#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Child List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Child List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Child List</em>' containment reference.
   * @see #setChildList(ChildList)
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.IndentationAwareTestLanguagePackage#getOtherTreeNode_ChildList()
   * @model containment="true"
   * @generated
   */
  ChildList getChildList();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.OtherTreeNode#getChildList <em>Child List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Child List</em>' containment reference.
   * @see #getChildList()
   * @generated
   */
  void setChildList(ChildList value);

} // OtherTreeNode
