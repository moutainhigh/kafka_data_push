package com.wenjie.xu;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wenjie.xu.parse.AbnormalMovementMeasuringEquipment;
import com.wenjie.xu.parse.SOE;
import com.wenjie.xu.parse.SwitchState;

public class DataPushKafka implements IDataPush{
	private static final Logger logger = LoggerFactory.getLogger(DataPushKafka.class);
	@Override
	public void abnormalMovementMeasuringEquipment(
			Map<String, List<Map<String, String>>> data) {
		if(data==null||data.size()<=0) return;
		logger.info("开始执行");
		new Thread(new AbnormalMovementMeasuringEquipment(Topic.ZT_DMS_TRANSACTION, data)).start();
		return;
	}
	@Override
	public void switchState(Map<String, List<Map<String, String>>> data) {
		if(data==null||data.size()<=0) return;
		logger.info("开始执行");
		new Thread(new SwitchState(Topic.ZT_DMS_CBSTATUS, data)).start();
		return;
	}
	@Override
	public void soe(Map<String, List<Map<String, String>>> data) {
		if(data==null||data.size()<=0) return;
		logger.info("开始执行");
		new Thread(new SOE(Topic.ZT_DMS_SOE, data)).start();
		return;
	}
}
