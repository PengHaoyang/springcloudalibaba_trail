package salonika.ariadne.core;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: penghaoyang
 * @Date: 2020/1/15 16:58
 * @Description: SourceCodeFetcher4LocalRepo
 */
public class SourceCodeFetcher4LocalRepo {

    public Map<String, String> getAllSourceCodeInLocalRepoHomeQuietly(String repoHome, String... fileSuffixes){
        try {
            return getAllSourceCodeInLocalRepoHome(repoHome, fileSuffixes);
        } catch (IOException ignored) {
            return null;
        }
    }

    /**
     * source_code 读取方法1：
     * - 从本地中的某个repo路径开始
     * - 递归读取其内部的所有文件 as source_code集合
     *
     * @param repoHome 本地的repo的绝对路径
     * @param fileSuffixes 需要返回的文件后缀
     * @return Map<String, String> 路径:文件内容
     */
    public Map<String, String> getAllSourceCodeInLocalRepoHome(String repoHome, String... fileSuffixes) throws IOException {
        Map<String, String> result = new HashMap<>();
        Collection<File> files = FileUtils.listFiles(new File(repoHome), fileSuffixes, true);
        for (File file : files) {
            /* 仅保留home开始的相对路径 */
            String identicalPath = file.getCanonicalPath().replace(repoHome, "");
            String content = FileUtils.readFileToString(file, "UTF-8");
            result.put(identicalPath, content);
        }
        return result;
    }

}
