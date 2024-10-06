package com.sitionix.athssox.util.database;

import jakarta.persistence.EntityManager;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
public class Database {

    private final EntityManager entityManager;

    private final UsersTable usersTable;

    public Database(final EntityManager entityManager, final NamedParameterJdbcTemplate jdbcTemplate) {
        this.entityManager = entityManager;
        this.usersTable = new UsersTable(entityManager, jdbcTemplate);
    }

    public UsersTable getUsersTable() {
        return this.flushAndReturnTable(this.usersTable);
    }

    private <T> T flushAndReturnTable(T table) {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            this.entityManager.flush();
        }
        return table;
    }

    public void clean() {
        this.getUsersTable().deleteAll();
    }
}
