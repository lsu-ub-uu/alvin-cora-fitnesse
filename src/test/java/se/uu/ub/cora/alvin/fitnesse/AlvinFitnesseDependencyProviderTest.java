/*
 * Copyright 2018, 2019 Uppsala University Library
 *
 * This file is part of Cora.
 *
 *     Cora is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Cora is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Cora.  If not, see <http://www.gnu.org/licenses/>.
 */
package se.uu.ub.cora.alvin.fitnesse;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import se.uu.ub.cora.alvin.mixedstorage.fedora.AlvinFedoraToCoraConverterFactoryImp;

public class AlvinFitnesseDependencyProviderTest {
	@Test
	public void testConstructor() {
		AlvinFitnesseDependencyProvider dependencyProvider = new AlvinFitnesseDependencyProvider();
		assertTrue(dependencyProvider instanceof AlvinFitnesseDependencyProvider);
	}

	@Test(expectedExceptions = RuntimeException.class)
	public void testFactorConverterNonExistingClassName() {
		AlvinFitnesseDependencyProvider.setConverterFactoryClassName(
				"se.uu.ub.cora.alvin.mixedstorage.DoesNotExistFactoryImp");
	}

	@Test(expectedExceptions = RuntimeException.class)
	public void testFactorConverterClassNameNotSet() {
		AlvinFitnesseDependencyProvider.setConverterFactoryClassName(null);
	}

	@Test
	public void testFactorHttpHandler() {
		AlvinFitnesseDependencyProvider.setConverterFactoryClassName(
				"se.uu.ub.cora.alvin.mixedstorage.fedora.AlvinFedoraToCoraConverterFactoryImp");
		AlvinFedoraToCoraConverterFactoryImp converterFactory = (AlvinFedoraToCoraConverterFactoryImp) AlvinFitnesseDependencyProvider
				.getConverterFactory();
		assertTrue(converterFactory instanceof AlvinFedoraToCoraConverterFactoryImp);

		assertEquals(converterFactory.getFedoraURL(),
				"someFakeUrlSinceItsNotUsedHereButCodeRefactoringIsNeededElsewhere");
	}

}
