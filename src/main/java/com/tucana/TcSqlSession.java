package com.tucana;

public class TcSqlSession {

    private TcConfiguration tcConfiguration;

    private TcExecutor tcExecutor;

    public TcSqlSession(TcConfiguration tcConfiguration, TcExecutor tcExecutor) {
        this.tcConfiguration = tcConfiguration;
        this.tcExecutor = tcExecutor;
    }

    /**
     * @param statementId 配置文件中定义的key，可以通过此来获取所定义的value
     * @param parameter
     * @return
     */
    public Fee selectOne(String statementId, Object parameter) {
        String sql = TcConfiguration.SQL_BUNDLE.getString(statementId);
        System.out.println("sql: " + sql);
        return tcExecutor.query(sql, parameter);
    }

    /** 直接使用注解的方式 */

    /**
     * 使用动态代理 用一个统一的MapperProxy代理类动态代理各个不同的Mapper
     *
     * <p>这样可以使用MapperProxy进行统一处理，提升复用和扩展性，为之后的使用提供了很多的可能
     */
    public <T> T getMapper(Class clazz) {
        // mapper相关信息在配置文件等数据中获取
        return tcConfiguration.getMapper(clazz, this);
    }
}
