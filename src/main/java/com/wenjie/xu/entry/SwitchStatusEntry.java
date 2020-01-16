package com.wenjie.xu.entry;
/**
 * {
	"SwitchStatus": {
	"mRId": 123456789, 设备 PMS_id
	"currentState": 1, 当前状态
	"value": 10, 变位信息
	"time": "2019-10-31\n13:30:00" 变位时间
	}
	}
 * @author 徐文杰
 *
 */
public class SwitchStatusEntry extends Entry{
	private SwitchStatus switchStatus;

	public SwitchStatus getSwitchStatus() {
		return switchStatus;
	}

	public void setSwitchStatus(SwitchStatus switchStatus) {
		this.switchStatus = switchStatus;
	}
}
