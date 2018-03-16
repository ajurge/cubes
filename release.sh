#!/usr/bin/env bash

RELEASE_VERSION=$1
DEVELOPMENT_VERSION=$2
VERSION_VALIDATION_REGEX='^([0-9]+\.){2,2}(\*|[0-9]+)$'

if [ -z "$RELEASE_VERSION" ]
  then
    echo "ERROR: No release version supplied"
    exit 1
fi

if [ -z "$DEVELOPMENT_VERSION" ]
  then
    echo "ERROR: No development version supplied"
    exit 1
fi

validate_version () {
  VERSION=$1
  if [[ ! $VERSION =~ $VERSION_VALIDATION_REGEX ]]; then
    echo "ERROR: Invalid version '$VERSION'"
    echo "INFO: Valid version format MAJOR.MINOR.PATCH see https://semver.org/"
    exit 1
  fi
}

validate_version $RELEASE_VERSION
validate_version $DEVELOPMENT_VERSION

git checkout master && echo -DreleaseVersion=$RELEASE_VERSION -DdevelopmentVersion=$DEVELOPMENT_VERSION-SNAPSHOT
#git checkout master && ./mvnw --settings settings.xml -B release:clean release:prepare release:perform -DreleaseVersion=$RELEASE_VERSION -DdevelopmentVersion=$DEVELOPMENT_VERSION-SNAPSHOT