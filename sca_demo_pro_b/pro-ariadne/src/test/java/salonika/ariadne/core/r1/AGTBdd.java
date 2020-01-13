package salonika.ariadne.core.r1;

import com.alibaba.fastjson.JSONObject;
import com.github.javaparser.ast.CompilationUnit;
import org.testng.annotations.Test;

/**
 * @Author: penghaoyang
 * @Date: 2020/1/11 09:31
 * @Description: AGTBdd
 */
public class AGTBdd {

    @Test
    public void test01(){
        // 根据某个java code实例，生成、返回一个GT实例集合（的数据结构）
        // - java code以类为单位， 逻辑在方法中， 一个方法为一个可直接查看的子GT
        // - 方法之间互相调用不会影响，最外层的方法（比如main方法、restful接口方法）即处在GT的往根节点的位置
        // 这个GT和树结构之间的区别是
        // - GT中每组同一个父节点的节点（同级节点）之间有关系需要表示出来
        // - 这些关系包括诸如：
        // - - 顺序要求（不可并发）or无顺序要求（可并发）
        // - - 且（都需要执行）or根据条件（来自上下文的数据或参数）的或（部分执行，如if-else、switch等策略）
        // - 表示这些关系，也可以用节点形式，
        // - - 节点的类型就得区分开来，是关系父节点，还是封装父节点
        // - - 封装父节点表示的下钻实际上也是特殊的关系
        // - - 关系节点不改变作用域（即节点的级别）
        // 需要另外定义AST结构，以及GT结构

        // 如何生成这样的GT呢？
        // 需要定义我们的AST结构，而不是使用框架中的AST结构
    }

    @Test
    public void test02(){
        // 根据java code实例展示GT实例，查询信息
        // 查询时有时会参照某些逻辑的位置（角度）
    }

}
