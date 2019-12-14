package com.orange.shop;

import java.util.Comparator;
import java.util.List;
/**
 * OrangeShopFinderImpl
 * @author imen
 * @date Le 14/12/2019
 */
public class OrangeShopFinderImpl implements OrangeShopFinder{
	
	private static final int NAUTICAL_MILLE_PER_DEGREE_OF_SEPERATION = 60 ;
	private static final int METERS_PER_NAUTICAL_MILLE  = 1852 ;
    
	/**
	 * @author imen
	 * find Orange Shop by longitude, latitude and nameMobile
	 * @param longitude
	 * @param latitude
	 * @param nameMobile
	 * @return String
	 */
	@Override
	public String findOrangeShopWithMobileAvailable(double longitude, double latitude, String nameMobile) {
		// TODO Auto-generated method stub
		/**read all lines from excel file **/
		FileShopReader fileReader = new FileShopReader();
		List<Line> allLines = fileReader.setAllLine();
		
		/**Create Comparator to compare distance between client location and two locations of orange boutique**/
		Comparator<Line> sortedByDistance = (line1,line2)->{
			
			double distance1 =  calculateDistance(longitude, latitude, Double.valueOf(line1.getField1()),
					Double.valueOf(line1.getField2()));
			double distance2 =  calculateDistance(longitude, latitude, Double.valueOf(line2.getField1()),
					Double.valueOf(line2.getField2()));
			
			return Double.compare(distance1, distance2);
			
		};
		
		/**Use Stream API to get the nearest orange boutique with stock > 0 for a given mobile name**/
		String orangeShop = allLines.stream()
				.sorted(sortedByDistance)
				.filter(line ->  (EnumNameMobile.Sunusng.getDisplay().equals(nameMobile)
							&& Integer.valueOf(line.getField4()) > 0 )
						|| (EnumNameMobile.Ipom.getDisplay().equals(nameMobile)
								&& Integer.valueOf(line.getField5()) > 0)
						|| (EnumNameMobile.Weiwei.getDisplay().equals(nameMobile)
								&& Integer.valueOf(line.getField6()) > 0)

						)
				.map(Line::getField3)
				.findAny()
				.orElse(null);
				

		return orangeShop;
	}

    /**
     * This function calculate distance between client location and orange shop :
     * @param lon1
     * @param lat1
     * @param lon2
     * @param lat2
     * @return double
     */
	private double calculateDistance(double lon1, double lat1, double lon2, double lat2) {
		double theta = lon1 - lon2;
		
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		
		dist = Math.acos(dist);
		dist = rad2deg(dist);

		dist = dist * NAUTICAL_MILLE_PER_DEGREE_OF_SEPERATION;
		dist = dist * METERS_PER_NAUTICAL_MILLE;
		return (dist);
	}

	/**
	 * This function converts decimal degrees to radians :
	 * @param deg
	 * @return double
	 */
	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
    /**
     *  This function converts radians to decimal degrees :
     * @param rad
     * @return
     */
	private double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}
	
   
}
