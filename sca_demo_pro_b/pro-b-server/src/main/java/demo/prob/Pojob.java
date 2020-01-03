package demo.prob;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 13:34
 * @Description: PojoAA
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pojob {

    private String fieldB1;

    private String fieldB2;

    private int fieldB3;

    private long fieldB4;

    private String fieldB5;

    private Map<String, Object> fieldBMap;
}
