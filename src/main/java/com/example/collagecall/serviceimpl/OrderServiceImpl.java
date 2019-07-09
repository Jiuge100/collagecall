package com.example.collagecall.serviceimpl;

import com.example.collagecall.dao.OrderDao;
import com.example.collagecall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
}
