package com.nongxin.terminal.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import com.nongxin.terminal.util.JwtUtil;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.schema.Column;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@EnableTransactionManagement
@Configuration
//@MapperScan("com.nongxin.terminal.dao.scfinance.*.mapper*")
public class MybatisPlusConfig {


    private static Logger logger = LoggerFactory.getLogger(MybatisPlusConfig.class);

    private static List<String> tableNames = Arrays.asList();


    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {


        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        /*
         * 【测试多租户】 SQL 解析处理拦截器<br>
         * 这里固定写成住户 1 实际情况你可以从cookie读取，因此数据看不到 【 麻花藤 】 这条记录（ 注意观察 SQL ）<br>
         */
        List<ISqlParser> sqlParserList = new ArrayList<>();
        TenantSqlParser tenantSqlParser = new MyTenantParser();
        tenantSqlParser.setTenantHandler(new TenantHandler() {


            @Override
            public Expression getTenantId(boolean where) {

                final boolean multipleTenantIds = false;
                if (where && multipleTenantIds) {
                    //logger.info("multipleTenantIdCondition");
                    return multipleTenantIdCondition();
                } else {
                    //logger.info("singleTenantIdCondition");
                    return singleTenantIdCondition();
                }
            }

            private Expression singleTenantIdCondition() {
                Integer fnanceUserId = JwtUtil.queryFnanceUserId();
                logger.info("singleTenantIdCondition:"+fnanceUserId);
                return new LongValue(fnanceUserId);//ID自己想办法获取到
            }

            private Expression multipleTenantIdCondition() {
                final InExpression inExpression = new InExpression();
                inExpression.setLeftExpression(new Column(getTenantIdColumn()));
                final ExpressionList itemsList = new ExpressionList();
                final List<Expression> inValues = new ArrayList<>(2);
                inValues.add(new LongValue(1));//ID自己想办法获取到
                inValues.add(new LongValue(2));
                itemsList.setExpressions(inValues);
                inExpression.setRightItemsList(itemsList);
                return inExpression;
            }

            @Override
            public String getTenantIdColumn() {
                return "tenant_id";
            }

            @Override
            public boolean doTableFilter(String tableName) {
                if(tableNames.contains(tableName)){
                    logger.info("tableNames.contains(tableName):"+tableName+": "+tableNames.contains(tableName));
                }

                return !tableNames.contains(tableName);
                //return !"user".equalsIgnoreCase(tableName);
            }

        });

        sqlParserList.add(tenantSqlParser);
        //paginationInterceptor.setSqlParserList(sqlParserList);

        return paginationInterceptor;
    }
}
