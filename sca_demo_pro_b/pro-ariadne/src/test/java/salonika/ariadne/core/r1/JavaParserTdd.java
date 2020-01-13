package salonika.ariadne.core.r1;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @Author: penghaoyang
 * @Date: 2020/1/7 13:54
 * @Description: JavaParserTdd
 */
public class JavaParserTdd {

    @DataProvider(name = "ds2")
    public Object[][] ds2() {
        String code_text = "package salonika.ariadne.core.sample;\n" +
                "\n" +
                "import com.alibaba.fastjson.JSONObject;\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "\n" +
                "/**\n" +
                " * @Author: penghaoyang\n" +
                " * @Date: 2020/1/7 14:02\n" +
                " * @Description: BasicPlace\n" +
                " */\n" +
                "class BasicPlace {\n" +
                "    /** key 就是key */\n" +
                "    String key = \"good one\"; /* 这是注释 */\n" +
                "    {\n" +
                "        long y = 1222L + 3555L;\n" +
                "        int x = (int) (54 + (y * 24));\n" +
                "        key = \"nice one\";\n" +
                "        System.out.println(\"begin BasicPlace, \" + x);\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "/**\n" +
                " * @Author: penghaoyang\n" +
                " * @Date: 2020/1/7 14:01\n" +
                " * @Description: City\n" +
                " */\n" +
                "public class City extends BasicPlace {\n" +
                "    static {\n" +
                "        int x = 34 * 16;\n" +
                "        System.out.println(\"begin City, \" + x);\n" +
                "    }\n" +
                "    @Autowired\n" +
                "    /** name 就是名字 */\n" +
                "    private String name; /* 这也是注释 */\n" +
                "    public String show(int num){\n" +
                "        int temp= 12 * num; // 临时的值\n" +
                "        for (int i = 0; i < 10; i++) { // 循环\n" +
                "            System.out.println(\"haha\");\n" +
                "        }\n" +
                "        String str1 = JSONObject.toJSONString(temp); // 调用方法\n" +
                "        return name + str1 + key; // 加起来\n" +
                "    }\n" +
                "}";
        return new Object[][]{
                {
                        "City.java",
                        StaticJavaParser.parse(code_text)
                }
        };
    }

    @Test(dataProvider = "ds2")
    public void test01(String textFileName, CompilationUnit rawAst) {

        rawAst.findAll(ClassOrInterfaceDeclaration.class).stream()
                .filter(c -> {
                    String className = c.getName().asString();
                    return StringUtils.equals(className, "City");
                })
                .forEach(c -> {
                    c.setName("BeautifulPlace");
                });

        List<BlockStmt> blockStmts = rawAst.findAll(BlockStmt.class);

        System.out.println(rawAst.toString());
    }

}
