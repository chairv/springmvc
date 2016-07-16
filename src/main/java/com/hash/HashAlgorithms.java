package com.hash;

/**
 * Created by tancw on 2016/7/12.
 */
public class HashAlgorithms {

	public static int additiveHash(String key, int prime) {
		int hash, i;
		for (hash = key.length(), i = 0; i < key.length(); i++) {
			hash += key.charAt(i);
		}
		return (hash & prime);
	}

	public static int rotatingHash(String key, int prime) {
		int hash, i;
		for (hash = key.length(), i = 0; i < key.length(); ++i) {
			hash = (hash << 4) ^ (hash >> 28) ^ key.charAt(i);
		}
		return (hash % prime);
	}

	public static void main(String[] args) {
		// System.out.println(additiveHash("keyvalue",3));
		// System.out.println(rotatingHash("keyvalue",3));
		int h;
		String key = "1sd";
		int rs = (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(rs);
	}
}
