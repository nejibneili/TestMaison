package com.adneom.sujetmaison;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Spliterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The Class PartitionTestCase.
 *
 * @author Nejib Neili
 * @Nom_Classe PartitionTestCase
 * @Date_Modification 29/05/2018 17:55
 */

@SuiteClasses(PartitionTestCase.class)
public class PartitionTestCase {

	/** The partition list. */
	List<Integer> partitionList;

	/** The partition list 1. */
	List<Integer> partitionList1;

	/** The partition list 2. */
	List<Integer> partitionList2;

	/** The partition list 3. */
	List<Integer> partitionList3;

	Partition partitionImpl;

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() {
		partitionImpl = new PartitionImpl();

		// On déclare la liste globale
		partitionList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		// On déclare les sous liste si la taille est égale à 3
		partitionList1 = Arrays.asList(1, 2, 3);
		partitionList2 = Arrays.asList(4, 5, 6);
		partitionList3 = Arrays.asList(7);

	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.adneom.sujetmaison.PartitionImpl#PartitionImpl()}.
	 */
	// Tester si la liste est vide
	@Test
	public void testEmptyList() {
		assertFalse(partitionImpl.partition(partitionList, 3).isEmpty());
	}

	/**
	 * Test method for {@link com.adneom.sujetmaison.PartitionImpl#PartitionImpl()}.
	 */
	// Tester si la liste est null
	@Test
	public void testNullList() {
		assertFalse(partitionImpl.partition(partitionList, 3) == null);
	}

	/**
	 * Test method for {@link com.adneom.sujetmaison.PartitionImpl#PartitionImpl()}.
	 */
	@Test
	public void testSizeList() {
		// Tester le nombre des sous listes/élements dans la liste
		assertTrue(partitionImpl.partition(partitionList, 3).size() == 3);
	}

	/**
	 * Test method for {@link com.adneom.sujetmaison.PartitionImpl#PartitionImpl()}.
	 */
	@Test
	public void testPartitionImpl() {

		Collection<List<Integer>> collection = partitionImpl.partition(partitionList, 3);

		Spliterator<List<Integer>> spliterator = collection.spliterator();

		// Tester la première partition dans la liste
		spliterator.tryAdvance(firstPartition -> assertEquals(partitionList1, firstPartition));
		// Tester la deuxième partition dans la liste
		spliterator.tryAdvance(secondPartition -> assertEquals(partitionList2, secondPartition));
		// Tester la troisième partition dans la liste
		spliterator.tryAdvance(thirdPartition -> assertEquals(partitionList3, thirdPartition));

	}

}
