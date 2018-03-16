#!/usr/bin/env bash

# https://travis-ci.org/ajurge/cubes --> More Options --> Trigger Build
#env:
#  global:
#        - PERFORM_RELEASE=release
#        - RELEASE_VERSION="<MAJOR.MINOR.PATCH>"
#        - DEVELOPMENT_VERSION="<MAJOR.MINOR.PATCH>"

if [ -z "$1" ]
  then
    echo "No release version supplied"
    exit 1
fi

if [ -z "$2" ]
  then
    echo "No development version supplied"
    exit 1
fi

RELEASE_VERSION=$1
DEVELOPMENT_VERSION=$2
TRAVIS_CI_BUILD_REST_API_URL=https://api.travis-ci.org/repo/ajurge%2Fcubes/requests

if [ -z "$API_TOKEN" ]
  then
    echo "Enter Travis CI API token for $TRAVIS_CI_BUILD_REST_API_URL:"
    read -t 10 -s API_TOKEN || { echo "Error: Travis CI API token not supplied"; exit 1; }
fi

BODY='{
 "request": {
 "message": "Triggered via REST API: Release version '"$RELEASE_VERSION"' and set next development cycle version to '"$DEVELOPMENT_VERSION"'",
 "config": {
   "env": {
     "global": {
        "PERFORM_RELEASE": "release",
        "RELEASE_VERSION": "'"$RELEASE_VERSION"'",
        "DEVELOPMENT_VERSION": "'"$DEVELOPMENT_VERSION"'"
     }
   }
  }
}}'

curl -s -X POST \
 -H "Content-Type: application/json" \
 -H "Accept: application/json" \
 -H "Travis-API-Version: 3" \
 -H "Authorization: token $API_TOKEN" \
 -d "$BODY" \
 "$TRAVIS_CI_BUILD_REST_API_URL"