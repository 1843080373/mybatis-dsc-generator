package com.ftl.basic.ib;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import freemarker.template.DefaultListAdapter;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class MySortMethod implements TemplateMethodModelEx {

    /**
     * 自定义函数需要实现的方法
     * @param list 在.ftl模板中调用自定义方法传的参数
     * @return 返回结果
     * @throws TemplateModelException
     */
    @SuppressWarnings("unchecked")
	@Override
    public Object exec(List list) throws TemplateModelException {

        // 接收传入的List
        DefaultListAdapter defaultListAdapter = (DefaultListAdapter) list.get(0);
        List<Integer> arrayList = (List<Integer>) defaultListAdapter.getAdaptedObject(Integer.class);

        // 接收传入的升序还是降序布尔值
        boolean asc = "yes".equals(((SimpleScalar) list.get(1)).getAsString()) ? true : false;

        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(asc) {
                    return o1 - o2;
                }else {
                    return o2 - o1;
                }
            }
        });
        return arrayList;
    }
}