package com.tuling;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lvwei
 * @date 2021/10/28 9:43 下午
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    @RequestMapping("/test")
    public String test() {
        Entry entry = null;
// 务必保证 finally 会被执行
        try {
            // 资源名可使用任意有业务语义的字符串，注意数目不能太多（超过 1K），超出几千请作为参数传入而不要直接作为资源名
            // EntryType 代表流量类型（inbound/outbound），其中系统规则只对 IN 类型的埋点生效
            entry = SphU.entry("test");
            // 被保护的业务逻辑
            // do something...
            log.info("success");
            return "hello world";
        } catch (BlockException ex) {
            // 资源访问阻止，被限流或被降级
            // 进行相应的处理操作
            return "降级";
        } catch (Exception ex) {
            // 若需要配置降级规则，需要通过这种方式记录业务异常
            // Tracer.traceEntry(ex, entry);
        } finally {
            // 务必保证 exit，务必保证每个 entry 与 exit 配对
            if (entry != null) {
                entry.exit();
            }
        }
        return null;
    }

    @PostConstruct
    private void initFlowQpsRule() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule("test");
        // set limit qps to 20
        rule.setCount(1);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //  rule.setLimitApp("default");
        rules.add(rule);



        FlowRule rule2 = new FlowRule("user");
        // set limit qps to 20
        rule2.setCount(1);
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //  rule.setLimitApp("default");
        rules.add(rule2);
        FlowRuleManager.loadRules(rules);
    }

    /**
     * blockHandler 对应处理 BlockException 的函数名称，
     * 可选项。blockHandler 函数访问范围需要是 public，
     * 返回类型需要与原方法相匹配，
     * 参数类型需要和原方法相匹配并且最后加一个额外的参数，
     * 类型为 BlockException。
     * blockHandler 函数默认需要和原方法在同一个类中。
     * 若希望使用其他类的函数，则可以指定 blockHandlerClass
     * 为对应的类的 Class 对象，注意对应的函数必需为 static 函数，否则无法解析。
     * @param id
     * @return
     */
    @RequestMapping("/user")
    @SentinelResource(value = "user", fallback = "helloFallback",blockHandler = "blockHandler01")
    public String test02(String id) {
        //int a=1/0;
        return "user成功";
    }

    public String blockHandler01(String id, BlockException ex) {

        return "user降级";
    }
    public String helloFallback(String id,Throwable e) {
        e.printStackTrace();
        return "异常处理";
    }
}
