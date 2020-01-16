package salonika.ariadne.core.r2;

import com.alibaba.fastjson.JSONObject;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.serialization.JavaParserJsonSerializer;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collection;

/**
 * @Author: penghaoyang
 * @Date: 2020/1/16 11:33
 * @Description: AGTGenServiceTest
 */
public class AGTGenServiceTest {

    /**
     * @return 在resources中准备了实验source_codes, 读取它们, 作为测试数据
     * @throws IOException 来自使用FileUtils可能抛出的异常IOException
     */
    @DataProvider(name = "ds02")
    public Object[][] ds02() throws IOException {
        URL url = this.getClass().getClassLoader().getResource("sample");
        assert url != null;
        String path = URLDecoder.decode(url.getPath(), "UTF-8");
        Collection<File> files = FileUtils.listFiles(new File(path), new String[]{"java", "scala"}, false);
        Object[][] ds = new Object[8][2];
        int i = 0;
        for (File file : files) {
            ds[i][0] = file.getName();
            ds[i][1] = FileUtils.readFileToString(file, "UTF-8");
            i++;
        }
        return ds;
    }

    /**
     * 测试2：将source_code生成为ast
     *
     * @param sourceCodeName source_code所在的文件名
     * @param sourceCode     source_code的原始内容
     */
    @Test(dataProvider = "ds02")
    public void test02_gen_astData_from_source_codes(String sourceCodeName, String sourceCode) throws IOException {
        /* 使用StaticJavaParser转化 */
        CompilationUnit rawAst = StaticJavaParser.parse(sourceCode);
        /* 使用javax.json输出为json字符串, 这是javaparser仅支持的 */
        ByteArrayOutputStream jsonOs = new ByteArrayOutputStream();
        JsonGenerator jsonGen = Json.createGenerator(jsonOs);
        new JavaParserJsonSerializer().serialize(rawAst, jsonGen);
        /* 使用fastjson */
        JSONObject jsonObject = JSONObject.parseObject(jsonOs.toString());
        System.out.println(jsonObject);
    }
}
