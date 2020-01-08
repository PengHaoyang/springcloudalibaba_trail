package salonika.ariadne.core;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

/**
 * @Author: penghaoyang
 * @Date: 2020/1/7 13:54
 * @Description: JavaParserTdd
 */
public class JavaParserTdd {

    @DataProvider(name = "ds2")
    public Object[][] ds2(){
        return new Object[][]{
                {
                        "City.java",
                        "package salonika.ariadne.core;\n" +
                                "\n" +
                                "import com.alibaba.fastjson.JSONObject;\n" +
                                "\n" +
                                "/**\n" +
                                " * @Author: penghaoyang\n" +
                                " * @Date: 2020/1/7 14:02\n" +
                                " * @Description: BasicPlace\n" +
                                " */\n" +
                                "class BasicPlace {\n" +
                                "    /** key 就是key */\n" +
                                "    String key = \"good one\"; /* 这是注释 */\n" +
                                "}\n" +
                                "\n" +
                                "/**\n" +
                                " * @Author: penghaoyang\n" +
                                " * @Date: 2020/1/7 14:01\n" +
                                " * @Description: City\n" +
                                " */\n" +
                                "public class City extends BasicPlace {\n" +
                                "   /** name 就是名字 */\n" +
                                "   private String name; /* 这也是注释 */\n" +
                                "   public String show(int num){\n" +
                                "       int temp= 12 * num; // 临时的值\n" +
                                "       for (int i = 0; i < 10; i++) { // 循环\n" +
                                "           System.out.println(\"haha\");\n" +
                                "       }\n" +
                                "       String str1 = JSONObject.toJSONString(temp); // 调用方法\n" +
                                "       return name + str1 + key; // 加起来\n" +
                                "   }\n" +
                                "}"
                }
        };
    }

    @Test(dataProvider = "ds2")
    public void test01(String textFileName, String codeText){
        CompilationUnit compilationUnit = StaticJavaParser.parse(codeText);
        Optional<ClassOrInterfaceDeclaration> classA = compilationUnit.getClassByName("A");
        System.out.println(compilationUnit.toString());
    }

}
