package com.adneom.sujetmaison;

import java.util.Collection;
import java.util.List;

/**
 * The Interface Partition.
 *
 * @author Nejib Neili
 * @Nom_Classe Partition
 * @Date_Modification 29/05/2018 17:56
 */
public interface Partition {

	/**
	 * Partition.
	 *
	 * @param liste
	 *            the liste
	 * @param taille
	 *            the taille
	 * @return the collection
	 */
	Collection<List<Integer>> partition(List<Integer> liste, int taille);

}
