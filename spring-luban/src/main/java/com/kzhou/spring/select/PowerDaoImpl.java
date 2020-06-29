package com.kzhou.spring.select;

import org.springframework.stereotype.Repository;

@Repository
public class PowerDaoImpl implements PowerDao {
    @Override
    public void getPower() {
        System.out.println("powerImpl");
    }
}
