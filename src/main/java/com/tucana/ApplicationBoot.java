package com.tucana;

/**
 * @Author: qingshan
 */
public class ApplicationBoot {
    public static void main(String[] args) {
        TcSqlSession sqlSession = new TcSqlSession(new TcConfiguration(), new TcExecutor());
        FeeMapper feeMapper = sqlSession.getMapper(FeeMapper.class);
        Fee fee = feeMapper.selectById(1L);
        System.out.println(fee);
    }
}
