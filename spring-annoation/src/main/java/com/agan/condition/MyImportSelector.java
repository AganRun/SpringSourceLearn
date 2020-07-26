package com.agan.condition;

import com.agan.bean.Blue;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author agan
 *
 * 自定义逻辑返回需要导入的组件
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //importingClassMetadata
        //方法不要返回null值
        return new String[]{"com.agan.bean.Blue"};
    }
}
