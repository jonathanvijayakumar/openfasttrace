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
 * This class implements a parameter object to control the settings of OFT's
 * specification item linker.
 */
public class LinkSettings
{
	private final ItemStatus minCoveringItemStatus;

	private LinkSettings(final Builder builder)
	{
		this.minCoveringItemStatus = builder.minCoveringItemStatus;
	}

	/**
	 * Get the minimum status a specification item must have to provide coverage
	 *
	 * @return minimum status
	 */
	public ItemStatus getMinCoveringItemStatus()
	{
		return this.minCoveringItemStatus;
	}

	/**
	 * Create default trace settings
	 *
	 * @return default trace settings
	 */
	public static LinkSettings createDefault()
	{
		return builder().build();
	}

	/**
	 * Create an export settings builder
	 *
	 * @return export settings builder
	 */
	public static Builder builder()
	{
		return new Builder();
	}

	/**
	 * Builder for {@link LinkSettings}
	 */
	public static class Builder
	{
		private ItemStatus minCoveringItemStatus = ItemStatus.APPROVED;

		private Builder()
		{
		}

		/**
		 * Set the minimum item status that should count into coverage
		 *
		 * @param minCoveringItemStatus minimum status an item must have to be able to
		 *                              provide coverage
		 * @return <code>this</code> for fluent programming
		 */
		public Builder minCoveringItemStatus(final ItemStatus minCoveringItemStatus)
		{
			this.minCoveringItemStatus = minCoveringItemStatus;
			return this;
		}

		/**
		 * Create a new instance of {@link LinkSettings}
		 *
		 * @return new instance
		 */
		public LinkSettings build()
		{
			return new LinkSettings(this);
		}
	}
}