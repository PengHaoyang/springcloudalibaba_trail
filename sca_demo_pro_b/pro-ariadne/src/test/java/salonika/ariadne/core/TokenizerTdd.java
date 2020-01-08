package salonika.ariadne.core;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: penghaoyang
 * @Date: 2020/1/7 11:40
 * @Description: TokenizerTdd
 */
public class TokenizerTdd {

    @DataProvider(name = "ds1")
    public Object[][] ds1(){
        return new Object[][]{
                {"civilization", Boolean.TRUE},
                {"userName", Boolean.TRUE},
                {"this_is_also_a_single_word", Boolean.TRUE},
                {"var02", Boolean.TRUE},
                {"1andOnly", Boolean.TRUE},
                {"3_000_000L", Boolean.TRUE},
                {"+", Boolean.TRUE},
                {"|", Boolean.TRUE},
                {"&&", Boolean.TRUE},
                {"->", Boolean.TRUE},
                {"->p", Boolean.FALSE},
                {"dfa.", Boolean.FALSE},
                {"Mkd<", Boolean.FALSE},
                {"dataSet=", Boolean.FALSE},
                {"ffe|", Boolean.FALSE},
                {"eeu&", Boolean.FALSE},
                {"|y", Boolean.FALSE},
                {"&w", Boolean.FALSE},
                {"[x", Boolean.FALSE},
                {"{z", Boolean.FALSE},
                {"(S", Boolean.FALSE},
                {"3+", Boolean.FALSE},
                {"/5", Boolean.FALSE},
        };
    }

    @DataProvider(name = "ds2")
    public Object[][] ds2(){
        return new Object[][]{
                {
                    "City.java",
                    "public class City {" +
                    "   /** name 就是名字 */" +
                    "   private String name; /* 这是注释 */" +
                    "   public String show(int num){" +
                    "       return name + num; // 加起来" +
                    "   }" +
                    "}"
                }
        };
    }

    /**
     * 从 tdd01_test_check_word_valid 中抽取出的方法
     * 检查字符串是否是完整单词（关键字、标识符、或标点符号等）而不是混合的
     * 先考虑没有注释的情况
     * @param word to be validate
     * @return boolean
     */
    private Boolean validWord(String word) {
        // 判断这个word是否是正确的单词，或标点符号, 或注释
        // 使用正则匹配
        // 对于单词：任意大于1的长度, 包含"a-zA-z0-9"以及"_"
        // 对于标点符号：长度都是指定的，常见长度为1，部分长度为2（如"->"）
        // TODO对于注释：长度都是任意的，判断如何包围，如"//...&"或"/*...*/"
        String wordRegex = "^[a-zA-Z0-9_]+$";
        String punctuatorRegex =
                "^(" +
                        "[!@<>=+\\-*/%?&|\"'{}\\[\\]()]" + /* 枚举长度为1的标点 */
                        "|(\\|\\|)" + /* 长度为2的标点: "||" */
                        "|(&&)" + /* 长度为2的标点: "&&" */
                        "|(->)" + /* 长度为2的标点: "->" */
                        ")$";
        return word.matches(wordRegex) || word.matches(punctuatorRegex);
    }

    @Test(dataProvider = "ds1")
    public void tdd01_test_check_word_valid(String word, Boolean expected){
        Boolean act = validWord(word);
        Assert.assertEquals(act, expected);
    }

    @Test(dataProvider = "ds2")
    public void tdd02_test_parse_line_into_words(String textFileName, String codeText){
        // 截取word成为char列表，然后循环每个char
        // 预添加char到当前单词
        // 如果仍是合规则的词（单词类或标点符号），则继续追加char到当前单词 */
        // 否则当前单词加入结果列表，然后重置当前单词
        List<String> resultWordList = new LinkedList<>();
        StringBuilder currentWord = new StringBuilder();
        for(char c : codeText.toCharArray()){
            String tempWord = currentWord.toString() + c;
            if(validWord(tempWord)){
                currentWord.append(c);
            } else {
                resultWordList.add(currentWord.toString());
                currentWord = new StringBuilder();
            }
        }
        System.out.println(resultWordList);

    }

}
