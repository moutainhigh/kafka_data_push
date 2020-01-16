package com.wenjie.xu;

import java.util.List;
import java.util.Map;

public interface IDataPush {
	/**
	 * 2.2.7量测设备异动信息
	 *  接口名称 配电网量测设备异动信息
		数据流向 配电自动化系统->电网资源业务中台
		交互频率 24小时
		技术路线 Kafka
		Topic ZT_DMS_TRANSACTION
	 * @param data
	 */
	public void abnormalMovementMeasuringEquipment(Map<String, List<Map<String, String>>> data);
	/**
	 * 2.2.2开关状态信息
		接口名称 配电网开关状态信息
		数据流向 配电自动化系统->电网资源业务中台
		交互频率 实时
		技术路线 Kafka
		Topic ZT_DMS_CBSTATUS
	 * @param data
	 */
	public void switchState(Map<String, List<Map<String, String>>> data);
	/**
	 * 2.2.3 SOE信息
		接口名称 配电网SOE信息
		数据流向 配电自动化系统->电网资源业务中台
		交互频率 实时
		技术路线 Kafka
		Topic ZT_DMS_SOE
	 * @param data
	 */
	public void soe(Map<String, List<Map<String, String>>> data);
}
