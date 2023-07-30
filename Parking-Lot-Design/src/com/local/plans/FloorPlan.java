package com.local.plans;

import java.util.HashMap;
import java.util.Map;

import com.local.entities.VehicleType;

public abstract class FloorPlan {
	protected static Map<Integer, VehicleType> plan = new HashMap<Integer, VehicleType>();
	
	
	public VehicleType getVehicleType(int slot) {
		return plan.containsKey(slot) ? plan.get(slot) : VehicleType.CAR;
	}
}
