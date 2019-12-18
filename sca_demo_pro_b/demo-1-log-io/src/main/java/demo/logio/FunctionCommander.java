package demo.logio;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @Author: penghaoyang
 * @Date: 2019/12/15 11:31
 * @Description: CliController
 */
@ShellComponent
public class FunctionCommander {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 这些注解， 分别定义了 [cmd] ([key] [value]) ()... 的各个未知以及默认值等
     * 当然这个方法也就在尝试特性的使用
     *
     * @param m String
     * @param h String
     * @return String
     */
    @ShellMethod(value = "say hello to this", key = {"hello", "hi"})
    public String hello(
            @ShellOption(help = "param No.1", value = {"-m"}, defaultValue = "world") String m,
            @ShellOption(help = "param No.2", defaultValue = "good") String h
    ){
        return "yes, the '" + m + "' is " + h;
    }

    /**
     * 打印日志
     * @param msg 打印的信息
     * @param level 级别
     * @param repeat 重复次数
     * @return String
     */
    @ShellMethod(value = "output something into log file")
    public String logger(
            @ShellOption(value = {"--message", "-m"}, defaultValue = "^_^ hi, there is some default words in the log line !!") String msg,
            @ShellOption(value = {"--level", "-l"}, defaultValue = "info") String level,
            @ShellOption(value = {"--repeat", "-r"}, defaultValue = "3") int repeat,
            @ShellOption(value = {"--name", "-n"}, defaultValue = "default") String name
    ){
        if(!StringUtils.equals(name, "default")){
            justLogInThread(msg, level, repeat, name);
        } else {
            justLog(msg, level, repeat, name);
        }
        return "success";
    }

    /**
     * 开启一个新的线程打印日志
     */
    private void justLogInThread(String msg, String level, int repeat, String name) {
        Runnable t = () -> justLog(msg, level, repeat, name);
        new Thread(t).start();
    }

    /**
     * 实际打印日志指令的操作（使用log4j2）
     */
    private void justLog(String msg, String level, int repeat, String name) {
        ThreadContext.put("seedName", name);
        for (int i = 0; i < repeat; i++) {

            if (StringUtils.endsWithIgnoreCase("debug", level)) {
                logger.debug(msg);
            }
            if (StringUtils.endsWithIgnoreCase("info", level)) {
                logger.info(msg);
            }
            if (StringUtils.endsWithIgnoreCase("warn", level)) {
                logger.warn(msg);
            }
            if (StringUtils.endsWithIgnoreCase("error", level)) {
                logger.error(msg);
            }
        }
        ThreadContext.remove("seedName");
    }

}
