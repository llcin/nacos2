package com.yumstone.service.impl;

import com.yumstone.dao.OrderDao;
import com.yumstone.domain.Order;
import com.yumstone.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lee.
 * @date 2020/9/8 13:58
 */
@Service
public class OrderImpl implements OrderService {
    @Autowired
    private  OrderDao orderDao;
    @Override
    public Order createOrder(Order order) {
        orderDao.save(order);
        return order;
    }
}
