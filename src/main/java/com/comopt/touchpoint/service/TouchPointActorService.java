package com.comopt.touchpoint.service;

import java.util.List;

import com.comopt.touchpoint.model.TouchPointActor;

public interface TouchPointActorService {

	void updateProcessedTouchPoint(List<? extends TouchPointActor> data);

}
