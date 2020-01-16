package com.wenjie.xu.java.chapter3;

import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.wenjie.xu.java.chapter2.Company;

/**
 * Created by 朱小厮 on 2018/7/26.
 */
public class ProtostuffDeserializer implements Deserializer<Company> {
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    public Company deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }
        Schema<Company> schema = RuntimeSchema.getSchema(Company.class);
        Company ans = new Company();
        ProtostuffIOUtil.mergeFrom(data, ans, schema);
        return ans;
    }

    public void close() {

    }
}
