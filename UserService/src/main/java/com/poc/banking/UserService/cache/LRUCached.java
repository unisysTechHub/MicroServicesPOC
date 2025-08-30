package com.poc.banking.UserService.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.*;


public class LRUCached<K,V> extends LinkedHashMap<K,V>{
	
	 private final int capacity;
	    private final ReadWriteLock lock = new ReentrantReadWriteLock();

	    public LRUCached(int capacity) {
	        super(capacity, 0.75f, true);
	        this.capacity = capacity;
	    }

	    @Override
	    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
	        return size() > capacity;
	    }

	    @Override
	    public V get(Object key) {
	        lock.readLock().lock();
	        try {
	            return super.get(key);
	        } finally {
	            lock.readLock().unlock();
	        }
	    }

	    @Override
	    public V put(K key, V value) {
	        lock.writeLock().lock();
	        try {
	            return super.put(key, value);
	        } finally {
	            lock.writeLock().unlock();
	        }
	    }
	
 
}
