package com.chegy218.service;

import java.util.List;

public interface BaseService <E>{
	public int add(E e);

	public List<E> queryAll();

	public int deleteById(Integer id);

	public int update(E e);

	public E queryById(Integer id);
}
