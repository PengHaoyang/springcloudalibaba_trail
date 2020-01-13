package salonika.ariadne.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: penghaoyang
 * @Date: 2020/1/13 16:47
 * @Description: DefaultAGTService
 */
@Service
public class DefaultAGTService {

    private RestTemplate restClient = new RestTemplate();


    /**
     *
     */
    public Map<String, String> getAllSourceCodeByGithubRepoIdentifier(String githubRepoIdentifier, String... fileSuffixes) {
        return getAllSourceCodeByGithubRepoIdentifier(githubRepoIdentifier, "", fileSuffixes);
    }

    /**
     *
     */
    public Map<String, String> getAllSourceCodeByGithubRepoIdentifier(String githubRepoIdentifier, String path, String... fileSuffixes) {
        /*
         * 调用repo_contents接口，返回值是包含各种文档或者代码元数据信息的 doc对象
         * - 遍历每个 doc对象，
         * - - 每个 doc对象 要么代表文件，要么代表文件夹（和github看到的文件结构一致）
         * - - 是dir，则
         * - - - 要继续进入获取子对象集合（迭代此方法）
         * - - - 直到没有dir可以进入
         * - - 是文件，则
         * - - - 从 doc对象 中的_links.self接口地址中获取 source_code，添加到结果map中
         * - - - 文件需要base64解压
         * 关于接口的授权
         * - 目前来看该调用会有限制，所以得使用github的接口授权，like OAuth
         * - 没有授权的调用每小时60次，授权后每小时是5000次
         * - 当然也可以把调用得到的内容存到本地
         */
        Map<String, String> result = new LinkedHashMap<>();
        String currApiGithubUrl = String.format("https://api.github.com/repos/%s/contents/%s", githubRepoIdentifier, path);
        JSONArray repoDocs = this.restClient.getForEntity(currApiGithubUrl, JSONArray.class).getBody();

        for (int i = 0; i < repoDocs.size(); i ++) {
            JSONObject docObj = repoDocs.getJSONObject(i);
            /* doc对象 自身在github中标记自身位置的路径 */
            String docPath = docObj.getString("path");
            if(StringUtils.equals(docObj.getString("type"), "dir")){
                Map<String, String> subSourceCode = this.getAllSourceCodeByGithubRepoIdentifier(githubRepoIdentifier, docPath, fileSuffixes);
                result.putAll(subSourceCode);
                continue;
            }
            String sourceCode = this.extractSourceCodeFromContentSelfUrl(docObj.getJSONObject("_links").getString("self"));
            result.put(docPath, sourceCode);
        }
        return result;
    }

    /**
     * @param ContentSelfUrl 通过repo_content接口得到的文件content对象中, 提供的_links.self接口地址，这个url地址中包含 source_code
     * @return String the source_code
     */
    private String extractSourceCodeFromContentSelfUrl(String ContentSelfUrl) {
        JSONObject docData = this.restClient.getForEntity(ContentSelfUrl, JSONObject.class).getBody();
        String content = docData.getString("content");
        return content;
    }

}
