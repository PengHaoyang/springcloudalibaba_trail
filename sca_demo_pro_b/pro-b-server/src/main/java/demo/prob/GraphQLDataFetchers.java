package demo.prob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;

/**
 * @Author: penghaoyang
 * @Date: 2020/1/3 17:23
 * @Description: GraphQLDataFetchers
 */
@Component
public class GraphQLDataFetchers {

    @Autowired
    private ProbService probService;

    public DataFetcher getPojobByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");
            return probService.peekData().get(id);
        };
    }

    public DataFetcher getPojobAll() {
        return dataFetchingEnvironment -> probService.peekData().values();
    }
}
