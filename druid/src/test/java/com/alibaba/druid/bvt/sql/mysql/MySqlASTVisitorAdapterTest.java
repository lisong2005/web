package com.alibaba.druid.bvt.sql.mysql;

import com.alibaba.druid.sql.ast.expr.SQLBinaryExpr;
import com.alibaba.druid.sql.ast.expr.SQLBooleanExpr;
import com.alibaba.druid.sql.dialect.mysql.ast.MySqlForceIndexHint;
import com.alibaba.druid.sql.dialect.mysql.ast.MySqlIgnoreIndexHint;
import com.alibaba.druid.sql.dialect.mysql.ast.MySqlKey;
import com.alibaba.druid.sql.dialect.mysql.ast.MySqlPrimaryKey;
import com.alibaba.druid.sql.dialect.mysql.ast.MySqlUnique;
import com.alibaba.druid.sql.dialect.mysql.ast.MySqlUseIndexHint;
import com.alibaba.druid.sql.dialect.mysql.ast.expr.MySqlCharExpr;
import com.alibaba.druid.sql.dialect.mysql.ast.expr.MySqlIntervalExpr;
import com.alibaba.druid.sql.dialect.mysql.ast.expr.MySqlOutFileExpr;
import com.alibaba.druid.sql.dialect.mysql.ast.expr.MySqlUserName;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.CobarShowStatus;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlAlterTableChangeColumn;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlAlterTableCharacter;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlAlterTableDiscardTablespace;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlAlterTableImportTablespace;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlAlterTableModifyColumn;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlAlterTableOption;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlAlterTableStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlBinlogStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement.TableSpaceOption;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateUserStatement.UserSpecification;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlDeleteStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlExecuteStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlInsertStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlKillStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlLoadXmlStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlLockTableStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlPartitionByHash;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlPartitionByKey;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlPartitionByList;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlPartitionByRange;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlPartitioningDef;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlPartitioningDef.InValues;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlPartitioningDef.LessThanValues;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlPrepareStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlRenameTableStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlReplaceStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlResetStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlRollbackStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock.Limit;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSetCharSetStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSetNamesStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSetTransactionStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowAuthorsStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowBinLogEventsStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowBinaryLogsStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowCharacterSetStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowCollationStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowColumnsStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowContributorsStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowCreateDatabaseStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowCreateEventStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowCreateFunctionStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowCreateProcedureStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowCreateTableStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowCreateTriggerStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowCreateViewStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowDatabasesStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowEngineStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowEnginesStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowErrorsStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowEventsStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowFunctionCodeStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowFunctionStatusStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowGrantsStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowIndexesStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowKeysStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowMasterLogsStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowMasterStatusStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowOpenTablesStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowPluginsStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowPrivilegesStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowProcedureCodeStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowProcedureStatusStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowProcessListStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowProfileStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowRelayLogEventsStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowSlaveHostsStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowSlaveStatusStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowStatusStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowTableStatusStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowTriggersStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowWarningsStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlStartTransactionStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlTableIndex;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlUnionQuery;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlUnlockTablesStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlUpdateStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlASTVisitorAdapter;

import junit.framework.TestCase;

public class MySqlASTVisitorAdapterTest extends TestCase {

    public void test_adapter() throws Exception {
        MySqlASTVisitorAdapter adapter = new MySqlASTVisitorAdapter();
        new SQLBooleanExpr().accept(adapter);
        new Limit().accept(adapter);
        new MySqlTableIndex().accept(adapter);
        new MySqlKey().accept(adapter);
        new MySqlPrimaryKey().accept(adapter);
        new MySqlIntervalExpr().accept(adapter);
        new SQLBinaryExpr().accept(adapter);
        new MySqlPrepareStatement().accept(adapter);
        new MySqlExecuteStatement().accept(adapter);
        new MySqlDeleteStatement().accept(adapter);
        new MySqlInsertStatement().accept(adapter);
        new MySqlLoadXmlStatement().accept(adapter);
        new MySqlReplaceStatement().accept(adapter);
        new MySqlStartTransactionStatement().accept(adapter);
        new MySqlRollbackStatement().accept(adapter);
        new MySqlShowColumnsStatement().accept(adapter);
        new MySqlShowDatabasesStatement().accept(adapter);
        new MySqlShowWarningsStatement().accept(adapter);
        new MySqlShowStatusStatement().accept(adapter);
        new CobarShowStatus().accept(adapter);
        new MySqlKillStatement().accept(adapter);
        new MySqlBinlogStatement().accept(adapter);
        new MySqlResetStatement().accept(adapter);
        new UserSpecification().accept(adapter);
        new MySqlPartitionByKey().accept(adapter);
        new MySqlOutFileExpr().accept(adapter);
        new MySqlUpdateStatement().accept(adapter);
        new MySqlSetTransactionStatement().accept(adapter);
        new MySqlSetNamesStatement().accept(adapter);
        new MySqlShowMasterLogsStatement().accept(adapter);
        new MySqlSetCharSetStatement().accept(adapter);
        new MySqlShowAuthorsStatement().accept(adapter);
        new MySqlShowCollationStatement().accept(adapter);
        new MySqlShowBinLogEventsStatement().accept(adapter);
        new MySqlShowCharacterSetStatement().accept(adapter);
        new MySqlShowContributorsStatement().accept(adapter);
        new MySqlShowCreateDatabaseStatement().accept(adapter);
        new MySqlShowCreateEventStatement().accept(adapter);
        new MySqlShowCreateFunctionStatement().accept(adapter);
        new MySqlShowCreateProcedureStatement().accept(adapter);
        new MySqlShowCreateTableStatement().accept(adapter);
        new MySqlShowCreateTriggerStatement().accept(adapter);
        new MySqlShowCreateViewStatement().accept(adapter);
        new MySqlShowEngineStatement().accept(adapter);
        new MySqlShowEnginesStatement().accept(adapter);
        new MySqlShowErrorsStatement().accept(adapter);
        new MySqlShowEventsStatement().accept(adapter);
        new MySqlShowFunctionCodeStatement().accept(adapter);
        new MySqlShowFunctionStatusStatement().accept(adapter);
        new MySqlShowGrantsStatement().accept(adapter);
        new MySqlUserName().accept(adapter);
        new MySqlShowIndexesStatement().accept(adapter);
        new MySqlShowKeysStatement().accept(adapter);
        new MySqlShowMasterStatusStatement().accept(adapter);
        new MySqlShowOpenTablesStatement().accept(adapter);
        new MySqlShowBinaryLogsStatement().accept(adapter);
        new MySqlShowPluginsStatement().accept(adapter);
        new MySqlShowPrivilegesStatement().accept(adapter);
        new MySqlShowProcedureCodeStatement().accept(adapter);
        new MySqlShowProcedureStatusStatement().accept(adapter);
        new MySqlShowProcessListStatement().accept(adapter);
        new MySqlShowProfileStatement().accept(adapter);
        new MySqlShowSlaveHostsStatement().accept(adapter);
        new MySqlShowRelayLogEventsStatement().accept(adapter);
        new MySqlShowSlaveStatusStatement().accept(adapter);
        new MySqlShowTableStatusStatement().accept(adapter);
        new MySqlShowTriggersStatement().accept(adapter);
        new MySqlAlterTableStatement().accept(adapter);
        new MySqlRenameTableStatement().accept(adapter);
        new MySqlUnionQuery().accept(adapter);
        new MySqlUseIndexHint().accept(adapter);
        new MySqlIgnoreIndexHint().accept(adapter);
        new MySqlLockTableStatement().accept(adapter);
        new MySqlUnlockTablesStatement().accept(adapter);
        new MySqlForceIndexHint().accept(adapter);
        new MySqlAlterTableChangeColumn().accept(adapter);
        new MySqlAlterTableCharacter().accept(adapter);
        new MySqlAlterTableOption().accept(adapter);
        new MySqlCreateTableStatement().accept(adapter);
        new MySqlCharExpr().accept(adapter);
        new MySqlUnique().accept(adapter);
        new MySqlAlterTableModifyColumn().accept(adapter);
        new MySqlAlterTableDiscardTablespace().accept(adapter);
        new MySqlAlterTableImportTablespace().accept(adapter);
        new TableSpaceOption().accept(adapter);
        new MySqlPartitionByHash().accept(adapter);
        new MySqlPartitionByRange().accept(adapter);
        new MySqlPartitioningDef().accept(adapter);
        new LessThanValues().accept(adapter);
        new InValues().accept(adapter);
        new MySqlPartitionByList().accept(adapter);
    }
}
