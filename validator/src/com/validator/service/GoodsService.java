package com.validator.service;

import java.util.ArrayList;

import com.validator.model.Goods;

public interface GoodsService {

	boolean save(Goods g);
	ArrayList<Goods> getGoods();
}
