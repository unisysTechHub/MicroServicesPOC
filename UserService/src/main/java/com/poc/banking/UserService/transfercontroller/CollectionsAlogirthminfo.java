package com.poc.banking.UserService.transfercontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionsAlogirthminfo {
	LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String, String>();  //- presive the order - buckets + linked list
	ArrayList<String> arrayList = new ArrayList<String>(); // array like based on index
	ConcurrentHashMap<String, String> cocurrentHashMpa = new ConcurrentHashMap<String, String>(); //- bulk updates
	HashSet<String> hashSet = new HashSet<String>(); //- Bucket - not presever order
	TreeSet<String> treeSet = new TreeSet<String>(); // sorted order BST
	TreeMap<String,String> treeMap = new TreeMap<String, String>(); // sorted order
   HashMap<String,String> hasMap = new HashMap<String, String>();// doesn't preseve order Bucket
}








