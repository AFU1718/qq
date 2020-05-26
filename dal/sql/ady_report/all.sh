#!/bin/bash

export PGPASSWORD=aszx

DB=$DB || ady_report_2

psql -h adx66 -Uroot $DB -c "drop table if exists stats;"
psql -h adx66 -Uroot $DB -c "drop table if exists stats_by_hour;"
psql -h adx66 -Uroot $DB -c "drop table if exists stats_by_day;"

for i in `ls | grep '.sql' | sort -r`
do
psql -h adx66 -Uroot $DB < $i
done
