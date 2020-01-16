package com.wenjie.xu;

public class Test{
	public static void main(String[] args){
//        Producer<String, String> producer = null;
//        try {
//            producer = new KafkaProducer<>(KafkaProperties.getProperties());
//            for (int i = 0; i < 1000; i++) {
//                String msg = "hello"+i;
//                producer.send(new ProducerRecord<String, String>("ZT_DMS_CBSTATUS", msg),new PushKafka());
//                System.out.println("Sent:" + msg);
//                Thread.sleep(100);
//                producer.flush();
//            }
//        } catch (Exception e) {
//        	e.printStackTrace();
//        } finally {
//            producer.close();
//        }
//		Map<String, List<Map<String, String>>> data = new HashMap<String, List<Map<String,String>>>();
//		List<Map<String, String>> lm = new ArrayList<Map<String,String>>();
//		for(int i=0;i<1000;i++){
//			Map<String, String> mp = new HashMap<String, String>();
//			mp.put("msgId", "11111111111111"+i);
//			lm.add(mp);
//		}
//		data.put("key", lm);
		//调用示例
//		new DataPushKafka().switchState(data);
//		new DataPushKafka().abnormalMovementMeasuringEquipment(data);
//		new DataPushKafka().soe(data);
    }
}
