package com.orange.shop;

/**
 * Recherche de boutiques Orange.
 * 
 * Le point d'entr�e doit impl�menter cette interface.
 * 
 * 
 */
public interface OrangeShopFinder {
    /**
     * @author imen
     * find Orange Shop by longitude, latitude and nameMobile
     * @param longitude
     * @param latitude
     * @param nameMobile
     * @return 
     */
	String findOrangeShopWithMobileAvailable(double longitude, double latitude, String nameMobile);
}
