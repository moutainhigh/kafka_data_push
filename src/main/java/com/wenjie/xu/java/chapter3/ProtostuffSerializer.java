package com.wenjie.xu.java.chapter3;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.wenjie.xu.java.chapter2.Company;

/**
 * Created by 朱小厮 on 2018/7/26.
 */
public class ProtostuffSerializer implements Serializer<Company> {
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @SuppressWarnings("unchecked")
	public byte[] serialize(String topic, Company data) {
        if (data == null) {
            return null;
        }
        Schema<Company> schema = (Schema<Company>) RuntimeSchema.getSchema(data.getClass());
        LinkedBuffer buffer =
                LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        byte[] protostuff = null;
        try {
            protostuff = ProtostuffIOUtil.toByteArray(data, schema, buffer);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        } finally {
            buffer.clear();
        }
        return protostuff;
    }

    public void close() {
    }
}
