package demo.prob;

import java.io.IOException;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * @Author: penghaoyang
 * @Date: 2020/1/3 17:16
 * @Description: GraphQLProvider
 */
@Component
public class GraphQLProvider {

    /**
     * 这个是GraphQL上下文，应该是
     */
    private GraphQL graphQL;

    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    /**
     * 读取graphql的配置，目前只定义在了schema.graphqls中
     */
    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("graphql/schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        /* graphql配置的具体加载过程 */
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    /**
     * 应该是定义映射
     *
     * @return RuntimeWiring
     */
    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("pojobById", graphQLDataFetchers.getPojobByIdDataFetcher())
                        .dataFetcher("pojobAll", graphQLDataFetchers.getPojobAll()))
                .type(newTypeWiring("Pojob"))
                .build();
    }
}
