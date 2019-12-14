package com.orange.shop;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;
/**
 * @author imen
 *@date 14/12/2019
 */
public class OrangeShopFinderTest {
	
	

	@Test
	public void testFindOrangeShopWithMobileAvailable() throws Exception {
		
		OrangeShopFinder orangeShopFinder = new OrangeShopFinderImpl();
		String orangeShop = orangeShopFinder.findOrangeShopWithMobileAvailable(4.83599, 43.92861, EnumNameMobile.Weiwei.getDisplay());
		System.out.println("la plus proche boutique orange est : "+ orangeShop);
		assertNotNull(orangeShop);

	}
	
	

}
