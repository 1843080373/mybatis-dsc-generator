package com.ftl.basic.ib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.SimpleScalar;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 自定义指令
 * @author Administrator
 *类似自定义函数，我们也可以自定义指令，类似于if-else、assign这样的指令。
 *自定义指令的需要使用 @ 符号，而不是 # 符号。
 *可以使用 TemplateDirectiveModel 接口在Java代码中实现自定义指令。
 *TemplateDirectiveModel 在 FreeMarker 2.3.11 版本时才加入， 来代替快被废弃的 TemplateTransformModel。
 */
public class MyValidationDirective implements TemplateDirectiveModel {

    /**
     *
     * @param environment 环境变量(实现复杂功能时可能会用)
     * @param map 在.ftl模板中使用自定义指令传的参数(key-value形式)
     * @param templateModels 返回值，数组形式
     * @param templateDirectiveBody 指令内容
     * @throws TemplateException
     * @throws IOException
     */
    @Override
    public void execute(Environment environment,
                        Map map,
                        TemplateModel[] templateModels,
                        TemplateDirectiveBody templateDirectiveBody)
            throws TemplateException, IOException {

        SimpleScalar username = (SimpleScalar) map.get("username");
        SimpleScalar password = (SimpleScalar) map.get("password");

        if("admin".equals(username.getAsString()) && "123456".equals(password.getAsString())) {
            templateModels[0] = TemplateBooleanModel.TRUE;
        } else {
            templateModels[0] = TemplateBooleanModel.FALSE;
        }

        List<String> rights = new ArrayList<>();
        rights.add("insert");
        rights.add("delete");
        rights.add("update");
        rights.add("select");
        templateModels[1] = new SimpleSequence(rights);

        templateDirectiveBody.render(environment.getOut());
    }
}