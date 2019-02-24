package org.itsallcode.openfasttrace.core;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

class TestItemStatus
{
	@Test
	void testIsEquallyOrMoreMature()
	{
		assertThat(ItemStatus.DRAFT.isEquallyOrMoreMature(ItemStatus.REJECTED), equalTo(true));
	}

	@Test
	void testIsEquallyOrMoreMatureTrueIfIdentical()
	{
		assertThat(ItemStatus.DRAFT.isEquallyOrMoreMature(ItemStatus.DRAFT), equalTo(true));
	}

	@Test
	void testIsEquallyOrMoreMatureFalse()
	{
		assertThat(ItemStatus.REJECTED.isEquallyOrMoreMature(ItemStatus.DRAFT), equalTo(false));
	}
}