package io.github.yehongzhi.canal.deploy;

import java.util.List;

public class CanalBean {
    //数据
    private List<TbCommodityInfo> data;
    //数据库名称
    private String database;

    private long es;
    //递增，从1开始
    private int id;
    //是否是DDL语句
    private boolean isDdl;
    //表结构的字段类型
    private MysqlType mysqlType;
    //UPDATE语句，旧数据
    private String old;
    //主键名称
    private List<String> pkNames;
    //sql语句
    private String sql;

    private SqlType sqlType;
    //表名
    private String table;

    private long ts;
    //(新增)INSERT、(更新)UPDATE、(删除)DELETE、(删除表)ERASE等等
    private String type;

    public List<TbCommodityInfo> getData() {
        return data;
    }

    public void setData(List<TbCommodityInfo> data) {
        this.data = data;
    }

    public boolean isDdl() {
        return isDdl;
    }

    public void setDdl(boolean ddl) {
        isDdl = ddl;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getDatabase() {
        return database;
    }

    public void setEs(long es) {
        this.es = es;
    }

    public long getEs() {
        return es;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIsDdl(boolean isDdl) {
        this.isDdl = isDdl;
    }

    public boolean getIsDdl() {
        return isDdl;
    }

    public void setMysqlType(MysqlType mysqlType) {
        this.mysqlType = mysqlType;
    }

    public MysqlType getMysqlType() {
        return mysqlType;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public String getOld() {
        return old;
    }

    public void setPkNames(List<String> pkNames) {
        this.pkNames = pkNames;
    }

    public List<String> getPkNames() {
        return pkNames;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    public void setSqlType(SqlType sqlType) {
        this.sqlType = sqlType;
    }

    public SqlType getSqlType() {
        return sqlType;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getTable() {
        return table;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public long getTs() {
        return ts;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}