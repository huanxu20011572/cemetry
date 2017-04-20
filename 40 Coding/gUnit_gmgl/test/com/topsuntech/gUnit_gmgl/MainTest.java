package com.topsuntech.gUnit_gmgl;

public class MainTest {
	
	public static void main(String[] a){
		String cemeteryRegistryCode ="20002201411004800";
		int orgId=2000;
		cemeteryRegistryCode = orgId + "_"+cemeteryRegistryCode.substring((orgId+"").length()+1,cemeteryRegistryCode.length()-2);

		System.out.println(cemeteryRegistryCode);

	}

}
