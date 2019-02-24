package org.itsallcode.openfasttrace.core;

/*-
 * #%L
 * OpenFastTrace
 * %%
 * Copyright (C) 2016 - 2018 itsallcode.org
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

/**
 * This class represent the maturity of a specification item (e.g. "approved" or
 * "rejected"
 */
public enum ItemStatus
{
	APPROVED(3), PROPOSED(2), DRAFT(1), REJECTED(0);

	private final int maturityLevel;

	private ItemStatus(final int maturityLevel)
	{
		this.maturityLevel = maturityLevel;
	}

	/**
	 * Compare the maturity level of this status with another one
	 *
	 * @param other status this is compared with
	 * @return <code>true</code> if this status is at least as mature as the other
	 *         one
	 */
	public boolean isEquallyOrMoreMature(final ItemStatus other)
	{
		return this.maturityLevel >= other.maturityLevel;
	}

	/**
	 * Parse a specification item status from a string
	 *
	 * @param text sting the status is parsed from
	 * @return detected status
	 * @throws IllegalArgumentException if the string is not recognized
	 */
	public static ItemStatus parseString(final String text)
	{
		for (final ItemStatus value : values())
		{
			if (text.equalsIgnoreCase(value.toString()))
			{
				return value;
			}
		}
		throw new IllegalArgumentException("Unrecognized specification item status: \"" + text + "\"");
	}

	@Override
	public String toString()
	{
		return this.name().toLowerCase();
	}
}
