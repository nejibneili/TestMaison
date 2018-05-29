package com.adneom.sujetmaison;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * The Class PartitionImpl.
 *
 * @author Nejib Neili
 * @Nom_Classe PartitionImpl
 * @Date_Modification 29/05/2018 17:56
 */
public class PartitionImpl implements Partition {

	/**
	 * Instantiates a new partition impl.
	 */
	public PartitionImpl() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adneom.sujetmaison.Partition#partition(java.util.List, int)
	 */
	// Utiliser Java Stream API pour faire la partition
	public Collection<List<Integer>> partition(List<Integer> liste, int taille) {
		final AtomicInteger atomicInteger = new AtomicInteger(0);

		return liste.stream().collect(Collectors.groupingBy(element -> atomicInteger.getAndIncrement() / taille))
				.values();
	}

}
