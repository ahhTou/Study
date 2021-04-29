package com.tou.s03_prototype.deep_clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeepProtoType implements Serializable, Cloneable {
    public String name;
    public DeepCloneableTarget deepCloneableTarget;

    // 深拷贝 - 方式1 使用clone 方法
    @Override
    protected DeepProtoType clone() throws CloneNotSupportedException {

        DeepProtoType deep = null;

        // 这里完成对基本数据类型和String的克隆
        deep = (DeepProtoType) super.clone();

        // 对引用类型的属性，进行单独的处理
        deep.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();

        return deep;
    }

    // 深拷贝 - 方式2 通过对象的序列化实现（推荐）
    public DeepProtoType deepClone() {
        // 创建流对象
        ByteArrayOutputStream bo = null;
        ByteArrayInputStream bi = null;
        ObjectOutputStream oo = null;
        ObjectInputStream oi = null;

        try{
            bo = new ByteArrayOutputStream();
            oo = new ObjectOutputStream(bo);
            oo.writeObject(this); // 当前这个对象以对象流的方式输出


            // 反序列化
            bi = new ByteArrayInputStream(bo.toByteArray());
            oi = new ObjectInputStream(bi);

            return (DeepProtoType) oi.readObject();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (bo != null) bo.close();
                if (bi != null) bi.close();
                if (oo != null) oo.close();
                if (oi != null) oi.close();
            }catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }

        return null;

    }
}
