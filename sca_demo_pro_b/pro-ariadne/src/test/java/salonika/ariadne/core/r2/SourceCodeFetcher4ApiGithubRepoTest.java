package salonika.ariadne.core.r2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import salonika.ariadne.core.SourceCodeFetcher4ApiGithubRepo;

import java.util.Map;

/**
 * @Author: penghaoyang
 * @Date: 2020/1/13 16:45
 * @Description: AGTService4ApiGithubRepoTest
 */
public class SourceCodeFetcher4ApiGithubRepoTest {

    private SourceCodeFetcher4ApiGithubRepo sourceCodeFetcher4ApiGithubRepo = new SourceCodeFetcher4ApiGithubRepo();

    @DataProvider(name = "ds01")
    public Object[][] ds01() {
        return new Object[][]{
                {"neo4j/neo4j", "java", "scala"}
        };
    }

    /**
     * 测试调用api.github获取repo的source_code
     * @param githubRepoIdentifier github项目的标识符，比如 "neo4j/neo4j"，指向某个项目的home，用于调api.github.com/repos
     * @param fileSuffixes 代码的后缀，默认使用java
     */
    @Test(dataProvider = "ds01")
    public void test01_get_all_source_code_from_agtService_by_githubRepoIdentifier(String githubRepoIdentifier, String... fileSuffixes){
        // 目前想到 得到的Map<String, String> sourceCodes有两种形式
        // a：代码文件所在全路径作为key, 代码文件内容作为value
        // b：保留文件目录的树形结构；
        // 目前来看后者没有太大必要，此为中间过程，暂时用a即可
        Map<String, String> sourceCodes = sourceCodeFetcher4ApiGithubRepo.getAllSourceCodeByGithubRepoIdentifier(githubRepoIdentifier, fileSuffixes);
        System.out.println(sourceCodes);
    }


}
