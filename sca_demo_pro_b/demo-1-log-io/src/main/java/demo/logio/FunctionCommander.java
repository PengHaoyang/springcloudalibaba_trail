package demo.logio;

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
    /**
     * 这些注解， 分别定义了 [cmd] ([key] [value]) ()... 的各个未知以及默认值等
     * @param msg String
     * @param msg2 String
     * @return String
     */
    @ShellMethod(value = "say hello to this")
    public String hello(
            @ShellOption(defaultValue = "world") String msg,
            @ShellOption(defaultValue = "good") String msg2){
        return "yes, the '" + msg + "' is " + msg2;
    }
}
