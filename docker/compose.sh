#!/bin/bash

IMAGE_PARAM=$1

docker container prune -f
docker volume prune -f

rm -rf .env
if [ -n "$1" ]; then
  echo "IMAGE=$1" >> .env
fi

PROJECT_DIR=..
#CONFIG_VOLUME=$(pwd)/conf
#LOCAL_VOLUME=$(pwd)/fs/local
#TEMPORAL_VOLUME=$(pwd)/fs/temporal
DB_INIT_VOLUME=$(pwd)/db-init
#LOGS_VOLUME=$(pwd)/logs

printf "Setting up volumes\n"
#rm -rf "$CONFIG_VOLUME"
#rm -rf "$LOCAL_VOLUME"
#rm -rf "$TEMPORAL_VOLUME"
rm -rf "$DB_INIT_VOLUME"
#rm -rf "$LOGS_VOLUME"

#mkdir -p "$CONFIG_VOLUME"
#mkdir -p "$LOCAL_VOLUME"
#mkdir -p "$TEMPORAL_VOLUME"
mkdir -p "$DB_INIT_VOLUME"
#mkdir -p "$LOGS_VOLUME"

#printf "Copying app properties and db properties yaml(s)\n"
#cp "$PROJECT_DIR"/dependencies/postgresql/dev/application.yml "$CONFIG_VOLUME"/application-db.yml
#cp "$PROJECT_DIR"/src/main/resources/application.* "$CONFIG_VOLUME"/

printf "Adapting files for this environment\n"
SED_PARAMS=
if [[ "$OSTYPE" == "linux-gnu"* ]]; then
        SED_PARAMS=-i
elif [[ "$OSTYPE" == "darwin"* ]]; then
        SED_PARAMS="-i ''"
fi

#sed $SED_PARAMS 's|repository-path: "fs/repository/"|repository-path: "/fs/repository/"|g' "$CONFIG_VOLUME"/application.yml
#sed $SED_PARAMS 's|local-repository-path: "fs/local/"|local-repository-path: "/fs/local/"|g' "$CONFIG_VOLUME"/application.yml
#sed $SED_PARAMS 's|path: "fs/temporal"|path: "/fs/temporal/"|g' "$CONFIG_VOLUME"/application.yml
#sed $SED_PARAMS 's|path: logs/siron-archive.log|path: /logs/siron-archive.log|g' "$CONFIG_VOLUME"/application.yml
#
sed $SED_PARAMS 's|url: "jdbc:postgresql://localhost:5432|url: "jdbc:postgresql://db:5432|g' "$CONFIG_VOLUME"/application-db.yml


printf "Copying init scripts for db\n"
cp "$PROJECT_DIR"/dependencies/postgresql/init/* "$DB_INIT_VOLUME"
cp pg_hba.conf "$DB_INIT_VOLUME"

## Remove backup files
#rm -rf $CONFIG_VOLUME/application.yml\'\'
#rm -rf $CONFIG_VOLUME/application-db.yml\'\'

docker compose up