package com.avinash.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateValidIPAddresses {

	public static ArrayList<String> validIPAddresses(String string) {
//		ArrayList<String> result = new ArrayList<>();
//		for (int i = 0; i < Math.min(string.length(), 4); i++) {
//			String[] currentIpAddressPart = new String[4];
//			currentIpAddressPart[0] = string.substring(0, i);
//			if (isValidIpPart(currentIpAddressPart[0])) {
//				for (int j = i+1; j < Math.min(string.length(), i + 4); j++) {
//					currentIpAddressPart[1] = string.substring(i, j);
//					if (isValidIpPart(currentIpAddressPart[1])) {
//						for (int k = j+1; k < string.length(); k++) {
//							currentIpAddressPart[2] = string.substring(j, k);
//							currentIpAddressPart[3] = string.substring(k);
//							if (isValidIpPart(currentIpAddressPart[2]) && isValidIpPart(currentIpAddressPart[3])) {
//								result.add(Arrays.stream(currentIpAddressPart).collect(Collectors.joining(".")));
//							}
//						}
//					}
//				}
//			}
//		}
//		return result;
		ArrayList<String> result = new ArrayList<>();
	    String[] sArray = new String[4];
	    for (int i = 0; i < Math.min(string.length(), 4); i++) {
	      sArray[0] = string.substring(0, i);
	      if (isValidIPPart(sArray[0])) {
	        for (int j = i+1; j < i + Math.min(string.length() - i, 4); j++) {
	          sArray[1] = string.substring(i, j);
	          if (isValidIPPart(sArray[1])) {
	            for (int k = j + 1; k < j + Math.min(string.length() - j, 4); k++) {
	              sArray[2] = string.substring(j, k);
	              sArray[3] = string.substring(k);
	              if (isValidIPPart(sArray[2]) && isValidIPPart(sArray[3])) {
	                result.add(Arrays.stream(sArray).collect(Collectors.joining(".")));
	              }
	            }
	          }
	        }
	      }
	    }
	    return result;
	}

	private static boolean isValidIPPart(String s) {
		return s.length() > 0 && s.length() < 4 && Integer.valueOf(s) < 256 && s.length() == String.valueOf(Integer.valueOf(s)).length();
	}
 
	public static void main(String[] args) {
//		System.out.println(validIPAddresses("1921680"));
		System.out.println(validIPAddresses("255255255256"));
		List<String> list = Arrays.stream("Algo Expert is best".split(" ")).collect(Collectors.toList());
		
		
		
	}
}
