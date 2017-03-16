package com.pomelo.car.web.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pomelo.car.web.model.Car;

@Component
public class CarDao extends BaseDao<Car> {
	public  CarDao() {
		super.setType(Car.class);
	}
	public List<Car> findListByBrandId(String brandId){
		String sql ="SELECT c.id AS id, c.`name` AS `name`, c.icon AS icon, c.brandId AS brandId, c.detail AS detail FROM Car_CarInfo AS c WHERE c.brandId=?";
		return getList(sql, brandId);
	}
	public List<Car> findCarsBySearchName(String keyWords) {
		String sql ="SELECT c.id AS id, c.`name` AS `name`, c.icon AS icon, c.brandId AS brandId, c.detail AS detail FROM Car_CarInfo AS c WHERE c.`name` LIKE ?";
		return getList(sql, "%"+keyWords+"%");
	}
	public Car findCarsDetailById(int id){
		String sql="SELECT c.id, c.name, c.icon, c.brandId, c.detail, c.addTime, c.isValid FROM Car_CarInfo AS c WHERE c.id=? ";
		return findForBean(Car.class,sql,id);
	}
}
