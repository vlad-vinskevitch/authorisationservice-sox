#!/bin/bash
echo "Initializing PostgreSQL custom scripts execution..."

# Execute all SQL files from 01_Tables and 02_Constraints in order
for sql_file in /docker-entrypoint-initdb.d/01_Tables/*.sql; do
  echo "Running $sql_file..."
  psql -U "$POSTGRES_USER" -d "$POSTGRES_DB" -f "$sql_file"
done

for sql_file in /docker-entrypoint-initdb.d/02_Constraints/*.sql; do
  echo "Running $sql_file..."
  psql -U "$POSTGRES_USER" -d "$POSTGRES_DB" -f "$sql_file"
done

echo "PostgreSQL custom scripts execution completed."
