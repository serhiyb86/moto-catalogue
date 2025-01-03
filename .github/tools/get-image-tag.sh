#!/bin/bash

HEAD_REF=$1
TAG=""
if [[ $HEAD_REF == "" ]]; then
  TAG=$(git rev-parse --abbrev-ref HEAD)
else
  TAG=$HEAD_REF
fi

TAG=$(echo "$TAG" | sed 's/[^[:alnum:]\.\_\-]/-/g')

if [[ $TAG == "main" ]]; then
  TAG="1.0.0-SNAPSHOT"
fi

echo $TAG