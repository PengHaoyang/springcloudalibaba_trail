package salonika.ariadne.core;

import java.util.Map;

/**
 * @Author: penghaoyang
 * @Date: 2020/1/15 16:58
 * @Description: AGTService4LocalRepo
 */
public class AGTService4LocalRepo {

    /**
     * source_code 读取方法1：
     * - 从本地中的某个repo路径开始
     * - 递归读取其内部的所有文件 as source_code集合
     *
     * @param repoHome 本地的repo的绝对路径
     * @param fileSuffixes 需要返回的文件后缀
     * @return Map<String, String> 路径:文件内容
     */
    public Map<String, String> getAllSourceCodeInLocalRepoHome(String repoHome, String... fileSuffixes) {
        return null;
    }

    /**
     * source_code 读取方法1：
     * - 从本地中的某个repo路径中，某个文件开始
     * - 递归读取其内部的所有文件 as source_code集合
     *
     * @param repoHome 本地的repo的绝对路径
     * @param path 某个文件或文件夹的路径
     * @param fileSuffixes 需要返回的文件后缀
     * @return Map<String, String> 路径:文件内容
     */
    public Map<String, String> getAllSourceCodeInLocalRepoHome(String repoHome, String path, String... fileSuffixes) {
        return null;
    }
}
