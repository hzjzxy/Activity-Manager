/*
 * Copyright (c) 2004-2017, Jean-Francois Brazeau. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 * 
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 * 
 *  3. The name of the author may not be used to endorse or promote products
 *     derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIEDWARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS
 * OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.activitymgr.core.dto;

import org.activitymgr.core.orm.annotation.Column;
import org.activitymgr.core.orm.annotation.ColumnNamePrefix;
import org.activitymgr.core.orm.annotation.Table;

/**
 * Collaborateur.
 */
@Table("COLLABORATOR")
@ColumnNamePrefix("CLB_")
public class Collaborator extends SimpleIdentityBean {

	/** Index de l'attribut 'id' */
	public static final int ID_FIELD_IDX = 0;

	/** Index de l'attribut 'login' du collaborateur */
	public static final int LOGIN_FIELD_IDX = 1;

	/** Index de l'attribut 'firstName' du collaborateur */
	public static final int FIRST_NAME_FIELD_IDX = 2;

	/** Index de l'attribut 'lastName' du collaborateur */
	public static final int LAST_NAME_FIELD_IDX = 3;

	/** Index de l'attribut 'isActive' du collaborateur */
	public static final int IS_ACTIVE_FIELD_IDX = 4;

	/** Identifiant du collaborateur */
	private String login;

	/** Nom */
	@Column("FIRST_NAME")
	private String firstName;

	/** Prénom */
	@Column("LAST_NAME")
	private String lastName;

	/** Booléen indiquant si le collaborateur est actif ou non */
	@Column("IS_ACTIVE")
	private boolean isActive = true;

	/**
	 * Default constructor.
	 * <p>
	 * This constructor is protected as this class is not supposed to be
	 * instantiated directly. One is supposed to use the {@link IDTOFactory
	 * factory} instead.
	 * </p>
	 * @see IDTOFactory
	 */
	protected Collaborator() {
	}

	/**
	 * @return le prénom du collaborateur.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Définit le prénom du collaborateur.
	 * 
	 * @param firstName
	 *            le nouveau prénom.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return le nom du collaborateur.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Définit le nom du collaborateur.
	 * 
	 * @param lastName
	 *            le nouveau nom.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return l'identifiant du collaborateur.
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Définit l'identifiant du collaborateur.
	 * 
	 * @param login
	 *            le nouvel identifiant.
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Retourne un booléen indiquant si le collaborateur est actif ou non.
	 * 
	 * @return un booléen indiquant si le collaborateur est actif ou non.
	 */
	public boolean getIsActive() {
		return isActive;
	}

	/**
	 * Définit si le collaborateur est actif ou non.
	 * 
	 * @param isActive
	 *            un booléen indiquant si le collaborateur est actif ou non.
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
}
