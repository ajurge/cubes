#!/usr/bin/env bash

if [ -z "$RELEASE_VERSION" ]
  then
    echo "ERROR: No release version supplied"
    exit 1
fi

if [ -z "$BINTRAY_USER" ]
  then
    echo "ERROR: No Bintray user supplied"
    exit 1
fi

if [ -z "$BINTRAY_API_KEY" ]
  then
    echo "ERROR: No Bintray API key supplied"
    exit 1
fi

################################################################################################
## By default the staging repository is closed and artifacts are released to Maven Central.   ##
## You can optionally turn this behaviour off and release the version manually.               ##
## This is achieved by passing 0 in the 'close' field of the JSON passed to the call.         ##
################################################################################################

if [ -z "$CLOSE_SONATYPE_STAGING" ]
  then
    CLOSE_SONATYPE_STAGING="1"
fi

BODY='{
  "close": "'"$CLOSE_SONATYPE_STAGING"'"
}'

BINTRAY_REST_API_URL="https://api.bintray.com/maven_central_sync/ajurge/com.bipinet.cubes/cubes/versions/$RELEASE_VERSION"

echo $(curl --user $BINTRAY_USER:$BINTRAY_API_KEY -s -X POST \
   -d "$BODY" \
   "$BINTRAY_REST_API_URL")