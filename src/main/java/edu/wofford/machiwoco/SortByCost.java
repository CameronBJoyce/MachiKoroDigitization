package edu.wofford.machiwoco;

import java.util.*; 
import java.lang.*; 
import java.io.*; 

/**
 * Uses built-in compare functionality to sort two Landmarks by cost.
 * 
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */

class SortByCost implements Comparator<Landmark> 
{ 
    // Used for sorting in ascending order of 
    // landmark cost 
    /**
     * Compares two Landmarks and returns an integer used to sort by cost.
     * @param a the first Landmark to be compared.
     * @param b the second Landmark to be compared.
     * @return an integer used to sort the Landmarks by cost.
     */

    public int compare(Landmark a, Landmark b) 
    { 
        return a.getCost() - b.getCost(); 
    } 
}